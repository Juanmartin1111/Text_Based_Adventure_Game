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
public class OnePlayer extends KeepItem {

    private Room room; 

    public OnePlayer(String aName, String aDescrip, ItemList tl, Room aRoom) {
        super(aName, aDescrip, tl); 
        this.room = aRoom;
    }

    public void setRoom(Room aRoom) {
        this.room = aRoom;
    }

    public Room getRoom() {
        return this.room;
    }
}
