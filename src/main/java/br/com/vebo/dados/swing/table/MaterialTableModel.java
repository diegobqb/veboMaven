/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.vebo.dados.swing.table;

import br.com.vebo.dados.mapeamento.Material;
import br.com.vebo.util.DoubleUtil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mohfus
 */
public class MaterialTableModel extends AbstractTableModel{

    private String[] colunas = new String[]{"Código", "Nome", "Valor"};
    private List<Material> materiais = new ArrayList<Material>();

    public int getColumnCount() {
        return colunas.length;
    }

    public int getRowCount() {
        return materiais.size();
    }

    public String getColumnName(int col) {
        return colunas[col];
    }

    public Object getValueAt(int row, int col) {
        Material material = materiais.get(row);
        switch(col) {
            case 0: return material.getId();
            case 1: return material.getNome();
            case 2: return new DoubleUtil().doubleParaString(material.getValor(), "#,##0.00");
        }
        return null;
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public void setMateriais(List<Material> materiais) {
        this.materiais = materiais;
    }


}
