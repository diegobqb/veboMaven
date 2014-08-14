/*
 * DataAccessException.java
 *
 * Created on 16 de Julho de 2007, 19:36
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.spartafw.exception;

/**
 * Classe que representa uma falha ao acessar os dados da aplicacao, ou mesmo uma 
 * falha de comunicacao com o banco de dados.
 * @author Diego Barreto
 * @since 16 de Julho de 2007
 */
public class CryptographyException extends Exception {
    
    /**
     * Cria uma nova instancia de DataAccessException
     */
    public CryptographyException() {
    }
    
    /**
     * Cria uma nova instancia de DataAccessException
     * @param message Descricao da excecao.
     */
    public CryptographyException(String message) {
        super(message);
    }
    
    /**
     * Cria uma nova instancia de DataAccessException
     * @param message Descricao da excecao.
     * @param exception Excecao a ser encapsulada.
     */
    public CryptographyException(String message, Throwable exception) {
        super(message, exception);
    }
    
    /**
     * Cria uma nova instancia de DataAccessException
     * @param exception Excecao a ser encapsulada.
     */
    public CryptographyException(Throwable exception) {
        super(exception);
    }

}