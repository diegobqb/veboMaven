/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.vebo.dados.enums;

/**
 *
 * @author mohfus
 */
public enum MesEnum {
    JANEIRO ("Janeiro",0),
    FEVEREIRO ("Fevereiro",1),
    MARCO ("Março",2),
    ABRIL ("Abril",3),
    MAIO ("Maio",4),
    JUNHO ("Junho",5),
    JULHO ("Julho",6),
    AGOSTO ("Agosto",7),
    SETEMBRO ("Setembro",8),
    OUTUBRO ("Outubro",9),
    NOVEMBRO ("Novembro",10),
    DEZEMBRO ("Dezembro",11);

    private String nome;

    private int numero;

    private MesEnum(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

}
