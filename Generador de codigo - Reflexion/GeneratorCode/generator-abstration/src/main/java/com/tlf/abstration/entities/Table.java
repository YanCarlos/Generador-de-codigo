package com.tlf.abstration.entities;

public class Table {    
    
    private DataBase dataBase;
    private String tableName;
    private String tableType;
    private String remarks;
    private String referenceColumnName;
    private String refGeneration;

    public Table(DataBase dataBase, String tableName, String tableType, String remarks, String referenceColumnName, String refGeneration) {
        this.dataBase = dataBase;
        this.tableName = tableName;
        this.tableType = tableType;
        this.remarks = remarks;
        this.referenceColumnName = referenceColumnName;
        this.refGeneration = refGeneration;
    }

    public Table() {
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getReferenceColumnName() {
        return referenceColumnName;
    }

    public void setReferenceColumnName(String referenceColumnName) {
        this.referenceColumnName = referenceColumnName;
    }

    public String getRefGeneration() {
        return refGeneration;
    }

    public void setRefGeneration(String refGeneration) {
        this.refGeneration = refGeneration;
    }
    
    
    
}
