/*
 * AbstractBaseEntity.java
 *
 * Created on 13 de Julho de 2007, 22:35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.spartafw.mapping;

import java.io.Serializable;

/**
 * Classe generica abstrata que serve como base para todas as entidades do sistema.
 * @author Diego Barreto
 * @since 13 de Julho de 2007
 */
public abstract class AbstractBaseEntity implements Serializable, Comparable{
    
    /**
     * Metodo abstrato que acessa o identificador unico da entidade. Como esta classe 
     * nao possui tal identificador, todas as suas especilizacoes devem implementar este
     * metodo e permitir assim o acesso ao seu identificador.
     * @return Identificador unico da instancia
     */
    public abstract Long getId();
    
    public int compareTo(Object o) {
        AbstractBaseEntity obj = (AbstractBaseEntity) o;
        return ((Comparable) this.getId()).compareTo(obj.getId());
    }

    public boolean equals(Object object) {
        AbstractBaseEntity obj = (AbstractBaseEntity) object;
        return this.getId().equals(obj.getId());
    }
    
}
