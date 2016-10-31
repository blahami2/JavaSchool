/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.codewars.unknown;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * https://preview.codewars.com/kata/5547cc7dcad755e480000004/train/java
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class RemovedNumbers {

    public static List<long[]> removNb( long n ) {
        // a*b = sum(1..n) - (a+b)
        // a*b + a+b = sum(1..n)
        // ...
        // a*b + b = sum(1..n) - a
        // (a+1)*b = sum(1..n) - a
        // b = (sum(1..n) - a) / (a+1)
        long sum = sum( n );
        return LongStream.range( 1, n + 1 )
                .filter( a -> checkB( sum, a ) && calculateB( sum, a ) <= n )
                .mapToObj( a -> new long[]{ a, calculateB( sum, a ) } )
                .collect( Collectors.toList() );
    }

    public static boolean checkB( long sum, long a ) {
        return ( ( sum - a ) % ( a + 1 ) ) == 0;
    }

    public static long calculateB( long sum, long a ) {
        return ( sum - a ) / ( a + 1 );
    }

    public static long sum( long last ) {
        return ( 1 + last ) * last / 2;
    }
}
