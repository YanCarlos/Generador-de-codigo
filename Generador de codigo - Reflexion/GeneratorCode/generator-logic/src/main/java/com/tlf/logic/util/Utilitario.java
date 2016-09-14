/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tlf.logic.util;

/**
 *
 * @author Administrador
 */
public class Utilitario {
    
    /**
     * Metodo para nombre correctamente una clase
     * con CamellCase
     *
     * @param name, nombre de la clase
     * @return
     */
    public static String getNameClass(String name) {
        String capital = name.charAt(0) + "";
        return (capital.toUpperCase() + name.substring(1));
    }
    
}
