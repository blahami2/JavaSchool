/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.codewars.unknown;

import cz.blahami2.javaschool.codewars.unknown.RemovedNumbers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class RemovedNumbersTest {

    public RemovedNumbersTest() {
    }

    @Test
    public void test12() {
        List<long[]> res = new ArrayList<>();
        res.add( new long[]{ 15, 21 } );
        res.add( new long[]{ 21, 15 } );
        List<long[]> a = RemovedNumbers.removNb( 26 );
        for ( long[] ls : a ) {
            System.out.println( Arrays.toString( ls ) );
        }
        assertArrayEquals( res.get( 0 ), a.get( 0 ) );
        assertArrayEquals( res.get( 1 ), a.get( 1 ) );
    }

    @Test
    public void test14() {
        List<long[]> res = new ArrayList<>();
        List<long[]> a = RemovedNumbers.removNb( 100 );
        assertTrue( res.size() == a.size() );
    }

    @Test
    public void sumUpTo_1_Returns_1_() {
        assertEquals( 1, RemovedNumbers.sum( 1 ) );
    }

    @Test
    public void sumUpTo_2_Returns_3_() {
        assertEquals( 3, RemovedNumbers.sum( 2 ) );
    }

    @Test
    public void sumUpTo_5_Returns_15_() {
        assertEquals( 15, RemovedNumbers.sum( 5 ) );
    }

    @Test
    public void print_sumUpTo_26_() {
        System.out.println( "sum(26)=" + RemovedNumbers.sum( 26 ) );
    }
}
