package org.example;

import java.util.ArrayList;
import java.util.Stack;

public class Staircase {
    public static int bottomUp(int steps) {
        int oneStep = 1;
        int twoStep = 1;
        int temp;
        for(int i = 0; i < steps; i++) {
            //temp = oneStep;
            oneStep += twoStep;
            twoStep = oneStep - twoStep;
        }
        return oneStep;
    }
}
