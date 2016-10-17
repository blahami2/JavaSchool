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
public class Accessors {

    // use accessor method, not public fields
    // see example of changing the implementation without changing the public interface
    public static class PointImpl1 { // 2014 - i'm gonna save me some fields and implement it so much better

        private long xy;

        public PointImpl1( int x, int y ) {
            xy = ( (long) x << 32 ) | y;
        }

        public int getX() {
            return (int) ( xy >> 32 );
        }

        public int getY() {
            return (int) xy;
        }
    }
    
    public static class PointImpl2 { // 2015 - i'm gonna reimplement it, it is so unnatural
        private int x;
        private int y;
        
        public PointImpl2(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public int getX(){
            return x;
        }
        
        public int getY(){
            return y;
        }
    }
    // package-private fields are tolerable, they can remove boiler-plate (pointless accessor methods) and do not influende anything outside the package
}
