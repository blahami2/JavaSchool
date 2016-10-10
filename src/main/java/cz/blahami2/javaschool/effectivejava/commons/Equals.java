/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.effectivejava.commons;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class Equals {
    // Do not override if
    // - each instance is unique
    // - you dont care
    // - superclass's equals is enough
    // - private, package-private, equals is never called
    //   - in this case override with impl: throw new AssertionError(); which ensures the equals is never called
    
    // reflexive - x.equals(x) == true
    // symmetric - x.equals(y) <=> y.equals(x)
    // transitive - x.equals(y) && y.equals(z) => x.equals(z)
    // consistent - x.equals(y)[t1] == x.equals(y)[t2] forall t unless object has been modified, where t is time
    // x.equals(null) return false
    
    // reflexive
    // - hard to violate
    
    // symmetric
    // - watch out with equality to object of different class - it does not have to be equal the other way around (my own String equals java String)
    
    // transitive
    // - extend class, add value component to equals: superclass does equal subclass, subclass does not equal superclass - broken symmetry
    // - fix symmetry by adding comparison to superclass without the added value, superclass.equals(red), superclass.equals(blue), blue does not equal red - broken transitivity
    // - there is no way to make it work? TODO
}
