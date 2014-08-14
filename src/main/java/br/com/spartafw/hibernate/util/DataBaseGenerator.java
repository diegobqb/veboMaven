/*
 * DataBaseScriptGenerator.java
 *
 * Created on 29 de Julho de 2007, 16:21
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.spartafw.hibernate.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * Classe responsavel por criar todo o esquema de banco de dados
 * @author Diego Barreto
 * @since 29 de Julho de 2007
 */
public class DataBaseGenerator {
      
    //public S
    
    /**
     * Metodo que efetivaente cria todo o banco de dados, de acordo com o arquivo de 
     * configuracao hibernate.cfg.xml
     */
    public void createDatabase() {
        Configuration conf = new AnnotationConfiguration();
        conf.configure();
        
        SchemaExport se = new SchemaExport(conf);
        se.create(true, true);
    }
}

