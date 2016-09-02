/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tlf.abstration.reflection;

import com.tlf.abstration.entities.Column;
import com.tlf.abstration.entities.Connector;
import com.tlf.abstration.entities.DataBase;
import com.tlf.abstration.entities.Table;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada que contiene los metodos de reflexion sobre un motor de bases
 * de datos para extraer sus informacion como tablas, campos entre otros.
 *
 * @author Crisitan Camilo Zapata Torres
 * @version 1.0.0
 * @see <a href="https://plus.google.com/u/0/117178818025238083388">Perfil</a>
 */
public class Reflection {

    /**
     * Constructor de la clase
     */
    public Reflection() {
        super();
    }

    /**
     * Funcion la cual establece una conexion con el motor de bases de datos
     *
     * @param conexion, es un objeto que lleva como atributos los datos y driver
     * de conexion a la base de datos
     * @return, un objeto Connection de SQL el cual es la referencia de
     * conecxion con el motor
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Connection getConnection(Connector conexion) throws
            SQLException, ClassNotFoundException {
        Class.forName(conexion.getDriver());
        return DriverManager.getConnection(conexion.getUrl(),
                conexion.getUser(), conexion.getPassword());
    }

    /**
     * Método para crear una lista de bases de datos de tipo Database
     *
     * @param con, el cual es la conecxion al motor de las bases de datos
     * @return, Una lista de objetos de tipo DataBase la cual hace referencia a
     * una base de datos.
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
     *
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
     *
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
