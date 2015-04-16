/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domein;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mikerooijackers
 */
public class RoundTest {
    
    Round round;
    
    private int roundNr = 1;
    private int durationInSeconds = 20;
    private Status status = Status.pause;
    private Competition competition;
    
    public RoundTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        round = new Round();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDurationInSeconds method, of class Round.
     */
    @Test
    public void testGetDurationInSeconds() {
        System.out.println("getDurationInSeconds");
        round.setDurationInSeconds(durationInSeconds);
        int result = round.getDurationInSeconds();
        assertEquals(20, result);
    }

    /**
     * Test of setDurationInSeconds method, of class Round.
     */
    @Test
    public void testSetDurationInSeconds() {
        System.out.println("setDurationInSeconds");
        round.setDurationInSeconds(durationInSeconds);
        int result = round.getDurationInSeconds();
        assertEquals(20, result);
    }

    /**
     * Test of getStatus method, of class Round.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Round instance = new Round();
        Status expResult = null;
        Status result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class Round.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        Status status = null;
        Round instance = new Round();
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCompetition method, of class Round.
     */
    @Test
    public void testGetCompetition() {
        System.out.println("getCompetition");
        Round instance = new Round();
        Competition expResult = null;
        Competition result = instance.getCompetition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCompetition method, of class Round.
     */
    @Test
    public void testSetCompetition() {
        System.out.println("setCompetition");
        Competition competition = null;
        Round instance = new Round();
        instance.setCompetition(competition);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAssignment method, of class Round.
     */
    @Test
    public void testGetAssignment() {
        System.out.println("getAssignment");
        Round instance = new Round();
        Assignment expResult = null;
        Assignment result = instance.getAssignment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAssignment method, of class Round.
     */
    @Test
    public void testSetAssignment() {
        System.out.println("setAssignment");
        Assignment assignment = null;
        Round instance = new Round();
        instance.setAssignment(assignment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Round.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Round instance = new Round();
        long expResult = 0L;
        long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Round.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        long id = 0L;
        Round instance = new Round();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoundNr method, of class Round.
     */
    @Test
    public void testGetRoundNr() {
        System.out.println("getRoundNr");
        Round instance = new Round();
        int expResult = 0;
        int result = instance.getRoundNr();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRoundNr method, of class Round.
     */
    @Test
    public void testSetRoundNr() {
        System.out.println("setRoundNr");
        int roundNr = 0;
        Round instance = new Round();
        instance.setRoundNr(roundNr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
