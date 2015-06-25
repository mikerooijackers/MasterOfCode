/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Domein.AnnotationData;
import Domein.AnnotationMethod;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

/**
 *
 * @author Gebruiker
 */
public class ReflectionUtils {
    
    private static List<String> testMethodNames = Arrays.asList("testName", "groups", "priority", "description" );

    /**
     *
     * @param path
     * @param annotations
     * @return
     */
    public static List<AnnotationData> readAnnotationData(String path, Class<? extends Annotation>... annotations) {
        List<AnnotationData> annotationData = new ArrayList<>();
        File folder = new File(path);
        File[] files = folder.listFiles();
        for (File file : files) {
            if (FileUtils.checkFileExtension(file, ".jar") && !file.getName().endsWith("-tests.jar")) {
                annotationData = ReflectionUtils.readAnnotationData(file, annotations);
                break;
            }
        }
        
        return annotationData;
    }
    
    /**
     *
     * @param path
     * @param annotations
     * @return
     */
    public static List<AnnotationData> readTestAnnotationData(String path, Class<? extends Annotation>... annotations) {
        List<AnnotationData> annotationData = new ArrayList<>();
        File folder = new File(path);
        File[] files = folder.listFiles();
        for (File file : files) {
            if (FileUtils.checkFileExtension(file, ".jar") && file.getName().endsWith("-tests.jar")) {
                annotationData = ReflectionUtils.readAnnotationData(file, annotations);
                break;
            }
        }
        
        return annotationData;
    }
    
    private static List<AnnotationData> readAnnotationData(File file, Class<? extends Annotation>... annotations) {
        List<AnnotationData> annotationData = new ArrayList<>();
        Reflections r;

        try {
            URLClassLoader loader = new URLClassLoader(new java.net.URL[]{file.toURI().toURL()});

            r = new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forClassLoader(loader)).addClassLoader(loader).setScanners(new SubTypesScanner(), new TypeAnnotationsScanner()));
            
            for (Class<? extends Annotation> an : annotations) {
                Set<Class<?>> annotated = r.getTypesAnnotatedWith(an);
                
                Iterator<Class<?>> iterator = annotated.iterator();
                while (iterator.hasNext()) {

                    Class<?> foundClass = iterator.next();
                    
                    AnnotationData data = new AnnotationData();
                    data.setName(foundClass.getName());
                    data.setAnnotationName(an.getSimpleName());

                    Annotation[] annotationArray = foundClass.getAnnotationsByType(an);
                    
                    for (Annotation annotation : annotationArray) {
                        
                        Class<Annotation> type = (Class<Annotation>) annotation.annotationType();                        
                        
                        for (Method method : type.getDeclaredMethods()) {
                            if (type.getSimpleName().equals("Test")) {
                                if (testMethodNames.contains(method.getName())) {
                                    data.addMethod(new AnnotationMethod(method.getName(), method.invoke(annotation, null)));
                                }
                            }
                            else {
                                data.addMethod(new AnnotationMethod(method.getName(), method.invoke(annotation, null)));
                            }
                        }
                    }
                    
                    annotationData.add(data);
                }
            }
        } catch (MalformedURLException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(ReflectionUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return annotationData;
    }
    
    private static List<AnnotationData> readMethodAnnotationData(File file, Class<? extends Annotation>... annotations) {
        List<AnnotationData> annotationData = new ArrayList<>();
        Reflections r;

        try {
            URLClassLoader loader = new URLClassLoader(new java.net.URL[]{file.toURI().toURL()});

            r = new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forClassLoader(loader)).addClassLoader(loader));
            
            for (Class<? extends Annotation> an : annotations) {
                Set<Method> annotated = r.getMethodsAnnotatedWith(an);

                Iterator<Method> iterator = annotated.iterator();
                while (iterator.hasNext()) {

                    Method foundMethod = iterator.next();

                    for (Annotation annotation : foundMethod.getAnnotationsByType(an)) {
                        
                        Class<Annotation> type = (Class<Annotation>) annotation.annotationType();
                        AnnotationData data = new AnnotationData();
                        data.setName(foundMethod.getName());
                        
                        data.setAnnotationName(type.getSimpleName());
                        for (Method method : type.getDeclaredMethods()) {
                            data.addMethod(new AnnotationMethod(method.getName(), method.invoke(annotation, null)));
                        }
                        annotationData.add(data);
                    }
                }
            }
        } catch (MalformedURLException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(ReflectionUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return annotationData;
    }
}
