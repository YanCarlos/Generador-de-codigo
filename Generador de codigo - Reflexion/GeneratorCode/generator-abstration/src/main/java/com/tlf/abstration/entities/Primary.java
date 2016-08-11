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
 
    private Column columnName;

    public Primary(Column columnName) {
        this.columnName = columnName;
    }

    public Primary() {
    }

    public Column getColumnName() {
        return columnName;
    }

    public void setColumnName(Column columnName) {
        this.columnName = columnName;
    }    
}
