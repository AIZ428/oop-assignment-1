package org.uob.a1;

public class Room {
    private String name;
    private String description;
    private char symbol;
    private Position position;
    private boolean hasPuzzleBeenSolved;
    private String puzzle;
    // note : used arrays so that some rooms may have more than 1 feature/required item/ trap etc
    private String[] requiredItems;
    private String[] features;
    private boolean[] isTrap;
    private String[] featureDesc;
    private String itemFound;
    String afterWin; // interactive message after user wins the puzzle


    public Room(String name, String description, char symbol, Position position) {
        this.name = name;
        this.description = description;
        this.symbol = symbol;
        this.position = position;
    }
    // setters
    public void setFeatures(String[] features) {
        this.features = features;
    }

    public void setFeatureDesc(String[] featureDesc) {
        this.featureDesc = featureDesc;
    }

    public void setRequiredItems(String[] requiredItems) {
        this.requiredItems = requiredItems;
    }

    public void setItemFound(String itemFound) {
        this.itemFound = itemFound;
    }

    public void setIsTrap(boolean[] isTrap) {
        this.isTrap = isTrap;
    }

    public void setPuzzle(String puzzle) {
        this.puzzle = puzzle;
    }

    public void setAfterWin(String afterWin) {
        this.afterWin = afterWin;
    }
    // getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public char getSymbol() {
        return symbol;
    }

    public Position getPosition() {
        return position;
    }
    public boolean isPuzzleSolved() {
        return hasPuzzleBeenSolved;
    }
    // to set the puzzle as solved and change the boolean value
    public void solvePuzzle() {
        this.hasPuzzleBeenSolved = true;
    }
    
    public String[] getFeatures() {
        return features;
    }

    public String getPuzzle() {
        return puzzle;
    }

    public String getFoundItem(){
        return itemFound;
    }

    public String getRequiredItem(int index) {
        return requiredItems[index];
    }

    public boolean isTrap(int index) {
        return isTrap[index];
    }

    public String getFeatureDesc(int index) {
        return featureDesc[index];
    }


    public String getAfterWin() {
        return afterWin;
    }


}