/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gebruiker
 */
public class AnnotationData {
    private String name;
    private String annotationName;
    private List<AnnotationMethod> methods;

    public AnnotationData() {
        this.methods = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnotationName() {
        return annotationName;
    }

    public void setAnnotationName(String annotationName) {
        this.annotationName = annotationName;
    }

    public List<AnnotationMethod> getMethods() {
        return methods;
    }

    public void setMethods(List<AnnotationMethod> methods) {
        this.methods = methods;
    }
    
    public void addMethod(AnnotationMethod method) {
        this.methods.add(method);
    }
}
