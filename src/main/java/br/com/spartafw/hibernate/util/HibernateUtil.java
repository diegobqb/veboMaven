/*
 * SessionFactory.java
 *
 * Created on 13 de Julho de 2007, 22:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.spartafw.hibernate.util;

import br.com.spartafw.exception.DataAccessException;
import org.hibernate.HibernateException;
import org.hibernate.Interceptor;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * Classe utilitaria utilizada na configuracao das Anotacoes do Hibernate e como
 * Fábrica de Sessoes, como indicada na documentacao do Próprio Hibernate: "<I>We
 * also recommend a small wrapper class to startup Hibernate in a static
 * initializer block</I>"
 * @author Diego Barreto
 * @since 13 de Julho de 2007
 */
public class HibernateUtil {
    
    /**
     * Flag que controla se e a sessao unica do hibernate
     */
    private static boolean uniqueSession = false;
    
    /**
     * Fabrica para a criacao de sessoes do hibernate
     */
    private static final SessionFactory sessionFactory;
    
    /**
     * Variavel "thread-safe" que mantem uma referencia para a sessao do hibernate
     */
    private static final ThreadLocal<Session> threadSession = new ThreadLocal<Session>();
    
    /**
     * Sessao do hibernate
     */
    private static Session session;
    
    /**
     * Variavel "thread-safe" que mantem uma referencia para a transacao do
     * hibernate
     */
    private static final ThreadLocal<Transaction> threadTransaction = new ThreadLocal<Transaction>();
    
    /**
     * Transacao do hibernate
     */
    private static Transaction transaction;
    
    /**
     * Variavel "thread-safe" que mantem um interceptor
     */
    private static final ThreadLocal<Interceptor> threadInterceptor = new ThreadLocal<Interceptor>();
    
    /**
     * interceptador do hibernate
     */
    private static Interceptor interceptor;
    
    static {
        try {
            // instancia um sessionFactory
            Configuration conf = new AnnotationConfiguration();
            conf.configure();
            sessionFactory = conf.buildSessionFactory();
            
        } catch (HibernateException ex) {
            System.err.println("Initial SessionFactory creation failed. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    /**
     * Metodo que modifica o valor da propriedade uniqueSession
     * @param valor Novo valor da flag que controla se e a sessao unica do hibernate
     */
    public static void setUniqueSession(boolean valor) {
        uniqueSession = valor;
    }
    
    /**
     * Obtem uma instancia do SessionFactory.
     *
     * @return Instância do SessinFactory.
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    /**
     * Abre uma nova sessao, se a thread ainda nao possuir nenhuma
     *
     * @return A sessao criada
     * @throws DataAccessException Excecao lancada caso ocorra algum problema na 
     * comunicacao com os dados
     */
    public static Session getSession() throws DataAccessException {
        Session s = uniqueSession ? session : threadSession.get();
        Interceptor i = uniqueSession ? interceptor : threadInterceptor.get();
        
        try {
            if (s == null) {
                if (i == null)
                    s = sessionFactory.openSession();
                else
                    s = sessionFactory.openSession(i);
                
                threadSession.set(s);
                session = s;
            }
        } catch (HibernateException ex) {
            throw new DataAccessException(ex);
        }
        
        return s;
    }
    
    /**
     * Fecha a sessao, se a thread possuir uma e esta estiver aberta
     *
     * @throws DataAccessException Excecao lancada caso ocorra algum problema na 
     * comunicacao com os dados
     */
    public static void closeSession() throws DataAccessException {
        try {
            Session s = uniqueSession ? session : threadSession.get();
            
            threadSession.set(null);
            session = null;
            
            if (s != null && s.isOpen()) {
                commitTransaction();
                s.close();
            }
        } catch (HibernateException ex) {
            throw new DataAccessException(ex);
        }
    }
    
    /**
     * Inicia uma transacao. Se a sessão do hibernate nao estiver iniciada, cria
     * uma nova.
     *
     * @return TRUE se uma nova transacao for iniciada. FALSE se utilizar uma
     *         transacao já existente.
     * @throws DataAccessException Excecao lancada caso ocorra algum problema na 
     * comunicacao com os dados
     */
    public static boolean beginTransaction() throws DataAccessException {
        Transaction tx = uniqueSession ? transaction : threadTransaction.get();
        try {
            if (tx == null) {
                tx = getSession().beginTransaction();
                threadTransaction.set(tx);
                transaction = tx;
                return true;
            }
            
            return false;
        } catch (HibernateException ex) {
            throw new DataAccessException(ex);
        }
    }
    
    /**
     * Comita a transacao. Este metodo utiliza a transacao global iniciada nesta
     * thread pelo metodo HibernateUtil.beginTransaction()
     *
     * @throws DataAccessException Excecao lancada caso ocorra algum problema na 
     * comunicacao com os dados
     */
    public static void commitTransaction() throws DataAccessException {
        Transaction tx = uniqueSession ? transaction : threadTransaction.get();
        try {
            if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack())
                tx.commit();
            
            threadTransaction.set(null);
            transaction = null;
            
        } catch (HibernateException ex) {
            rollbackTransaction();
            throw new DataAccessException(ex);
        }
    }
    
    /**
     * Desfaz a transacao
     *
     * @throws DataAccessException Excecao lancada caso ocorra algum problema na 
     * comunicacao com os dados
     */
    public static void rollbackTransaction() throws DataAccessException {
        Transaction tx = uniqueSession ? transaction : threadTransaction.get();
        try {
            threadTransaction.set(null);
            transaction = null;
            
            if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack())
                tx.rollback();
            
        } catch (HibernateException ex) {
            throw new DataAccessException(ex);
        } finally {
            closeSession();
        }
    }
    
    /**
     * Registra um interceptor na thread atual. As proximas sessoes do hibernate
     * que forem abertas, utilizarao este interceptor.
     * @param intcptr Interceptador do hibernate a ser registrado
     * @throws DataAccessException Excecao lancada caso ocorra algum problema na 
     * comunicacao com os dados
     */
    public static void registrarInterceptor(Interceptor intcptr) throws DataAccessException {
        
        try {
            threadInterceptor.set(intcptr);
            interceptor = intcptr;
        } finally {
            closeSession();
            getSession();
        }
        
    }
}