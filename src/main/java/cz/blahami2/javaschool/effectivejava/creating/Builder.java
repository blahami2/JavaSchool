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
public class Builder {

    // #1 used when there are too many optional parameters
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    public Builder( int a, int b, int c, int d, int e, int f, int g ) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
    }

    public static class BuilderBuilder {

        private int a;
        private int b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;

        public BuilderBuilder setA( int a ) {
            this.a = a;
            return this;
        }

        public BuilderBuilder setB( int b ) {
            this.b = b;
            return this;
        }

        public BuilderBuilder setC( int c ) {
            this.c = c;
            return this;
        }

        public BuilderBuilder setD( int d ) {
            this.d = d;
            return this;
        }

        public BuilderBuilder setE( int e ) {
            this.e = e;
            return this;
        }

        public BuilderBuilder setF( int f ) {
            this.f = f;
            return this;
        }

        public BuilderBuilder setG( int g ) {
            this.g = g;
            return this;
        }

        public Builder build() {
            return new Builder( a, b, c, d, e, f, g );
        }
    }
}
