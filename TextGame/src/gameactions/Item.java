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
public class Item {
     

    private String name;
    private String descrip;

    public Item(String aName, String aDescrip) {
       
        this.name = aName;
        this.descrip = aDescrip;
    }

    // Getters and setters 
    
    public String getName() {
        return name;
    }

    public void setName(String aName) {
        this.name = aName;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String aDescrip) {
        this.descrip = aDescrip;
    }
}
