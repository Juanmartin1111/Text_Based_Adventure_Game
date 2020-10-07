/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import gameactions.OnePlayer;
import gameactions.Room;
import gameactions.Item;
import gameactions.ItemList;
import gameactions.Treasure;

/**
 *
 * @author juanm
 */
public class TextGame {

    private ArrayList<Room> map;   
    private OnePlayer player; 

    List<String> actions = new ArrayList<>(Arrays.asList("pick", "drop", "look", "inventory", "n", "s", "w", "e", "save", "load"));
    
    List<String> items = new ArrayList<>(Arrays.asList("lantern", "banana", "bread", "knife", "bag", "necklace", "sword", "oldsword", "dagger", "shield", "poison", "head", "keys"));

    public TextGame() {
        this.map = new ArrayList<>();
        
        // Story
        
        ItemList castleEntrance = new ItemList();
        castleEntrance.add(new Treasure("lantern", "Useful for dark spaces", 1));

        ItemList livingRoom = new ItemList();
        

        ItemList kitchen = new ItemList();
        kitchen.add(new Treasure("banana", "Will help you when you get hungry.", 5));
        kitchen.add(new Treasure("bread", "Will help you when you get hungry.", 7));
        kitchen.add(new Treasure("knife", "Knife full of blood. Might be useful for later", 100));

        ItemList barberShop = new ItemList();
        barberShop.add(new Treasure("bag", "Seems like it has 2 gold coins and 500 silver coins.\n" 
                + " 'For reference a gold coin cost 500 silver coins' ", 1500));
        
        ItemList fightingColiseum = new ItemList();
        fightingColiseum.add(new Treasure("necklace", " Seems like a tooth necklace. might be a lucky charm", 10));
        fightingColiseum.add(new Treasure("oldsword", " It looks pretty rusty but can help you fight!!", 420));
        
        ItemList armorStorage = new ItemList();
        armorStorage.add(new Treasure("sword", "Brand new sharp sword. Good for long distance fights. Cost: 280 silver coins", 280));
        armorStorage.add(new Treasure("dagger", "Brand new dagger. Good for short distance fights.Cost: 200 silver coins", 200));
        armorStorage.add(new Treasure("shield", "Brand new shiled. Good to protect yourself. Cost: 220 silver coins", 220));
        armorStorage.add(new Treasure("poison", "Health poison. Can help you heal 100 times faster. Cost: 1000 silver coins or 2 gold coin", 1000));
        
        
        ItemList dungeon = new ItemList();
        dungeon.add(new Treasure("head", "Troll's head. Maybe you want to hang it on your wall later", 10));
        
        ItemList entranceOfHell = new ItemList();
        entranceOfHell.add(new Treasure("keys", "Keys from a treasure or maybe some handcuffs. Anyway we should take them just in case", 10));
        
        ItemList hell = new ItemList();
        
        
        ItemList unnamedRoom = new ItemList();
        unnamedRoom.add(new Treasure("princess", "Pick her up to save her", 10));

        ItemList playerlist = new ItemList();
        
        // Adding rooms to the map: It starts from N,S,W,E
        // -1 represents a block fro the plater
        
        map.add(new Room("Castle Entrance:\n", "Find your way to the princess. YOU GOT THIS", -1, -1, -1, 1, castleEntrance));
        map.add(new Room("Living Room:\n", "Dark room full of old furniture. Keep moving", 2, -1, 0, -1, livingRoom));
        map.add(new Room("Kitchen:\n", "Empty kitchen full of spider webs", -1, 1, -1, 3, kitchen));
        map.add(new Room("Barber Shop:\n", "Many barbers and dangerous people you don't know ", -1, 4, 2, -1, barberShop));
        map.add(new Room("Fighting Coliseum:\n", "The are gladiators fighting to death, You better stay away if you want to keep leaving 0_o", 3,5, -1, 6, fightingColiseum));
        map.add(new Room("Armor Storage:\n", "Wow, this room is full of equipment.\n "
                + "luckily we  found that bag full of money earlier.\n" 
                + "pick up everything you can!", 4, -1, -1, 7, armorStorage));
        map.add(new Room("Dungeon:\n", "Old and nasty cell full of trolls. Lets get out of here before they get mad", -1, 7, 4, -1, dungeon));
        map.add(new Room("Entrance of Hell:\n", "There are Two soldiers of death arouond the door.\n"
                + "I thing they are scared of the tooth necklace! 0_0 \n"
                + "Hope you have good equipment before you go through that door, if not, you better find the Armour storage.\n"
                + "Cannot believe they will let us pass!", 6, 8, 5, -1, entranceOfHell));
        map.add(new Room("Hell:\n", "HUGE ROOM!\n"
                + "There are many different types of monsters.\n"
                + "The Trolls head seems to prevent the trolls from getting closer but we got to do something with the other monsters.\n"
                + "Luckily we have enough equipment to get through this room.\n"
                + "MOVE FAST!!!", 7, -1, -1, 9, hell));
        map.add(new Room("The Unnamed Room...:\n", "You found your princess tied up with chains and handcuffs.\n"
                + "The key works perfetly in the handcuffs\n"
                + "Good job kid, I knew you could save her.", -1, -1, 8, -1, unnamedRoom));

        // Player starts from the first room
        player = new OnePlayer("juan", "player", playerlist, map.get(0));
    }

    // get and set methods fro map, player, pick and drop
    ArrayList getMap() {
        return map;
    }

    void setMap(ArrayList aMap) {
        map = aMap;
    }

    public OnePlayer getPlayer() {
        return player;
    }

    public void setPlayer(OnePlayer aPlayer) {
        player = aPlayer;
    }
    
    //////////////////////

