/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.workspacemanagementmoduleb;

import Domein.AnnotationData;
import Domein.SourceCode;
import com.mycompany.annotations.AssignCreator;
import com.mycompany.annotations.AssignInformation;
import com.mycompany.annotations.Editable;
import com.mycompany.annotations.Hints;
import com.mycompany.annotations.ReadOnly;
import com.mycompany.workspacemanagementmoduleb.utils.FileUtils;
import com.mycompany.workspacemanagementmoduleb.utils.ReflectionUtils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

/**
 *
 * @author Gebruiker
 */
public class WorkspaceService {
    
    private static WorkspaceService instance;
    
    public static WorkspaceService getInstance() {
        if (instance == null) {
            instance = new WorkspaceService();
        }
        
        return instance;
    }
    
    public String createWorkspace(Long competitionId, Long teamId, String workspacePath) {
        String path = workspacePath + File.pathSeparator + competitionId + File.pathSeparator + teamId;
        new File(path).mkdirs();
        
        return path;
    }
    
    public String deleteWorkspace(Long competitionId, Long teamId, String workspacePath) {
        String path = workspacePath + File.pathSeparator + competitionId + File.pathSeparator + teamId ;
        this.deleteFolder(new File(path));
        
        return path;
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

    public boolean editSourceCode(String sourceCodePath, String sourceCode) {
        FileWriter writer = null;
        boolean succesful = false;
        try {
            String sourceFilePath = sourceCodePath; //workspacePath + "\\" + team.getId() + "\\" + assignmentDirectory + "\\" + sourceCodePath;
            String path = sourceFilePath.substring(0, sourceFilePath.lastIndexOf(File.pathSeparator)); //+ "\\" + sourceCodeFileName;
            File sourceFile = new File(sourceFilePath);

            writer = new FileWriter(sourceFile);
            writer.write(sourceCode);

            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, Locale.FRENCH, null);
            fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Arrays.asList(new File(path)));
            compiler.getTask(null, fileManager, null, null, null, fileManager.getJavaFileObjectsFromFiles(Arrays.asList(sourceFile))).call();
            fileManager.close();
            succesful = true;
        } catch (IOException ex) {
            Logger.getLogger(WorkspaceService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(WorkspaceService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return succesful;
    }

    public List<SourceCode> readSourceCode(Long teamId, Long competitionId, Long roundId, String workspacePath, String sourceCodePath, String assignmentPath, Long assignmentId) {
        List<SourceCode> sourceCodeFiles = new ArrayList<>();
        String path = assignmentPath;
        List<AnnotationData> annotationData = ReflectionUtils.readAnnotationData(path, ReadOnly.class, Editable.class);

        path = workspacePath + File.pathSeparator + teamId + File.pathSeparator + competitionId + File.pathSeparator + roundId; //+ "\\" + sourceCodePath;

        File folder = new File(path);
        File[] files = folder.listFiles();
        path += "\\" + files[0].getName() + "\\" + sourceCodePath;

        for (AnnotationData ad : annotationData) {
            String sourceCodeFilePath = ad.getName().replace(".", "\\");
            String absolutePath = path + "\\" + sourceCodeFilePath + ".java";

            SourceCode sc = new SourceCode();
            sc.setFileName(ad.getName());
            sc.setPath(absolutePath);
            sc.setContent(FileUtils.readContentOfSourceCode(new File(absolutePath)));
            sc.setIsEditable(Editable.class.getSimpleName().equals(ad.getAnnotationName()));
            sourceCodeFiles.add(sc);
        }

        return sourceCodeFiles;
    }

    public List<AnnotationData> readAssignmentMetaData(String assignmentPath, Long assignmentId) {
        String path = assignmentPath + File.pathSeparator + assignmentId;

        return ReflectionUtils.readAnnotationData(path, AssignCreator.class, AssignInformation.class, Hints.class);
    }

    public void extractAssignmentToWorkspace(Long teamId, Long competitionId, Long roundId, String workspacePath, Long assignmentId, String assignmentPath) {
        String destination = workspacePath + File.pathSeparator + teamId + File.pathSeparator + competitionId + File.pathSeparator + roundId;
        new File(destination).mkdir();
        
        File assignmentFolder = new File(assignmentPath);
        File[] files = assignmentFolder.listFiles();
        for (File file : files) {
            if (FileUtils.checkFileExtension(file, ".zip")) {
                FileUtils.extractZIPFile(file, destination);
                break;
            }
        }
    }
    
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
            Logger.getLogger(WorkspaceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Compilation successful");
        return true;
    }
}
