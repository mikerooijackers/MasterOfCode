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
import com.mycompany.utilitiesmodule.ZipUtils;
import com.mycompany.workspacemanagementmoduleb.utils.FileUtils;
import com.mycompany.workspacemanagementmoduleb.utils.ReflectionUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
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
import org.testng.annotations.Test;

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
    
    public static final String WORKSPACES_PATH = "C:\\workspaces";
    public static final String ASSIGNMENTS_PATH = "C:\\assignments";
    public static final String DEFAULT_JAVA_SOURCECODE_PATH = "src\\main\\java";
    
    public String createWorkspace(Long competitionId, Long teamId) {
        String path = WORKSPACES_PATH + File.separator + competitionId + File.separator + teamId;
        new File(path).mkdirs();
        
        return path;
    }
    
    public String deleteWorkspace(Long competitionId, Long teamId) {
        String path = WORKSPACES_PATH + File.separator + competitionId + File.separator + teamId ;
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
            String path = sourceFilePath.substring(0, sourceFilePath.lastIndexOf(File.separator)); //+ "\\" + sourceCodeFileName;
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

    public List<SourceCode> readSourceCode(Long teamId, Long competitionId, Long roundId, List<AnnotationData> annotationData) {
        List<SourceCode> sourceCodeFiles = new ArrayList<>();      

        String path = WORKSPACES_PATH + File.separator + competitionId + File.separator + teamId + File.separator + roundId; //+ "\\" + sourceCodePath;

        File folder = new File(path);
        File[] files = folder.listFiles();
        path += File.separator + files[0].getName() + File.separator + DEFAULT_JAVA_SOURCECODE_PATH;

        for (AnnotationData ad : annotationData) {
            String sourceCodeFilePath = ad.getName().replace(".", File.separator);
            String absolutePath = path + File.separator + sourceCodeFilePath + ".java";

            SourceCode sc = new SourceCode();
            sc.setFileName(ad.getName());
            sc.setPath(absolutePath);
            sc.setContent(FileUtils.readContentOfSourceCode(new File(absolutePath)));
            sc.setIsEditable(Editable.class.getSimpleName().equals(ad.getAnnotationName()));
            sourceCodeFiles.add(sc);
        }

        return sourceCodeFiles;
    }

    public List<AnnotationData> readAssignmentMetaData(Long assignmentId) {
        String path = ASSIGNMENTS_PATH + File.separator + assignmentId;

        List<AnnotationData> annotationData = ReflectionUtils.readTestAnnotationData(path, org.testng.annotations.Test.class);
        annotationData.addAll(ReflectionUtils.readAnnotationData(path, AssignCreator.class, AssignInformation.class, Hints.class));
        
        return annotationData;
    }

    public boolean extractAssignmentToWorkspaces(Long competitionId, Long roundId, byte[] blob) {
        String destination = WORKSPACES_PATH + File.separator + competitionId;
        File zipFile = new File(WORKSPACES_PATH + File.separator + "temp.zip");
        if (Files.exists(zipFile.toPath())) {
            try {
                Files.delete(zipFile.toPath());
            } catch (IOException ex) {
                Logger.getLogger(WorkspaceService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ZipUtils.writeByteArrayToFile(blob, zipFile);
        
        File competitionFolder = new File(destination);
        File[] teamWorkspaces = competitionFolder.listFiles();
        
        for (File teamWorkspace : teamWorkspaces) {
            String teamWorkspaceDestination = destination + File.separator + teamWorkspace.getName() + File.separator + roundId;
            
            new File(teamWorkspaceDestination).mkdirs();

            FileUtils.extractZIPFile(zipFile, teamWorkspaceDestination);
        }
        
        return true;
//+ File.separator + teamId + File.separator + roundId;
        
    }
    
    public String requestCompile(Long teamId, Long competitionId, Long roundId) {
        String pomPath = WORKSPACES_PATH + File.separator + competitionId + File.separator + teamId + File.separator + roundId;
        File folder = new File(pomPath);
        File[] files = folder.listFiles();
        pomPath += File.separator + files[0].getName();
        
        String result;
        // Start a new process with the given sourcePath
        try {

            new ProcessBuilder(
                    "pom.xml", "-cp", pomPath).start();
            result = "Compilation successful";

            /**
             * The project cannot be compiled if: 1: The sourcePath is null 2:
             * The sourcePath is invalid
             */
        } catch (IOException ex) {
            // access to the stack trace
            StackTraceElement[] trace = ex.getStackTrace();
            result = trace[0].toString();
        }
        return result;
    }
    
    public String runTestGroup(String group, Long competitionId, Long teamId, Long roundId) {
        String pomPath = WORKSPACES_PATH + File.separator + competitionId + File.separator + teamId + File.separator + roundId;
        File folder = new File(pomPath);
        File[] files = folder.listFiles();
        pomPath += File.separator + files[0].getName();
        
        String command = "cmd.exe /c mvn test -Dgroup=" + group;
        return runCommand(command, pomPath);
    }
    
    public String runSingleTest(String test, Long competitionId, Long teamId, Long roundId) {
        String pomPath = WORKSPACES_PATH + File.separator + competitionId + File.separator + teamId + File.separator + roundId;
        File folder = new File(pomPath);
        File[] files = folder.listFiles();
        pomPath += File.separator + files[0].getName();
        
        String command = "cmd.exe /c mvn test -Dtest=" + test;
        return runCommand(command, pomPath);
    }
    
    public String runCommand(String command, String directory) {
        String output = "";
        Process p;
        try {
            p = Runtime.getRuntime().exec(command, null, new File(directory));
            p.waitFor();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            while ((line = r.readLine()) != null) {
                output += line + "\n";
            }
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(WorkspaceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
}
