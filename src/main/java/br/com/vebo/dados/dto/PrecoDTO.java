/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.vebo.dados.dto;

import br.com.vebo.dados.mapeamento.Perfume;
import java.io.Serializable;

/**
 *
 * @author mohfus
 */
public class PrecoDTO implements Serializable{

    private String nomeCalculo;

    private Perfume perfume;

    private Double custo;
    
    private Double valorRevendedor;

    private Double valorFinal;

    private Double lucroRevendedor;

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public String getNomeCalculo() {
        return nomeCalculo;
    }

    public void setNomeCalculo(String nomeCalculo) {
        this.nomeCalculo = nomeCalculo;
    }

    public Perfume getPerfume() {
        return perfume;
    }

    public void setPerfume(Perfume perfume) {
        this.perfume = perfume;
    }

    public Double getLucroRevendedor() {
        return lucroRevendedor;
    }

    public void setLucroRevendedor(Double lucroRevendedor) {
        this.lucroRevendedor = lucroRevendedor;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Double getValorRevendedor() {
        return valorRevendedor;
    }

    public void setValorRevendedor(Double valorRevendedor) {
        this.valorRevendedor = valorRevendedor;
    }

}
