/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tlf.abstration.entities;

/**
 *
 * @author Administrador
 */
public class Primary {
    
    private Table table;
    private String columnName;

    public Primary(String columnName,Table table) {
        this.columnName = columnName;
        this.table = table;
    }

    public Primary() {
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }    
}
