/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tlf.logic.properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author Administrador
 */
public class ReadProperty {

    public static final Map<String, String> mapDriver = new HashMap<>();
    public static final Map<String, String> mapHost = new HashMap<>();
    public static final Map<String, String> mapDialect = new HashMap<>();

    static {
        try (FileReader fReader = new FileReader("drivers.properties")) {
            Properties property = new Properties();
            property.load(fReader);
            String strDriver = property.getProperty("drivers");
            String strHost = property.getProperty("host").replaceAll(" ","");
            String strDialetc = property.getProperty("dialect").replaceAll(" ", "");
            String[] drivers = strDriver.split(";;");
            String[] hosts = strHost.split(";;");
            String[] dialetcs = strDialetc.split(";;");
            for (String driver : drivers) {
                String valueDriver[] = driver.split(",,");                
                mapDriver.put(valueDriver[0], valueDriver[1]);
            }
            for (String host : hosts) {
                String valueHost[] = host.split(",,");                
                mapHost.put(valueHost[0], valueHost[1]);
            }
            for (String dialect : dialetcs) {
                String valueHost[] = dialect.split(",,");                
                mapDialect.put(valueHost[0], valueHost[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
