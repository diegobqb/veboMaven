/*
 * DAOFactory.java
 *
 * Created on 14 de Julho de 2007, 08:04
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.vebo.dados.dao;

import br.com.spartafw.exception.DataAccessException;
import br.com.spartafw.hibernate.util.HibernateUtil;

/**
 * Classe responsavel por encapsular a construcao de novas instancias de DAO no
 * sistema. Esta classe implementa o padrao <B>Abstract Factory</B> para facilitar o acesso
 * aos DAO existentes e tambem para facilitar a <B>Dependency Injection</B> com a camada de
 * apresentacao
 * @author Diego Barreto
 * @since 14 de Maio de 2009
 */
public class DAOFactory {
    
    /**
     * Cria uma nova instancia de DAOFactory
     */
    public DAOFactory() {
    }

    public MaterialDAO getMaterialDAO() throws DataAccessException {
        return new MaterialDAO(HibernateUtil.getSession());
    }

    public PerfumeDAO getPerfumeDAO() throws DataAccessException {
        return new PerfumeDAO(HibernateUtil.getSession());
    }

    public CalculoDAO getCalculoDAO() throws DataAccessException {
        return new CalculoDAO(HibernateUtil.getSession());
    }

    public UtilizacaoMaterialDAO getUtilizacaoMaterialDAO() throws DataAccessException {
        return new UtilizacaoMaterialDAO(HibernateUtil.getSession());
    }

    public RevendedorDAO getRevendedorDAO() throws DataAccessException {
        return new RevendedorDAO(HibernateUtil.getSession());
    }

    public PedidoDAO getPedidoDAO() throws DataAccessException {
        return new PedidoDAO(HibernateUtil.getSession());
    }

    public ConfiguracaoDAO getConfiguracaoDAO() throws DataAccessException {
        return new ConfiguracaoDAO(HibernateUtil.getSession());
    }
    
}
