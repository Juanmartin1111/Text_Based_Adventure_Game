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
public class Room extends KeepItem {

    private int n, s, w, e;

    public Room(String aName, String aDescrip, int aN, int aS, int aW, int aE,
            ItemList tl) {
        super(aName, aDescrip, tl); 
        this.n = aN;
        this.s = aS;
        this.w = aW;
        this.e = aE;
    }

    // Getters and setters
    
    public int getN() {
        return n;
    }

    public void setN(int aN) {
        this.n = aN;
    }

    public int getS() {
        return s;
    }

    public void setS(int aS) {
        this.s = aS;
    }

    public int getE() {
        return e;
    }

    public void setE(int aE) {
        this.e = aE;
    }

    public int getW() {
        return w;
    }

    void setW(int aW) {
        this.w = aW;
    }

    public String describe() {
        return String.format("%s. %s.",
                getName(), getDescrip())
                + "\n - Items in this room:\n" + getItems().itemDescrip();
    }
}
