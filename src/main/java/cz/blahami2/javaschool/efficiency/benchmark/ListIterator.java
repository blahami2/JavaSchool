/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.efficiency.benchmark;

import gnu.trove.iterator.TIntIterator;
import gnu.trove.list.array.TIntArrayList;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class ListIterator {

    private static final int LIST_SIZE = 100000;
    private static final int RUNS = 1000;

    public static void main(String... args) {
        List<Integer> list = create(LIST_SIZE);
        IntArrayContainer arrayContainer = new IntArrayContainer(ListIterator.createArray(LIST_SIZE));
        IntegerArrayContainer arrayIntegerContainer = new IntegerArrayContainer(list);
        TIntArrayList troveList = new TIntArrayList(arrayContainer.array);
        System.out.println("WarmUp #1");
        runWarmUp(ListIterator::maxIterator, list);
        runWarmUp(ListIterator::maxIntIterator, list);
        runWarmUp(ListIterator::maxGet, list);
        runWarmUp(ListIterator::maxIntGet, list);
        runWarmUp(ListIterator::maxInt, arrayContainer);
        runWarmUp(ListIterator::maxIntIterator, arrayContainer);
        runWarmUp(ListIterator::maxIntIterator_NoForLoop, arrayContainer);
        runWarmUp(ListIterator::maxIntIterator_NoCheck, arrayContainer);
        runWarmUp(ListIterator::maxTroveIterator, troveList);
        runWarmUp(ListIterator::maxIntegerIterator, arrayIntegerContainer);
        System.out.println("WarmUp #2");
        runWarmUp(ListIterator::maxIterator, list);
        runWarmUp(ListIterator::maxIntIterator, list);
        runWarmUp(ListIterator::maxGet, list);
        runWarmUp(ListIterator::maxIntGet, list);
        runWarmUp(ListIterator::maxInt, arrayContainer);
        runWarmUp(ListIterator::maxIntIterator, arrayContainer);
        runWarmUp(ListIterator::maxIntIterator_NoForLoop, arrayContainer);
        runWarmUp(ListIterator::maxIntIterator_NoCheck, arrayContainer);
        runWarmUp(ListIterator::maxTroveIterator, troveList);
        runWarmUp(ListIterator::maxIntegerIterator, arrayIntegerContainer);
        System.out.println("Test #1");
        System.out.print("maxIterator");
        runTest(ListIterator::maxIterator, list);
        System.out.print("maxIntIterator");
        runTest(ListIterator::maxIntIterator, list);
        System.out.print("maxGet");
        runTest(ListIterator::maxGet, list);
        System.out.print("maxIntGet");
        runTest(ListIterator::maxIntGet, list);
        System.out.print("maxInt_array");
        runTest(ListIterator::maxInt, arrayContainer);
        System.out.print("maxIntIterator_array");
        runTest(ListIterator::maxIntIterator, arrayContainer);
        System.out.print("maxIntIteratorNoForLoop_array");
        runTest(ListIterator::maxIntIterator_NoForLoop, arrayContainer);
        System.out.print("maxIntIteratorNoCheck_array");
        runTest(ListIterator::maxIntIterator_NoCheck, arrayContainer);
        System.out.print("maxTroveIterator");
        runTest(ListIterator::maxTroveIterator, troveList);
        System.out.println("Test #2");
        System.out.print("maxIterator");
        runTest(ListIterator::maxIterator, list);
        System.out.print("maxIntIterator");
        runTest(ListIterator::maxIntIterator, list);
        System.out.print("maxGet");
        runTest(ListIterator::maxGet, list);
        System.out.print("maxIntGet");
        runTest(ListIterator::maxIntGet, list);
        System.out.print("maxInt_array");
        runTest(ListIterator::maxInt, arrayContainer);
        System.out.print("maxIntIterator_array");
        runTest(ListIterator::maxIntIterator, arrayContainer);
        System.out.print("maxIntIteratorNoForLoop_primitiveArray");
        runTest(ListIterator::maxIntIterator_NoForLoop, arrayContainer);
        System.out.print("maxIntIteratorNoCheck_array");
        runTest(ListIterator::maxIntIterator_NoCheck, arrayContainer);
        System.out.print("maxTroveIterator");
        runTest(ListIterator::maxTroveIterator, troveList);
        System.out.print("maxIntegerIterator");
        runTest(ListIterator::maxIntegerIterator, arrayIntegerContainer);
    }

    private static <T> void runWarmUp(Function<T, Integer> function, T input) {
        int m = 0;
        for (int i = 0; i < RUNS; i++) {
            m = function.apply(input);
        }

    }

    private static <T> void runTest(Function<T, Integer> function, T input) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long currentCpuTime = threadMXBean.getCurrentThreadCpuTime();
        int m = 0;
        long nanoTime = System.nanoTime();
        for (int i = 0; i < RUNS; i++) {
            m = function.apply(input);
        }
        System.out.println(", max = " + m + ", time = " + ((System.nanoTime() - nanoTime) / 10E6) + " ms. CPU time = " + ((threadMXBean.getCurrentThreadCpuTime() - currentCpuTime) / 10E6) + " ms");
    }

    public static List<Integer> create(int length) {
        Random r = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(r.nextInt(128));
        }
        return list;
    }

    public static int[] createArray(int length) {
        Random r = new Random();
        int[] array = new int[length];
        for (int i = 0; i < 100000; i++) {
            array[i] = r.nextInt(128);
        }
        return array;
    }

    public static int maxIterator(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (Integer i : list) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static int maxIntIterator(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int i : list) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static int maxGet(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            Integer j = list.get(i);
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

    public static int maxIntGet(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int j = list.get(i);
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

    public static int maxInt(IntArrayContainer input) {
        int[] array = input.array;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int j = array[i];
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

    public static int maxIntIterator(IntArrayContainer input) {
        int[] array = input.array;
        int max = Integer.MIN_VALUE;
        IntArrayIterator intArrayIterator = new IntArrayIterator(array);
        for (Integer i : intArrayIterator) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static int maxIntIterator_NoForLoop(IntArrayContainer input) {
        int[] array = input.array;
        int max = Integer.MIN_VALUE;
        PrimitiveIntArrayIterator intArrayIterator = new PrimitiveIntArrayIterator(array);
        while (intArrayIterator.hasNext()) {
            int i = intArrayIterator.next();
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static int maxIntIterator_NoCheck(IntArrayContainer input) {
        int[] array = input.array;
        int max = Integer.MIN_VALUE;
        IntArrayIterator_NoCheck intArrayIterator = new IntArrayIterator_NoCheck(array);
        for (Integer i : intArrayIterator) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static int maxTroveIterator(TIntArrayList list) {
        int max = Integer.MIN_VALUE;
        TIntIterator iterator = list.iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static int maxIntegerIterator(IntegerArrayContainer input) {
        Integer[] array = input.array;
        int max = Integer.MIN_VALUE;
        IntegerArrayIterator intArrayIterator = new IntegerArrayIterator(array);
        for (Integer i : intArrayIterator) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    private static class IntArrayIterator implements Iterator<Integer>, Iterable<Integer> {

        private final int[] array;
        private int counter = 0;

        public IntArrayIterator(int[] array) {
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
            if (!hasNext()) {
                throw new IllegalStateException("Call hasNext() first!");
            }
            return array[counter++];
        }

    }

    private static class IntArrayIterator_NoCheck implements Iterator<Integer>, Iterable<Integer> {

        private final int[] array;
        private int counter = 0;

        public IntArrayIterator_NoCheck(int[] array) {
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

        public IntegerArrayIterator(Integer[] array) {
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

        public PrimitiveIntArrayIterator(int[] array) {
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

        public IntArrayContainer(int[] array) {
            this.array = array;
        }

    }

    public static class IntegerArrayContainer {

        final Integer[] array;

        public IntegerArrayContainer(Integer[] array) {
            this.array = array;
        }

        public IntegerArrayContainer(List<Integer> list) {
            this.array = list.toArray(new Integer[list.size()]);
        }
    }
}
