package com.example.iarecursion;

import java.util.ArrayList;
import java.util.Random;

public class Questions {
    private int number;
    private int answer;
    private int result = 1;

    public Questions() {
        // Generate a random number between 2 and 8
        Random rand = new Random();
        this.number = rand.nextInt(7) + 2;

        // Calculate the answer
        this.answer = factorial(this.number);
    }

    public int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }

    public String askQuestion() {
        String question = ("What is " + this.number + "! ?");
        return question;
    }
    ArrayList<String> answerString= new ArrayList();
    public ArrayList<String> printAnswer(){
        answerString.add("Solution: ");
        factorialStepByStep(this.number);
        return answerString;
    }

    private void factorialStepByStep(int n) {
        if (n == 0) {
            answerString.add("Factorial(0) = 1 ");
            answerString.add("Final answer is: " + result);
        } else {
            result = result * n;
            answerString.add("Factorial(" + n + ") = " + result + " * Factorial(" + (n-1) + ")");
            factorialStepByStep(n-1);
        }
    }
}
