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
import javax.persistence.Enumerated;
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
public class Pedido extends AbstractBaseEntity {
    
    /** Cria uma nova instancia de Country */
    public Pedido() {
    }
    
    /**
     * Identificador unico da instancia
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_pedido")
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_calculo", nullable=false)
    private Calculo calculo;

    @ManyToOne
    @JoinColumn(name="id_revendedor", nullable=false)
    private Revendedor revendedor;

    @ManyToOne
    @JoinColumn(name="id_perfume", nullable=false)
    private Perfume perfume;

    private String observacao;

    @Temporal(TemporalType.DATE)
    private Date pedido;

    @Temporal(TemporalType.DATE)
    private Date entrega;

    @Enumerated
    @Column(nullable=false)
    private SituacaoPedidoEnum situacaoPedido = SituacaoPedidoEnum.FEITO;

    @Enumerated
    @Column(nullable=false)
    private SituacaoPagamentoPedidoEnum situacaoPagamentoPedido = SituacaoPagamentoPedidoEnum.PENDENTE;

    private Double valor;

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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Revendedor getRevendedor() {
        return revendedor;
    }

    public void setRevendedor(Revendedor revendedor) {
        this.revendedor = revendedor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getEntrega() {
        return entrega;
    }

    public void setEntrega(Date entrega) {
        this.entrega = entrega;
    }

    public Date getPedido() {
        return pedido;
    }

    public void setPedido(Date pedido) {
        this.pedido = pedido;
    }

    public Perfume getPerfume() {
        return perfume;
    }

    public void setPerfume(Perfume perfume) {
        this.perfume = perfume;
    }

    public SituacaoPagamentoPedidoEnum getSituacaoPagamentoPedido() {
        return situacaoPagamentoPedido;
    }

    public void setSituacaoPagamentoPedido(SituacaoPagamentoPedidoEnum situacaoPagamentoPedido) {
        this.situacaoPagamentoPedido = situacaoPagamentoPedido;
    }

    public SituacaoPedidoEnum getSituacaoPedido() {
        return situacaoPedido;
    }

    public void setSituacaoPedido(SituacaoPedidoEnum situacaoPedido) {
        this.situacaoPedido = situacaoPedido;
    }
    
}
