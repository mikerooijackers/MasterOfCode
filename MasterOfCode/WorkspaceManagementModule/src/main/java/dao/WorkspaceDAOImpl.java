/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Domein.Team;
import Domein.MOCUser;
import Domein.SourceCode;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;
/**
 *
 * @author Gebruiker
 */
public class WorkspaceDAOImpl implements WorkspaceDAO {

    //@PersistenceContext
    private EntityManager em;
    
    //@PersistenceUnit(unitName = "MasterOfCodeDB")
    //private EntityManagerFactory factory;

    public WorkspaceDAOImpl() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MasterOfCodeDB");
        em = factory.createEntityManager();
        
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
        if(files != null) { //some JVMs return null for empty dirs
            for(File f : files) {
                if(f.isDirectory()) {
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
    public List<SourceCode> readSourceCode(Team team, String workspacePath, String assignmentDirectory, String sourceCodePath) {
        String path = workspacePath + "\\" + team.getId() + "\\" + assignmentDirectory; //+ "\\" + sourceCodePath;
        
        File folder = new File(path);
        File[] files = folder.listFiles();
        path += "\\" + files[0].getName() + "\\" + sourceCodePath;
        
        return this.getClassFilesPath(new File(path));
    }
    
    private List<SourceCode> getClassFilesPath(File folder) {
        List<SourceCode> sourceCodeFiles = new ArrayList<>();
        File[] files = folder.listFiles();
        
        if(files != null) { //some JVMs return null for empty dirs
            for(File f : files) {
                if(f.isDirectory()) {
                    sourceCodeFiles.addAll(getClassFilesPath(f));
                } else {
                    if (f.isFile()) {
                        String fileName = f.getName();
                        int index = fileName.lastIndexOf('.');
                        
                        if (index >= 0) {
                            String extension = fileName.substring(index);
                            
                            if (extension.equals(".java")) {
                                SourceCode sc = new SourceCode();
                                sc.setFileName(fileName);
                                sc.setPath(f.getAbsolutePath());
                                sc.setContent(this.readContentOfSourceCode(f));
                                sourceCodeFiles.add(sc);
                            }
                        }
                        
                    }
                }
            }
        }
        
        return sourceCodeFiles;
    }
    
    private String readContentOfSourceCode(File sourceFile) {
        String output = "";
        FileReader reader = null;
        try {
            reader = new FileReader(sourceFile);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                output += line + "\n";
            }
            
            int length = output.length();
            if (length > 0) {
                output = output.substring(0, length-1);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WorkspaceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WorkspaceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(WorkspaceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return output;
    }
    
    @Override
    public boolean requestCompile(String sourcePath) {
        // The project cannot be compiled if the sourcePath is null
        if (sourcePath == null) {
            System.out.println("The project to compile cannot be found");
            return false;
        }
        // Start a new process with the given sourcePath
        try {
            new ProcessBuilder(
                    "java.exe", "-cp", "bin", sourcePath).start();
        } catch (IOException ex) {
            Logger.getLogger(WorkspaceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Compilation successful");
        return true;
    }
}
