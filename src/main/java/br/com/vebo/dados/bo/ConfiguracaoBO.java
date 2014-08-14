package br.com.vebo.dados.bo;

import br.com.spartafw.exception.DataAccessException;
import br.com.spartafw.hibernate.util.HibernateUtil;
import br.com.vebo.dados.dao.DAOFactory;
import br.com.vebo.dados.mapeamento.Configuracao;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mohfus
 * @since 14 de Maio de 2009
 */
public class ConfiguracaoBO {
    
    public ConfiguracaoBO() {
    }
    
    public void save(Configuracao configuracao) throws DataAccessException {
        HibernateUtil.beginTransaction();
        new DAOFactory().getConfiguracaoDAO().update(configuracao);
        HibernateUtil.commitTransaction();
    }
    
    public Configuracao retrieve()  {
        Configuracao retorno = null;
        try {
            if (new DAOFactory().getConfiguracaoDAO().findAll().size() > 0) {
                retorno = new DAOFactory().getConfiguracaoDAO().retrieve(1l);
            }
            else {
                retorno = new Configuracao();
                retorno.setId(1l);
                new DAOFactory().getConfiguracaoDAO().insert(retorno);
                retorno = new DAOFactory().getConfiguracaoDAO().retrieve(1l);
            }
            
        } catch (Exception ex) {
            
        }
        return retorno;
    }

}
