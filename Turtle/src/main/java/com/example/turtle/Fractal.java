package com.example.turtle;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import static java.lang.Math.*;

public class Fractal
{
    int recurseTime;

    public Fractal(int recurseTime) {
        this.recurseTime = recurseTime;
        if(recurseTime < 0) {
            this.recurseTime = 1;
        }
    }

    public Scene Sierpinski(double length) {
        Group root = new Group();
        Scene scene = new Scene(root, length*(pow(2, recurseTime))+10, length*(pow(2, recurseTime)), Color.BLACK);

        Turtle turt = new Turtle(5, length*(pow(2, recurseTime))-5, 0, Color.WHITE);

        Group a = new Group();
        Group b =  new Group();
        Group c = new Group();

        setTriangles(a, b, c, turt, length);
        //Sierpinski(root, a, b, c, length);

        SierpinskiRecursion(root, a, b, c, turt, length, 1);

        return scene;
    }

    private void SierpinskiRecursion(Group root, Group a, Group b, Group c, Turtle turt, double length, int initialTimer) {
        Group d = new Group();

        Sierpinski(d, a, b, c, length);

        Group e = cloneLinesFromGroup(d);
        Group f = cloneLinesFromGroup(d);

        if(initialTimer < recurseTime) {
            SierpinskiRecursion(root, d, e, f, turt, length*2, initialTimer+1);
        }

        root.getChildren().add(d);
    }

    private void Sierpinski(Group root, Group a, Group b, Group c, double length) {
        for(int i = 0; i <= a.getChildren().size()-1; i = i) {
            root.getChildren().add(a.getChildren().remove(i));
        }
        for(int i = 0; i <= b.getChildren().size()-1; i = i) {
            Node n = b.getChildren().remove(i);
            n.setLayoutX(n.getLayoutX()+length);
            root.getChildren().add(n);
        }
        for(int i = 0; i <= c.getChildren().size()-1; i = i) {
            Node n = c.getChildren().remove(i);
            n.setLayoutX(n.getLayoutX()+length/2);
            n.setLayoutY((n.getLayoutY()-length*sin(toRadians(60))));
            root.getChildren().add(n);
        }
    }

    private Group cloneLinesFromGroup(Group root) {
        Group target = new Group();
        for(Node n : root.getChildren()) {
            if(n instanceof Line) {
                Line l = new Line(((Line) n).getStartX(), ((Line) n).getStartY(), ((Line) n).getEndX(), ((Line) n).getEndY());
                l.setStroke(((Line) n).getStroke());
                l.setLayoutX(n.getLayoutX());
                l.setLayoutY(n.getLayoutY());
                target.getChildren().add(l);
            }
        }
        return target;
    }


    private void setTriangles(Group a, Group b, Group c, Turtle turt, double length) {
        turt.drawTriangle(a, length);
        turt.drawTriangle(b, length);
        turt.drawTriangle(c, length);
    }


    public Scene KochCurve(double length) {
        Group root = new Group();
        Scene scene = new Scene(root, 700, 600, Color.BLACK);

        Turtle turt = new Turtle(50, 400, 0, Color.WHITE);

        KochCurveRecursion(root, turt, length, 1);
        KochCurveDrawSpike(root, turt, length/recurseTime);

        return scene;
    }

    private void KochCurveRecursion(Group root, Turtle turt, double length, int initialTimer) {
        if(initialTimer < recurseTime) {
            KochCurveRecursion(root, turt, length, initialTimer+1);
        }
        KochCurveDrawSpike(root, turt, length/recurseTime);
        turt.turnLeft(60);

        if(initialTimer < recurseTime) {
            KochCurveRecursion(root, turt, length, initialTimer+1);
        }
        KochCurveDrawSpike(root, turt, length/recurseTime);
        turt.turnRight(120);

       if(initialTimer < recurseTime) {
            KochCurveRecursion(root, turt, length, initialTimer+1);
        }
        KochCurveDrawSpike(root, turt, length/recurseTime);
        turt.turnLeft(60);

        if(initialTimer < recurseTime) {
            KochCurveRecursion(root, turt, length, initialTimer+1);
        }
    }

    private void KochCurveDrawSpike(Group root, Turtle turt, double length) {
        turt.drawLine(root, length);
        turt.turnLeft(60);
        turt.drawLine(root, length);
        turt.turnRight(120);
        turt.drawLine(root, length);
        turt.turnLeft(60);
        turt.drawLine(root, length);
    }

    public Scene FractalTree(double length) {
        Group root = new Group();
        Scene scene = new Scene(root, 600, 600, Color.BLACK);

        Turtle turt = new Turtle(300, 550, 90, Color.WHITE);

        FractalTree(root, turt, length, 1);

        return scene;
    }

    private void FractalTree(Group root, Turtle turt, double length, int initialTimer) {

        FractalTreeDrawBranch(root, turt, length, initialTimer);
        if(initialTimer < recurseTime) {
            turt.turnLeft(30);
            FractalTree(root, turt, length, initialTimer+1);
            turt.backStep((length/(initialTimer+1))*2);
        }
        if(initialTimer < recurseTime) {
            turt.turnRight(60);
            FractalTree(root, turt, length, initialTimer+1);
            turt.backStep((length/(initialTimer+1))*2);
            turt.turnLeft(30);
        }
    }

    private void FractalTreeDrawBranch(Group root, Turtle turt, double length, int initialTimer) {
        turt.drawLine(root, ((length/initialTimer)*2));
        turt.turnLeft(30);
        turt.drawLine(root,(length/initialTimer));
        turt.backStep(length/initialTimer);
        turt.turnRight(60);
        turt.drawLine(root, (length/initialTimer));
        turt.backStep(length/initialTimer);
        turt.turnLeft(30);
        //turt.backStep((length/initialTimer)*2);
    }

    public static Scene Hi() {
        Group root = new Group();
        Scene scene = new Scene(root, 600, 600, Color.BLACK);

        Turtle iortle = new Turtle(250, 250, 0, Color.WHITE);

        iortle.turnRight(90);
        iortle.drawLine(root,50);
        iortle.backStep(25);
        iortle.turnLeft(90);
        iortle.drawLine(root, 25);
        iortle.turnRight(90);
        iortle.backStep(25);
        iortle.drawLine(root, 50);
        iortle.turnLeft(90);
        iortle.step(25);
        iortle.turnLeft(90);
        iortle.drawLine(root, 50);

        return scene;
    }
}
