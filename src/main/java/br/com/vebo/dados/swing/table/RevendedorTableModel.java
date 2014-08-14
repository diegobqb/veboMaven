/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.vebo.dados.swing.table;

import br.com.vebo.dados.mapeamento.Revendedor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mohfus
 */
public class RevendedorTableModel extends AbstractTableModel{

    private String[] colunas = new String[]{"Código", "Nome", "CPF", "Telefone", "Celular", "E-Mail"};
    private List<Revendedor> revendedores = new ArrayList<Revendedor>();

    public int getColumnCount() {
        return colunas.length;
    }

    public int getRowCount() {
        return revendedores.size();
    }

    public String getColumnName(int col) {
        return colunas[col];
    }

    public Object getValueAt(int row, int col) {
        Revendedor revendedor = revendedores.get(row);
        switch(col) {
            case 0: return revendedor.getId();
            case 1: return revendedor.getNome();
            case 2: return revendedor.getCpf();
            case 3: return revendedor.getTelefone();
            case 4: return revendedor.getCelular();
            case 5: return revendedor.getEmail();
        }
        return null;
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public void setRevendedores(List<Revendedor> revendedores) {
        this.revendedores = revendedores;
    }

}
