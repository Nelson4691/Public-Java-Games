package team1project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 SID: 28: use to get and set player name and score
 */

/**
 *
 * @author Keval
 */
public class Person {

    private String pname;
    private int pscore;

    public Person(String pname, int pscore) {
        this.pname = pname;
        this.pscore = pscore;
    }

    public String getGender() {
        return pname;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String pname) {
        this.pname = pname;
    }

    public int getmoves() {
        return pscore;
    }

    /**
     * @param age the age to set
     */
    public void setmoves(int pscore) {
        this.pscore = pscore;
    }

    public String toString() {
        return this.pname + " " + this.pscore;
    }
}

