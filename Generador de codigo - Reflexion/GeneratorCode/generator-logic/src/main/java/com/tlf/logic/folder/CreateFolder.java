/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tlf.logic.folder;

import com.tlf.logic.constant.Constant;
import com.tlf.logic.velocityUtil.VelocityUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase la cual se encargara de crear los directorios de los proyectos
 *
 * @author Crisitan Camilo Zapata Torres
 * @version 1.0.0
 * @see <a href="https://plus.google.com/u/0/117178818025238083388">Perfil</a>
 */
public class CreateFolder {

	private VelocityUtil util;
	private String path;

	public CreateFolder(VelocityUtil util, String path) {
		super();
		this.util = util;
		this.path = path;
	}

	/**
	 * Metodo el cual crea el paquete o proyecto principal Maven para el proyect
	 * WEB Java
	 *
	 * @param name
	 *            , es el nombre que llevara la carpeta o proyeto global
	 * @throws FileNotFoundException
	 */
	public void createFolderPrincipalJSF(String name)
			throws FileNotFoundException {
		createFolder(path + "/" + name);
		Map<String, Object> map = new HashMap<>();
		PrintStream salidatxt = null;
		List<String> modules = new ArrayList<>();
		modules.add(Constant.ejb.toString());
		modules.add(Constant.web.toString());
		modules.add(Constant.ear.toString());
		modules.add(Constant.jpa.toString());
		try {
			map.put("nameGroup", name);
			map.put("nameId", name);
			map.put("modules", modules);
			StringWriter writer = this.util.executeTemplate("pomPpal.vm", map,
					"templates");
			salidatxt = new PrintStream(path + "/" + name + "/pom.xml");
			salidatxt.println(writer.toString());
			map.clear();
		} finally {
			salidatxt.close();
		}
		for (String module : modules) {
			this.createModuleJSF(module, name);
		}
	}

	/**
	 * Metodo el cual crea los modulos del del proyeto principal java web
	 *
	 * @param nameModule
	 *            , nombre del modulo del proyecto
	 * @param nameProject
	 *            , nombre del padre del modulo
	 * @param modules
	 *            , lista de los modulos del cual depende el que se va a crear
	 * @throws FileNotFoundException
	 */
	private void createModuleJSF(String nameModule, String nameProject)
			throws FileNotFoundException {
		createFolder(path + "/" + nameProject + "/" + nameProject + "-"
				+ nameModule);
		Map<String, Object> map = new HashMap<>();
		PrintStream salidatxt = null;
		try {
			map.put("nameGroup", nameProject);
			map.put("nameId", nameProject);
			map.put("nameModule", nameModule);
			StringWriter writer = this.util.executeTemplate("pomModule.vm",
					map, "templates");
			salidatxt = new PrintStream(path + "/" + nameProject + "/"
					+ nameProject + "-" + nameModule + "/pom.xml");
			salidatxt.println(writer.toString());
			map.clear();
		} finally {
			salidatxt.close();
		}
		createFolderInternal(nameModule, nameProject);
	}

	/**
	 * Metodo el cual crea los directorios internos de los subproyectos o mudlos
	 *
	 * @param nameModule
	 *            , nombre del modulo
	 * @param nameProject
	 *            , nombre del proyecto padre
	 */
	private void createFolderInternal(String nameModule, String nameProject) {
		String pathLocal = nameProject + "/" + nameProject + "-" + nameModule;
		createFolder(this.path + "/" + pathLocal + "/src");
		createFolder(this.path + "/" + pathLocal + "/src/main");
		if(!nameModule.equals(Constant.ear.toString())){
			createFolder(this.path + "/" + pathLocal + "/src/main/java");
			createFolder(this.path + "/" + pathLocal + "/src/main/java/com");
		}
		if (nameModule.equals(Constant.ear.toString())) {
			createFolder(this.path + "/" + pathLocal + "/src/main/application");
			createFolder(this.path + "/" + pathLocal + "/src/main/application/META-INF");
		}
		if (nameModule.equals(Constant.jpa.toString())) {
			createFolder(this.path + "/" + pathLocal + "/src/main/resources");
			createFolder(this.path + "/" + pathLocal
					+ "/src/main/resources/META-INF");
			createFolder(this.path + "/" + pathLocal
					+ "/src/main/java/com/entity");
			createFolder(this.path + "/" + pathLocal + "/src/main/java/com/DAO");
		}
		if (nameModule.equals(Constant.ejb.toString())) {
			createFolder(this.path + "/" + pathLocal + "/src/main/resources");
			createFolder(this.path + "/" + pathLocal
					+ "/src/main/java/com/util");
			createFolder(this.path + "/" + pathLocal + "/src/main/java/com/ejb");
		}
		if (nameModule.equals(Constant.web.toString())) {
			createFolder(this.path + "/" + pathLocal + "/src/main/webapp");
			createFolder(this.path + "/" + pathLocal
					+ "/src/main/webapp/resources");
			createFolder(this.path + "/" + pathLocal
					+ "/src/main/webapp/WEB-INF");
			createFolder(this.path + "/" + pathLocal
					+ "/src/main/webapp/templates");
			createFolder(this.path + "/" + pathLocal
					+ "/src/main/java/com/beans");
			createFolder(this.path + "/" + pathLocal
					+ "/src/main/java/com/services");
			createFolder(this.path + "/" + pathLocal
					+ "/src/main/java/com/rest");
		}
	}

	/**
	 * Metodo que crea directorios
	 *
	 * @param name
	 */
	private void createFolder(String name) {
		File file = new File(name);
		file.mkdir();
	}

}
