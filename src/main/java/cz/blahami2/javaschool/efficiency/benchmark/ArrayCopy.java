/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.efficiency.benchmark;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.Random;
import java.util.function.BiConsumer;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class ArrayCopy {

    public static int[] createArray( int size ) {
        int[] array = new int[size];
        Random r = new Random();
        for ( int i = 0; i < size; i++ ) {
            array[i] = r.nextInt();
        }
        return array;
    }

    public static int[] copyByArraysCopyOf( int[] array, int size ) {
        return Arrays.copyOf( array, array.length + size );
    }

    public static int[] copyByEnlarge( int[] array, int size ) {
        return enlarge( array, size );
    }

    public static int[] copyManually( int[] array, int size ) {
        int[] newArray = new int[array.length + size];
        for ( int i = 0; i < array.length; i++ ) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    private static void copyArray( int[] source, int[] target ) {
        System.arraycopy( source, 0, target, 0, Math.min( source.length, target.length ) );
    }

    private static int[] enlarge( int[] orig, int size ) {
        int[] newArray = new int[orig.length + size];
        copyArray( orig, newArray );
        return newArray;
    }

    public static void main( String... args ) {
        int[] array = createArray( 1000000 );
        int runs = 1000;
        int size = 1000000;
        System.out.println( "****************** warm up #1 ******************" );
        warmup( ArrayCopy::copyByArraysCopyOf, array, size, runs );
        warmup( ArrayCopy::copyByEnlarge, array, size, runs );
        warmup( ArrayCopy::copyManually, array, size, runs );
        System.out.println( "****************** warm up #2 ******************" );
        warmup( ArrayCopy::copyByArraysCopyOf, array, size, runs );
        warmup( ArrayCopy::copyByEnlarge, array, size, runs );
        warmup( ArrayCopy::copyManually, array, size, runs );
        System.out.println( "********************* test *********************" );
        System.out.print( "copyByArrayCopyOf" );
        runTest( ArrayCopy::copyByArraysCopyOf, array, size, runs );
        System.out.print( "copyByEnlarge" );
        runTest( ArrayCopy::copyByEnlarge, array, size, runs );
        System.out.print( "copyManually" );
        runTest( ArrayCopy::copyManually, array, size, runs );
    }

    private static void warmup( BiConsumer<int[], Integer> consumer, int[] array, int size, int runs ) {
        for ( int i = 0; i < runs; i++ ) {
            consumer.accept( array, size );
        }
    }

    private static void runTest( BiConsumer<int[], Integer> consumer, int[] array, int size, int runs ) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long currentCpuTime = threadMXBean.getCurrentThreadCpuTime();
        long nanoTime = System.nanoTime();
        for ( int i = 0; i < runs; i++ ) {
            consumer.accept( array, size );
        }
        System.out.println( "-time = " + ( ( System.nanoTime() - nanoTime ) / 10E6 ) + " ms. CPU time = " + ( ( threadMXBean.getCurrentThreadCpuTime() - currentCpuTime ) / 10E6 ) + " ms" );
    }
}
