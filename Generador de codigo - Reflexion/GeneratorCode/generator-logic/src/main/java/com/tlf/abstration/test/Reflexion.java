package com.tlf.abstration.test;

import com.tlf.abstration.entities.Connector;
import com.tlf.abstration.entities.DataBase;
import com.tlf.abstration.entities.Table;
import com.tlf.abstration.reflection.Reflection;
import com.tlf.logic.constant.Constant;
import com.tlf.logic.execute.TempleteJPA;
import com.tlf.logic.folder.CreateFolder;
import com.tlf.logic.velocityUtil.VelocityUtil;
import java.sql.Connection;
import java.util.List;

public class Reflexion {

    public static void main(String[] args) {
        new Reflexion();
    }

    public Reflexion() {
        try {
            String path = "C:\\Users\\Administrador\\Desktop\\Proyecto Generados";
            Connector con = new Connector("root", "root",
                    "jdbc:mysql://localhost:3306", "com.mysql.jdbc.Driver");
            Reflection ref = new Reflection();
            Connection conn = ref.getConnection(con);
            List<DataBase> dbs = ref.listDataBases(conn);
            DataBase bd = dbs.get(0);
            List<Table> tables = ref.listTables(conn, bd);
            for (Table table : tables) {
                table.setColumns(ref.listColumns(conn, bd, table));
                table.setPrimaries(ref.listPrimaries(conn, bd, table));
                table.setForeigns(ref.listForeings(conn, bd, table));
            }            
            VelocityUtil vUtil = new VelocityUtil();
            CreateFolder cf = new CreateFolder(vUtil, path);
            cf.createFolderPrincipalJSF(bd.getName());
            TempleteJPA tJPA = new TempleteJPA(vUtil, path);
            tJPA.createDao(Constant.jpa.toString(), bd.getName());
            tJPA.createEntity(tables, Constant.jpa.toString(), bd.getName());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
