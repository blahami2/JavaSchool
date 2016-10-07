/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.effectivejava.creating;

import java.io.Serializable;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class Singleton {
    // Singleton complicates testing due to impossibility of mock substitution

    // CAUTION - serializable - instance fields make 'transient', implement readResolve() and prevent recreating the object!
    public static class FinalFieldSingleton implements Serializable {

        public static final FinalFieldSingleton INSTANCE = new FinalFieldSingleton();

        private FinalFieldSingleton() {

        }

        public Object readResolve() {
            return INSTANCE;
        }
    }

    public static class StaticFactorySingleton implements Serializable {

        private static final StaticFactorySingleton INSTANCE = new StaticFactorySingleton();

        private StaticFactorySingleton() {

        }

        public static StaticFactorySingleton getInstance() {
            return INSTANCE;
        }

        public Object readResolve() {
            return INSTANCE;
        }

    }

    // Solves everything
    public static enum EnumSingleton {
        INSTANCE;

    }
}
