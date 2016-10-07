/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.efficiency.benchmark;

import gnu.trove.iterator.TIntIterator;
import gnu.trove.list.array.TIntArrayList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class ListIterator {

    public static List<Integer> create( int length ) {
        Random r = new Random();
        List<Integer> list = new ArrayList<>();
        for ( int i = 0; i < 100000; i++ ) {
            list.add( r.nextInt(128) );
        }
        return list;
    }

    public static int[] createArray( int length ) {
        Random r = new Random();
        int[] array = new int[length];
        for ( int i = 0; i < 100000; i++ ) {
            array[i] = r.nextInt(128);
        }
        return array;
    }

    public static int maxIterator( List<Integer> list ) {
        int max = Integer.MIN_VALUE;
        for ( Integer i : list ) {
            if ( i > max ) {
                max = i;
            }
        }
        return max;
    }

    public static int maxIntIterator( List<Integer> list ) {
        int max = Integer.MIN_VALUE;
        for ( int i : list ) {
            if ( i > max ) {
                max = i;
            }
        }
        return max;
    }

    public static int maxGet( List<Integer> list ) {
        int max = Integer.MIN_VALUE;
        for ( int i = 0; i < list.size(); i++ ) {
            Integer j = list.get( i );
            if ( j > max ) {
                max = j;
            }
        }
        return max;
    }

    public static int maxIntGet( List<Integer> list ) {
        int max = Integer.MIN_VALUE;
        for ( int i = 0; i < list.size(); i++ ) {
            int j = list.get( i );
            if ( j > max ) {
                max = j;
            }
        }
        return max;
    }

    public static int maxInt( IntArrayContainer input ) {
        int[] array = input.array;
        int max = Integer.MIN_VALUE;
        for ( int i = 0; i < array.length; i++ ) {
            int j = array[i];
            if ( j > max ) {
                max = j;
            }
        }
        return max;
    }

    public static int maxIntIterator( IntArrayContainer input ) {
        int[] array = input.array;
        int max = Integer.MIN_VALUE;
        IntArrayIterator intArrayIterator = new IntArrayIterator( array );
        for ( Integer i : intArrayIterator ) {
            if ( i > max ) {
                max = i;
            }
        }
        return max;
    }

    public static int maxIntIterator_NoForLoop( IntArrayContainer input ) {
        int[] array = input.array;
        int max = Integer.MIN_VALUE;
        PrimitiveIntArrayIterator intArrayIterator = new PrimitiveIntArrayIterator(array );
        while ( intArrayIterator.hasNext() ) {
            int i = intArrayIterator.next();
            if ( i > max ) {
                max = i;
            }
        }
        return max;
    }

    public static int maxIntIterator_NoCheck( IntArrayContainer input ) {
        int[] array = input.array;
        int max = Integer.MIN_VALUE;
        IntArrayIterator_NoCheck intArrayIterator = new IntArrayIterator_NoCheck( array );
        for ( Integer i : intArrayIterator ) {
            if ( i > max ) {
                max = i;
            }
        }
        return max;
    }

    public static int maxTroveIterator( TIntArrayList list ) {
        int max = Integer.MIN_VALUE;
        TIntIterator iterator = list.iterator();
        while ( iterator.hasNext() ) {
            int i = iterator.next();
            if ( i > max ) {
                max = i;
            }
        }
        return max;
    }

    public static int maxIntegerIterator( IntegerArrayContainer input ) {
        Integer[] array = input.array;
        int max = Integer.MIN_VALUE;
        IntegerArrayIterator intArrayIterator = new IntegerArrayIterator( array );
        for ( Integer i : intArrayIterator ) {
            if ( i > max ) {
                max = i;
            }
        }
        return max;
    }

    private static class IntArrayIterator implements Iterator<Integer>, Iterable<Integer> {

        private final int[] array;
        private int counter = 0;

        public IntArrayIterator( int[] array ) {
            this.array = array;
        }

        @Override
        public Iterator<Integer> iterator() {
            return this;
        }

        @Override
        public boolean hasNext() {
            return counter < array.length;
        }

        @Override
        public Integer next() {
            if ( !hasNext() ) {
                throw new IllegalStateException( "Call hasNext() first!" );
            }
            return array[counter++];
        }

    }

    private static class IntArrayIterator_NoCheck implements Iterator<Integer>, Iterable<Integer> {

        private final int[] array;
        private int counter = 0;

        public IntArrayIterator_NoCheck( int[] array ) {
            this.array = array;
        }

        @Override
        public Iterator<Integer> iterator() {
            return this;
        }

        @Override
        public boolean hasNext() {
            return counter < array.length;
        }

        @Override
        public Integer next() {
            return array[counter++];
        }

    }

    private static class IntegerArrayIterator implements Iterator<Integer>, Iterable<Integer> {

        private final Integer[] array;
        private int counter = 0;

        public IntegerArrayIterator( Integer[] array ) {
            this.array = array;
        }

        @Override
        public boolean hasNext() {
            return counter < array.length;
        }

        @Override
        public Integer next() {
            return array[counter++];
        }

        @Override
        public Iterator<Integer> iterator() {
            return this;
        }

    }

    private static class PrimitiveIntArrayIterator {

        private final int[] array;
        private int counter = 0;

        public PrimitiveIntArrayIterator( int[] array ) {
            this.array = array;
        }

        public boolean hasNext() {
            return counter < array.length;
        }

        public int next() {
            return array[counter++];
        }
    }

    public static class IntArrayContainer {

        final int[] array;

        public IntArrayContainer( int[] array ) {
            this.array = array;
        }

    }

    public static class IntegerArrayContainer {

        final Integer[] array;

        public IntegerArrayContainer( Integer[] array ) {
            this.array = array;
        }

        public IntegerArrayContainer( List<Integer> list ) {
            this.array = list.toArray( new Integer[list.size()] );
        }
    }
}
