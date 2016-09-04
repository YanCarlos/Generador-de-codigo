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
public class Foreign {

    private String pkTable;
    private String pkColumnName;
    private String fkColumnName;

    public Foreign() {
    }

    public Foreign(String pkTable, String pkColumnName, String fkColumnName) {
        this.pkTable = pkTable;
        this.pkColumnName = pkColumnName;
        this.fkColumnName = fkColumnName;
    }

    public String getPkTable() {
        return pkTable;
    }

    public void setPkTable(String pkTable) {
        this.pkTable = pkTable;
    }

    public String getPkColumnName() {
        return pkColumnName;
    }

    public void setPkColumnName(String pkColumnName) {
        this.pkColumnName = pkColumnName;
    }

    public String getFkColumnName() {
        return fkColumnName;
    }

    public void setFkColumnName(String fkColumnName) {
        this.fkColumnName = fkColumnName;
    }
}
