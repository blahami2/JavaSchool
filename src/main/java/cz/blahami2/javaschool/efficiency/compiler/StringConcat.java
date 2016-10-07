/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.efficiency.compiler;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class StringConcat {

    public static String concat( String firstName, String lastName ) {
        return firstName + " " + lastName;
    }

    public static String concat( String degree1, String firstName, String lastName, String degree2 ) {
        String s = "";
        if ( degree1 != null ) {
            s = degree1 + " ";
        }
        s += firstName + " " + lastName;
        if ( degree2 != null ) {
            s += ", " + degree2;
        }
        return s;
    }

    public static String concatTernary( String degree1, String firstName, String lastName, String degree2 ) {
        String s = degree1 != null ? degree1 + " " : "";
        s += firstName + " " + lastName;
        s = degree2 != null ? s + ", " + degree2 : s;
        return s;
    }

    public static String concatNames( String... names ) {
        String s = "";
        for ( String name : names ) {
            s += name + " ";
        }
        return s;
    }

}
