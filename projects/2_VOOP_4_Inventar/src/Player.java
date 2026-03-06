import com.sun.media.jfxmedia.events.PlayerStateEvent;
import greenfoot.*;

import java.util.List;

/**
 * @author SAE
 * @version 3.0
 */
public class Player extends MovingActor {

    //Attribute
    //TODO: 1) Attribut vom Typ InventoryVisualizer deklarieren mit dem Namen vizualizer
    private final Item[] inventory = new Item[8];
    private final InventoryVisualizer visualizer = new InventoryVisualizer(this.inventory);
    private int currentSlot = 0;


 
    //Konstruktoren

    //Methoden
    public void addedToWorld(World thisWorld){
        thisWorld.addObject(this.visualizer, 0, thisWorld.getHeight()-1);
        //TODO: 2) Erstellen Sie neues Objekt vom Typ InventoryVisualizer und übergeben die Karotten als das zu visualisierende Inventar.
        //TODO: 3) Plazieren Sie das Objekt vom Type InventoryVisualizer in der Welt (0, Höhe der Welt -1) => unten links


    }


    /**
     * Wird einmal pro Zeiteinheit aufgerufen
     */
    public void act() {
        performMovement();
        selectSlot();
        if (Greenfoot.isKeyDown("E")) {
            pickSlot();
        }

        if (Greenfoot.isKeyDown("R")) {
            putSlot();
        }
    }
    private void selectSlot() {
        String lastKey = Greenfoot.getKey();
        for(int i = 0; i < inventory.length; i++) {
            if(lastKey != null  && lastKey.equals(String.valueOf(i))) {
                if(i == 0) {
                    currentSlot = 9;
                }
                currentSlot = i -1;
                return;
            }
        }
    }
    private void pickSlot() {
        List<Item> objs = getWorld().getObjectsAt(getX(), getY(), Item.class);
        if(currentSlot > inventory.length) {
            return;
        }
        if(!objs.isEmpty()){
            Item obj = objs.get(0);
            if(inventory[currentSlot]==null){
                inventory[currentSlot]=obj;
                getWorld().removeObject(obj);
                return;  //beendet die gesamte Methode
            }
            // slot not empty
            Item objToAdd = inventory[currentSlot];
            inventory[currentSlot]=null;
            inventory[currentSlot]=obj;
            getWorld().removeObject(obj);
            getWorld().addObject(objToAdd, getX(), getY());
        }
    }
    private void putSlot() {
        if(currentSlot > inventory.length) {
            return;
        }
        if(inventory[currentSlot] != null) {
            Item objToAdd = inventory[currentSlot];
            inventory[currentSlot] = null;
            getWorld().addObject(objToAdd, getX(), getY());
        }
    }

    private void pick(){
        List<Item> objs = getWorld().getObjectsAt(getX(), getY(), Item.class);

        if(!objs.isEmpty()){
            for(int i = 0; i< inventory.length; i++){
                if(inventory[i]==null){
                    Item obj = objs.get(0);
                    inventory[i]=obj;
                    getWorld().removeObject(obj);
                    return;  //beendet die gesamte Methode
                }
            }
        }
    }

    private void put(){
        for(int i = 0; i< inventory.length; i++){
            if(inventory[i]!=null){
                getWorld().addObject(inventory[i], getX(), getY());
                inventory[i]=null;
                return; //beendet die gesamte Methode
            }
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


}
