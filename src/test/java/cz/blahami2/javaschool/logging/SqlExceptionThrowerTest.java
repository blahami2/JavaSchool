/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.logging;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class SqlExceptionThrowerTest {
    
    public SqlExceptionThrowerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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

    /**
     * Test of thrower method, of class SqlExceptionThrower.
     */
    @Test
    public void testThrower() throws IOException {
        System.out.println( "thrower" );
        SqlExceptionThrower instance = new SqlExceptionThrower();
        try {
            instance.thrower();
        } catch ( IOException ex ) {
            Logger.getLogger( SqlExceptionThrowerTest.class.getName() ).log( Level.SEVERE, null, ex );
            throw ex;
        }
    }
    
}
