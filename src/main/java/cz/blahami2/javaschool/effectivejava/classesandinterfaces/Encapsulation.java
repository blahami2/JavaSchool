/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.effectivejava.classesandinterfaces;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class Encapsulation {

    // hide internal data
    private int internalInt;

    // hide implementation details
    public int getPositiveNumber() {
        return internalInt > 0 ? internalInt : 1;
    }

    // leads to decoupling
    // always make it as inaccessible as possible
    // - package-private makes it part of the (package-)internal implementation
    // - public makes it part of the public API and therefore it should stay the same forever (compatibility reasons)
    // make package-private classes used in a single class nested in that class => there is the rule if and when to create nested class
    private static class InternalClass {
    }
    // watch out for protected! Is has higher accesibility than pacakge-private, should the class be extended outside the module
    // it is possible to make members package-private for tests, but not more than that!
    // instance fields should never be public
    // watch out for public final arrays, they can be modified!
    public static final InternalClass[] DANGEROUS_MODIFIABLE_ARRAY = { new InternalClass(), new InternalClass() };
    // use unmodifiable collection instead - when it will be returned/called often and will not be modified
    public static final List<InternalClass> UNMODIFIABLE_LIST = Collections.unmodifiableList( Arrays.asList( new InternalClass(), new InternalClass() ) );
    // or defensive copy - if its an array, it should be fairly quick to return cloned array, also does not have to check for modifications all the time
    private static final InternalClass[] PRIVATE_MODIFIABLE_ARRAY = { new InternalClass(), new InternalClass() };

    public static final InternalClass[] getPrivateModifiableArray() {
        return PRIVATE_MODIFIABLE_ARRAY.clone();
    }
}
