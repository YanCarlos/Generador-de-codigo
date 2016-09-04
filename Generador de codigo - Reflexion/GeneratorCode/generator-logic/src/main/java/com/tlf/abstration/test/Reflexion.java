package com.tlf.abstration.test;

import com.tlf.abstration.entities.Column;
import com.tlf.abstration.entities.Connector;
import com.tlf.abstration.entities.DataBase;
import com.tlf.abstration.entities.Foreign;
import com.tlf.abstration.entities.Primary;
import com.tlf.abstration.entities.Table;
import com.tlf.abstration.reflection.Reflection;
import com.tlf.logic.execute.TempleteEntity;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reflexion {

    public static void main(String[] args) {
        new Reflexion();
    }

    public Reflexion() {
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String url = "jdbc:mysql://localhost:3306";
        String password = "root";

        Connector conexion = new Connector(user, password, url, driver);

        try {
            Reflection ref = new Reflection();
            Connection con = ref.getConnection(conexion);

            if (con != null) {
                List<DataBase> dbs = ref.listDataBases(con);
                List<Table> tables = new ArrayList<>();
                for (int i = 0; i < 1; i++) {
                    tables = ref.listTables(con, dbs.get(i));
                    for (Table table : tables) {
                        table.setColumns(ref.listColumns(con, dbs.get(i), table));
                        table.setPrimaries(ref.listPrimaries(con, dbs.get(i), table));
                        table.setForeigns(ref.listForeings(con, dbs.get(i), table));
                        System.out.println(table.getForeigns().size());
                    }                    
                    TempleteEntity en = new TempleteEntity();
                    en.createEntity(tables);
                }
            } else {
                System.out.println("No hay Conexion");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(Reflexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
