package com.tlf.abstration.entities;

public class Connector {

	private String user;
	private String password;
	private String url;
	private String driver;

	public Connector(String user, String password, String url, String driver) {
		super();
		this.user = user;
		this.password = password;
		this.url = url;
		this.driver = driver;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}
	
}
