/*
 * JasperProcessException.java
 *
 * Created on 16 de Julho de 2007, 19:36
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.spartafw.exception;

/**
 * Classe que representa uma falha no processamento do relatorio.
 * @author Diego Barreto
 * @since 16 de Julho de 2007
 */
public class JasperProcessException extends Exception {
    
    /**
     * Cria uma nova instancia de JasperProcessException
     */
    public JasperProcessException() {
    }
    
    /**
     * Cria uma nova instancia de JasperProcessException
     * @param message Descricao da excecao.
     */
    public JasperProcessException(String message) {
        super(message);
    }
    
    /**
     * Cria uma nova instancia de JasperProcessException
     * @param message Descricao da excecao.
     * @param exception Excecao a ser encapsulada.
     */
    public JasperProcessException(String message, Throwable exception) {
        super(message, exception);
    }
    
    /**
     * Cria uma nova instancia de JasperProcessException
     * @param exception Excecao a ser encapsulada.
     */
    public JasperProcessException(Throwable exception) {
        super(exception);
    }

}