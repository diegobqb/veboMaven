/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.vebo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mohfus
 */
public class DateUtil {

    private SimpleDateFormat formatador;

    public DateUtil() {
        formatador = new SimpleDateFormat("dd/MM/yyyy");
        
    }

    public Date stringParaDate(String data) {
        try {
            Date retorno = formatador.parse(data);
            return retorno;
        }
        catch(Exception e) {
            return null;
        }
    }

    public String dateParaString(Date data) {
        try {
            String retorno = formatador.format(data);
            return retorno;
        }
        catch(Exception e) {
            return "";
        }
    }

}
