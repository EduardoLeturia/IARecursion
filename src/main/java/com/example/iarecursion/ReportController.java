package com.example.iarecursion;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ReportController {

    @FXML
    private Label correctLabel;

    @FXML
    private Label incorrectLabel;

    private int correctCount = 0;

    private int incorrectCount = 0;

    public void updateReport(boolean isCorrect) {
        if (isCorrect) {
            correctCount++;
        } else {
            incorrectCount++;
        }
        correctLabel.setText("Correct: " + correctCount);
        incorrectLabel.setText("Incorrect: " + incorrectCount);
    }

}
