/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.effectivejava.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class Wildcard {

    // Use bounded wildcards to increase API flexibility
    // - parametrized types are invariant => for any types T1 and T2 (even if T1 is subtype of T2), List<T1> is neither subtype nor supertype of List<T2>
    static class NoWildcard<E> {

        void addAll( Collection<E> collection ) {

        }
    }

    static {
        NoWildcard<Number> numbers = new NoWildcard<>();
        Collection<Integer> ints = Arrays.asList( 1, 2, 3 );
        // numbers.addAll( ints ); // Collection<Integer> cannot be converted into Collection<Number>
    }

    static class YesWildcard<E> {

        <F extends E> void addAll1( Collection<F> collection ) {
            // explicit type
        }

        void addAll( Collection<? extends E> collection ) {
            // use wildcard
        }
    }

    static {
        YesWildcard<Number> numbers = new YesWildcard<>();
        Collection<Integer> ints = Arrays.asList( 1, 2, 3 );
        numbers.addAll( ints ); // works
        numbers.addAll1( ints ); // works
    }

    // PECS - Producer-extends, Consumer-super
    // - if the parameter is a producer, then use extends (see above - the collection parameter produces values to add - we need them to be of type E or its subtype)
    // - it the parameter is a consumer, then use super (see below - the collection parameter consumes values - we need them to accept at least E, but it can be a collection of Numbers as well)
    static void pushThreeOnesInto( Collection<? super Integer> collection ) {
        collection.add( 1 );
        collection.add( 1 );
        collection.add( 1 );
    }

    static {
        Collection<Number> numbers = new ArrayList<>();
        pushThreeOnesInto( numbers );
    }

    static void pushThreeOnesInto_Wrong( Collection<Integer> collection ) {
        collection.add( 1 );
        collection.add( 1 );
        collection.add( 1 );
    }

    static {
        Collection<Number> numbers = new ArrayList<>();
        // pushThreeOnesInto_Wrong( numbers ); // Collection<Number> cannot be converted into Collection<Integer>
    }
    // - if the parameter is both a producet and a consumer, is must be exactly E - we need it to be E or its subtype AND E or its supertype => E

    // Do NOT use wildcard types as return types, it would force user to do the same
    // - wildcards should be "invisible" to user, he should not be forced to think about them
    // Sometimes explicit type parameter is necessary
    static {
        List<Integer> ints = Arrays.asList( 1, 2, 3 );
        List<Double> floats = Arrays.asList( 1.0, 2.0, 3.0 );
        List<Number> numbers = Methods.<Number>join1( ints, floats ); // works even without it here, though... just see the syntax, it might be problematic somewhere else
    }
    // TODO page 138
}
