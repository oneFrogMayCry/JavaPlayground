package com.example.turtle;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

public class Turtle
{
    private static final int GAMMA = 90;
    private static final int SUM_OF_TRIANGLE_ANGLES = 180;

    private static final int DEGREES_IN_CIRCLE = 360;
    private double x;
    private double y;
    private double rememberX;
    private double rememberY;
    private double alpha; //counter-clockwise to x-axis
    private Color color;

    public Turtle() {
        x = 0;
        y = 0;
        alpha = 0;
        color = Color.BLACK;
    }

    public Turtle(double x, double y) {
        this.x = x;
        this.y = y;
        alpha = 0;
        color = Color.BLACK;
    }

    public Turtle(double x, double y, int angle) {
        this.x = x;
        this.y = y;
        this.alpha = angle;
        color = Color.BLACK;
    }

    public Turtle(double x, double y, double angle, Color color) {
        this.x = x;
        this.y = y;
        this.alpha = angle;
        this.color = color;
    }

    public void turnLeft(double deg) {

        alpha = (alpha+deg)%DEGREES_IN_CIRCLE;
        if(alpha < 0) {
            alpha = (alpha+DEGREES_IN_CIRCLE)%DEGREES_IN_CIRCLE;
        }
    }

    public void turnRight(double deg) {

        alpha = (alpha-deg)%360;
        if(alpha < 0) {
            alpha = (alpha+DEGREES_IN_CIRCLE)%DEGREES_IN_CIRCLE;
        }
    }

    public void drawLine(Group root, double length) {
        Line r = returnLine(length);

        root.getChildren().add(r);
    }

    public Line returnLine(double length) {
        double oldX = x;
        double oldY = y;

        double beta = SUM_OF_TRIANGLE_ANGLES -alpha-GAMMA;
        x += length*sin(toRadians(beta));
        y -= length*sin(toRadians(alpha));

        Line r = new Line(oldX, oldY, x, y);
        r.setStroke(color);

        return r;
    }

    public void drawTriangle(Group root, double length) {
        drawLine(root, length);
        turnLeft(120);
        drawLine(root, length);
        turnLeft(120);
        drawLine(root, length);
        turnLeft(120);
    }

    public void step(double length) {
        double beta = SUM_OF_TRIANGLE_ANGLES -alpha-GAMMA;
        x += length*sin(toRadians(beta));
        y -= length*sin(toRadians(alpha));
    }

    public void backStep(double length) {
        double beta = SUM_OF_TRIANGLE_ANGLES -alpha-GAMMA;
        x -= length*sin(toRadians(beta));
        y += length*sin(toRadians(alpha));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getAlpha() {
        return alpha;
    }
}
