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
public class Parameters {
    // Check parameters for validity (defensive programming)
    // - document restrictions
    // - enforce with checks at the beginning of the method body
    // - - for public methods use exception (IllegalArgument, NullPointer, IndexOutOfBound, ...)
    // - - for private methods use assertions (must be enabled via -ea execution parameter, do not slow down the app otherwise)
    // 
    // Create defensive copies
    // - when obtaining mutable object, create defensive copy, which is then saved instead
    // - check its validity after (check validity of the copy)
    // - - another thread can change the object after its validity check in so called "window of vulnerability"
    // - do not use clone for defensive copies
    // - - an extension of the input class can be provided, and it can override the clone method, which can be malicious
    //
    // Use varargs judiciously
    // - do not retrofit methods with array parameter to varargs
    // - use varargs only when a call really operates on a variable-length sequence of values (use trick for 1+, 2+, ...: foo(int first, int... rest), foo(int first, int second, int... rest))
    // - consider performance
    // - - array creation required when invoking method
    // - - that's why there are usually so many methods overloaded with compelx signatures such as foo(int a), foo(int a, int b), foo(int a, int b, int c), foo(int a, int b, int c, int... rest)
    // - - suppose 95% of the calls use fewer than 4 args, then create 3 methods (see above) and then varargs version for the 5%
}
