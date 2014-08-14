/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.vebo.dados.swing.table;

import br.com.vebo.dados.dto.PrecoDTO;
import br.com.vebo.util.DoubleUtil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mohfus
 */
public class TabelaPrecoTableModel extends AbstractTableModel{

    private String[] colunas = new String[]{"Nome", "Essência", "Público", "Cálculo", "Custo", "Valor Revendedor", "Valor Cliente", "Lucro Revendedor"};
    private List<PrecoDTO> precos = new ArrayList<PrecoDTO>();

    public int getColumnCount() {
        return colunas.length;
    }

    public int getRowCount() {
        return precos.size();
    }

    public String getColumnName(int col) {
        return colunas[col];
    }

    public Object getValueAt(int row, int col) {
        PrecoDTO valorPerfumesDTO = precos.get(row);
        switch(col) {
            case 0: return valorPerfumesDTO.getPerfume().getNomeVebo();
            case 1: return valorPerfumesDTO.getPerfume().getNomeEssencia();
            case 2: return valorPerfumesDTO.getPerfume().getPublico().toString();
            case 3: return valorPerfumesDTO.getNomeCalculo();
            case 4: return new DoubleUtil().doubleParaString(valorPerfumesDTO.getCusto(), "#,##0.00");
            case 5: return new DoubleUtil().doubleParaString(valorPerfumesDTO.getValorRevendedor(), "#,##0.00");
            case 6: return new DoubleUtil().doubleParaString(valorPerfumesDTO.getValorFinal(), "#,##0.00");
            case 7: return new DoubleUtil().doubleParaString(valorPerfumesDTO.getLucroRevendedor(), "#,##0.00");
        }
        return null;
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public void setPrecos(List<PrecoDTO> precos) {
        this.precos = precos;
    }

    
}
