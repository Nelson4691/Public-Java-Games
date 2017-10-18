/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team1project;

import javafx.scene.Parent;

/**
 *
 * @author Andrew
 */
public class Ship extends Parent {
    

    public int type;//Variable for different Types of ships
    public boolean vertical = true; //Check to see if ship is vertical or not, to allow user to rotat ship.
    private int hp; //Variable for the health of a ship
    public String shipName = " ";
    public int hitCount = 1; 

    public Ship(int type, boolean vertical) {
        this.type = type;
        this.vertical = vertical;
        hp = type;
    }

    //This method decreases a ships hit points if they are hit. As of now this method does not return anything.
    public void hit() {
        hp--;
        hitCount = hitCount +1;
    }

    //This method check to see if a ship is still alive. As of right now this method does not return anything.   
    public boolean alive() {
        return hp > 0;
    }

    public int getShipType() {
        return type;
    }
    public void setShipName(){
        if(getShipType() ==5){
            shipName = "Carrier";
            
        }
        else if (getShipType() == 4){
            shipName = "Battleship";
        }
        else if (getShipType() == 3){
            shipName = "Cruiser";
        }
        else if (getShipType() == 2){
            shipName = "Submarine";
        }
        else if (getShipType() == 1){
            shipName = "Destroyer";
        }
        System.out.println(shipName+ " Placed");
    }
    public void displayShipStatus(){
        
        System.out.println(shipName + "Ship has been hit " + hitCount + " Times");
    }
    
}
