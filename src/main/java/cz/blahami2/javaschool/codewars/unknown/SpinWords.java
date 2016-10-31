/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.codewars.unknown;

import java.util.Arrays;
import static java.util.stream.Collectors.joining;

/**
 * https://www.codewars.com/kata/5264d2b162488dc400000001/train/java
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class SpinWords {

    public String spinWords( String sentence ) {
        return Arrays.stream( sentence.split( " " ) )
                .map( word -> word.length() < 5 ? word : new StringBuilder( word ).reverse().toString() )
                .collect( joining( " " ) );
    }

}
