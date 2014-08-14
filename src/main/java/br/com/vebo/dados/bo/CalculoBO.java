package br.com.vebo.dados.bo;

import br.com.spartafw.exception.DataAccessException;
import br.com.spartafw.hibernate.util.HibernateUtil;
import br.com.vebo.dados.dao.DAOFactory;
import br.com.vebo.dados.mapeamento.Calculo;
import java.util.Collection;

/**
 *
 * @author mohfus
 * @since 14 de Maio de 2009
 */
public class CalculoBO {
    
    public CalculoBO() {
    }
    
    public void save(Calculo calculo) throws DataAccessException {
        
        HibernateUtil.beginTransaction();
        new DAOFactory().getCalculoDAO().insertOrUpdate(calculo);
        HibernateUtil.commitTransaction();
    }
    
    public void delete(Calculo calculo) throws DataAccessException {
        HibernateUtil.beginTransaction();
        new DAOFactory().getCalculoDAO().delete(calculo);
        HibernateUtil.commitTransaction();
    }
    
    public Calculo retrieve(Long id) throws DataAccessException {
        return new DAOFactory().getCalculoDAO().retrieve(id);
    }

    public Collection<Calculo> findAll() throws DataAccessException {
        return new DAOFactory().getCalculoDAO().findAll();
    }
    
    public Collection<Calculo> findByFilter(Calculo calculo) throws DataAccessException {
        if (calculo == null) {
            calculo = new Calculo();
        }
        
        return new DAOFactory().getCalculoDAO().findByFilter(calculo);
    }

}
