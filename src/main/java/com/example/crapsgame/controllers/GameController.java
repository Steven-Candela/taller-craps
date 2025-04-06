package com.example.crapsgame.controllers;

import com.example.crapsgame.models.Dice;
import com.example.crapsgame.models.Game;
import com.example.crapsgame.models.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameController {

    @FXML
    private Label nicknameLabel;

    @FXML
    private Label rollScoreLabel;

    @FXML
    private Label pointLabel;

    @FXML
    private Label gamesWonLabel;

    @FXML
    private Label gamesLostLabel;

    @FXML
    private ImageView diceImageView1;

    @FXML
    private ImageView diceImageView2;

    private Player player;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void showNicknameLabel() {
        nicknameLabel.setText(player.getNickname());
    }

    private Game game = new Game();
    private int gamesWon = 0;
    private int gamesLost = 0;

    @FXML
    void onActionPlayButton(ActionEvent event) {
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();

        int rollScore = dice1.roll() + dice2.roll();

        this.diceImageView1.setImage(new Image(getClass().getResourceAsStream(
                dice1.getDiceImagePath()
        )));
        this.diceImageView2.setImage(new Image(getClass().getResourceAsStream(
                dice2.getDiceImagePath()
        )));

        Game.GameStatus result = game.play(rollScore);

        if (result == Game.GameStatus.WIN){
            gamesWon++;
        } else if (result == Game.GameStatus.LOSE){
            gamesLost++;
        }

        if (game.isFirstRoll()) {
            this.pointLabel.setText("-");
        } else {
            this.pointLabel.setText(String.valueOf(game.getPoint()));
        }

        this.rollScoreLabel.setText(String.valueOf(rollScore));
        this.gamesWonLabel.setText(String.valueOf(gamesWon));
        this.gamesLostLabel.setText(String.valueOf(gamesLost));
    }
}

