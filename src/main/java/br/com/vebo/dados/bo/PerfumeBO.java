package br.com.vebo.dados.bo;

import br.com.spartafw.exception.DataAccessException;
import br.com.spartafw.hibernate.util.HibernateUtil;
import br.com.vebo.dados.dao.DAOFactory;
import br.com.vebo.dados.mapeamento.Material;
import br.com.vebo.dados.mapeamento.Perfume;
import java.util.Collection;

/**
 *
 * @author mohfus
 * @since 14 de Maio de 2009
 */
public class PerfumeBO {
    
    public PerfumeBO() {
    }
    
    public void save(Perfume perfume) throws DataAccessException {
        
        HibernateUtil.beginTransaction();
        new DAOFactory().getPerfumeDAO().insertOrUpdate(perfume);
        HibernateUtil.commitTransaction();
    }
    
    public void delete(Perfume perfume) throws DataAccessException {
        HibernateUtil.beginTransaction();
        new DAOFactory().getPerfumeDAO().delete(perfume);
        HibernateUtil.commitTransaction();
    }
    
    public Perfume retrieve(Long id) throws DataAccessException {
        return new DAOFactory().getPerfumeDAO().retrieve(id);
    }

    public Collection<Perfume> findAll() throws DataAccessException {
        return new DAOFactory().getPerfumeDAO().findAll();
    }
    
    public Collection<Perfume> findByFilter(Perfume perfume) throws DataAccessException {
        if (perfume == null) {
            perfume = new Perfume();
        }
        
        return new DAOFactory().getPerfumeDAO().findByFilter(perfume);
    }

}
