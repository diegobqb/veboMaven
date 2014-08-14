/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.vebo.util;

import java.text.DecimalFormat;

/**
 *
 * @author mohfus
 */
public class DoubleUtil {

    private DecimalFormat formatador;

    public DoubleUtil() {
        formatador = new DecimalFormat("###.00");
        
    }

    public Double stringParaDouble(String numero) {
        try {
            Double retorno = formatador.parse(numero).doubleValue();
            return retorno;
        }
        catch(Exception e) {
            return null;
        }
    }

    public String doubleParaString(Double numero) {
        try {
            String retorno = formatador.format(numero);
            return retorno;
        }
        catch(Exception e) {
            return "";
        }
    }

    public String doubleParaString(Double numero, String formato) {
        try {
            DecimalFormat formatadorEspecifico = new DecimalFormat(formato);
            String retorno = formatadorEspecifico.format(numero);
            return retorno;
        }
        catch(Exception e) {
            return "";
        }
    }

}
