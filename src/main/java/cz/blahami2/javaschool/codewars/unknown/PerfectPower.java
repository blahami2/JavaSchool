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
public class PerfectPower {

    public static int[] isPerfectPower( int n ) {
        int sqrt = (int) Math.sqrt( n );
        for ( int m = 2; m <= sqrt; m++ ) {
            int curr = n;
            int k = 0;
            while ( curr % m == 0 ) {
                k++;
                curr /= m;
            }
            if ( curr == 1 ) {
                return new int[]{ m, k };
            }
        }
        return null;
    }
}
