/*
 * ClientDAO.java
 *
 * Created on 13 de Julho de 2007, 23:03
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.vebo.dados.dao;

import br.com.spartafw.dao.AbstractBaseDAO;
import br.com.vebo.dados.mapeamento.Calculo;
import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;

/**
 * 
 * @author Diego Barreto
 * @since 14 de Maio de 2009
 */
public class CalculoDAO extends AbstractBaseDAO<Calculo>{
    
   public CalculoDAO (Session session) {
      super(session, Calculo.class);
    }
   
    protected void addOrderToCriteria(Criteria criteria) {
        criteria.addOrder(Order.asc("nome"));
    }

}