/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.effectivejava.enumsandannotations;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class Enums {
    // Use enums instead of int constants
    // - limits user to predefined values (cannot input something that is not in the enum)
    // - implements serializable and comparable
    // - enum is a regular final class, its members are final instancs (constructor with parameters, methods, etc.)
    // - each member can also define declared abstract methods!
    // - scenario
    // - - you want to have an enum, where each instance uses certain operation, but some of the members share the same operation
    // - - bad solution: switch statemens
    // - - simple correct solution: use internal streategy enum and force it via constructor parameter!
    // - switches are fine for external enums (out of our control)
    //
    // Prefer instnace fields to ordinals
    // - do not make the application rely on the ordinal number, use field instead
    // 
    // Use EnumSet instead of bit fields
    // - EnumSet uses bit fields internally for all enums with fewer than 65 elements
    // - while preserving performance, it also offers all the advantages of enums
    //
    // Use EnumMap instead of ordinal indexing
    // - using them so can cause troubles with generics (arrays vs generics)
    // - any int value can be used in an array, not any enum can be used in the map
    // - EnumMap is backed by array
    // - while preserving performance, it also offers all the advantages of enums
    
}
