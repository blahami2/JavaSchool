/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.effectivejava.creating;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class UnnecessaryOperations {

    // Avoid constructors for classes like String, Boolean, etc.
    // DONT
    String s1 = new String( "string" );
    // DO
    String s2 = "string";
    
    // Avoid boxing types, prefer primitives
    // DO
    long sum1 = 0; // fori
    // DONT
    Long sum2 = 0L; // fori 
}
