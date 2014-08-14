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
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * @author mohfus
 * @since 13 de Maio de 2009
 */
@Entity
public class Calculo extends AbstractBaseEntity {
    
    /** Cria uma nova instancia de Country */
    public Calculo() {
    }
    
    /**
     * Identificador unico da instancia
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_calculo")
    private Long id;
    
    private String nome;

    private Double utilizacaoEssencia;

    @OneToMany(mappedBy="calculo")
    @Cascade(CascadeType.ALL)
    private Set<UtilizacaoMaterial> utilizacoes = new HashSet<UtilizacaoMaterial>();


    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<UtilizacaoMaterial> getUtilizacoes() {
        return utilizacoes;
    }

    public void setUtilizacoes(Set<UtilizacaoMaterial> utilizacoes) {
        this.utilizacoes = utilizacoes;
    }

    public Double getUtilizacaoEssencia() {
        return utilizacaoEssencia;
    }

    public void setUtilizacaoEssencia(Double utilizacaoEssencia) {
        this.utilizacaoEssencia = utilizacaoEssencia;
    }

    @Override
    public String toString() {
        return nome;
    }

}
