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
    
    private Column pkColumnName;
    private Column fkColumnName;
    private String fkName;
    private String pkName;

    public Foreign() {
    }

    public Foreign(Column pkColumnName, Column fkColumnName, String fkName, String pkName) {
        this.pkColumnName = pkColumnName;
        this.fkColumnName = fkColumnName;
        this.fkName = fkName;
        this.pkName = pkName;
    }

    public Column getPkColumnName() {
        return pkColumnName;
    }

    public void setPkColumnName(Column pkColumnName) {
        this.pkColumnName = pkColumnName;
    }

    public Column getFkColumnName() {
        return fkColumnName;
    }

    public void setFkColumnName(Column fkColumnName) {
        this.fkColumnName = fkColumnName;
    }

    public String getFkName() {
        return fkName;
    }

    public void setFkName(String fkName) {
        this.fkName = fkName;
    }

    public String getPkName() {
        return pkName;
    }

    public void setPkName(String pkName) {
        this.pkName = pkName;
    } 
}