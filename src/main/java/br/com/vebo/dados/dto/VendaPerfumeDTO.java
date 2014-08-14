/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.vebo.dados.dto;

/**
 *
 * @author mohfus
 */
public class VendaPerfumeDTO {
    private String nomeVebo;
    private String nomeEssencia;
    private Integer quantidadeVendas;

    public String getNomeEssencia() {
        return nomeEssencia;
    }

    public void setNomeEssencia(String nomeEssencia) {
        this.nomeEssencia = nomeEssencia;
    }

    public String getNomeVebo() {
        return nomeVebo;
    }

    public void setNomeVebo(String nomeVebo) {
        this.nomeVebo = nomeVebo;
    }

    public Integer getQuantidadeVendas() {
        return quantidadeVendas;
    }

    public void setQuantidadeVendas(Integer quantidadeVendas) {
        this.quantidadeVendas = quantidadeVendas;
    }
}
