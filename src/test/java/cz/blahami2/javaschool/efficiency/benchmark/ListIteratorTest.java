/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.efficiency.benchmark;

import cz.blahami2.javaschool.efficiency.benchmark.ListIterator.IntArrayContainer;
import cz.blahami2.javaschool.efficiency.benchmark.ListIterator.IntegerArrayContainer;
import gnu.trove.list.array.TIntArrayList;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.List;
import java.util.function.Function;
import javax.management.ObjectName;
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
public class ListIteratorTest {

    private final List<Integer> list;
    private final IntArrayContainer arrayContainer;
    private final IntegerArrayContainer arrayIntegerContainer;
    private final int LIST_SIZE = 1000;
    private final int RUNS = 10;

    public ListIteratorTest() {
        list = ListIterator.create( LIST_SIZE );
        arrayContainer = new IntArrayContainer( ListIterator.createArray( LIST_SIZE ) );
        arrayIntegerContainer = new IntegerArrayContainer( list );
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
     * Test of maxIterator method, of class ListIterator.
     */
    @Test
    public void test() {
        TIntArrayList troveList = new TIntArrayList( arrayContainer.array );
        System.out.println( "WarmUp #1" );
        runWarmUp( ListIterator::maxIterator, list );
        runWarmUp( ListIterator::maxIntIterator, list );
        runWarmUp( ListIterator::maxGet, list );
        runWarmUp( ListIterator::maxIntGet, list );
        runWarmUp( ListIterator::maxInt, arrayContainer );
        runWarmUp( ListIterator::maxIntIterator, arrayContainer );
        runWarmUp( ListIterator::maxIntIterator_NoForLoop, arrayContainer );
        runWarmUp( ListIterator::maxIntIterator_NoCheck, arrayContainer );
        runWarmUp( ListIterator::maxTroveIterator, troveList );
        runWarmUp( ListIterator::maxIntegerIterator, arrayIntegerContainer );
        System.out.println( "WarmUp #2" );
        runWarmUp( ListIterator::maxIterator, list );
        runWarmUp( ListIterator::maxIntIterator, list );
        runWarmUp( ListIterator::maxGet, list );
        runWarmUp( ListIterator::maxIntGet, list );
        runWarmUp( ListIterator::maxInt, arrayContainer );
        runWarmUp( ListIterator::maxIntIterator, arrayContainer );
        runWarmUp( ListIterator::maxIntIterator_NoForLoop, arrayContainer );
        runWarmUp( ListIterator::maxIntIterator_NoCheck, arrayContainer );
        runWarmUp( ListIterator::maxTroveIterator, troveList );
        runWarmUp( ListIterator::maxIntegerIterator, arrayIntegerContainer );
        System.out.println( "Test #1" );
        System.out.print( "maxIterator" );
        runTest( ListIterator::maxIterator, list );
        System.out.print( "maxIntIterator" );
        runTest( ListIterator::maxIntIterator, list );
        System.out.print( "maxGet" );
        runTest( ListIterator::maxGet, list );
        System.out.print( "maxIntGet" );
        runTest( ListIterator::maxIntGet, list );
        System.out.print( "maxInt_array" );
        runTest( ListIterator::maxInt, arrayContainer );
        System.out.print( "maxIntIterator_array" );
        runTest( ListIterator::maxIntIterator, arrayContainer );
        System.out.print( "maxIntIteratorNoForLoop_array" );
        runTest( ListIterator::maxIntIterator_NoForLoop, arrayContainer );
        System.out.print( "maxIntIteratorNoCheck_array" );
        runTest( ListIterator::maxIntIterator_NoCheck, arrayContainer );
        System.out.print( "maxTroveIterator" );
        runTest( ListIterator::maxTroveIterator, troveList );
        System.out.println( "Test #2" );
        System.out.print( "maxIterator" );
        runTest( ListIterator::maxIterator, list );
        System.out.print( "maxIntIterator" );
        runTest( ListIterator::maxIntIterator, list );
        System.out.print( "maxGet" );
        runTest( ListIterator::maxGet, list );
        System.out.print( "maxIntGet" );
        runTest( ListIterator::maxIntGet, list );
        System.out.print( "maxInt_array" );
        runTest( ListIterator::maxInt, arrayContainer );
        System.out.print( "maxIntIterator_array" );
        runTest( ListIterator::maxIntIterator, arrayContainer );
        System.out.print( "maxIntIteratorNoForLoop_primitiveArray" );
        runTest( ListIterator::maxIntIterator_NoForLoop, arrayContainer );
        System.out.print( "maxIntIteratorNoCheck_array" );
        runTest( ListIterator::maxIntIterator_NoCheck, arrayContainer );
        System.out.print( "maxTroveIterator" );
        runTest( ListIterator::maxTroveIterator, troveList );
        System.out.print( "maxIntegerIterator" );
        runTest(ListIterator::maxIntegerIterator, arrayIntegerContainer );
    }

    private <T> void runWarmUp( Function<T, Integer> function, T input ) {
        int m = 0;
        for ( int i = 0; i < RUNS; i++ ) {
            m = function.apply( input );
        }

    }

    private <T> void runTest( Function<T, Integer> function, T input ) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long currentCpuTime = threadMXBean.getCurrentThreadCpuTime();
        int m = 0;
        long nanoTime = System.nanoTime();
        for ( int i = 0; i < RUNS; i++ ) {
            m = function.apply( input );
        }
        System.out.println( ", max = " + m + ", time = " + ( ( System.nanoTime() - nanoTime ) / 10E6 ) + " ms. CPU time = " + ( ( threadMXBean.getCurrentThreadCpuTime() - currentCpuTime ) / 10E6 ) + " ms" );
    }

}
