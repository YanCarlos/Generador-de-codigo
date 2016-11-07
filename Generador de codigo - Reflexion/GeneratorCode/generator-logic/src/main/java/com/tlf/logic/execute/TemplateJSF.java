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
 * @author Administrador
 */
public class TemplateJSF {

	private VelocityUtil util;
	private String path;

	public TemplateJSF(VelocityUtil util, String path) {
		super();
		this.util = util;
		this.path = path;
	}

	/**
	 * Metodo el cual crea los ejb respecto a las tablas obtenidas de la base de
	 * datos
	 *
	 * @param tables
	 *            , lista de tablas
	 * @param nameModule
	 *            , nombre del subproyecto
	 * @param nameProject
	 *            , nombre del proyecto
	 * @throws FileNotFoundException
	 */
	public void createBean(List<Table> tables, String nameModule,
			String nameProject) throws FileNotFoundException {
		Map<String, Object> map = new HashMap<>();
		PrintStream salidatxt = null;
		String pack = "com.beans";
		for (Table table : tables) {
			try {
				map.put("table", table);
				map.put("pack", pack);
				StringWriter writer = this.util.executeTemplate("bean.vm", map,
						"templates");
				salidatxt = new PrintStream(this.path + "/" + nameProject + "/"
						+ nameProject + "/" + nameProject + "-" + nameModule
						+ "/src/main/java/com/beans/"
						+ getNameClass(table.getTableName()) + "Bean.java");
				salidatxt.println(writer.toString());
				map.clear();
			} finally {
				salidatxt.close();
			}
		}
	}

	public void createIndexHTML(String nameModule, String nameProject)
			throws FileNotFoundException {
		Map<String, Object> map = new HashMap<>();
		PrintStream salidatxt = null;
		try {
			StringWriter writer = this.util.executeTemplate("indexHTML.vm",
					map, "templates");
			salidatxt = new PrintStream(this.path + "/" + nameProject + "/"
					+ nameProject + "/" + nameProject + "-" + nameModule
					+ "/src/main/webapp/index.html");
			salidatxt.println(writer.toString());
			map.clear();
		} finally {
			salidatxt.close();
		}
	}

	public void createIndexXHTML(String nameModule, String nameProject)
			throws FileNotFoundException {
		Map<String, Object> map = new HashMap<>();
		PrintStream salidatxt = null;
		try {
			map.put("name", nameProject);
			StringWriter writer = this.util.executeTemplate("indexXHTML.vm",
					map, "templates");
			salidatxt = new PrintStream(this.path + "/" + nameProject + "/"
					+ nameProject + "/" + nameProject + "-" + nameModule
					+ "/src/main/webapp/index.xhtml");
			salidatxt.println(writer.toString());
			map.clear();
		} finally {
			salidatxt.close();
		}
	}

	public void createIndexXHTMLPage(List<Table> tables, String nameModule,
			String nameProject) throws FileNotFoundException {
		Map<String, Object> map = new HashMap<>();
		PrintStream salidatxt = null;
		for (Table table : tables) {
			try {
				map.put("table", table);
				StringWriter writer = this.util.executeTemplate(
						"indexXHTMLPage.vm", map, "templates");
				salidatxt = new PrintStream(this.path + "/" + nameProject + "/"
						+ nameProject + "/" + nameProject + "-" + nameModule
						+ "/src/main/webapp/templates/" + table.getTableName()
						+ ".xhtml");
				salidatxt.println(writer.toString());
				map.clear();
			} finally {
				salidatxt.close();
			}
		}
	}

	public void createBeansXml(String nameModule, String nameProject)
			throws FileNotFoundException {
		Map<String, Object> map = new HashMap<>();
		PrintStream salidatxt = null;
		try {
			StringWriter writer = this.util.executeTemplate("beansXml.vm", map,
					"templates");
			salidatxt = new PrintStream(this.path + "/" + nameProject + "/"
					+ nameProject + "/" + nameProject + "-" + nameModule
					+ "/src/main/webapp/WEB-INF/beans.xml");
			salidatxt.println(writer.toString());
			map.clear();
		} finally {
			salidatxt.close();
		}
	}

	public void createFacesConfig(String nameModule, String nameProject)
			throws FileNotFoundException {
		Map<String, Object> map = new HashMap<>();
		PrintStream salidatxt = null;
		try {
			StringWriter writer = this.util.executeTemplate("facesConfig.vm",
					map, "templates");
			salidatxt = new PrintStream(this.path + "/" + nameProject + "/"
					+ nameProject + "/" + nameProject + "-" + nameModule
					+ "/src/main/webapp/WEB-INF/faces-config.xml");
			salidatxt.println(writer.toString());
			map.clear();
		} finally {
			salidatxt.close();
		}
	}

	public void createExponerRest(String nameModule, String nameProject)
			throws FileNotFoundException {
		Map<String, Object> map = new HashMap<>();
		PrintStream salidatxt = null;
		try {
			StringWriter writer = this.util.executeTemplate("exponer.vm", map,
					"templates");
			salidatxt = new PrintStream(this.path + "/" + nameProject + "/"
					+ nameProject + "/" + nameProject + "-" + nameModule
					+ "/src/main/java/com/rest/Expone.java");
			salidatxt.println(writer.toString());
			map.clear();
		} finally {
			salidatxt.close();
		}
	}

	public void createIndentificador(String nameModule, String nameProject)
			throws FileNotFoundException {
		Map<String, Object> map = new HashMap<>();
		PrintStream salidatxt = null;
		try {
			StringWriter writer = this.util.executeTemplate("idRest.vm", map,
					"templates");
			salidatxt = new PrintStream(this.path + "/" + nameProject + "/"
					+ nameProject + "/" + nameProject + "-" + nameModule
					+ "/src/main/java/com/rest/Identificador.java");
			salidatxt.println(writer.toString());
			map.clear();
		} finally {
			salidatxt.close();
		}
	}

	public void createServices(List<Table> tables, String nameModule,
			String nameProject) throws FileNotFoundException {
		Map<String, Object> map = new HashMap<>();
		PrintStream salidatxt = null;
		for (Table table : tables) {
			try {
				map.put("table", table);
				StringWriter writer = this.util.executeTemplate("rest.vm", map,
						"templates");
				salidatxt = new PrintStream(this.path + "/" + nameProject + "/"
						+ nameProject + "/" + nameProject + "-" + nameModule
						+ "/src/main/java/com/services/"
						+ getNameClass(table.getTableName()) + "Service.java");
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
	 * @param name
	 *            , nombre de la clase
	 * @return
	 */
	public String getNameClass(String name) {
		String capital = name.charAt(0) + "";
		return (capital.toUpperCase() + name.substring(1));
	}
}
