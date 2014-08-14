package br.com.vebo.dados.bo;

import br.com.spartafw.exception.DataAccessException;
import br.com.spartafw.hibernate.util.HibernateUtil;
import br.com.vebo.dados.dao.DAOFactory;
import br.com.vebo.dados.dto.VendaPerfumeDTO;
import br.com.vebo.dados.mapeamento.Pedido;
import br.com.vebo.dados.mapeamento.Revendedor;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mohfus
 * @since 14 de Maio de 2009
 */
public class PedidoBO {
    
    public PedidoBO() {
    }
    
    public void save(Pedido pedido) throws DataAccessException {
        
        HibernateUtil.beginTransaction();
        new DAOFactory().getPedidoDAO().insertOrUpdate(pedido);
        HibernateUtil.commitTransaction();
    }
    
    public void delete(Pedido pedido) throws DataAccessException {
        HibernateUtil.beginTransaction();
        new DAOFactory().getPedidoDAO().delete(pedido);
        HibernateUtil.commitTransaction();
    }
    
    public Pedido retrieve(Long id) throws DataAccessException {
        return new DAOFactory().getPedidoDAO().retrieve(id);
    }

    public Collection<Pedido> findAll() throws DataAccessException {
        return new DAOFactory().getPedidoDAO().findAll();
    }
    
    public Collection<Pedido> findByFilter(Pedido pedido) throws DataAccessException {
        if (pedido == null) {
            pedido = new Pedido();
        }
        
        return new DAOFactory().getPedidoDAO().findByFilter(pedido);
    }

    public List<VendaPerfumeDTO> obterPerfumesPorVenda() throws DataAccessException {
        return new DAOFactory().getPedidoDAO().obterPerfumesPorVenda();
    }

    public Collection<Pedido> obterPorRevendedorPeriodo(Date dataInicial, Date dataFinal, Revendedor revendedor) throws DataAccessException {
        return new DAOFactory().getPedidoDAO().obterPorRevendedorPeriodo(dataInicial, dataFinal, revendedor);
    }

}
