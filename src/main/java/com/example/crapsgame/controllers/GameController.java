package com.example.crapsgame.controllers;

import com.example.crapsgame.models.Dice;
import com.example.crapsgame.models.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert;

public class GameController {

    @FXML
    private Label nicknameLabel;

    @FXML
    private Label rollScoreLabel;

    @FXML
    private Label dieScoreLabel;

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

    private int dieScore = 0;
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
        this.rollScoreLabel.setText(String.valueOf(rollScore));
        this.dieScoreLabel.setText(String.valueOf(dieScore));
        this.gamesWonLabel.setText(String.valueOf(gamesWon));
        this.gamesLostLabel.setText(String.valueOf(gamesLost));
    }

    @FXML
    private void onInstructionsClick() {
        String mensaje = """
        Cómo jugar:
        
        - Haz click en el botón ubicado en la parte inferior izquierda "JUGAR"
        
        - Si en tu primer lanzamiento de dados sacas un 7 u 11, ganas automáticamente el juego
        
        - En caso de que obtengas un 2, 3 o 12, es un "Craps", significa que habrás perdido el juego
        
        - Cualquier otro número (4, 5, 6, 8, 9, 10) establece el "punto". El "punto" implicaría que debes repetir el mismo numero
        para ganar, pero si obtienes un 7 pierdes.
        
        - En caso de sacar un "punto" diferente del anterior (el numero 11 se transformaría en "punto") 
        debes sacar el actual, pero si obtienes un 7 después de un punto pierdes


        ¡Buena suerte y diviértete! ;)
        """;

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Instrucciones");
        alert.setHeaderText("CrapsGame");
        alert.setContentText(mensaje);
        alert.getDialogPane().setPrefWidth(480);
        alert.showAndWait();
    }
}
