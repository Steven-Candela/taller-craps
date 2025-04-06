package com.example.crapsgame.models;

public class Game {

    public enum GameStatus {
        WIN, LOSE, CONTINUE
    }

    private boolean isFirstRoll = true;
    private int point = 0;

    public GameStatus play(int rollSum) {
        if (isFirstRoll) {
            switch (rollSum) {
                case 7:
                case 11:
                    return GameStatus.WIN;
                case 2:
                case 3:
                case 12:
                    return GameStatus.LOSE;
                default:
                    point = rollSum;
                    isFirstRoll = false;
                    return GameStatus.CONTINUE;
            }
        } else {
            if (rollSum == point) {
                resetGame();
                return GameStatus.WIN;
            } else if (rollSum == 7) {
                resetGame();
                return GameStatus.LOSE;
            } else {
                return GameStatus.CONTINUE;
            }
        }
    }

    public void resetGame() {
        isFirstRoll = true;
        point = 0;
    }

    public int getPoint() {
        return point;
    }

    public boolean isFirstRoll() {
        return isFirstRoll;
    }
}