/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tlf.logic.velocityUtil;

import java.io.StringWriter;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;

/**
 *
 * @author Crisitan Camilo Zapata Torres
 * @version 1.0.0
 * @see <a href="https://plus.google.com/u/0/117178818025238083388">Perfil</a>
 */
public class VelocityUtil {

    /**
     * Logger
     */
    private Logger logger = Logger.getLogger(VelocityUtil.class);

    /**
     * ruta base de las plantilas.
     */
    private String rutaBase;

    /**
     * Constructor
     */
    public VelocityUtil() {
        super();
    }

    /**
     *
     * Constructor ruta base de las plantillas.
     *
     * @param rutaBase
     */
    public VelocityUtil(String rutaBase) {
        this.rutaBase = rutaBase;
    }
    
    /**
     * Metodo para ejecutar la plantilla.
     *
     * @author Camilo Andres Ferrer Bustos <caferrerb@eam.edu.co>
     * @date 7/11/2015
     * @param rutaPlantilla, nombre de la plantilla a compilar con la ruta a partir de la base
     * @param parametros, mapa de valores a ejecutar en la plantilla
     * @param rutaBase, ruta donde estan almacenadas las plantillas
     * @return cadena con la plantilla ejecutada.
     */
    public StringWriter executeTemplate(String rutaPlantilla, Map<String, Object> parametros, String rutaBase) {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "file");
        ve.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH, rutaBase);
        ve.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_CACHE, "true");
        ve.init();

        // calcular la ruta de la plantilla.

        /* next, get the Template */
        Template t = ve.getTemplate(rutaPlantilla);
        /* create a context and add data */
        VelocityContext context = new VelocityContext();
        // llenar los parametro del velocity.
        for (Map.Entry<String, Object> entry : parametros.entrySet()) {
            context.put(entry.getKey(), entry.getValue());
        }

        /* now render the template into a StringWriter */
        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        return writer;
    }
}
