/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tlf.gui.controller;

import com.tlf.abstration.entities.Connector;
import com.tlf.abstration.entities.DataBase;
import com.tlf.abstration.entities.Table;
import com.tlf.abstration.reflection.Reflection;
import com.tlf.logic.constant.Constant;
import com.tlf.logic.execute.TemplateJSF;
import com.tlf.logic.execute.TemplateWebHTML;
import com.tlf.logic.execute.TempleteEJB;
import com.tlf.logic.execute.TempleteJPA;
import com.tlf.logic.folder.CreateFolder;
import com.tlf.logic.velocityUtil.VelocityUtil;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Crisitan Camilo Zapata Torres
 * @version 1.0.0
 * @see <a href="https://plus.google.com/u/0/117178818025238083388">Perfil</a>
 */
public class Controller {

	private Connector conn;
	private Connection con;
	private Reflection ref;
	private VelocityUtil util;

	public Controller() {
		this.ref = new Reflection();
		this.util = new VelocityUtil();
	}

	public boolean establishConnection(String driver, String url, String user,
			String pass) {
		try {
			this.conn = new Connector(user, pass, url, driver);
			this.con = this.ref.getConnection(conn);
			return (con != null);
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public List<DataBase> listDatabase() {
		List<DataBase> ldb = new ArrayList<>();
		try {
			ldb = this.ref.listDataBases(this.con);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return ldb;
	}

	public void generateProject(String driver, String path, DataBase bd) {
		try {
			this.conn.setDataBase(bd.getName());
			List<Table> tables = this.ref.listTables(this.con, bd);
			for (Table table : tables) {
				table.setColumns(ref.listColumns(this.con, bd, table));
				table.setPrimaries(ref.listPrimaries(this.con, bd, table));
				table.setForeigns(ref.listForeings(this.con, bd, table));
			}
			/*
			 * Cremos las carpetas
			 */
			CreateFolder cf = new CreateFolder(this.util, path);
			cf.createFolderPrincipalJSF(bd.getName());
                        cf.createFolderWebPage(bd.getName());
                        
			/*
			 * Creamos los archivos internos como son las clases, dao, etc
			 */
			TempleteJPA tJPA = new TempleteJPA(this.util, path);
			tJPA.createDao(Constant.jpa.toString(), bd.getName());
			tJPA.createEntity(tables, Constant.jpa.toString(), bd.getName());
			tJPA.createPersisten(driver, Constant.jpa.toString(), bd.getName());
			/*
			 * Creamos los archivs con respecto a los EJB
			 */
			TempleteEJB tEJB = new TempleteEJB(this.util, path);
			tEJB.createEJBGeneric(Constant.ejb.toString(), bd.getName());
			tEJB.createEJB(tables, Constant.ejb.toString(), bd.getName());
			/*
			 * Creamos los archivos con respecto a los Bean
			 */
			TemplateJSF tJSF = new TemplateJSF(this.util, path);
			tJSF.createBean(tables, Constant.web.toString(), bd.getName());
			tJSF.createIndexHTML(Constant.web.toString(), bd.getName());
			tJSF.createIndexXHTML(Constant.web.toString(), bd.getName());
			tJSF.createBeansXml(Constant.web.toString(), bd.getName());
			tJSF.createFacesConfig(Constant.web.toString(), bd.getName());
			tJSF.createIndexXHTMLPage(tables, Constant.web.toString(),
					bd.getName());
			tJSF.createExponerRest(Constant.web.toString(), bd.getName());
			tJSF.createIndentificador(Constant.web.toString(), bd.getName());
			tJSF.createServices(tables, Constant.web.toString(), bd.getName());

                        /*
                        Creamos los archivos de la pagina web
                        */
                        TemplateWebHTML tWeb= new TemplateWebHTML(this.util, path);
                        tWeb.createIndexHTML(Constant.webPage.toString(), bd.getName());
                        tWeb.crearteDependencies(Constant.webPage.toString(), bd.getName());
                        tWeb.createMenu(tables, Constant.webPage.toString(), bd.getName());
                        tWeb.createModulePageHTML(tables, Constant.webPage.toString(), bd.getName());
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}

}
