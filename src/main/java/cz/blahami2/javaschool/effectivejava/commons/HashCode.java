/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.effectivejava.commons;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class HashCode {

    private final boolean booleanField;
    /**
     * int, short, char, byte, ...
     */
    private final int intAndLowerField;
    private final long longField;
    private final float floatField;
    private final double doubleField;
    private final Object objectField;
    private final Object nonEqualsObjectField;
    private final double[] arrayField;
    private Object nonFinalField;
    private volatile int hashCode;

    public HashCode( boolean booleanField, int intAndLowerField, long longField, float floatField, double doubleField, Object objectField, Object nonEqualsObjectField, double[] arrayField ) {
        this.booleanField = booleanField;
        this.intAndLowerField = intAndLowerField;
        this.longField = longField;
        this.floatField = floatField;
        this.doubleField = doubleField;
        this.objectField = objectField;
        this.nonEqualsObjectField = nonEqualsObjectField;
        this.arrayField = arrayField;
    }

    // hashCode must be constant (for a particular object) during the whole execution process!
    // a.equals(b) => a.hashCode == b.hashCode
    public int calculateHashCode() {
        int hash = hashCode;
        if ( hash == 0 ) {
            hash = 31; // take some non-zero (prime) constant
            hash += booleanField ? 1 : 0; // 1 or 0 for boolean
            hash += (int) intAndLowerField; // int for char, byte, int, ...
            hash += (int) ( longField ^ ( longField >>> 32 ) ); // create int from long
            hash += Float.floatToIntBits( floatField ); // int equivalent to float
            long d = Double.doubleToLongBits( doubleField ); // double to long, long to int
            hash += (int) ( d ^ ( d >>> 32 ) );
            hash += objectField == null ? 0 : objectField.hashCode(); // 0 for null, hashCode otherwise
            for ( int i = 0; i < arrayField.length; i++ ) { // apply recursively for each field
                double e = arrayField[i];
                long de = Double.doubleToLongBits( e );
                hash += (int) ( de ^ ( de >>> 32 ) );
            }
            // do not add field that is not in equals!
            // do not add nonfinal field!
            // test that a.equals(b) => a.hash == b.hash
            hashCode = hash;
        }
        return hash;
    }
}
