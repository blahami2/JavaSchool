/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.effectivejava.generics;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class Typesafe {
    // Don't use raw types. It treats everything as an object

    // Eliminate unchecked warnings
    // - eliminate it naturally (fix it)
    // - prove that the code is typesafe, then use @SupressWarnings("unchecked") annotation for the code and comment it
    // Favor generic types
    // - dont use List, use List<>
}
