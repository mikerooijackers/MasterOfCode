/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Domein.Team;
import Domein.SourceCode;
//import com.mycompany.annotations.Hint;
import domain.AnnotationData;
import domain.AnnotationMethod;
import java.io.File;
import java.lang.annotation.Annotation;
import java.util.List;
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
        
        String expectedSourceCodePath = "C:\\workspaces\\0\\0\\archetype-1.0-SNAPSHOT\\src\\main\\java\\nl\\sogeti\\sample\\archetype\\ReadOnlyClass.java";
        assertTrue("source code path valid", expectedSourceCodePath.equals(sc.getPath()));
        
        String expectedFileName = "nl.sogeti.sample.archetype.ReadOnlyClass";
        assertTrue("file name valid", expectedFileName.equals(sc.getFileName()));

        String expectedContent = "/*\n" +
               " * To change this license header, choose License Headers in Project Properties.\n" +
               " * To change this template file, choose Tools | Templates\n" +
               " * and open the template in the editor.\n" +
               " */\n" +
               "package nl.sogeti.sample.archetype;\n" +
               "\n" +
               "import com.mycompany.annotations.Editable;\n" +
               "\n" +
               "/**\n" +
               " *\n" +
               " * @author JordiK\n" +
               " */\n" +
               "    }\n" +
               "}";
        
        assertTrue("content valid", expectedContent.equals(sc.getContent()));
        
        assertFalse("is editable", sc.isIsEditable());
        
        sc = sourceCodeFiles.get(1);
        
        expectedSourceCodePath = "C:\\workspaces\\0\\0\\archetype-1.0-SNAPSHOT\\src\\main\\java\\nl\\sogeti\\sample\\archetype\\EditableClass.java";
        assertTrue("source code path valid", expectedSourceCodePath.equals(sc.getPath()));
        
        expectedFileName = "nl.sogeti.sample.archetype.EditableClass";
        assertTrue("file name valid", expectedFileName.equals(sc.getFileName()));
        
        expectedContent = "package domain;\n\n" +
               "@SomeAnnotation(something=\"bla\")\n" +
               "@ReadOnly\n" +
               "public class Hello {\n" +
               "    public void HelloThere() {\n" +
               "        System.out.println(\"Hi matey!\");\n" +
               "    }\n" +
               "}";
        
        assertTrue("content valid", expectedContent.equals(sc.getContent()));
        
        assertTrue("is editable", sc.isIsEditable());
    }
    
    @Test
    public void readAssignmentMetaDataTest() {
        String assignmentPath = "C:\\assignments";
        String assignment = "0";
        
        List<AnnotationData> data = service.readAssignmentMetaData(assignmentPath, assignment);
        
        String expectedAssignmentCreatorClassName = "nl.sogeti.sample.archetype.Config";
        String expectedAssignmentCreatorAnnotationName = "AssignCreator";
        String expectedAssignmentCreatorMethod1Name = "creatorLogo";
        String expectedAssignmentCreatorMethod1Value = "Logo url here";
        String expectedAssignmentCreatorMethod2Name = "creatorWebsite";
        String expectedAssignmentCreatorMethod2Value = "Website here";
        String expectedAssignmentCreatorMethod3Name = "creatorName";
        String expectedAssignmentCreatorMethod3Value = "Fill in creator name here";
        String expectedAssignmentCreatorMethod4Name = "creatorOrginisation";
        String expectedAssignmentCreatorMethod4Value = "Orginisation here";
        
        String expectedAssignmentInformationClassName = "nl.sogeti.sample.archetype.Config";
        String expectedAssignmentInformationAnnotationName = "AssignInformation";
        String expectedAssignmentInformationMethod1Name = "name";
        String expectedAssignmentInformationMethod1Value = "archetype name here";
        String expectedAssignmentInformationMethod2Name = "difficulty";
        String expectedAssignmentInformationMethod2Value = "Easy/Medium/Hard";
        String expectedAssignmentInformationMethod3Name = "spectatorDescription";
        String expectedAssignmentInformationMethod3Value = "Description for contestants here";
        String expectedAssignmentInformationMethod4Name = "contestantDescription";
        String expectedAssignmentInformationMethod4Value = "Description for contestants here";
        
        String expectedHintsClassName = "nl.sogeti.sample.archetype.Config";
        String expectedHintsAnnotationName = "Hints";
        String expectedHintsMethod1Name = "value";

        int expectedListLength = 3;
        
        AnnotationData ad0 = data.get(0);
        
        assertEquals(expectedAssignmentCreatorClassName, ad0.getClassName());
        assertEquals(expectedAssignmentCreatorAnnotationName, ad0.getAnnotationName());
        assertEquals(expectedAssignmentCreatorMethod1Name, ad0.getMethods().get(0).getName());
        assertEquals(expectedAssignmentCreatorMethod1Value, ad0.getMethods().get(0).getValue());
        assertEquals(expectedAssignmentCreatorMethod2Name, ad0.getMethods().get(1).getName());
        assertEquals(expectedAssignmentCreatorMethod2Value, ad0.getMethods().get(1).getValue());
        assertEquals(expectedAssignmentCreatorMethod3Name, ad0.getMethods().get(2).getName());
        assertEquals(expectedAssignmentCreatorMethod3Value, ad0.getMethods().get(2).getValue());
        assertEquals(expectedAssignmentCreatorMethod4Name, ad0.getMethods().get(3).getName());
        assertEquals(expectedAssignmentCreatorMethod4Value, ad0.getMethods().get(3).getValue());
        
        AnnotationData ad1 = data.get(1);
        
        assertEquals(expectedAssignmentInformationClassName, ad1.getClassName());
        assertEquals(expectedAssignmentInformationAnnotationName, ad1.getAnnotationName());
        assertEquals(expectedAssignmentInformationMethod1Name, ad1.getMethods().get(0).getName());
        assertEquals(expectedAssignmentInformationMethod1Value, ad1.getMethods().get(0).getValue());
        assertEquals(expectedAssignmentInformationMethod2Name, ad1.getMethods().get(1).getName());
        assertEquals(expectedAssignmentInformationMethod2Value, ad1.getMethods().get(1).getValue());
        assertEquals(expectedAssignmentInformationMethod3Name, ad1.getMethods().get(2).getName());
        assertEquals(expectedAssignmentInformationMethod3Value, ad1.getMethods().get(2).getValue());
        assertEquals(expectedAssignmentInformationMethod4Name, ad1.getMethods().get(3).getName());
        assertEquals(expectedAssignmentInformationMethod4Value, ad1.getMethods().get(3).getValue());
        
        AnnotationData ad2 = data.get(2);
        
        List<AnnotationMethod> methods = ad2.getMethods();
        Hint[] hints = (Hint[]) methods.get(0).getValue();
        
        assertEquals(expectedHintsClassName, ad2.getClassName());
        assertEquals(expectedHintsAnnotationName, ad2.getAnnotationName());
        assertEquals(expectedHintsMethod1Name, ad2.getMethods().get(0).getName());
        assertEquals(hints[0].description(), "Enter hint here");
        assertEquals(hints[0].delay(), 50);
        assertEquals(hints[1].description(), "Enter hint here");
        assertEquals(hints[1].delay(), 100);
        
        assertEquals("list length", expectedListLength, data.size());
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
    
    @Test
    public void testRequestCompile() {
        String compileResult = service.requestCompile("C:\\Users\\May\\Documents\\NetBeansProjects\\MasterOfCode\\MasterOfCode\\WorkspaceModule");
        assertEquals("Compilation succesfull", compileResult);
    }
    
    
    // TODO: add test to ensure that a valid project can be compiled
     @Test
     public void testRequestCompileFail() {
         String compileResult = service.requestCompile(null);
         assertEquals("null", compileResult);
     }
}
