/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Domein.Competition;
import Domein.Team;
import Domein.MOCUser;
import Domein.SourceCode;
import domain.AnnotationData;
import java.io.File;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import services.WorkspaceService;
import utils.FileUtils;

/**
 *
 * @author Gebruiker
 */
public class NewEmptyJUnitTest {
    
    private static WorkspaceService service;
    
    public NewEmptyJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        service = new WorkspaceService();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void addWorkspace() {
        Team team = new Team();
        team.setId(0);
        String workspacePath = "C:\\workspaces";
        service.createWorkspace(team, workspacePath);
        
        String expectedWorkspacePath = "C:\\workspaces\\0";
        assertTrue(new File(expectedWorkspacePath).exists());
        
        //assertTrue(retTeam.getId() != 0);
        //em.persist(team);
    }
    
    @Test @Ignore
    public void removeWorkspace() {
        Team team = new Team();
        team.setId(0);
        String workspacePath = "C:\\workspaces";
        service.deleteWorkspace(team, workspacePath);
        
        String expectedWorkspacePath = "C:\\workspaces\\0";
        assertFalse(new File(expectedWorkspacePath).exists());
    }
    
    @Test
    public void editSourceCode() {
        new File("C:\\workspaces\\0\\0\\com").mkdirs();
        Team team = new Team();
        team.setId(0);
        String sourceCodePath = "C:\\workspaces\\0\\0\\com\\Hello.java";
        String sourceCode = "package com;\n\n" +
            "public class Hello {\n" +
            "\tpublic void doit() { \n" +
            "\t\tSystem.out.println(\"Hello world\");\n" +
            "\t}\n" +
            "}";
        service.editSourceCode(sourceCodePath, sourceCode);
        
        String expectedPath = "C:\\workspaces\\0\\0\\com\\Hello.java";
        
        assertTrue(new File(expectedPath).exists());
    }
    
    @Test
    public void readSourceCode() {
        Team team = new Team();
        team.setId(0);
        String workspacePath = "C:\\workspaces";
        String assignment = "0";
        String sourceCodePath = "src\\main\\java";
        String assignmentPath = "C:\\assignments\\0";
        
        List<SourceCode> sourceCodeFiles = service.readSourceCode(team, workspacePath, assignment, sourceCodePath, assignmentPath);
        
        // should only be 1 source code file
        SourceCode sc = sourceCodeFiles.get(0);
        
        String expectedSourceCodePath = "C:\\workspaces\\0\\0\\mavenproject1\\src\\main\\java\\domain\\Hello.java";
        assertTrue("source code path valid", expectedSourceCodePath.equals(sc.getPath()));
        
        String expectedFileName = "domain.Hello";
        assertTrue("file name valid", expectedFileName.equals(sc.getFileName()));
        
        String expectedContent = "package domain;\n\n" +
               "@SomeAnnotation(something=\"bla\")\n" +
               "@ReadOnly\n" +
               "public class Hello {\n" +
               "    public void HelloThere() {\n" +
               "        System.out.println(\"Hi matey!\");\n" +
               "    }\n" +
               "}";
        
        assertTrue("content valid", expectedContent.equals(sc.getContent()));
        
        assertFalse("is editable", sc.isIsEditable());
    }
    
    @Test
    public void readAssignmentMetaDataTest() {
        String assignmentPath = "C:\\assignments";
        String assignment = "0";
        
        List<AnnotationData> data = service.readAssignmentMetaData(assignmentPath, assignment);
        
        String expectedAnnotationName = "domain.SomeAnnotation";
        String expectedMethodName = "something";
        Object expectedMethodValue = "bla";
        int expectedListLength = 1;
        
        AnnotationData ad = data.get(0);
        
        assertEquals("list length", expectedListLength, data.size());
        
        assertEquals("annotation name", expectedAnnotationName, ad.getAnnotationName());
        
        assertEquals("method name", expectedMethodName, ad.getMethods().get(0).getName());
        
        assertEquals("method value", expectedMethodValue, ad.getMethods().get(0).getValue());
    }
    
    @Test
    public void extractAssignmentToWorkspaceTest() {
        Team team = new Team();
        team.setId(0);
        String workspacePath = "C:\\workspaces";
        String assignment = "0";
        String assignmentPath = "C:\\assignments\\0";
        
        service.extractAssignmentToWorkspace(team, workspacePath, assignment, assignmentPath);
        
        File expectedFolder = new File("C:\\workspaces\\0\\0");
        File[] files = expectedFolder.listFiles();
        
        int expectedFiles = 1;
        
        assertEquals("nrOfFiles", expectedFiles, files.length);
        
        assertTrue("fileIsFolder", files[0].isDirectory());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
