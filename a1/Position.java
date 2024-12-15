package org.uob.a1;

public class Position {
   int x;
   int y;


   public Position(int x, int y){
        this.x = x;
        this.y = y;
   }
   // to update the position of a user
   public void setPosition(int newX, int newY){
        this.x = newX;
        this.y = newY;

   }

   // Getter methods for x and y positions
   public int getX(){
        return x;
   }

   public int getY(){
    return y;
   }


}