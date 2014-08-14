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
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author mohfus
 * @since 13 de Maio de 2009
 */
@Entity
public class Perfume extends AbstractBaseEntity {
    
    /** Cria uma nova instancia de Country */
    public Perfume() {
    }
    
    /**
     * Identificador unico da instancia
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_perfume")
    private Long id;
    
    private String nomeVebo;
    
    private String nomeEssencia;

    private Double valorEssencia10ml;

    @Enumerated
    private SexoEnum publico;

    @Column(length=1000)
    private String descricao;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

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

    public SexoEnum getPublico() {
        return publico;
    }

    public void setPublico(SexoEnum publico) {
        this.publico = publico;
    }

    public Double getValorEssencia10ml() {
        return valorEssencia10ml;
    }

    public void setValorEssencia10ml(Double valorEssencia10ml) {
        this.valorEssencia10ml = valorEssencia10ml;
    }

    @Override
    public String toString() {
        return nomeVebo+" ("+nomeEssencia+")"+" - "+publico.toString();
    }
    
}
