/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameactions;

import java.util.ArrayList;

/**
 *
 * @author juanm
 */
public class ItemList extends ArrayList<Item> {

    public String itemDescrip() {
        String s = "";
        if (this.isEmpty()) {
            s = "None.\n";
        } else {
            for (Item t : this) {
                s = s + t.getName() + ": " + t.getDescrip() + "\n";
            }
        }
        return s;
    }

    public Item newItem(String aName) {
        Item aitem = null;
        String itemName = " ";
        String itemLowCase = aName.trim().toLowerCase();
        for (Item t : this) {
            itemName = t.getName().trim().toLowerCase();
            if (itemName.equals(itemLowCase)) {
                aitem = t;
            }
        }
        return aitem;
    }
}
