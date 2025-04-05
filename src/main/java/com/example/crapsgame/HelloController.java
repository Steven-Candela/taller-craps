package com.example.crapsgame;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private Label rollScoreLabel;

    @FXML
    private Label dieScoreLabel;

    @FXML
    private Label gamesWonLabel;

    @FXML
    private Label gamesLostLabel;

    private int rollScore = 0;
    private int dieScore = 0;
    private int gamesWon = 0;
    private int gamesLost = 0;

    @FXML
    protected void onHelloButtonClick() {

        rollScore++;

        if (rollScore == 1) {
            dieScore = 8;
        } else if (rollScore == 2) {
            gamesWon++;
        } else if (rollScore == 3) {
            gamesLost++;
            rollScore = 0;
            dieScore = 0;
        }

        rollScoreLabel.setText(String.valueOf(rollScore));
        dieScoreLabel.setText(String.valueOf(dieScore));
        gamesWonLabel.setText(String.valueOf(gamesWon));
        gamesLostLabel.setText(String.valueOf(gamesLost));
    }
}
