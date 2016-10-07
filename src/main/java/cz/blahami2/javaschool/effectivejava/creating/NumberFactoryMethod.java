/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.effectivejava.creating;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class NumberFactoryMethod {

    private static final int SIZE = 128;
    private static final IntNumber[] PREDEFINED = new IntNumber[SIZE + 1];

    // #1 factory method has name
    public static NumberFactoryMethod fromString( String string ) {
        return of( Double.parseDouble( string ) );
    }

    // #2 factory method does not have to create new object every time
    public static NumberFactoryMethod of( int value ) {
        if ( -SIZE / 2 <= value && value <= SIZE / 2 ) {
            int idx = value + SIZE / 2;
            if ( PREDEFINED[idx] == null ) {
                PREDEFINED[idx] = new IntNumber( value );
            }
            return PREDEFINED[idx];
        }
        return new IntNumber( value );
    }

    // #3 factory method can return object of any subtype of its type, it also does not even have to be public
    public static NumberFactoryMethod of( double value ) {
        // for example int for int values, double for double values - no need to use double if its int
        return new DoubleNumber( value );
    }
    
    // #X see java.util.Collections, it provides multiple factory methods for Collections
    
    // common names:
    // valueOf - value of parameters
    // of - short for valueOf
    // getInstance - returns some instance
    // newInstance - guarantees new instance (distinct from others)
    // getType
    // newType
    
    // CAUTION
    // Only factory methods make it impossible to subclass the class
    // Creational factory method does not stand out in the API, as the 'new' keyword does

    private static class IntNumber extends NumberFactoryMethod {

        private final int value;

        public IntNumber( int value ) {
            this.value = value;
        }

    }

    private static class DoubleNumber extends NumberFactoryMethod {

        private final double value;

        public DoubleNumber( double value ) {
            this.value = value;
        }

    }
    // ...
}
