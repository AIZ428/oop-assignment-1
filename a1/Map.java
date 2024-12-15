package org.uob.a1;

public class Map {

    private int width;
    private int height;
    private char[][] grid; // used word grid to avoid any confusions if i use map
    final private char EMPTY = '.';


    public Map(int width, int height){
        this.width = width;
        this.height = height;
        grid = new char[width][height];

        // filling the entire map with . characters
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                grid[i][j] = EMPTY;
            }
        }
    }
    // to place a room in the map 
    public void placeRoom(Position pos, char symbol){

        int x = pos.getX();
        int y = pos.getY();

        if(x >= width || y >= height || x < 0 || y < 0){
            System.out.println(" Position is out of grid width/height.");
        } else {
            grid[y][x] = symbol;
        }


    }
    public String display(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                sb.append(grid[i][j]);
            }
            sb.append('\n'); // return character
        }
        return sb.toString();
    }

   

}