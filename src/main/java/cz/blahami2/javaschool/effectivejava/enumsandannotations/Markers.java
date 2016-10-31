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
public class Markers {
    // Use marker interfaces to define types
    // - marker interfaces define a type, marker annotations do not
    // Use marker annotation
    // - if its not a class nor interface
    // - if answer to the following question is NO: might I want to write one or more methods that accept only objects that have this marking?
    // - then ask: do I want to limit the use of this marker to elements of a particular interface, forever?
    // - both NO => annotation
    // - otherwise => interface
    // - especially think about it when creating annotation with target ElementType.TYPE
}
