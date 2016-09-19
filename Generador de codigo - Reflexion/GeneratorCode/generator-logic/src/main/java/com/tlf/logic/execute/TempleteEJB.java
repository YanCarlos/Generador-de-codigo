/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tlf.logic.execute;

import com.tlf.abstration.entities.Table;
import com.tlf.logic.velocityUtil.VelocityUtil;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase la cual ejecutar y creara los archivos relacionados con el proyecto
 * JAVA-EJB
 *
 * @author Crisitan Camilo Zapata Torres
 * @version 1.0.0
 * @see <a href="https://plus.google.com/u/0/117178818025238083388">Perfil</a>
 */
public class TempleteEJB {

    private VelocityUtil util;
    private String path;

    public TempleteEJB(VelocityUtil util, String path) {
        super();
        this.util = util;
        this.path = path;
    }

    /**
     * Metodo el cual crea un EJB generico para realizar las acciones de CRUD
     *
     * @param nameModule, nombre del subproyecto.
     * @param nameProject, nombre del proyecto padre
     * @throws FileNotFoundException
     */
    public void createEJBGeneric(String nameModule, String nameProject) throws FileNotFoundException {
        Map<String, Object> map = new HashMap<>();
        PrintStream salidatxt = null;
        String pack = "com.util";
        try {
            map.put("pack", pack);
            StringWriter writer = this.util.
                    executeTemplate("ejbGenerico.vm", map, "templates");
            salidatxt = new PrintStream(this.path + "/" + nameProject + "/" + nameModule
                    + "/src/main/java/com/util/EJBGenerico.java");
            salidatxt.println(writer.toString());
            map.clear();
        } finally {
            salidatxt.close();
        }
    }

    /**
     * Metodo el cual crea los ejb respecto a las tablas obtenidas de la base de
     * datos
     *
     * @param tables, lista de tablas
     * @param nameModule, nombre del subproyecto
     * @param nameProject, nombre del proyecto
     * @throws FileNotFoundException
     */
    public void createEJB(List<Table> tables, String nameModule, String nameProject)
            throws FileNotFoundException {
        Map<String, Object> map = new HashMap<>();
        PrintStream salidatxt = null;
        String pack = "com.ejb";
        for (Table table : tables) {
            try {
                map.put("table", table);
                map.put("pack", pack);
                StringWriter writer = this.util.
                        executeTemplate("ejbs.vm", map, "templates");
                salidatxt = new PrintStream(this.path + "/" + nameProject + "/" + nameModule
                        + "/src/main/java/com/ejb/"
                        + getNameClass(table.getTableName()) + "EJB.java");
                salidatxt.println(writer.toString());
                map.clear();
            } finally {
                salidatxt.close();
            }
        }
    }

    /**
     * Metodo para nombre correctamente una clase con CamellCase
     *
     * @param name, nombre de la clase
     * @return
     */
    public String getNameClass(String name) {
        String capital = name.charAt(0) + "";
        return (capital.toUpperCase() + name.substring(1));
    }

}
