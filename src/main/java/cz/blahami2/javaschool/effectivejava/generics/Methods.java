/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.effectivejava.generics;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class Methods {
    // Favor generic methods
    // - wrong
    public static List join( List listA, List listB ) {
        List list = new ArrayList( listA );
        list.addAll( listB );
        return list;
    }

    // - correct
    public static <E> List<E> join1( List<? extends E> listA, List<? extends E> listB ) {
        List<E> list = new ArrayList<>( listA );
        list.addAll( listB );
        return list;
    }
}
