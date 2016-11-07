/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tlf.logic.execute;

import com.tlf.abstration.entities.Table;
import com.tlf.logic.properties.ReadProperty;
import com.tlf.logic.velocityUtil.VelocityUtil;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase la cual ejecutar y creara los archivos relacionados con el proyecto
 * JAVA-JPA
 *
 * @author Crisitan Camilo Zapata Torres
 * @version 1.0.0
 * @see <a href="https://plus.google.com/u/0/117178818025238083388">Perfil</a>
 */
public class TempleteJPA {

	private VelocityUtil util;
	private String path;

	public TempleteJPA(VelocityUtil util, String path) {
		super();
		this.util = util;
		this.path = path;
	}

	/**
	 * Metodo el cual crea las entidades del proyecto con base en la lista de
	 * tablas que llegan de la reflexion.
	 *
	 * @param tables
	 *            , lista de tablas
	 * @param nameModule
	 *            , nombre del sub proyecto
	 * @param nameProject
	 *            , nombre del proyecto padre
	 * @throws FileNotFoundException
	 */
	public void createEntity(List<Table> tables, String nameModule,
			String nameProject) throws FileNotFoundException {
		Map<String, Object> map = new HashMap<>();
		PrintStream salidatxt = null;
		String pack = "com.entity";
		for (Table table : tables) {
			try {
				map.put("table", table);
				map.put("pack", pack);
				map.put("columns", table.getColumns());
				map.put("primaries", table.getPrimaries());
				map.put("foreigns", table.getForeigns());
				StringWriter writer = this.util.executeTemplate("entity.vm",
						map, "templates");
				salidatxt = new PrintStream(this.path + "/" + nameProject + "/"
						+ nameProject + "/" + nameProject + "-" + nameModule
						+ "/src/main/java/com/entity/"
						+ getNameClass(table.getTableName()) + ".java");
				salidatxt.println(writer.toString());
				map.clear();
				if (table.getPrimaries().size() > 1) {
					this.createEntityId(table, nameModule, nameProject);
				}
			} finally {
				salidatxt.close();
			}
		}
	}

	public void createEntityId(Table table, String nameModule,
			String nameProject) throws FileNotFoundException {
		Map<String, Object> map = new HashMap<>();
		PrintStream salidatxt = null;
		String pack = "com.entity";
		try {
			map.put("table", table);
			map.put("pack", pack);
			map.put("columns", table.getColumns());
			map.put("primaries", table.getPrimaries());
			StringWriter writer = this.util.executeTemplate("entityId.vm", map,
					"templates");
			salidatxt = new PrintStream(this.path + "/" + nameProject + "/"
					+ nameProject + "/" + nameProject + "-" + nameModule
					+ "/src/main/java/com/entity/"
					+ getNameClass(table.getTableName()) + "Id.java");
			salidatxt.println(writer.toString());
			map.clear();
		} finally {
			salidatxt.close();
		}
	}

	/**
	 * Metodo el cual crea un DAO generico para realizar las acciones sobre la
	 * base de datos
	 *
	 * @param nameModule
	 *            , nombre del subproyecto.
	 * @param nameProject
	 *            , nombre del proyecto padre
	 * @throws FileNotFoundException
	 */
	public void createDao(String nameModule, String nameProject)
			throws FileNotFoundException {
		Map<String, Object> map = new HashMap<>();
		PrintStream salidatxt = null;
		String pack = "com.DAO";
		try {
			map.put("pack", pack);
			StringWriter writer = this.util.executeTemplate("daoGenerico.vm",
					map, "templates");
			salidatxt = new PrintStream(this.path + "/" + nameProject + "/"
					+ nameProject + "/" + nameProject + "-" + nameModule
					+ "/src/main/java/com/DAO/DAOGenerico.java");
			salidatxt.println(writer.toString());
			map.clear();
		} finally {
			salidatxt.close();
		}
	}

	/**
	 * Metodo el cual crea el archivo persisten.xml donde van mapeadas las
	 * clases
	 *
	 * @param nameDriver
	 * @param nameModule
	 *            ,, nombre del subProyecto
	 * @param nameProject
	 *            , nombre del proyecto padre
	 * @throws FileNotFoundException
	 */
	public void createPersisten(String nameDriver, String nameModule,
			String nameProject) throws FileNotFoundException {
		Map<String, Object> map = new HashMap<>();
		PrintStream salidatxt = null;
		try {
			map.put("nameProject", nameProject);
			map.put("dialect", ReadProperty.mapDialect.get(nameDriver));
			StringWriter writer = this.util.executeTemplate("persisten.vm",
					map, "templates");
			salidatxt = new PrintStream(this.path + "/" + nameProject + "/"
					+ nameProject + "/" + nameProject + "-" + nameModule
					+ "/src/main/resources/META-INF/persistence.xml");
			salidatxt.println(writer.toString());
			map.clear();
		} finally {
			salidatxt.close();
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
