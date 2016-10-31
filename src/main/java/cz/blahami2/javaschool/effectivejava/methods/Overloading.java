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
public class Overloading {
    // Use overloading judiciously
    // - unlike override selection (which is dynamic), overload selection is static
    // - - overloaded methods are renamed in compile time to something like foo_int_int and statically resolved
    // - consider the following rules:
    // - - never export two overloadings with the same number of parameters
    // - - for varargs, dont overload them at all (unless the varargs variant has strictly more parameters)
    // - example of wrong overloading in Java API: ArrayList.remove(E element), ArrayList.remove(int index) for ArrayList<Integer> caused by autoboxing
}
