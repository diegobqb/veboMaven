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
import javax.persistence.Temporal;

/**
 * @author mohfus
 * @since 13 de Maio de 2009
 */
@Entity
public class Revendedor extends AbstractBaseEntity {
    
    /** Cria uma nova instancia de Country */
    public Revendedor() {
    }
    
    /**
     * Identificador unico da instancia
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_revendedor")
    private Long id;
    
    private String nome;

    private String cpf;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date nascimento;

    private String telefone;

    private String celular;

    private String email;

    @Column(length=1000)
    private String endereco;

    @Column(length=1000)
    private String observacoes;

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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return nome;
    }
}
