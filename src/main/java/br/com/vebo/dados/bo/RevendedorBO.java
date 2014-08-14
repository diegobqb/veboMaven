package br.com.vebo.dados.bo;

import br.com.spartafw.exception.DataAccessException;
import br.com.spartafw.hibernate.util.HibernateUtil;
import br.com.vebo.dados.dao.DAOFactory;
import br.com.vebo.dados.mapeamento.Revendedor;
import java.util.Collection;

/**
 *
 * @author mohfus
 * @since 14 de Maio de 2009
 */
public class RevendedorBO {
    
    public RevendedorBO() {
    }
    
    public void save(Revendedor revendedor) throws DataAccessException {
        
        HibernateUtil.beginTransaction();
        new DAOFactory().getRevendedorDAO().insertOrUpdate(revendedor);
        HibernateUtil.commitTransaction();
    }
    
    public void delete(Revendedor revendedor) throws DataAccessException {
        HibernateUtil.beginTransaction();
        new DAOFactory().getRevendedorDAO().delete(revendedor);
        HibernateUtil.commitTransaction();
    }
    
    public Revendedor retrieve(Long id) throws DataAccessException {
        return new DAOFactory().getRevendedorDAO().retrieve(id);
    }

    public Collection<Revendedor> findAll() throws DataAccessException {
        return new DAOFactory().getRevendedorDAO().findAll();
    }
    
    public Collection<Revendedor> findByFilter(Revendedor revendedor) throws DataAccessException {
        if (revendedor == null) {
            revendedor = new Revendedor();
        }
        
        return new DAOFactory().getRevendedorDAO().findByFilter(revendedor);
    }

}