    private void removeItem(Item t, ItemList fromlist, ItemList tolist) {
        fromlist.remove(t);
        tolist.add(t);
    }

    // pick up item 
    public String pickItem(String aname) {
        String retStr = "";
        Item t = player.getRoom().getItems().newItem(aname);
        if (aname.equals("")) {
            aname = "nameless object"; // if no object specified
        }
        if (t == null) {
            retStr = "Cannot find a what you are looking for";
        } else {
            removeItem(t, player.getRoom().getItems(), player.getItems());
            retStr = " You have a " + aname + " " + "now";
        }
        return retStr;
    }

    // drop item
    public String dropItem(String aname) {
        String retStr = null;
        Item t = player.getItems().newItem(aname);
        if (aname.equals("")) {
            retStr = "What item would you like to drop!"; 
        } else if (t == null) {
            retStr = "I dont know what you are talking about";
        } else {
            removeItem(t, player.getItems(), player.getRoom().getItems());
            retStr = aname + " dropped!";
        }
        return retStr;
    }

    
    void setPlayerRoom(OnePlayer p, Room aRoom) {
        p.setRoom(aRoom);
    }
    public enum Direction {
        NORTH, 
        SOUTH, 
        EAST, 
        WEST;
        
    };
    // assign the direction where the player will move
    
    int goingTo(OnePlayer aPlayer, Direction dir) {
        
        Room r = aPlayer.getRoom();
        int exit;

        switch (dir) {
            case NORTH:
                exit = r.getN();
                break;
            case SOUTH:
                exit = r.getS();
                break;
            case EAST:
                exit = r.getE();
                break;
            case WEST:
                exit = r.getW();
                break;
            default:
                exit = -1; 
                break;
        }
        if (exit != -1) {
            setPlayerRoom(aPlayer, map.get(exit));
        }
        return exit;
    }

    public int movePlayerTo(Direction dir) {
            
        return goingTo(player, dir);
    }

    private void goN() {
        roomDescrip(movePlayerTo(Direction.NORTH));
    }

    private void goS() {
        roomDescrip(movePlayerTo(Direction.SOUTH));
    }

    private void goW() {
        roomDescrip(movePlayerTo(Direction.WEST));
    }

    private void goE() {
        roomDescrip(movePlayerTo(Direction.EAST));
    }

    private void look() {
        showStr("Room: " + getPlayer().getRoom().describe());
    }

    private void showStr(String s) {
        System.out.println(s);
    }

    private void roomDescrip(int roomNumber) {
              
        String a;
        if (roomNumber == -1) {
            a = "Wall ";
        } else {
            Room r = getPlayer().getRoom();
            a = "Room: " + r.describe();
        }
        showStr(a);
    }

    private void showInventory() {
        showStr("You have a " + getPlayer().getItems().itemDescrip());
    }
   
    public String action(List<String> wordlist) {
        String act;
        String msg = "";
        act = wordlist.get(0);
        if (!actions.contains(act)) {
            msg = act + " does not exist ";
        } else {
            switch (act) {
                case "n":
                    goN();
                    break;
                case "s":
                    goS();
                    break;
                case "w":
                    goW();
                    break;
                case "e":
                    goE();
                    break;
                case "look":
                    look();
                    break;
                case "inventory":
                    showInventory();
                    break;               
                default:
                    msg = act + " does not exist ";
                    break;
            }
        }
        return msg;
    }

    public String pickAndDrop(List<String> wordlist) {
        String act;
        String pd;
        String msg = "";
        boolean error = false;
        act = wordlist.get(0);
        pd = wordlist.get(1);
        if (!actions.contains(act)) {
            msg = act + " does not exist  ";
            error = true;
        }
        if (!items.contains(pd)) {
            msg += ("Cannot find " + pd );
            error = true;
        }
        if (!error) {
            switch (act) {
                case "pick":
                    msg = pickItem(pd);
                    break;
                case "drop":
                    msg = dropItem(pd);
                    break;
                default:
                    msg += " Dont make things up o_o ";
                    break;
            }
        }
        return msg;
    }

    public String instructionCommand(List<String> wordlist) {
        String msg;
        switch (wordlist.size()) {
            case 1:
                msg = action(wordlist);
                break;
            case 2:
                msg = pickAndDrop(wordlist);
                break;
            default:
                msg = "One command at a time";
                break;
        }
        return msg;
    } 

    public List<String> wordList(String input) {
        String delimiters;
        delimiters = " \t,.:;!?\"'";
        List<String> strlist = new ArrayList<>();
        StringTokenizer token = new StringTokenizer(input, delimiters);
        String t;

        while (token.hasMoreTokens()) {
            t = token.nextToken();
            strlist.add(t);
        }
        return strlist;
    }

    public void Intro() {
        String s;
        s = "You are inside a castle looking to rescue the love of your life\n"
                + "A princess named Aurora.\n"
                + "You heard she is in the 'Unnamed Room'.\n"
                + "Good luck on your journey'.\n"
                + "You can type the following commands to interact with the game: \n"
                + "'pick', 'drop', 'look', 'inventory'.\n"
                + "I recommend you to pick up as many items as you can on your way.\n"
                + "Where would you like to go? n, s, w or e?\n"
                + "Press 'q' to quit at any time ";
        showStr(s);
        roomDescrip(0);
    }

    public String runCommand(String input) {
        List<String> wordlist;
        String s = "Until Next time";
        String lowCase = input.trim().toLowerCase();
        if (!lowCase.equals("q")) {
            if (lowCase.equals("")) {
                s = "Enter an action";
            } else {
                wordlist = wordList(lowCase);
                s = instructionCommand(wordlist);
            }
        }
        return s;
    }

}
