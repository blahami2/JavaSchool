/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.effectivejava.classesandinterfaces;

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
public class AccessorsTest {

    int x;
    int y;

    public AccessorsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        x = 15;
        y = 33;
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testPoint1() {
        Accessors.PointImpl1 p = new Accessors.PointImpl1( x, y );
        assertEquals( x, p.getX() );
        assertEquals( y, p.getY() );
    }

    @Test
    public void testPoint2() {
        Accessors.PointImpl2 p = new Accessors.PointImpl2( x, y );
        assertEquals( x, p.getX() );
        assertEquals( y, p.getY() );
    }

}
