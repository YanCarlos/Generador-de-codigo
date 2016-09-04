package com.tlf.abstration.entities;

import java.util.ArrayList;
import java.util.List;

public class Table {

    /**
     * Base de datos a la cual pertenece la Tabla
     */
    private DataBase dataBase;
    /**
     * Nombre de la Tabla en la base de datos
     */
    private String tableName;
    /**
     * Tipo de Tabla en la base de datos Ejemplos: ->Table ->View
     */
    private String tableType;

    /**
     * Lista de las columna que contiene la tabla
     */
    private List<Column> columns;

    /**
     * Lista las primarias que contiene la tabla
     */
    private List<Primary> primaries;
    /**
     * lista de foraneas de la tabla
     */
    private List<Foreign> foreigns;

    public Table(DataBase dataBase, String tableName, String tableType) {
        this.dataBase = dataBase;
        this.tableName = tableName;
        this.tableType = tableType;
        this.columns = new ArrayList<>();
        this.primaries = new ArrayList<>();
        this.foreigns = new ArrayList<>();
    }

    public Table() {
        this.columns = new ArrayList<>();
        this.primaries = new ArrayList<>();
        this.foreigns = new ArrayList<>();
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public List<Primary> getPrimaries() {
        return primaries;
    }

    public void setPrimaries(List<Primary> primaries) {
        this.primaries = primaries;
    }

    public List<Foreign> getForeigns() {
        return foreigns;
    }

    public void setForeigns(List<Foreign> foreigns) {
        this.foreigns = foreigns;
    }
}
