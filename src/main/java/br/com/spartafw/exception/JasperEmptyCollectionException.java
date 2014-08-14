/*
 * JasperEmptyCollectionException.java
 *
 * Created on 16 de Julho de 2007, 19:36
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.spartafw.exception;

/**
 * Classe que representa o erro do uma colecao vazia para o relatorio.
 * @author Diego Barreto
 * @since 16 de Julho de 2007
 */
public class JasperEmptyCollectionException extends Exception {
    
    /**
     * Cria uma nova instancia de JasperEmptyCollectionException
     */
    public JasperEmptyCollectionException() {
    }
    
    /**
     * Cria uma nova instancia de JasperEmptyCollectionException
     * @param message Descricao da excecao.
     */
    public JasperEmptyCollectionException(String message) {
        super(message);
    }
    
    /**
     * Cria uma nova instancia de JasperEmptyCollectionException
     * @param message Descricao da excecao.
     * @param exception Excecao a ser encapsulada.
     */
    public JasperEmptyCollectionException(String message, Throwable exception) {
        super(message, exception);
    }
    
    /**
     * Cria uma nova instancia de JasperEmptyCollectionException
     * @param exception Excecao a ser encapsulada.
     */
    public JasperEmptyCollectionException(Throwable exception) {
        super(exception);
    }

}