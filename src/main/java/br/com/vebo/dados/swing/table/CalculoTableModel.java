/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.vebo.dados.swing.table;

import br.com.vebo.dados.mapeamento.Calculo;
import br.com.vebo.util.DoubleUtil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mohfus
 */
public class CalculoTableModel extends AbstractTableModel{

    private String[] colunas = new String[]{"Código", "Nome", "Qtd Essência"};
    private List<Calculo> calculos = new ArrayList<Calculo>();

    public int getColumnCount() {
        return colunas.length;
    }

    public int getRowCount() {
        return calculos.size();
    }

    public String getColumnName(int col) {
        return colunas[col];
    }

    public Object getValueAt(int row, int col) {
        Calculo calculo = calculos.get(row);
        switch(col) {
            case 0: return calculo.getId();
            case 1: return calculo.getNome();
            case 2: return new DoubleUtil().doubleParaString(calculo.getUtilizacaoEssencia(), "#,##0.#######");
        }
        return null;
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public void setCalculos(List<Calculo> calculos) {
        this.calculos = calculos;
    }


}
