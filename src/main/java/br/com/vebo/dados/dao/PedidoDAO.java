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
import br.com.vebo.dados.dto.VendaPerfumeDTO;
import br.com.vebo.dados.mapeamento.Pedido;
import br.com.vebo.dados.mapeamento.Revendedor;
import br.com.vebo.dados.mapeamento.SituacaoPagamentoPedidoEnum;
import br.com.vebo.dados.mapeamento.SituacaoPedidoEnum;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

/**
 * 
 * @author Diego Barreto
 * @since 14 de Maio de 2009
 */
public class PedidoDAO extends AbstractBaseDAO<Pedido>{
    
   public PedidoDAO (Session session) {
      super(session, Pedido.class);
    }


   
    protected void addOrderToCriteria(Criteria criteria) {
        criteria.addOrder(Order.asc("revendedor.nome"));
        criteria.addOrder(Order.asc("perfume.nomeVebo"));
    }

    @Override
    protected void addPropertiedToCriteria(Criteria criteria) {
        criteria.createAlias("revendedor", "revendedor");
        criteria.createAlias("perfume", "perfume");
    }

    public List<VendaPerfumeDTO> obterPerfumesPorVenda() {
       List<VendaPerfumeDTO> retorno = new ArrayList<VendaPerfumeDTO>();
       for (Object[] objeto : (List<Object[]>)this.getSession().createQuery("select pedido.perfume.nomeVebo, pedido.perfume.nomeEssencia, count(pedido.perfume.id) from Pedido pedido group by pedido.perfume.nomeVebo, pedido.perfume.nomeEssencia").list()) {
           VendaPerfumeDTO vendaPerfumeDTO = new VendaPerfumeDTO();
           vendaPerfumeDTO.setNomeVebo((String)objeto[0]);
           vendaPerfumeDTO.setNomeEssencia((String)objeto[1]);
           vendaPerfumeDTO.setQuantidadeVendas(((Long)objeto[2]).intValue());
           retorno.add(vendaPerfumeDTO);
       }
       return retorno;
   }

    @Override
    protected void addValuesToPropertied(Criteria criteria, Pedido entity) {
        if (entity.getRevendedor() != null && entity.getRevendedor().getId() != null) {
            criteria.add(Expression.eq("revendedor.id", entity.getRevendedor().getId()));
        }
    }

/*    private List<Pedidos> obterPorSituacoes(SituacaoPedidoEnum situacaoPedidoEnum, SituacaoPagamentoPedidoEnum situacaoPagamentoPedidoEnum) {
        Criteria criteria = this.getSession().createCriteria(Pedido.class);

        if (situacaoPedidoEnum != null) {

        }

    }*/

    public Collection<Pedido> obterPorRevendedorPeriodo(Date dataInicial, Date dataFinal, Revendedor revendedor) {
        return this.getSession().createQuery("from Pedido p where p.pedido >= :dataInicial and p.pedido <= :dataFinal and p.revendedor = :revendedor").setDate("dataInicial", dataInicial).setDate("dataFinal", dataFinal).setEntity("revendedor", revendedor).list();
    }

}