/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.effectivejava.creating;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class Noninstantiability {
    // making class abstract does not work - can be subclassed and instantiated
    
    // solved
    private Noninstantiability(){
        
    }
}