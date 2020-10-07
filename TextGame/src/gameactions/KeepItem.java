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
public class KeepItem extends Item {

    private ItemList items = new ItemList( );
    
    public KeepItem(String aName, String aDescrip, ItemList tl) {
        super(aName, aDescrip);
        items = tl;
    }

    
    public ItemList getItems() {
        return items;
    }
   
    public void setItems(ItemList items) {
        this.items = items;
    }
    
}
