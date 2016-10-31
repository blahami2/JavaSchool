/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.codewars.kyu6;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class LongestConsecTest {

    public LongestConsecTest() {
    }

    private static void testing( String actual, String expected ) {
        assertEquals( expected, actual );
    }

    @Test
    public void test() {
        System.out.println( "longestConsec Fixed Tests" );
        testing( LongestConsec.longestConsec( new String[]{ "zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail" }, 2 ), "abigailtheta" );
        testing( LongestConsec.longestConsec( new String[]{ "ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh" }, 1 ), "oocccffuucccjjjkkkjyyyeehh" );
        testing( LongestConsec.longestConsec( new String[]{}, 3 ), "" );
        testing( LongestConsec.longestConsec( new String[]{ "itvayloxrp", "wkppqsztdkmvcuwvereiupccauycnjutlv", "vweqilsfytihvrzlaodfixoyxvyuyvgpck" }, 2 ), "wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck" );
        testing( LongestConsec.longestConsec( new String[]{ "wlwsasphmxx", "owiaxujylentrklctozmymu", "wpgozvxxiu" }, 2 ), "wlwsasphmxxowiaxujylentrklctozmymu" );
        testing( LongestConsec.longestConsec( new String[]{ "zone", "abigail", "theta", "form", "libe", "zas" }, -2 ), "" );
        testing( LongestConsec.longestConsec( new String[]{ "it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz" }, 3 ), "ixoyx3452zzzzzzzzzzzz" );
        testing( LongestConsec.longestConsec( new String[]{ "it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz" }, 15 ), "" );
        testing( LongestConsec.longestConsec( new String[]{ "it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz" }, 0 ), "" );
    }

}
