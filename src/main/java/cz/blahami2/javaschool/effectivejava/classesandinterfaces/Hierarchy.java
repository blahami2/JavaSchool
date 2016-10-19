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
public class Hierarchy {
    // Prefer class hierarchies to tagged classes
    // - tagged class is a class, whose behavior depends on some tag (representing a state) - usually full of switches/ifs
    // - alternatives
    // - - abstract class
    // - - - create abstract class/interface representing the supertype
    // - - - create concrete implementations (for each state)
    // - - state pattern
    
    // Favor static member classes over nonstatic
    // - nested class should only serve its enclosing class
    // - use nonstatic if and only if it accesses the enclosing instance
    
    private int encapsulated;
    private class InnerMemberAccessorClass { // for performance reasons it is good to access members - for example iterator
        void foo(){
            encapsulated++;
        }
    }
    
    private static class HierarchyMessengerClass { // otherwise use static - for example Messenger pattern tied up to the given class - somewhat unique return type used only here
        void getSmthing(){
            // do stuff
        }
    }
    
    
}
