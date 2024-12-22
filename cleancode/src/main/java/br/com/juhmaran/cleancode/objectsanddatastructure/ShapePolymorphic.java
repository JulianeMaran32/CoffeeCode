package br.com.juhmaran.cleancode.objectsanddatastructure;

import java.awt.*;

public class ShapePolymorphic {

    public static abstract class Square implements Shape {

        private Point topLeft;
        private double side;

        public double area() {
            return side * side;
        }

    }

    public static abstract class Rectangle implements Shape {

        private Point topLeft;
        private double height;
        private double width;

        public double area() {
            return height * width;
        }

    }

    public static abstract class Circle implements Shape {

        private Point center;
        private double radius;
        public final double PI = 3.141592653589793;

        public double area() {
            return PI * radius * radius;
        }

    }

    public static class Geometry {

        public double area(Object shape) throws NoSuchShapeException {
            if (shape instanceof Square s) {
                return s.area();
            }
            if (shape instanceof Rectangle r) {
                return r.area();
            }
            if (shape instanceof Circle c) {
                return c.area();
            }
            throw new NoSuchShapeException();
        }

    }

    public static class NoSuchShapeException extends RuntimeException {
        public NoSuchShapeException() {
        }
    }

}
