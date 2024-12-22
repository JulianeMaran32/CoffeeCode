package br.com.juhmaran.cleancode.objectsanddatastructure;

import java.awt.*;

public class ShapeProcedural {

    public static class Square {
        public Point topLeft;
        public double side;
    }

    public static class Rectangle {
        public Point topLeft;
        public double height;
        public double width;
    }

    public static class Circle {
        public Point center;
        public double radius;
    }

    public static class Geometry {

        public final double PI = 3.141592653589793;

        public double area(Object shape) throws NoSuchShapeException {
            if (shape instanceof Square s) {
                return s.side * s.side;
            }
            if (shape instanceof Rectangle r) {
                return r.height * r.width;
            }
            if (shape instanceof Circle c) {
                return PI * c.radius * c.radius;
            }
            throw new NoSuchShapeException();
        }

    }

    public static class NoSuchShapeException extends RuntimeException {
        public NoSuchShapeException() {
        }
    }

}
