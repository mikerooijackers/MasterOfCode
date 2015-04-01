/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gebruiker
 */
@XmlRootElement
public class AnnotationData {
    private String className;
    private String annotationName;
    private List<AnnotationMethod> methods;

    public AnnotationData() {
        this.methods = new ArrayList<>();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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
