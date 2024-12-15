package org.uob.a1;

public class Score {

    private final int PUZZLE_VALUE = 10;
    private int startingScore;
    private int currentScore;
    private int roomsVisited;
    private int puzzlesSolved;
    private int hp;

    public Score(int startingScore) {
        this.startingScore = startingScore;
        this.currentScore = startingScore;
        this.roomsVisited = 0;
        this.puzzlesSolved = 0;
        this.hp = 100;
    }

    public void visitRoom() {
        roomsVisited++;
        updateScore();
    }

    public void solvePuzzle() {
        puzzlesSolved++;
        updateScore();
    }

    public int getScore() {
        return currentScore;
    }
    // used to update the score after each room visit or puzzle solved
    private void updateScore() {
        currentScore = startingScore - roomsVisited + (puzzlesSolved * PUZZLE_VALUE);
    }

    public void displayScore() {
        System.out.println("\nCurrent Score: " + getScore());
        System.out.println("Current HP: " + hp);
    }

    public void loseHP(int damage) {
        hp -= damage;
    }

    public void loseScore(int score) {
        currentScore -= score;
    }

    public int getHP() {
        return hp;
    }
    // those 2 getters are for after the player wins, for stats
    public int getRoomsVisited() {
        return roomsVisited;
    }

    public int getPuzzlesSolved() {
        return puzzlesSolved;
    }
}