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
import br.com.vebo.dados.mapeamento.Revendedor;
import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;

/**
 * 
 * @author Diego Barreto
 * @since 14 de Maio de 2009
 */
public class RevendedorDAO extends AbstractBaseDAO<Revendedor>{
    
   public RevendedorDAO (Session session) {
      super(session, Revendedor.class);
    }
   
    protected void addOrderToCriteria(Criteria criteria) {
        criteria.addOrder(Order.asc("nome"));
    }

}