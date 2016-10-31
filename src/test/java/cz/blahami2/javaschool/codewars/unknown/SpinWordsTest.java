/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.codewars.unknown;

import cz.blahami2.javaschool.codewars.unknown.SpinWords;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class SpinWordsTest {
    
    public SpinWordsTest() {
    }

    @Test
    public void test() {
      assertEquals("emocleW", new SpinWords().spinWords("Welcome"));
      assertEquals("Hey wollef sroirraw", new SpinWords().spinWords("Hey fellow warriors"));
    }
    
    
}
