package com.tlf.abstration.test;

import com.tlf.abstration.entities.Column;
import com.tlf.abstration.entities.Connector;
import com.tlf.abstration.entities.DataBase;
import com.tlf.abstration.entities.Table;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class Reflexion {

	public static void main(String[] args) {
		new Reflexion();
	}

	public Reflexion(){
		String driver = "com.mysql.jdbc.Driver";
		String user = "desarrollo";
		String url = "174.142.65.144:3306";
		String password = "desarrollo";
		
		Connector conexion = new Connector(user, password, url, driver);

		try {
			Connection con = getConnection(conexion);

			if(con != null){
				List<DataBase> dbs = listarBasesDeDatos(con);
				for (int i = 0; i < dbs.size(); i++) {
					String bd = dbs.get(i).getName();
					System.out.println(bd);
					
					List<Table> tables = listarTablas(con, bd);
					for (int j=0; j<tables.size();j++){
						System.out.println(tables.get(j).getTableCat() +" -  "+tables.get(j).getTableName());
					}
					
				}
			}else{
				System.out.println("No hay Conexion");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection(Connector conexion) throws SQLException,ClassNotFoundException{
		Class.forName(conexion.getDriver());
		return DriverManager.getConnection("jdbc:mysql://"+conexion.getUrl(),conexion.getUser(),conexion.getPassword());
	}

	public static List<DataBase> listarBasesDeDatos(Connection con) throws SQLException{
		ResultSet rs = con.getMetaData().getCatalogs();
		List<DataBase> dbs = new ArrayList<>();
		while(rs.next()){
			DataBase bd = new DataBase(rs.getString("TABLE_CAT"));
			dbs.add(bd);
		}
		return dbs;
	}
	
	public static List<Table> listarTablas(Connection con, String nameBD) throws SQLException{
		DatabaseMetaData dbmd = con.getMetaData();
		ResultSet rs = dbmd.getTables(nameBD, null, "%", new String[]{"table","view"});
		List<Table>tables = new ArrayList<>();
		while(rs.next()){
			Table tabla = new Table();
			tabla.setTableCat(rs.getString("TABLE_CAT"));
			tabla.setTableSchem(rs.getString("TABLE_SCHEM"));
			tabla.setTableName(rs.getString("TABLE_NAME"));
			tabla.setTableType(rs.getString("TABLE_TYPE"));
			tabla.setRemarks(rs.getString("REMARKS"));
			/*tabla.setTypeCat(rs.getString("TYPE_CAT"));
			tabla.setTypeSchem(rs.getString("TYPE_SCHEM"));
			tabla.setTypeName(rs.getString("TYPE_NAME"));
			tabla.setReferenceColumnName(rs.getString("SELF_REFERENCING_COL_NAME"));
			tabla.setRefGeneration(rs.getString("REF_GENERATION"));*/
			tables.add(tabla);
		}
		return tables;
	}
	
	public static List<Column> listarColumnas(Connection con,String nameBD,String nameTable) throws SQLException{
		DatabaseMetaData dbmd = con.getMetaData();
		ResultSet rs = dbmd.getColumns(nameBD, null, nameTable, "%");
		List<Column>columns = new ArrayList<>();
		while(rs.next()){
			Column column = new Column();
			
		}
		return columns;
	}
	

}
