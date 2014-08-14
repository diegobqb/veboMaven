package br.com.vebo.dados.bo;

import br.com.spartafw.exception.DataAccessException;
import br.com.spartafw.hibernate.util.HibernateUtil;
import br.com.vebo.dados.dao.DAOFactory;
import br.com.vebo.dados.mapeamento.Material;
import java.util.Collection;

/**
 *
 * @author mohfus
 * @since 14 de Maio de 2009
 */
public class MaterialBO {
    
    public MaterialBO() {
    }
    
    public void save(Material material) throws DataAccessException {
        
        HibernateUtil.beginTransaction();
        new DAOFactory().getMaterialDAO().insertOrUpdate(material);
        HibernateUtil.commitTransaction();
    }
    
    public void delete(Material material) throws DataAccessException {
        HibernateUtil.beginTransaction();
        new DAOFactory().getMaterialDAO().delete(material);
        HibernateUtil.commitTransaction();
    }
    
    public Material retrieve(Long id) throws DataAccessException {
        return new DAOFactory().getMaterialDAO().retrieve(id);
    }

    public Collection<Material> findAll() throws DataAccessException {
        return new DAOFactory().getMaterialDAO().findAll();
    }
    
    public Collection<Material> findByFilter(Material material) throws DataAccessException {
        if (material == null) {
            material = new Material();
        }
        
        return new DAOFactory().getMaterialDAO().findByFilter(material);
    }

}
