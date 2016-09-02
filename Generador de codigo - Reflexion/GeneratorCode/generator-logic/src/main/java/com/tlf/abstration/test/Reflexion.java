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
                List<DataBase> dbs = ref.listarBasesDeDatos(con);
                List<Table> tables = new ArrayList<>();
                List<Column> columns = new ArrayList<>();
                List<Primary> primaries = new ArrayList<>();
                for (int i = 0; i < 1; i++) {
                    tables = ref.listarTablas(con, dbs.get(i));
                    List<Column> col = new ArrayList<>();
                    List<Primary> prs = new ArrayList<>();
                    for (Table table : tables) {
                        col = ref.listarColumnas(con, dbs.get(i), table);
                        for (Column column : col) {
                            columns.add(column);
                        }
                        prs = ref.listarPrimarias(con, dbs.get(i), table);
                        for (Primary pr : prs) {
                            primaries.add(pr);
                        }
                    }
                    
                    TempleteEntity en = new TempleteEntity();
                    en.createEntity(tables, columns,primaries);
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
