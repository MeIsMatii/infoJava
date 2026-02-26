import greenfoot.*;

import java.util.List;

/**
 * @author SAE
 * @version 3.0
 */
public class Player extends MovingActor {
    
    //Attribute    
    //TODO: 1) Attribut vom Typ InventoryVisualizer deklarieren mit dem Namen vizualizer
    private final Carrot[] carrots = new Carrot[8];



    //Konstruktoren
    
    //Methoden
    public void addedToWorld(World world){
        //TODO: 2) Erstellen Sie neues Objekt vom Typ InventoryVisualizer und übergeben die Karotten als das zu visualisierende Inventar.
        //TODO: 3) Plazieren Sie das Objekt vom Type InventoryVisualizer in der Welt (0, Höhe der Welt -1) => unten links


    }
       
    
    /**
     * Wird einmal pro Zeiteinheit aufgerufen
     */
    public void act() {
        performMovement();    

        if (Greenfoot.isKeyDown("E")) {
            pick();
        }
        
        if (Greenfoot.isKeyDown("R")) {
            put();
        }
    }
    
    
    private void pick(){
        List<Carrot> objs = getWorld().getObjectsAt(getX(), getY(), Carrot.class);
        
        if(!objs.isEmpty()){
            for(int i = 0; i< carrots.length; i++){
                if(carrots[i]==null){
                    Carrot obj = objs.get(0);
                    carrots[i]=obj;
                    getWorld().removeObject(obj);
                    return;  //beendet die gesamte Methode
                }
            }   
        }
    }
    
    private void put(){       
        for(int i = 0; i< carrots.length; i++){
            if(carrots[i]!=null){
                getWorld().addObject(carrots[i], getX(), getY());
                carrots[i]=null;
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
