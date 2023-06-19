package com.example.iarecursion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class PracticeController{

    public TextArea questionTextArea;
    public TextArea workingTextArea;
    public TextArea solutionTextArea;
    public CheckBox factCheckBox;
    Questions myQuestion = new Questions();
    RecursiveQuestion reQuestion = new RecursiveQuestion();

    public void initialize(){



    }

    public void finalSolutionButtonAction(ActionEvent actionEvent) {
        if (factCheckBox.isSelected()){
                solutionTextArea.appendText("\n");
                solutionTextArea.appendText(reQuestion.allLinesString);
        }
        else{
            for (String s:myQuestion.printAnswer()
            ) {
                solutionTextArea.appendText("\n");
                solutionTextArea.appendText(s);
            }
        }


        /**
        if (userAnswer == this.answer) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect.");
        }
         **/
    }

    @FXML
    private Label hintLabel;

    private Questions questions = new Questions();
    private ArrayList<String> answerSteps = questions.printAnswer();
    private int hintIndex = 0;


    @FXML
    public void hintButtonAction(ActionEvent actionEvent) {
        if (hintIndex < answerSteps.size()) {
            hintLabel.setText(answerSteps.get(hintIndex));
            hintIndex++;
        } else {
            hintLabel.setText("No more hints available.");
        }
    }


    public void generateQuestionButtonAction(ActionEvent actionEvent) {

        if (factCheckBox.isSelected()) {

            RecursiveQuestion reQuestion = new RecursiveQuestion();
            questionTextArea.setText(reQuestion.askRecursiveQuestion());
            solutionTextArea.clear();
            questionTextArea.setText(reQuestion.askRecursiveQuestion());
        }
        else {
            questionTextArea.setText(myQuestion.askQuestion());
            myQuestion = new Questions();
            solutionTextArea.clear();
            questionTextArea.setText(myQuestion.askQuestion());

        }

    }
}

