/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team1project;

/**
 *
 * @author nir5113
 */
public class Messages {
    //# Demo ID 14
    String shipHitMessage = " ";
    String oponentShipHitMessage = " ";
    Ship ship;

    Messages() {

    }
    public String getOpponentHitMessage(){
        oponentShipHitMessage = "You hit the opponent ship";
        return oponentShipHitMessage;
    }

    public String getHitMessage() {
        shipHitMessage = "Your ship was hit";
        return shipHitMessage;
    }
    

    public String displayShiphitMessage() {
        if (ship.getShipType() == 5) {
            shipHitMessage = getCarrierHitMessage();
        } else if (ship.getShipType() == 4) {
            shipHitMessage = getBattleshipHitMessage();
        } else if (ship.getShipType() == 3) {
            shipHitMessage = getCruiserHitMessage();
        } else if (ship.getShipType() == 2) {
            shipHitMessage = getSubmarineHitMessage();
        } else if (ship.getShipType() == 1) {
            shipHitMessage = getDestroyerHitMessage();
        }
        return shipHitMessage;
    }

    public String getCarrierHitMessage() {
        String Message = "Your Carrier was hit!";
        return Message;
    }

    public String getBattleshipHitMessage() {
        String Message = "Your Battleship  was hit!";
        return Message;
    }

    public String getCruiserHitMessage() {
        String Message = "Your Cruiser  was hit!";
        return Message;
    }

    public String getSubmarineHitMessage() {
        String Message = "Your Submarine  was hit!";
        return Message;
    }

    public String getDestroyerHitMessage() {
        String Message = "Your Destroyer  was hit!";
        return Message;
    }

}
