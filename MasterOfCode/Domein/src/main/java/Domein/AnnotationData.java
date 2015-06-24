/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domein;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gebruiker
 */
public class AnnotationData implements Serializable {
    private String name;
    private String annotationName;
    private List<AnnotationMethod> methods;

    /**
     * Constructor
     */
    public AnnotationData() {
        this.methods = new ArrayList<>();
    }

    /**
     * Get Name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get annorationName
     * @return
     */
    public String getAnnotationName() {
        return annotationName;
    }

    /**
     * set AnnotationName
     * @param annotationName
     */
    public void setAnnotationName(String annotationName) {
        this.annotationName = annotationName;
    }

    /**
     * get Methods
     * @return
     */
    public List<AnnotationMethod> getMethods() {
        return methods;
    }

    /**
     * set methods
     * @param methods
     */
    public void setMethods(List<AnnotationMethod> methods) {
        this.methods = methods;
    }
    
    /**
     * add Method
     * @param method
     */
    public void addMethod(AnnotationMethod method) {
        this.methods.add(method);
    }
}
