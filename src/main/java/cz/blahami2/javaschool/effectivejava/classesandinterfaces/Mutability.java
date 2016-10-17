/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.effectivejava.classesandinterfaces;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class Mutability {
    // minimize mutability
    // - easier to design, implement, use, less error-prone and more secure
    // - much easier to use with synchronization

    // 1. no modify methods
    public void setSomething( int smt ) {
        throw new IllegalStateException( "Don't" );
    }

    // 2. ensure that the class cannot be extended
    public static final class Cls {
    }

    // - an alternative
    public static final class ClsPrivate {

        private ClsPrivate() {
        }

        public static ClsPrivate newObject() {
            return new ClsPrivate();
        }

    }

    // 3. make all fields final
    private final int field1 = 1;

    // 4. make all field private
    private final int field2 = 2;

    // 5. ensure exclusive access to any mutable components
    private static final class Cls2 {

        private final List<Cls> mutableList = new ArrayList<>();

        public final List<Cls> getList() { // make sure the content of list is immutable as well
            return new ArrayList<>( mutableList );
        }
    }

    // functional approach
    private static final class Cls3 {

        private final int x;

        public Cls3( int x ) {
            this.x = x;
        }

        public int getValue() {
            return x;
        }

        // create new object with the result
        public Cls3 add( Cls3 other ) {
            return new Cls3( getValue() + other.getValue() );
        }
    }

    // main disadvantage
    // - performance - need to create new object for new value
    // possible solutions
    // - provide multistep operation as primitive
    // - provide mutable companion (for example String + StringBuilder)
    
    // other optimizations
    // - it is possible to have mutable innter fields such as cache, lazy inits etc., just don't make it visible from the outside
}
