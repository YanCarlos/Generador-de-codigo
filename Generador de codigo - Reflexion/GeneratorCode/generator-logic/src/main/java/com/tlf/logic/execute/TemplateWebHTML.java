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
 *
 * @author donoso
 */
public class TemplateWebHTML {

    private VelocityUtil util;
    private String path;

    public TemplateWebHTML(VelocityUtil util, String path) {
        super();
        this.util = util;
        this.path = path;
    }

    /**
     * Método que crea el index de la página web
     *
     * @param nameModule, nombre del modulo
     * @param nameProject, nombre de la base de datos
     * @throws FileNotFoundException
     */
    public void createIndexHTML(String nameModule, String nameProject)
            throws FileNotFoundException {
        Map<String, Object> map = new HashMap<>();
        PrintStream salidatxt = null;
        try {
            map.put("name", nameProject);
            StringWriter writer = this.util.executeTemplate("indexHTML.vm",
                    map, "templates");
            salidatxt = new PrintStream(this.path + "/" + nameProject + "/"
                    + nameProject + "-" + nameModule + "/index.html");
            salidatxt.println(writer.toString());
            map.clear();
        } finally {
            salidatxt.close();
        }
    }

    /**
     * Método que crea los archivos con de dependencias para la pagina web
     *
     * @param nameModule, nombre del modulo
     * @param nameProject, nombre de la base de datos
     * @throws FileNotFoundException
     */
    public void crearteDependencies(String nameModule, String nameProject)
            throws FileNotFoundException {
        createBootstrapCssDependency(nameModule, nameProject);
        createJQueryDependency(nameModule, nameProject);
//        createAngularDependency(nameModule, nameProject);
        createAngularRouteDependency(nameModule, nameProject);
    }
    
    /**
     * Método que crea la dependencia a bootstrap css
     * @param nameModule, nombre del modulo
     * @param nameProject, nombre de la base de datos
     * @throws FileNotFoundException 
     */
    private void createBootstrapCssDependency(String nameModule, String nameProject)
            throws FileNotFoundException {
        Map<String, Object> map = new HashMap<>();
        PrintStream salidatxt = null;
        try {
            StringWriter writer = this.util.executeTemplate("bootstrap.vm",
                    map, "templates");
            salidatxt = new PrintStream(this.path + "/" + nameProject + "/"
                    + nameProject + "-" + nameModule + "/Resources/css/bootstrap.min.css");
            salidatxt.println(writer.toString());
            map.clear();
        } finally {
            salidatxt.close();
        }
    }
    
    /**
     * Método que crea la dependencia a jquery
     * @param nameModule, nombre del modulo
     * @param nameProject, nombre de la base de datos
     * @throws FileNotFoundException 
     */
    private void createJQueryDependency(String nameModule, String nameProject)
            throws FileNotFoundException {
        Map<String, Object> map = new HashMap<>();
        PrintStream salidatxt = null;
        try {
            StringWriter writer = this.util.executeTemplate("jquery.vm", map, "templates");
            salidatxt = new PrintStream(this.path + "/" + nameProject + "/"
                    + nameProject + "-" + nameModule + "/Resources/js/jquery.min.js");
            salidatxt.println(writer.toString());
            map.clear();
        } finally {
            salidatxt.close();
        }
    }

    /**
     * Método que crea la dependencia a angular
     * @param nameModule, nombre del modulo
     * @param nameProject, nombre de la base de datos
     * @throws FileNotFoundException 
     */
    private void createAngularDependency(String nameModule, String nameProject)
            throws FileNotFoundException {
        Map<String, Object> map = new HashMap<>();
        PrintStream salidatxt = null;
        try {
            StringWriter writer = this.util.executeTemplate("angular.vm", map, "templates");
            salidatxt = new PrintStream(this.path + "/" + nameProject + "/"
                    + nameProject + "-" + nameModule + "/Resources/js/angular.min.js");
            salidatxt.println(writer.toString());
            map.clear();
        } finally {
            salidatxt.close();
        }
    }
    
    /**
     * Método que crea la dependencia a angular
     * @param nameModule, nombre del modulo
     * @param nameProject, nombre de la base de datos
     * @throws FileNotFoundException 
     */
    private void createAngularRouteDependency(String nameModule, String nameProject)
            throws FileNotFoundException {
        Map<String, Object> map = new HashMap<>();
        PrintStream salidatxt = null;
        try {
            StringWriter writer = this.util.executeTemplate("angularRoute.vm", map, "templates");
            salidatxt = new PrintStream(this.path + "/" + nameProject + "/"
                    + nameProject + "-" + nameModule + "/Resources/js/angular-route.min.js");
            salidatxt.println(writer.toString());
            map.clear();
        } finally {
            salidatxt.close();
        }
    }
    
