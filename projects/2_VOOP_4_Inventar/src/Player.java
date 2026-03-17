//import com.sun.media.jfxmedia.events.PlayerStateEvent;
import greenfoot.*;

import java.util.List;

/**
 * @author SAE
 * @version 3.0
 */
public class Player extends Character {

    //Attribute
    //TODO: 1) Attribut vom Typ InventoryVisualizer deklarieren mit dem Namen vizualizer
    private final Item[] inventory;
    private int gold;
    private World currentWorld;

    //Konstruktoren
    //default
    public Player() {
        super(100);
        this.inventory = new Item[8];
        this.gold = 0;

    }

    public Player(int invSize, int gold, int life) {
        super(life);
        this.inventory = new Item[invSize];
        this.gold = gold;
    }




    //Methoden
    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void addedToWorld(World thisWorld){
        this.currentWorld = thisWorld;
        InventoryVisualizer visualizer = new InventoryVisualizer(this.inventory, this);
        currentWorld.addObject(visualizer, 0, thisWorld.getHeight()-1);
        //TODO: 2) Erstellen Sie neues Objekt vom Typ InventoryVisualizer und übergeben die Karotten als das zu visualisierende Inventar.
        //TODO: 3) Plazieren Sie das Objekt vom Type InventoryVisualizer in der Welt (0, Höhe der Welt -1) => unten links


    }


    /**
     * Wird einmal pro Zeiteinheit aufgerufen
     */
    public void act() {
        performMovement();
        selectSlot();
        moveItem();
        interactMerchant();
        if (Greenfoot.isKeyDown("F")) {
            pickSlot();
        }

        if (Greenfoot.isKeyDown("R")) {
            putSlot();
        }

        if (Greenfoot.isKeyDown("U")) {
            useItem();
            System.out.println("heal");
        }

        if(Greenfoot.isKeyDown("F1")) {
            debug();
        }

    }
    public void selectSlot() {
        String lastKey = Greenfoot.getKey();
        for(int i = 0; i < inventory.length+1; i++) {
            if(lastKey != null  && lastKey.equals(String.valueOf(i))) {
                if(i == 0) {
                    setSelectedSlot(9);
                    return;
                }
                setSelectedSlot(i-1);
                return;
            }
        }
    }

    public void moveItem() {
        if(!Greenfoot.isKeyDown("CONTROL") || getSelectedSlot() > inventory.length || inventory[getSelectedSlot()] == null) {
            return;
        }
        int slot = 0;
        boolean check = false;
        for(int i = 0; i < inventory.length+1; i++) {
            if(Greenfoot.isKeyDown(String.valueOf(i))) {
                if(i == 0) {
                    if(inventory.length < 10) {
                        break;
                    }
                    slot = 9;
                    check = true;
                    break;
                }
                check = true;
                slot = i-1;
                break;
            }
        }

        if(!check) {
            return;
        }
        if(inventory[getSelectedSlot()] == null) {
            inventory[getSelectedSlot()] = inventory[slot];
            inventory[slot] = null;
            return;
        }
        Item objToAdd = inventory[getSelectedSlot()];
        inventory[getSelectedSlot()] = inventory[slot];
        inventory[slot] = objToAdd;

    }

    public void pickSlot() {
        if(getSelectedSlot() > inventory.length || !isTouching(Item.class)) {
            return;
        }
        List<Item> objs = getWorld().getObjectsAt(getX(), getY(), Item.class);
        if(!objs.isEmpty()){
            Item obj = objs.get(0);
            if(inventory[getSelectedSlot()]==null){
                inventory[getSelectedSlot()]=obj.onPick(this);;
                return;  //beendet die gesamte Methode
            }
            // slot not empty
            //putSlot();

            Item objToAdd = inventory[getSelectedSlot()];
            inventory[getSelectedSlot()]=obj.onPick(this);;
            objToAdd.put(getX(),getY(), getWorld());
        }
    }
    public void putSlot() {
        if(getSelectedSlot() > inventory.length) {
            return;
        }
        if(inventory[getSelectedSlot()] != null) {
            Item objToAdd = inventory[getSelectedSlot()];
            inventory[getSelectedSlot()] = null;
            objToAdd.put(getX(),getY(), getWorld());
        }
    }
    public void useItem() {
        if(getSelectedSlot() > inventory.length) {
            return;
        }
        if(inventory[getSelectedSlot()] != null) {
            inventory[getSelectedSlot()] = inventory[getSelectedSlot()].onUse(this);
        }
    }


    /**
     * W - A - S - D movement
     */
    private void performMovement() {
        if (Greenfoot.isKeyDown("W")) {
            turn(Direction.NORTH);
            move(1);
        } else if (Greenfoot.isKeyDown("S")) {
            turn(Direction.SOUTH);
            move(1);
        } else if (Greenfoot.isKeyDown("A")) {
            turn(Direction.WEST);
            move(1);
        } else if (Greenfoot.isKeyDown("D")) {
            turn(Direction.EAST);
            move(1);
        }

    }

    public void interactMerchant() {
        if (!isTouching(Merchant.class)) {
            return;
        }
        draw(getGold());
        List<Merchant> merchants = currentWorld.getObjectsAt(getX(),getY(), Merchant.class);
        Merchant merchant = merchants.get(0);
        if(Greenfoot.isKeyDown("E")) {
            merchant.setSelectedSlot(merchant.getSelectedSlot()+1);
        }
        if(Greenfoot.isKeyDown("Q")) {
            merchant.setSelectedSlot(merchant.getSelectedSlot()-1);
        }
        if(Greenfoot.isKeyDown("SPACE")) {
            buyItem();
        }
        if(Greenfoot.isKeyDown("TAB")) {
            sellItem();
        }
    }
    public void buyItem() {
        if (!isTouching(Merchant.class)) {
            return;
        }

        List<Merchant> merchants = currentWorld.getObjectsAt(getX(),getY(), Merchant.class);
        Merchant merchant = merchants.get(0);
        Item item = merchant.getCurrentItem();
        if (item == null || getGold() < item.getValue()) {
            //no item selected or not enough money
            System.out.println("cannot buy");
            return;
        }
        if(inventory[getSelectedSlot()]==null){
            inventory[getSelectedSlot()]=item;
        } else {
            // slot not empty
            Item objToAdd = inventory[getSelectedSlot()];
            inventory[getSelectedSlot()] = item;
            getWorld().addObject(objToAdd, getX(), getY());
        }
        setGold(getGold()-item.getValue()); //remove the money
        merchant.buyItem(merchant.getSelectedSlot());  //one item per slot
    }
    public void sellItem() {
        if (!isTouching(Merchant.class) || inventory[getSelectedSlot()] == null) {
            return;
        }
        setGold(getGold() + inventory[getSelectedSlot()].getValue());
        inventory[getSelectedSlot()] = null;
    }



    public void debug() {
        System.out.printf("Life: %d \n", getLife());
        System.out.printf("Gold: %d \n", getGold());
    }
}
