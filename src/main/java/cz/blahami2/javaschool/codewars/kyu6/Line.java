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
public class Line {

    public static String Tickets( int[] peopleInLine ) {
        int fifties = 0;
        int twentyFives = 0;
        for ( int money : peopleInLine ) {
            switch ( money ) {
                case 25:
                    twentyFives++;
                    break;
                case 50:
                    if ( twentyFives > 0 ) {
                        twentyFives--;
                        fifties++;
                    } else {
                        return "NO";
                    }
                    break;
                case 100:
                    if ( twentyFives > 0 && fifties > 0 ) {
                        twentyFives--;
                        fifties--;
                    } else if ( twentyFives > 2 ) {
                        twentyFives -= 3;
                    } else {
                        return "NO";
                    }
                    break;
            }
        }
        return "YES";
    }
}
