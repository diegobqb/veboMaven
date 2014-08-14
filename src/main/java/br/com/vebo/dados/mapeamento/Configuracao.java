/*
 * Country.java
 *
 * Created on 17 de Julho de 2007, 20:28
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.vebo.dados.mapeamento;

import br.com.spartafw.mapping.AbstractBaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author mohfus
 * @since 13 de Maio de 2009
 */
@Entity
public class Configuracao extends AbstractBaseEntity {
    
    /** Cria uma nova instancia de Country */
    public Configuracao() {
    }
    
    /**
     * Identificador unico da instancia
     */
    @Id
    @Column(name="id_configuracao")
    private Long id;
    
    private Double taxaCusto;
    private Double taxaValorRevendedor;
    private Double taxaValorFinal;
    private Double taxaLucroRevendedor;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTaxaCusto() {
        return taxaCusto;
    }

    public void setTaxaCusto(Double taxaCusto) {
        this.taxaCusto = taxaCusto;
    }

    public Double getTaxaLucroRevendedor() {
        return taxaLucroRevendedor;
    }

    public void setTaxaLucroRevendedor(Double taxaLucroRevendedor) {
        this.taxaLucroRevendedor = taxaLucroRevendedor;
    }

    public Double getTaxaValorFinal() {
        return taxaValorFinal;
    }

    public void setTaxaValorFinal(Double taxaValorFinal) {
        this.taxaValorFinal = taxaValorFinal;
    }

    public Double getTaxaValorRevendedor() {
        return taxaValorRevendedor;
    }

    public void setTaxaValorRevendedor(Double taxaValorRevendedor) {
        this.taxaValorRevendedor = taxaValorRevendedor;
    }

}
