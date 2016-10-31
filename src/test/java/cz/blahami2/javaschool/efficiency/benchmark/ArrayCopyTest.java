/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.efficiency.benchmark;

import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class ArrayCopyTest {

    int[] array;
    int size;

    public ArrayCopyTest() {
    }

    @Before
    public void setUp() throws Exception {
        size = 1000000;
        array = ArrayCopy.createArray( size );
    }

    /**
     * Test of createArray method, of class ArrayCopy.
     */
    @Test
    public void testCreateArray() {
        System.out.println( "createArray" );
        assertThat( ArrayCopy.createArray( size ).length, equalTo( size ) );
    }

    /**
     * Test of copyByArraysCopyOf method, of class ArrayCopy.
     */
    @Test
    public void testCopyByArraysCopyOf() {
        System.out.println( "copyByArraysCopyOf" );
        int[] copy = ArrayCopy.copyByArraysCopyOf( array, size );
        assertThat( copy, equalTo( enlarge( array, size ) ) );
    }

    /**
     * Test of copyByEnlarge method, of class ArrayCopy.
     */
    @Test
    public void testCopyByEnlarge() {
        System.out.println( "copyByEnlarge" );
        int[] copy = ArrayCopy.copyByEnlarge( array, size );
        assertThat( copy, equalTo( enlarge( array, size ) ) );
    }

    /**
     * Test of copyManually method, of class ArrayCopy.
     */
    @Test
    public void testCopyManually() {
        System.out.println( "copyManually" );
        int[] copy = ArrayCopy.copyManually( array, size );
        assertThat( copy, equalTo( enlarge( array, size ) ) );
    }

    private int[] enlarge( int[] arr, int s ) {
        int[] n = new int[arr.length + s];
        for ( int i = 0; i < arr.length; i++ ) {
            n[i] = arr[i];
        }
        return n;
    }

}
