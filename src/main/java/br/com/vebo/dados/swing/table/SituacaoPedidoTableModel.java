/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.vebo.dados.swing.table;

import br.com.spartafw.exception.DataAccessException;
import br.com.spartafw.hibernate.util.HibernateUtil;
import br.com.vebo.dados.bo.PedidoBO;
import br.com.vebo.dados.dao.DAOFactory;
import br.com.vebo.dados.mapeamento.Pedido;
import br.com.vebo.util.DateUtil;
import br.com.vebo.util.DoubleUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mohfus
 */
public class SituacaoPedidoTableModel extends AbstractTableModel{

    private String[] colunas = new String[]{"Código", "Revendedor", "Cálculo", "Data", "Entrega", "Valor", "Situação Pedido", "Situação Pagamento"};
    private List<Pedido> pedidos = new ArrayList<Pedido>();

    public int getColumnCount() {
        return colunas.length;
    }

    public int getRowCount() {
        return pedidos.size();
    }

    public String getColumnName(int col) {
        return colunas[col];
    }

    public Object getValueAt(int row, int col) {
        Pedido pedido = pedidos.get(row);
        switch(col) {
            case 0: return pedido.getId();
            case 1: return pedido.getRevendedor().getNome();
            case 2: return pedido.getCalculo().getNome();
            case 3: return new DateUtil().dateParaString(pedido.getPedido());
            case 4: return new DateUtil().dateParaString(pedido.getEntrega());
            case 5: return new DoubleUtil().doubleParaString(pedido.getValor(), "#,##0.00");
            case 6: return pedido.getSituacaoPedido().toString();
            case 7: return pedido.getSituacaoPagamentoPedido().toString();
        }
        return null;
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    
    public static void main(String[] args) throws DataAccessException {
        Collection<Pedido> pedidos = new PedidoBO().findAll();
        for(Pedido pedido : pedidos){
            System.out.println("==> "+new DoubleUtil().doubleParaString(pedido.getValor(), "#,##0.00"));
        }
        HibernateUtil.beginTransaction();
        //new DAOFactory().getPedidoDAO().deleteAll(pedidos);
        HibernateUtil.commitTransaction();
    }

}
