package com.tlf.abstration.entities;

public class Column {
    
    private Table table;
    private String columnName;
    private String dataType;
    private String columnSize;
    private int nullable;
    private String remarks;
    private String columnDefault;
    private String isAutoIncrement;

    public Column(Table table, String columnName, String dataType, String columnSize,
            int nullable, String remarks, String columnDefault, String isAutoIncrement) {
        this.table = table;
        this.columnName = columnName;
        this.dataType = dataType;
        this.columnSize = columnSize;
        this.nullable = nullable;
        this.remarks = remarks;
        this.columnDefault = columnDefault;
        this.isAutoIncrement = isAutoIncrement;
    }

    public Column() {
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getColumnSize() {
        return columnSize;
    }

    public void setColumnSize(String columnSize) {
        this.columnSize = columnSize;
    }

    public int getNullable() {
        return nullable;
    }

    public void setNullable(int nullable) {
        this.nullable = nullable;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getColumnDefault() {
        return columnDefault;
    }

    public void setColumnDefault(String columnDefault) {
        this.columnDefault = columnDefault;
    }

    public String getIsAutoIncrement() {
        return isAutoIncrement;
    }

    public void setIsAutoIncrement(String isAutoIncrement) {
        this.isAutoIncrement = isAutoIncrement;
    }
}
