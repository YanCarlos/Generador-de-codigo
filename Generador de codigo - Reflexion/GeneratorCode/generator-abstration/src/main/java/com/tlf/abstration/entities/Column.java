package com.tlf.abstration.entities;

public class Column {

	private String tableCat;
	private String tableSchem;
	private String tableName;
	private String columnName;
	private String dataType;
	private String columnSize;
	private int nullable;
	private String remarks;
	private String columnDefault;
	private String isAutoIncrement;

	public Column(){
		
	}

	public Column(String tableCat, String tableSchem, String tableName, String columnName, String dataType,
			String columnSize, int nullable, String remarks, String columnDefault, String isAutoIncrement) {
		super();
		this.tableCat = tableCat;
		this.tableSchem = tableSchem;
		this.tableName = tableName;
		this.columnName = columnName;
		this.dataType = dataType;
		this.columnSize = columnSize;
		this.nullable = nullable;
		this.remarks = remarks;
		this.columnDefault = columnDefault;
		this.isAutoIncrement = isAutoIncrement;
	}

	public String getTableCat() {
		return tableCat;
	}

	public void setTableCat(String tableCat) {
		this.tableCat = tableCat;
	}

	public String getTableSchem() {
		return tableSchem;
	}

	public void setTableSchem(String tableSchem) {
		this.tableSchem = tableSchem;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
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
