/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Domein.Team;
import Domein.MOCUser;
import Domein.SourceCode;
import domain.AnnotationData;
//import domain.Annotation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.net.MalformedURLException;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.scanners.TypeElementsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import utils.FileUtils;
import utils.ReflectionUtils;

/**
 *
 * @author Gebruiker
 */
public class WorkspaceDAOImpl implements WorkspaceDAO {

    //@PersistenceContext
    //private EntityManager em;
    //@PersistenceUnit(unitName = "MasterOfCodeDB")
    //private EntityManagerFactory factory;
    public WorkspaceDAOImpl() {
        //EntityManagerFactory factory = Persistence.createEntityManagerFactory("MasterOfCodeDB");
        //em = factory.createEntityManager();

    }

    @Override
    public void createWorkspace(Team team, String workspacePath) {
        // TODO
        String path = workspacePath + "\\" + team.getId();
        new File(path).mkdirs();
//        team.setWorkspacePath(path);
//        
//        em.getTransaction().begin();
//        em.merge(team);
//        em.getTransaction().commit();
    }

//    @Override
//    public Team addTeam(Team team) {
//        em.getTransaction().begin();
//        em.persist(team);
//        em.getTransaction().commit();
//        return team;
//    }
//
//    @Override
//    public MOCUser addUser(MOCUser user) {
//        em.getTransaction().begin();
//        em.persist(user);
//        em.getTransaction().commit();
//        return user;
//    }
//    
//    @Override
//    public Team findTeam() {
//        return em.find(Team.class, 1);
//    }
    @Override
    public void deleteWorkspace(Team team, String workspacePath) {
        String path = workspacePath + "\\" + team.getId();
        this.deleteFolder(new File(path));
    }

    private void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if (files != null) { //some JVMs return null for empty dirs
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }

    @Override
    public void editSourceCode(String sourceCodePath, String sourceCode) {
        FileWriter writer = null;
        try {
            String sourceFilePath = sourceCodePath; //workspacePath + "\\" + team.getId() + "\\" + assignmentDirectory + "\\" + sourceCodePath;
            String path = sourceFilePath.substring(0, sourceFilePath.lastIndexOf("\\")); //+ "\\" + sourceCodeFileName;
            File sourceFile = new File(sourceFilePath);

            writer = new FileWriter(sourceFile);
            writer.write(sourceCode);

            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, Locale.FRENCH, null);
            fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Arrays.asList(new File(path)));
            compiler.getTask(null, fileManager, null, null, null, fileManager.getJavaFileObjectsFromFiles(Arrays.asList(sourceFile))).call();
            fileManager.close();
        } catch (IOException ex) {
            Logger.getLogger(WorkspaceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(WorkspaceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<SourceCode> readSourceCode(Team team, String workspacePath, String assignment, String sourceCodePath, String assignmentPath) {
        List<SourceCode> sourceCodeFiles = new ArrayList<>();
        String path = assignmentPath;
        List<AnnotationData> annotationData = ReflectionUtils.readAnnotationData(path, domain.ReadOnly.class);

        path = workspacePath + "\\" + team.getId() + "\\" + assignment; //+ "\\" + sourceCodePath;

        File folder = new File(path);
        File[] files = folder.listFiles();
        path += "\\" + files[0].getName() + "\\" + sourceCodePath;

        for (AnnotationData ad : annotationData) {
            String sourceCodeFilePath = ad.getClassName().replace(".", "\\");
            String absolutePath = path + "\\" + sourceCodeFilePath + ".java";

            SourceCode sc = new SourceCode();
            sc.setFileName(ad.getClassName());
            sc.setPath(absolutePath);
            sc.setContent(FileUtils.readContentOfSourceCode(new File(absolutePath)));
            sc.setIsEditable(!"domain.ReadOnly".equals(ad.getAnnotationName()));
            sourceCodeFiles.add(sc);
        }

        return sourceCodeFiles;
    }

    @Override
    public List<AnnotationData> readAssignmentMetaData(String assignmentPath, String assignment) {
        String path = assignmentPath + "\\" + assignment;

        return ReflectionUtils.readAnnotationData(path, domain.SomeAnnotation.class);
    }

    @Override
    public void extractAssignmentToWorkspace(Team team, String workspacePath, String assignment, String assignmentPath) {
        String destination = workspacePath + "\\" + team.getId() + "\\" + assignment;
        File assignmentFolder = new File(assignmentPath);
        File[] files = assignmentFolder.listFiles();
        for (File file : files) {
            if (FileUtils.checkFileExtension(file, ".zip")) {
                FileUtils.extractZIPFile(file, destination);
                break;
            }
        }
    }
}
