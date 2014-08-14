/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.vebo.dados.swing.table;

import br.com.vebo.dados.dto.VendaPerfumeDTO;
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
public class VendaPerfumeTableModel extends AbstractTableModel{

    private String[] colunas = new String[]{"Nome", "Essência", "Pedidos"};
    private List<VendaPerfumeDTO> vendaPerfumes = new ArrayList<VendaPerfumeDTO>();

    public int getColumnCount() {
        return colunas.length;
    }

    public int getRowCount() {
        return vendaPerfumes.size();
    }

    public String getColumnName(int col) {
        return colunas[col];
    }

    public Object getValueAt(int row, int col) {
        VendaPerfumeDTO vendaPerfume = vendaPerfumes.get(row);
        switch(col) {
            case 0: return vendaPerfume.getNomeVebo();
            case 1: return vendaPerfume.getNomeEssencia();
            case 2: return vendaPerfume.getQuantidadeVendas();
        }
        return null;
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public void setVendaPerfumes(List<VendaPerfumeDTO> vendaPerfumes) {
        this.vendaPerfumes = vendaPerfumes;
    }

}
