/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.vebo.dados.swing.table;

import br.com.vebo.dados.mapeamento.UtilizacaoMaterial;
import br.com.vebo.util.DoubleUtil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mohfus
 */
public class UtilizacaoMaterialTableModel extends AbstractTableModel{

    private String[] colunas = new String[]{"Código Material", "Nome", "Quantidade"};
    private List<UtilizacaoMaterial> utilizacoes = new ArrayList<UtilizacaoMaterial>();

    public int getColumnCount() {
        return colunas.length;
    }

    public int getRowCount() {
        return utilizacoes.size();
    }

    public String getColumnName(int col) {
        return colunas[col];
    }

    public Object getValueAt(int row, int col) {
        UtilizacaoMaterial utilizacao = utilizacoes.get(row);
        switch(col) {
            case 0: return utilizacao.getMaterial().getId();
            case 1: return utilizacao.getMaterial().getNome();
            case 2: return new DoubleUtil().doubleParaString(utilizacao.getQuantidade(), "#,##0.#######");
        }
        return null;
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public void setUtilizacoes(List<UtilizacaoMaterial> utilizacoes) {
        this.utilizacoes = utilizacoes;
    }

    public List<UtilizacaoMaterial> getUtilizacoes() {
        return utilizacoes;
    }

    

}
