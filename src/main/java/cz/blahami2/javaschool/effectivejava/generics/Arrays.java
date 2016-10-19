/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.effectivejava.generics;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class Arrays {

    // Prefer Lists to Arrays
    // - array (legal code, fails at runtime) - if A is a subtype of B, then A[] is a subtype of B[]
    static Object[] objectArray = new Long[1];

    static {
        // objectArray[0] = "I don't fit"; // throws an exception
    }
    // - list (fails at compile)
    // static List<Object> objectList = new ArrayList<Long>(); // illegal code

    // - arrays and lists dont mix them, if you see an error or a warning, use list instead
    // However, there is still a workaround - nope, it does not work at all
    private static class SomeClass<E> {

        E[] array;

        public SomeClass() {
            //this.array = new E[10]; // wont compile
            this.array = (E[]) new Object[10]; // not typesafe, but what the hell, it works
        }

    }

    public static void main( String... args ) {
        SomeClass<String> someClass = new SomeClass<>();
        String content1 = someClass.array[0]; // ClassCastException - it typecasts it before return
        String content2 = (String) someClass.array[0]; // ClassCastException as well
        someClass.array[0] = "aaaa";
        String content = someClass.array[0];
        System.out.println( "content = " + content );
    }
}
