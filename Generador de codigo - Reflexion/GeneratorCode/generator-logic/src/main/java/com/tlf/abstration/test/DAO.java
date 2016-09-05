/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tlf.abstration.test;

import java.io.Serializable;
import javax.persistence.EntityManager;


public class DAO implements Serializable {
    
    /*
    constante de seralizacion
    */
    private static final long serialVersionUID = -3106939302290740868L;

    /**
     * Entitymanager.
     */
    private EntityManager entityManager;
    
    public DAO(EntityManager entityManager) {
        super();
        this.entityManager = entityManager;
    }

    public DAO() {
    }
    
    /**
     * Persiste un objeto en la base de datos
     * @param instancia 
     */
    public void insert(Object instancia) {
        entityManager.persist(instancia);

    }
    
    /**
     * Busca un objeto en la base de datos
     * @param <T>
     * @param clase, tipo de objeto
     * @param pk, valor unico de busqueda
     * @return 
     */
    public <T> T search(Class<T> clase, Object pk) {
        return entityManager.find(clase, pk);
    }
    
    /**
     * Metodo el cual elimina un objeto a partir de un identificador
     * @param <T>
     * @param clase, tipo de objeto
     * @param pk, valor de la busqueda
     * @return 
     */
    public <T extends Object> T delete(Class<T> clase, Object pk) {
        Object instance = search(clase, pk);
        delete(instance);
        return (T) instance;
    }
    
    /**
     * Metodo el cual realiza una eliminacion
     * @param entidad , elemento a eliminar
     */
    public void delete(Object entidad) {
        entityManager.remove(entidad);
    }
    
    /**
     * Metodo el cual realiza un actualizacion de un objeto
     * @param <T>
     * @param updatedInstance, objeto a actualizar
     * @return 
     */
    public <T> T update(Object updatedInstance) {
        T obj = (T) entityManager.merge(updatedInstance);
        return obj;
    }
}
