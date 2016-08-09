package com.tlf.abstration.entities;

public class Table {

	private String tableCat;
	private String tableSchem;
	private String tableName;
	private String tableType;
	private String remarks;
	private String typeCat;
	private String typeSchem;
	private String typeName;
	private String referenceColumnName;
	private String refGeneration;
	
	public Table(String tableCat, String tableSchem, String tableName,String tableType, String remarks, String typeCat, String typeSchem,
			String typeName, String referenceColumnName, String refGeneration) {
		super();
		this.tableCat = tableCat;
		this.tableSchem = tableSchem;
		this.tableName = tableName;
		this.tableType = tableType;
		this.remarks = remarks;
		this.typeCat = typeCat;
		this.typeSchem = typeSchem;
		this.typeName = typeName;
		this.referenceColumnName = referenceColumnName;
		this.refGeneration = refGeneration;
	}
	
	public Table(){
		
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

	public String getTypeCat() {
		return typeCat;
	}

	public void setTypeCat(String typeCat) {
		this.typeCat = typeCat;
	}

	public String getTypeSchem() {
		return typeSchem;
	}

	public void setTypeSchem(String typeSchem) {
		this.typeSchem = typeSchem;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
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
