/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.effectivejava.methods;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class Signatures {
    // Choose method names carefully
    // - obey the standard naming conventions
    //
    // Limit number of methods
    // - use convenience methods judiciously
    // - when id doubt, just don't
    //
    // Avoid long parameter lists
    // - 4 or fewer
    // - especially beware of identically typed parameters (order can be confusing)
    // - techniques for shortening:
    // - - break into multiple methods - can cause method boom, but also reduction (increased orthogonality)
    // - - helper classes to hold groups of patameters - static member classes, recommended if a freqquently occuring sequence of parameters is seen
    // - - builder for the helper class (escpeciially if some parameters are optional)
    //
    // For parameter types favor interfaces over classes
    //
    // Prefer two-element enum types to boolean parameters
    // - easier to read, ability to add more options later
    
}
