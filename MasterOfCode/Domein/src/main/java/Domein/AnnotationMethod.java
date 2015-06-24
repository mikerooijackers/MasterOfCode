/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domein;

import java.io.Serializable;

/**
 *
 * @author Gebruiker
 */
public class AnnotationMethod implements Serializable {
    private String name;
    private Object value;

    /**
     * constructor
     */
    public AnnotationMethod() {
    }

    /**
     * constructor
     * @param name
     * @param value
     */
    public AnnotationMethod(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    /**
     * get name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * set name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get value
     * @return
     */
    public Object getValue() {
        return value;
    }

    /**
     * set value
     * @param value
     */
    public void setValue(Object value) {
        this.value = value;
    }
}
