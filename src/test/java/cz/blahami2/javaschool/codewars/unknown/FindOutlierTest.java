/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.codewars.unknown;

import cz.blahami2.javaschool.codewars.unknown.FindOutlier;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class FindOutlierTest {

    public FindOutlierTest() {
    }

    @Test
    public void testExample() {
        int[] exampleTest1 = { 2, 6, 8, -10, 3 };
        int[] exampleTest2 = { 206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781 };
        int[] exampleTest3 = { Integer.MAX_VALUE, 0, 1 };
        assertEquals( 3, FindOutlier.find( exampleTest1 ) );
        assertEquals( 206847684, FindOutlier.find( exampleTest2 ) );
        assertEquals( 0, FindOutlier.find( exampleTest3 ) );
    }

    @Test
    public void isOddArray_for_oddArray_returns_true() {
        assertTrue( FindOutlier.isOddArray( new int[]{ 1, 3, 4 } ) );
        assertTrue( FindOutlier.isOddArray( new int[]{ 1, 4, 3 } ) );
        assertTrue( FindOutlier.isOddArray( new int[]{ 4, 3, 1 } ) );
        assertTrue( FindOutlier.isOddArray( new int[]{ 1, 3, 5 } ) );
        assertTrue( FindOutlier.isOddArray( new int[]{ -1, -3, -5 } ) );
        assertTrue( FindOutlier.isOddArray( new int[]{ 1, 3, 5, 8, 8, 8, 8 } ) );
    }

    @Test
    public void isOddArray_for_evenArray_returns_false() {
        assertFalse( FindOutlier.isOddArray( new int[]{ 2, 6, 3 } ) );
        assertFalse( FindOutlier.isOddArray( new int[]{ 2, 3, 6 } ) );
        assertFalse( FindOutlier.isOddArray( new int[]{ 3, 6, 2 } ) );
        assertFalse( FindOutlier.isOddArray( new int[]{ 2, 6, 10 } ) );
        assertFalse( FindOutlier.isOddArray( new int[]{ -2, -6, -10 } ) );
        assertFalse( FindOutlier.isOddArray( new int[]{ 2, 6, 10, 3, 3, 3, 3 } ) );
    }

    @Test
    public void isOdd_1_returns_true() {
        assertTrue( FindOutlier.isOdd( 1 ) );
    }

    @Test
    public void isOdd_negative_1_returns_true() {
        assertTrue( FindOutlier.isOdd( -1 ) );
    }

    @Test
    public void isOdd_2_returns_false() {
        assertFalse( FindOutlier.isOdd( 2 ) );
    }

    @Test
    public void isOdd_negative_2_returns_false() {
        assertFalse( FindOutlier.isOdd( -2 ) );
    }

    @Test
    public void isOdd_0_returns_false() {
        assertFalse( FindOutlier.isOdd( 0 ) );
    }

}
