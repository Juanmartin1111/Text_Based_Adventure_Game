/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameactions;

/**
 *
 * @author juanm
 */
public class Treasure extends Item {

    private int number;

    public Treasure(String aName, String aDescrip, int aNumber) {
        super(aName, aDescrip); 
        this.number = aNumber;
    }

  
    public int getValue() {
        return number;
    }

}
