package com.tlf.abstration.entities;

public class DataBase {

    /**
     * Nombre de la base de datos dentro del Motor
     */
    private String name;

    public DataBase(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName()+"";
    }
}
