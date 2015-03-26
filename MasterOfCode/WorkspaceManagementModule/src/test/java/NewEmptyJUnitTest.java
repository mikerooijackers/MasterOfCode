/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Domein.Team;
import Domein.SourceCode;
import java.io.File;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import services.WorkspaceService;

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
        String sourceCodePath = "src\\main";
        
        List<SourceCode> sourceCodeFiles = service.readSourceCode(team, workspacePath, assignment, sourceCodePath);
        
        // should only be 1 source code file
        SourceCode sc = sourceCodeFiles.get(0);
        
        String expectedSourceCodePath = "C:\\workspaces\\0\\0\\assignment\\src\\main\\Hello.java";
        assertTrue("source code path valid", expectedSourceCodePath.equals(sc.getPath()));
        
        String expectedFileName = "Hello.java";
        assertTrue("file name valid", expectedFileName.equals(sc.getFileName()));
        
        String expectedContent = "package com;\n\n" +
            "public class Hello {\n" +
            "\tpublic void doit() { \n" +
            "\t\tSystem.out.println(\"Hello world\");\n" +
            "\t}\n" +
            "}";
        
        assertTrue("content valid", expectedContent.equals(sc.getContent()));
    }
    
    
    // TODO: add test to ensure that a valid project can be compiled
     @Test
     public void testRequestCompileFail() {
         boolean compileResult = service.requestCompile(null);
         assertEquals(false, compileResult);
     }
}
