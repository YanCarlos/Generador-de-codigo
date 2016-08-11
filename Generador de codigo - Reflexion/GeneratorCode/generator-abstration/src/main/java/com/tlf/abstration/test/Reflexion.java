package com.tlf.abstration.test;

import com.tlf.abstration.entities.Column;
import com.tlf.abstration.entities.Connector;
import com.tlf.abstration.entities.DataBase;
import com.tlf.abstration.entities.Foreign;
import com.tlf.abstration.entities.Table;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Reflexion {

    public static void main(String[] args) {
        new Reflexion();
    }

    public Reflexion() {
        String driver = "com.mysql.jdbc.Driver";
        String user = "desarrollo";
        String url = "174.142.65.144:3306";
        String password = "desarrollo";

        Connector conexion = new Connector(user, password, url, driver);

        try {
            Connection con = getConnection(conexion);

            if (con != null) {
                List<DataBase> dbs = listarBasesDeDatos(con);
                for (DataBase db : dbs) {
                    System.out.println("Data base: "+db.getName());
                    List<Table> tables = listarTablas(con, db);
                    for (Table table : tables) {
                        System.out.println("--> Table: "+table.getTableName());
                        List<Column> columns=listarColumnas(con, db, table);
                        for (Column column : columns) {
                            System.out.println("-----> Column: "+column.getColumnName());
                        }
                    }
                }
            } else {
                System.out.println("No hay Conexion");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(Connector conexion) throws
            SQLException, ClassNotFoundException {
        Class.forName(conexion.getDriver());
        return DriverManager.getConnection("jdbc:mysql://" + conexion.getUrl(),
                conexion.getUser(), conexion.getPassword());
    }

    /**
     * Método para crear una lista de bases de datos de tipo Database
     *
     * @param con
     * @return
     * @throws SQLException
     */
    public static List<DataBase> listarBasesDeDatos(Connection con) throws SQLException {
        ResultSet rs = con.getMetaData().getCatalogs();
        List<DataBase> dbs = new ArrayList<>();
        while (rs.next()) {
            DataBase bd = new DataBase(rs.getString("TABLE_CAT"));
            dbs.add(bd);
        }
        return dbs;
    }
    /**
     * Método para crear una lista de tablas de una base de datos
     * @param con, conexión para consultar las tablas
     * @param db, base de datos de la que se desean las tablas
     * @return lista de tablas de una base de datos
     * @throws SQLException 
     */
    public static List<Table> listarTablas(Connection con, DataBase db) throws SQLException {
        DatabaseMetaData dbmd = con.getMetaData();
        ResultSet rs = dbmd.getTables(db.getName(), null, "%", new String[]{"table", "view"});
        List<Table> tables = new ArrayList<>();
        while (rs.next()) {
            Table table = new Table();
            table.setDataBase(db);
            table.setTableName(rs.getString("TABLE_NAME"));
            table.setTableType(rs.getString("TABLE_TYPE"));
            table.setRemarks(rs.getString("REMARKS"));
            table.setReferenceColumnName(rs.getString("SELF_REFERENCING_COL_NAME"));
            table.setRefGeneration(rs.getString("REF_GENERATION"));
            tables.add(table);
        }
        return tables;
    }
    /**
     * Método para crear una lista de campos de una tabla de una base de datos
     * @param con, conexión para consultar los campos
     * @param db, base de datos en la que se consulta
     * @param table, tabla de la que se desea listar los campos
     * @return lista de campos e una tabla
     * @throws SQLException 
     */
    public static List<Column> listarColumnas(Connection con, DataBase db, Table table) 
            throws SQLException {
        DatabaseMetaData dbmd = con.getMetaData();
        ResultSet rs = dbmd.getColumns(db.getName(), null, table.getTableName(), "%");
        List<Column> columns = new ArrayList<>();
        while (rs.next()) {
            Column column = new Column();
            column.setTable(table);
            column.setColumnName(rs.getString("COLUMN_NAME"));
            column.setDataType(rs.getString("DATA_TYPE"));
            column.setColumnSize(rs.getString("COLUMN_SIZE"));
            column.setNullable(rs.getInt("NULLABLE"));
            column.setRemarks(rs.getString("REMARKS"));
            column.setColumnDefault(rs.getString("COLUMN_DEF"));
            column.setIsAutoIncrement(rs.getString("IS_AUTOINCREMENT"));
            columns.add(column);
        }
        return columns;
    }
    /*
    public static List<Foreign> listarLlavesForaneas(Connection con,DataBase db, Table table) 
            throws SQLException{
        DatabaseMetaData dbmd = con.getMetaData();
        ResultSet rs=dbmd.getImportedKeys(db.getName(), null, table.getTableName());
        List<Foreign> foreigns= new ArrayList<>();
        while(rs.next()){
            Foreign foreign=new Foreign();
            
        }
        return null;
    }*/
}
