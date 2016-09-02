package com.tlf.abstration.entities;

/**
 * Clase encargada de contener todos los elementos de una conexion a un motor de
 * bases de datos
 *
 * @author Crisitan Camilo Zapata Torres
 */
public class Connector {

    /**
     * Nombre usuario requerido para la conexion con el motor
     */
    private String user;
    /**
     * Contraseña del usuario para la validacion en el motor
     */
    private String password;
    /**
     * Ubicacion del motor
     */
    private String url;
    /**
     * controlador Java para la conexion con el Motor
     */
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
