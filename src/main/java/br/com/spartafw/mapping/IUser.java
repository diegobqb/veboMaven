/*
 * IUser.java
 *
 * Created on 26 de Agosto de 2007, 20:56
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.spartafw.mapping;

import java.util.Collection;

/**
 *
 * @author mohfus
 * @since 26 de Agosto de 2007
 */
public interface IUser {

    public abstract String getLogin();
    
    public abstract Collection<IFunctionality> functionalities();
}
