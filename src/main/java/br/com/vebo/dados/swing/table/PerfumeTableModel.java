/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.vebo.dados.swing.table;

import br.com.vebo.dados.mapeamento.Material;
import br.com.vebo.dados.mapeamento.Perfume;
import br.com.vebo.util.DoubleUtil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mohfus
 */
public class PerfumeTableModel extends AbstractTableModel{

    private String[] colunas = new String[]{"Código", "Nome", "Essência", "Público", "Valor"};
    private List<Perfume> perfumes = new ArrayList<Perfume>();

    public int getColumnCount() {
        return colunas.length;
    }

    public int getRowCount() {
        return perfumes.size();
    }

    public String getColumnName(int col) {
        return colunas[col];
    }

    public Object getValueAt(int row, int col) {
        Perfume perfume = perfumes.get(row);
        switch(col) {
            case 0: return perfume.getId();
            case 1: return perfume.getNomeVebo();
            case 2: return perfume.getNomeEssencia();
            case 3: return perfume.getPublico().toString();
            case 4: return new DoubleUtil().doubleParaString(perfume.getValorEssencia10ml());
        }
        return null;
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public void setPerfumes(List<Perfume> perfumes) {
        this.perfumes = perfumes;
    }

}
