/*
 * AbstractBaseDAO.java
 *
 * Created on 13 de Julho de 2007, 22:30
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.spartafw.dao;

import br.com.spartafw.exception.DataAccessException;
import br.com.spartafw.mapping.AbstractBaseEntity;
import java.util.Collection;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

/**
 * Classe base para todas as classes de acesso a dados do sistema (<B>Data Access
 * Object</B>), contendo metodos padrao para CRUD (<B>Create, Retrieve, Update, Delete</B>).
 * Atraves do <B>Generic</B>, todas as suas subclasses ja vao possuir esses metodos
 * especializados pra suas entidades.
 * @author Diego Barreto
 * @since 13 de Julho de 2007
 */
public abstract class AbstractBaseDAO<T extends AbstractBaseEntity> {
    
    /**
     * Sessao do Hibernate
     */
    private final Session session;
    
    /**
     * Classe da entidade a ser manipulada.
     */
    private final Class entityClass;
    
    /**
     * Cria uma nova instancia de AbstractBaseDAO. <I>Este metodo nao pode ser chamado pois
     * a classe e abstrata.</I>
     * @param session Sessao do hibernate
     * @param entityClass Classe da enidade a ser persistida
     */
    public AbstractBaseDAO(Session session, Class entityClass) {
        this.session = session;
        this.entityClass = entityClass;
    }
    
    protected Session getSession() {
        return this.session;
    }
    
    /**
     * Metodo generico que insere no banco um novo registro de uma entidade.
     * @param entity Entidade a ser inserida no banco
     * @throws br.com.sparta.exception.DataAccessException Excecao lancada caso ocorra algum comportamento inexperado.
     */
    public Long insert(T entity) throws DataAccessException{
        Long returnPk = null;
        try {
            returnPk = (Long) session.save(entity);
            session.flush();
        } catch (HibernateException e) {
            throw new DataAccessException(e);
        }
        return returnPk;
    }
    
    /**
     * Metodo generico que altera no banco um registro de uma entidade.
     * @param entity Entidade a ser atualizada
     * @throws br.com.sparta.exception.DataAccessException Excecao lancada caso ocorra algum comportamento inexperado.
     */
    public void update(T entity) throws DataAccessException{
        try {
            session.update(entity);
            session.flush();
        } catch (HibernateException e) {
            throw new DataAccessException(e);
        }
    }
    
    /**
     * Metodo generico que insere ou altera no banco um registro de uma entidade.
     * @param entity Entidade a ser atualizada
     * @throws br.com.sparta.exception.DataAccessException Excecao lancada caso ocorra algum comportamento inexperado.
     */
    public void insertOrUpdate(T entity) throws DataAccessException{
        try {
            session.saveOrUpdate(entity);
            session.flush();
        } catch (HibernateException e) {
            throw new DataAccessException(e);
        }
    }
    
    /**
     * Metodo generico que remove de banco um registro de uma entidade.
     * @param entity Entidade a ser excluida
     * @throws br.com.sparta.exception.DataAccessException Excecao lancada caso ocorra algum comportamento inexperado.
     */
    public void delete(T entity) throws DataAccessException{
        try {
            session.delete(entity);
            session.flush();
        } catch (HibernateException e) {
            throw new DataAccessException(e);
        }
    }
    
    /**
     * Metodo generico que remove do banco varios registros de uma entidade.
     * @param collection Colecao de registros a serem excluidos
     * @throws br.com.sparta.exception.DataAccessException Excecao lancada caso ocorra algum comportamento inexperado.
     */
    public void deleteAll(Collection<T> collection) throws DataAccessException {
        for(T entity : collection) {
            this.delete(entity);
        }
    }
    
