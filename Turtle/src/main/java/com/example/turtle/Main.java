package com.example.turtle;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Io'sTurtle");
        Fractal f  = new Fractal(6);
        //Scene scene = f.Sierpinski(5);
        //Scene scene = f.KochCurve(10);
        Scene scene = f.FractalTree(40);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
