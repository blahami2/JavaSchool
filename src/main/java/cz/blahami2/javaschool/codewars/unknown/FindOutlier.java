/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.codewars.unknown;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class FindOutlier {

    static int find( int[] integers ) {
        boolean isOdd = isOddArray( integers );
        for ( int i = 0; i < integers.length; i++ ) {
            if ( isOdd != isOdd( integers[i] ) ) {
                return integers[i];
            }
        }
        throw new IllegalArgumentException( "No outlier found" );
    }

    static boolean isOddArray( int[] integers ) {
        int oddCounter = 0;
        for ( int i = 0; i < 3; i++ ) {
            oddCounter += isOdd( integers[i] ) ? 1 : 0;
        }
        return oddCounter >= 2;
    }

    static boolean isOdd( int number ) {
        return number == 0
                ? false : ( number > 0
                        ? number % 2 == 1
                        : ( -1 * number ) % 2 == 1 );
    }
}
