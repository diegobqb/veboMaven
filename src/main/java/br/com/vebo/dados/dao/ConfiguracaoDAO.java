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
import br.com.vebo.dados.mapeamento.Configuracao;
import org.hibernate.classic.Session;

/**
 * 
 * @author Diego Barreto
 * @since 14 de Maio de 2009
 */
public class ConfiguracaoDAO extends AbstractBaseDAO<Configuracao>{
    
   public ConfiguracaoDAO (Session session) {
      super(session, Configuracao.class);
    }

}