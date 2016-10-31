/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.codewars.kyu6;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class LineTest {

    public LineTest() {
    }

    @Test
    public void test1() {
        assertEquals( "YES", Line.Tickets( new int[]{ 25, 25, 50 } ) );
    }

    @Test
    public void test2() {
        assertEquals( "NO", Line.Tickets( new int[]{ 25, 100 } ) );
    }

}
