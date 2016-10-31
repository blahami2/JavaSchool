/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.codewars.unknown;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class DnaStrand {

    public static String makeComplement( String dna ) {
        // next time better use dna.chars() -> IntStream
        byte[] bytes = dna.getBytes();
        return IntStream.range( 0, bytes.length )
                .map( idx -> map( bytes[idx] ) )
                .mapToObj( c -> Character.toString( (char) c ) )
                .collect( Collectors.joining() );
    }

    public static int map( int c ) {
        switch ( c ) {
            case 'A':
                return 'T';
            case 'T':
                return 'A';
            case 'G':
                return 'C';
            case 'C':
                return 'G';
        }
        throw new IllegalArgumentException( "Unknown char: " + c );
    }

}
