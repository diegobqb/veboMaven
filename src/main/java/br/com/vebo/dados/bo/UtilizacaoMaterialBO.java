package br.com.vebo.dados.bo;

import br.com.spartafw.exception.DataAccessException;
import br.com.spartafw.hibernate.util.HibernateUtil;
import br.com.vebo.dados.dao.DAOFactory;
import br.com.vebo.dados.mapeamento.Calculo;
import br.com.vebo.dados.mapeamento.UtilizacaoMaterial;

/**
 *
 * @author mohfus
 * @since 14 de Maio de 2009
 */
public class UtilizacaoMaterialBO {
    
    public UtilizacaoMaterialBO() {
    }
    
    public void delete(UtilizacaoMaterial utilizacao) throws DataAccessException {
        HibernateUtil.beginTransaction();
        Calculo calculo = utilizacao.getCalculo();
        calculo.getUtilizacoes().remove(utilizacao);
        new DAOFactory().getCalculoDAO().insertOrUpdate(calculo);
        utilizacao.setCalculo(null);
        new DAOFactory().getUtilizacaoMaterialDAO().delete(utilizacao);
        HibernateUtil.commitTransaction();
    }
    
    public UtilizacaoMaterial retrieve(Long id) throws DataAccessException {
        return new DAOFactory().getUtilizacaoMaterialDAO().retrieve(id);
    }
}
