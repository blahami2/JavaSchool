/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.effectivejava.classesandinterfaces;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class Abstract {
    // Prefer interfaces to abstract classes
    // - existing classes can be easily retrofitted to implement a new interface
    // - interfaces are ideal for defining mixins (mixin adds some optional behavior to the primary functionality)
    // - interfaces allow the construction of nonhierarchical type frameworks (multiple inheritance)
    // - via the wrapper class idiom interfaces allow safe, powerful enhancements
    // - there can be skeletal implementation using the abstract class
    // - - application still uses the interface
    // - - abstract class helps classes with the implementation, if it's possible
    // - - by convention, these skeletal implementations are called Abstract<InterfaceName>
    // - - see Inheritance for details about ihneritance classes - documented, etc.
    // - - since Java8, default methods might help as well
}
