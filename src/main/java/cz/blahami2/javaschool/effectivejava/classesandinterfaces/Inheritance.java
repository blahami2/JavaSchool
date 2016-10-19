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
public class Inheritance {
    // Favor composition over inheritance
    // - extend only classes made for this purpose
    // - - abstract classes
    // - - well documented extendable classes
    // - example of wrong inheritance:
    // - - HashSet, override add and addAll with counter, but internally addAll calls add, which makes the addition double its size - and it depends on the implementation details
    // instead, use composition:

    interface NumberSupplier {

        int getNumber();
    }

    private static class ClassA implements NumberSupplier {

        @Override
        public int getNumber() {
            return 1;
        }
    }

    interface StringSupplier {

        String getString();
    }

    private static class ClassB implements StringSupplier {

        @Override
        public String getString() {
            return "1";
        }
    }

    /**
     * Forwarding class, wrapper class, Decorator pattern
     */
    private static class ClassC implements NumberSupplier, StringSupplier {

        private final NumberSupplier numberSupplier = new ClassA();
        private final StringSupplier stringSupplier = new ClassB();

        /**
         * Forwarding method
         *
         * @return number
         */
        @Override
        public int getNumber() {
            return numberSupplier.getNumber();
        }

        @Override
        public String getString() {
            return stringSupplier.getString();
        }

    }
    
    // B should extend A if and only if there is "is-a" relationship between them
    // - is every B really an A?
    // inheritance disadvantages
    // - extending class is tied up to the extended class forever
    // - endangers encapsulation
    // - less error-prone
    
    // Design and document for inheritance or else prohibit it
    // just make it final or see item #17
    // - for each method, if it uses its other methods, document usage sequence - useful when overriding
}
