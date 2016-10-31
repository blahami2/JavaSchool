/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.codewars.unknown;

import cz.blahami2.javaschool.codewars.unknown.DnaStrand;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class DnaStrandTest {
    
    public DnaStrandTest() {
    }
    
    @Test
    public void test01() {
       assertEquals("TTTT", DnaStrand.makeComplement("AAAA"));
    }
    @Test
    public void test02() {
       assertEquals("TAACG", DnaStrand.makeComplement("ATTGC"));
    }
    @Test
    public void test03() {
       assertEquals("CATA", DnaStrand.makeComplement("GTAT"));
    }  
    
}
