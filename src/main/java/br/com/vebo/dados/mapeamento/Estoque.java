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
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author mohfus
 * @since 13 de Maio de 2009
 */
@Entity
public class Estoque extends AbstractBaseEntity {
    
    /** Cria uma nova instancia de Country */
    public Estoque() {
    }
    
    /**
     * Identificador unico da instancia
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date movimentacao;

    private MovimentacaoEstoqueEnum tipo;

    @ManyToOne
    @JoinColumn(name="id_material", nullable=false)
    private Material material;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Date getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(Date movimentacao) {
        this.movimentacao = movimentacao;
    }

    public MovimentacaoEstoqueEnum getTipo() {
        return tipo;
    }

    public void setTipo(MovimentacaoEstoqueEnum tipo) {
        this.tipo = tipo;
    }

}