    /**
     * Metodo generico que consulta no banco todos os registros de uma entidade
     * @return Colecao de registros da entidade
     * @throws br.com.sparta.exception.DataAccessException Excecao lancada caso ocorra algum comportamento inexperado.
     */
    public Collection<T> findAll() throws DataAccessException {
        Collection<T> retorno = null;
        try {
            Criteria criteria = session.createCriteria(this.entityClass);
            addPropertiedToCriteria(criteria);
            addOrderToCriteria(criteria);
            retorno = (Collection<T>) criteria.list();
        } catch (HibernateException e) {
            throw new DataAccessException(e);
        }
        return retorno;
    }
    
    /**
     * Metodo generico que consulta no banco um registro especifico de uma entidade,
     * atraves do id.
     * @param id Identificador do registro a ser consultado
     * @return Registro da entidade com o identificador indicado
     * @throws br.com.sparta.exception.DataAccessException Excecao lancada caso ocorra algum comportamento inexperado.
     */
    public T retrieve(Long id) throws DataAccessException {
        T retorno = null;
        try {
            retorno = (T) session.load(this.entityClass, id);
        } catch (HibernateException e) {
            throw new DataAccessException(e);
        }
        return retorno;
    }
    
    /**
     * Metodo generio que pesquisa utilizando a propria entidade como filtro. Para
     * obter uma filtragem mais completa, incluindo atributos agregados, sobrescreva o
     * metodo <B>addPropertiedToCriteria</B> e insira as agregacoes no Criteria.
     * Para adicionar uma ordem especifica a consulta, sobrescreva o metodo
     * <B>addOrderToCriteria</B>.
     * @param entity Entidade utilizada como filtro na consulta.
     * @return Colecao filtrada de registros da entidade
     * @throws br.com.sparta.exception.DataAccessException Excecao lancada caso ocorra algum comportamento inexperado.
     */
    public Collection<T> findByFilter(T entity) throws DataAccessException {
        Collection<T> retorno = null;
        try {
            Example example = Example.create(entity);
            example.enableLike(MatchMode.ANYWHERE).ignoreCase();
            example.ignoreCase();
            Criteria criteria = session.createCriteria(this.entityClass);
            criteria.add(example);
            addPropertiedToCriteria(criteria);
            addValuesToPropertied(criteria, entity);
            addOrderToCriteria(criteria);
            retorno = (Collection<T>) criteria.list();
        } catch (HibernateException e) {
            throw new DataAccessException(e);
        }
        return retorno;
    }
    
    /**
     * Metodo generico utilizado pelo metodo <B>findByFilter</B> que permite que as 
     * agregações de uma entidade possam ser adicionadas ao filtro, ampliando o poder 
     * de busca do metodo <B>findByFilter</B>.
     * @param criteria Criteria ao qual serao adicionadas as agregacoes.
     * @param entity Entidade contendo os valores das agregacoes. Esta entidade sera passada como 
     * parametro pelo metodo <B>findByFilter</B>.
     */
    protected void addPropertiedToCriteria(Criteria criteria) {
    }
    
    /**
     * Metodo generico utilizado pelo metodo <B>findByFilter</B> que permite que as 
     * agregações de uma entidade possam ser adicionadas ao filtro, ampliando o poder 
     * de busca do metodo <B>findByFilter</B>.
     * @param criteria Criteria ao qual serao adicionadas as agregacoes.
     * @param entity Entidade contendo os valores das agregacoes. Esta entidade sera passada como 
     * parametro pelo metodo <B>findByFilter</B>.
     */
    protected void addValuesToPropertied(Criteria criteria, T entity) {
    }
    
    /**
     * Metodo generico utilizado para adicionar ordem aos metodos <B>findAll</B> e 
     * <B>findByExample</B>.
     * Para adicionar ordem no criteria basta utilizar um comando semelhante a este:
     * <CODE>criteria.addOrder(Order.asc("nomeAtributo"));</CODE>
     * @param criteria Criteria ao qual sera adicionado a ordem.
     */
    protected void addOrderToCriteria(Criteria criteria) {
    }
    
}