    /**
     * Método que crea el menu de la pagina web
     *
     * @param tables, lista de tablas de la base de datos
     * @param nameModule, nombre del modulo
     * @param nameProject, nombre de la base de datos
     * @throws FileNotFoundException
     */
    public void createMenu(List<Table> tables, String nameModule, String nameProject)
            throws FileNotFoundException {
        Map<String, Object> map = new HashMap<>();
        PrintStream salidatxt = null;
        try {
            map.put("tables", tables);
            StringWriter writer = this.util.
                    executeTemplate("menuHTML.vm", map, "templates");
            salidatxt = new PrintStream(this.path + "/" + nameProject + "/"
                    + nameProject + "-" + nameModule
                    + "/Views/Templates/menu.html");
            salidatxt.println(writer.toString());
            map.clear();
        } finally {
            salidatxt.close();
        }

    }

    /**
     * Método que crea las páginas de cada modulo del proyecto que se genera
     *
     * @param tables, lista de tablas de la base de datos
     * @param nameModule, nombre del modulo
     * @param nameProject, nombre de la base de datos
     * @throws FileNotFoundException
     */
    public void createModulePageHTML(List<Table> tables, String nameModule, String nameProject)
            throws FileNotFoundException {
        Map<String, Object> map = new HashMap<>();
        PrintStream salidatxt = null;
        for (Table table : tables) {
            try {
                map.put("table", table);
                map.put("columns", table.getColumns());
                StringWriter writer = this.util.
                        executeTemplate("pageHTML.vm", map, "templates");
                salidatxt = new PrintStream(this.path + "/" + nameProject + "/"
                        + nameProject + "-" + nameModule
                        + "/Views/" + getNameClass(table.getTableName()) + ".html");
                salidatxt.println(writer.toString());
                map.clear();
            } finally {
                salidatxt.close();
            }
        }

    }
    /**
     * Método que crea la definicíon del ng-app de angular
     * @param nameModule, nombre del modulo
     * @param nameProject, nombre de la base de datos
     * @throws FileNotFoundException 
     */
    public void createAngularApp(List<Table> tables,String nameModule, String nameProject) 
            throws FileNotFoundException{
        Map<String, Object> map = new HashMap<>();
        PrintStream salidatxt = null;
        try {
            map.put("name", nameProject);
            map.put("tables", tables);
            StringWriter writer = this.util.
                    executeTemplate("ngApp.vm", map, "templates");
            salidatxt = new PrintStream(this.path + "/" + nameProject + "/"
                    + nameProject + "-" + nameModule
                    + "/Resources/js/General/app.js");
            salidatxt.println(writer.toString());
            map.clear();
        } finally {
            salidatxt.close();
        }
    }
    /**
     * Método que crea los controladores de la pagina web
     * @param tables, lista de tablas de la base de datos
     * @param nameModule, nombre del modulo
     * @param nameProject, nombre de la base de datos
     * @throws FileNotFoundException 
     */
    public void createAngularControllers(List<Table> tables, String nameModule, String nameProject)
            throws FileNotFoundException{
        Map<String, Object> map = new HashMap<>();
        PrintStream salidatxt = null;
        for (Table table : tables) {
            try {
                map.put("table", table);
                map.put("columns", table.getColumns());
                StringWriter writer = this.util.
                        executeTemplate("angularController.vm", map, "templates");
                salidatxt = new PrintStream(this.path + "/" + nameProject + "/"
                        + nameProject + "-" + nameModule
                        + "/Resources/js/Controllers/ctl"+getNameClass(table.getTableName())+".js");
                salidatxt.println(writer.toString());
                map.clear();
            } finally {
                salidatxt.close();
            }
        }
    }

    /* Método que crea los services de la pagina web
     * @param tables, lista de tablas de la base de datos
     * @param nameModule, nombre del modulo
     * @param nameProject, nombre de la base de datos
     * @throws FileNotFoundException 
     */
    public void createAngularServices(List<Table> tables, String nameModule, String nameProject)
            throws FileNotFoundException{
        Map<String, Object> map = new HashMap<>();
        PrintStream salidatxt = null;
        for (Table table : tables) {
            try {
                map.put("table", table);
                map.put("columns", table.getColumns());
                StringWriter writer = this.util.
                        executeTemplate("angularService.vm", map, "templates");
                salidatxt = new PrintStream(this.path + "/" + nameProject + "/"
                        + nameProject + "-" + nameModule
                        + "/Resources/js/Services/ser"+getNameClass(table.getTableName())+".js");
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
     * @param name , nombre de la clase
     * @return
     */
    public String getNameClass(String name) {
        String capital = name.charAt(0) + "";
        return (capital.toUpperCase() + name.substring(1));
    }
}
