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
public class EnumsAndDesign {
    // Emulate extensible enums with interfaces
    // - enums should rarely be extensible
    // - however, that are rare cases, where users should be able to provide their own elements (e.g. operations)
    // - solution:
    // - - use interface
    // - - implements this interface in the enum
    // - - use enum elements or implement your own
}
