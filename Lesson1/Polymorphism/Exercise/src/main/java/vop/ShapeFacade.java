/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vop;

/**
 *
 * @author erso
 */
public class ShapeFacade {

    //Singleton Stufff:
    private static ShapeFacade instance = null;

    public static ShapeFacade getInstance() {
        if (instance == null) {
            instance = new ShapeFacade();
        }
        return instance;
    }

    // enum som kendes af GUI'en
    public enum SHAPES {
        CIRCLE, ELLIPSE, RECTANGLE, SQUARE
    };

    // Facadens public metoder
    public String getShapeInfo(SHAPES shape, double... a) {
        switch (shape) {
            case CIRCLE:
                return "" + (new Circle(a[0]));
            case SQUARE:
                return "" + (new Square(a[0]));
            case ELLIPSE:
                return "" + (new Ellipse(a[0], a[1]));
            case RECTANGLE:
                return "" + (new Rectangle(a[0], a[1]));
            default:
                return "Shape is unknown";
        }
    }
}
