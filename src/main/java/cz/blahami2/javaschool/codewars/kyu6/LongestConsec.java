/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.codewars.kyu6;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class LongestConsec {

    public static String longestConsec( String[] strarr, int k ) {
        if ( strarr.length == 0 || strarr.length < k || k <= 0 ) {
            return "";
        }
        int[] lengths = new int[strarr.length - k + 1];
        int sum = 0;
        for ( int i = strarr.length - 1; i > strarr.length - k; i-- ) {
            sum += strarr[i].length();
        }
        for ( int i = lengths.length - 1; i >= 0; i-- ) {
            sum = sum - ( i + k < strarr.length ? strarr[i + k].length() : 0 ) + strarr[i].length();
            lengths[i] = sum;
        }
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for ( int i = 0; i < lengths.length; i++ ) {
            if ( lengths[i] > max ) {
                max = lengths[i];
                idx = i;
            }

        }
        StringBuilder sb = new StringBuilder();
        for ( int i = idx; i < idx + k; i++ ) {
            sb.append( strarr[i] );
        }
        return sb.toString();
    }
}
