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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author mohfus
 * @since 13 de Maio de 2009
 */
@Entity
public class UtilizacaoMaterial extends AbstractBaseEntity {
    
    /** Cria uma nova instancia de Country */
    public UtilizacaoMaterial() {
    }
    
    /**
     * Identificador unico da instancia
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_utilizacaomaterial")
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_calculo", nullable=false)
    private Calculo calculo;

    @ManyToOne
    @JoinColumn(name="id_material", nullable=false)
    private Material material;

    private Double quantidade;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calculo getCalculo() {
        return calculo;
    }

    public void setCalculo(Calculo calculo) {
        this.calculo = calculo;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

}
