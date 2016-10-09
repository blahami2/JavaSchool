/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.java8.exercise.transaction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Michael Blaha <blahami2@gmail.com>
 */
public class ExerciseRunner {

    public static void main( String... args ) {
        // init
        Trader raoul = new Trader( "Raoul", "Cambridge" );
        Trader mario = new Trader( "Mario", "Milan" );
        Trader alan = new Trader( "Alan", "Cambridge" );
        Trader brian = new Trader( "Brian", "Cambridge" );
        List<Transaction> transactions = Arrays.asList(
                new Transaction( brian, 2011, 300 ),
                new Transaction( raoul, 2012, 1000 ),
                new Transaction( raoul, 2011, 400 ),
                new Transaction( mario, 2012, 710 ),
                new Transaction( mario, 2012, 700 ),
                new Transaction( alan, 2012, 950 )
        );
        System.out.println( "#1 Find all transactions in the year 2011 and sort them by value (small to high)" );
        List<Transaction> list1 = transactions.stream()
                .filter( x -> x.getYear() == 2011 )
                .sorted( ( x, y ) -> Integer.compare( x.getValue(), y.getValue() ) )
                // .sorted(Comparator.comparing(Transaction::getValue))
                .collect( Collectors.toList() );
        System.out.println( toString( list1 ) );
        System.out.println( "#2 What are all the unique cities where the trades work?" );
        List<String> list2 = transactions.stream()
                .map( x -> x.getTrader().getCity() )
                .distinct()
                .collect( Collectors.toList() );
        System.out.println( toString( list2 ) );
        System.out.println( "#3 Find all traders from Cambridge and sort them by name" );
        Stream<Trader> list3 = transactions.stream()
                .map( Transaction::getTrader )
                .filter( x -> x.getCity().equals( "Cambridge" ) )
                .distinct()
                .sorted( ( x, y ) -> x.getName().compareTo( y.getName() ) );
        System.out.println( toString( list3 ) );
        System.out.println( "#4 Return a string of all traders' names sorted alphabetically" );
        String names4 = transactions.stream()
                .map( x -> x.getTrader().getName() )
                .distinct()
                .sorted()
                // .reduce("", (x1,x2) -> x1 + x2)
                .collect( Collectors.joining( " " ) );
        System.out.println( names4 );
        System.out.println( "#5 Are any traders based in Milan?" );
        boolean boolean5 = transactions.stream()
                .anyMatch( x -> x.getTrader().getCity().equals( "Milan" ) );
        System.out.println( boolean5 );
        System.out.println( "#6 Print all transactions' values from the traders living in Cambridge" );
        Stream<Integer> list6 = transactions.stream()
                .filter( x -> x.getTrader().getCity().equals( "Cambridge" ) )
                .map( Transaction::getValue );
        System.out.println( toString( list6 ) );
        System.out.println( "#7 What's the highest value of all the transactions?" );
        int int7 = transactions.stream()
                // .map(Transaction::getValue)
                // .reduce(Integer::max)
                .mapToInt( Transaction::getValue )
                .max().getAsInt();
        System.out.println( int7 );
        System.out.println( "#8 Find the transaction with the smallest value" );
        Transaction trans8 = transactions.stream()
                // .reduce((x1,x2) -> x1.getValue() < x2.getValue() ? x1 : x2)
                // OR
                // .min(Comparator.comparing(Transaction::getValue))
                .sorted( ( x, y ) -> Integer.compare( x.getValue(), y.getValue() ) )
                .findFirst().get();
        System.out.println( trans8 );
    }

    private static <T> String toString( List<T> list ) {
        return toString( list.stream() );
    }

    private static <T> String toString( Stream<T> list ) {
        return "[" + list.map( T::toString ).collect( Collectors.joining( ", " ) ) + "]";
    }
}
