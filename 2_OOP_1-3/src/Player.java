import greenfoot.*;

import java.util.List;


public class Player extends MovingActor {
    //Attribute

    private int life;
    private Carrot[] carrotInventory = new Carrot[30];
    public int x;
    public int y;
    public World currentWorld;
    
    //Konstruktoren
    public Player(){
        setLife(100);
        for(int i = 0; i < 20; i++) {
            Carrot carrot = new Carrot(3);
            setCarrotInSlot(carrot, getCarrotAmount());
        }

    }
    public Player(int life, int carrotAmount){
        setLife(life);
        for(int i = 0; i < carrotAmount; i++) {
            Carrot carrot = new Carrot(3);
            setCarrotInSlot(carrot, getCarrotAmount());
        }

    }


    //Methoden
    //getter/setter
    public void setCarrotInSlot(Carrot newCarrot, int slot) {
        if(slot >= 0 && slot < carrotInventory.length) {
            carrotInventory[slot] = newCarrot;
        }

    }

    public Carrot[] getCarrotInventory() {
        return carrotInventory;
    }
    public int getCarrotAmount() {
        for(int slotNum = carrotInventory.length-1; slotNum >= 0; slotNum--) {
            if (carrotInventory[slotNum] != null) {
                return slotNum +1;
            }
        }
        return 0;
    }
    public Carrot getCarrotInSlot(int slot) {
        if (slot>=0 && slot <25) {
            return carrotInventory[slot];
        }
        return null;
    }


    public int getLife() {
        return life;
    }
    public void setLife(int newLife) {
        life = newLife;
        draw(life);
    }

    public void hit(int damage) {
        setLife(getLife()-damage);
        draw(getLife());
    }

    /**
     * Wird einmal pro Zeiteinheit aufgerufen
     */
    public void act() {
        performMovement();
        turnDirection();

        putCarrot();
        takeCarrot();
        eatCarrot();
        hitStone();
    }

    private void performMovement() {
        if (Greenfoot.isKeyDown("W")) {
            turn(Direction.NORTH);
            wallDamage();

        } else if (Greenfoot.isKeyDown("S")) {
            turn(Direction.SOUTH);
            wallDamage();

        } else if (Greenfoot.isKeyDown("A")) {
            turn(Direction.WEST);
            wallDamage();

        } else if (Greenfoot.isKeyDown("D")) {
            turn(Direction.EAST);
            wallDamage();

        }
        x = getX();
        y = getY();
    }


    private void turnDirection() {

        if (Greenfoot.isKeyDown("Up")) {
            turn(Direction.NORTH);

        } else if (Greenfoot.isKeyDown("Down")) {
            turn(Direction.SOUTH);

        } else if (Greenfoot.isKeyDown("Left")) {
            turn(Direction.WEST);

        } else if (Greenfoot.isKeyDown("Right")) {
            turn(Direction.EAST);

        }
    }
    public void putCarrot() {

        currentWorld = getWorld();

        if (Greenfoot.isKeyDown("R")) {

            System.out.println(getCarrotAmount());

            if (getCarrotAmount() > 0) {
                Carrot carrot = getCarrotInSlot(getCarrotAmount()-1);
                currentWorld.addObject(carrot, x, y);
                setCarrotInSlot(null,getCarrotAmount()-1);
            }
        }
    }
    public void takeCarrot() {
        currentWorld = getWorld();

        if (Greenfoot.isKeyDown("T")) {
            List<Carrot> carrots = currentWorld.getObjectsAt(x, y, Carrot.class);
            if(!carrots.isEmpty()) {
                Carrot carrot = carrots.get(0);
                setCarrotInSlot(carrot,getCarrotAmount());
                currentWorld.removeObject(carrot);
            }
        }
    }
    public void eatCarrot() {
        currentWorld = getWorld();

        if (Greenfoot.isKeyDown("Q")) {
            List<Carrot> carrots = currentWorld.getObjectsAt(x, y, Carrot.class);
            if(!carrots.isEmpty()) {
                Carrot carrot = carrots.get(0);
                currentWorld.removeObject(carrot);
                setLife(getLife() + carrot.getWeight());
            }
        }
    }

    public void hitStone() {
        currentWorld = getWorld();
        if (Greenfoot.isKeyDown("E")) {
            List<Rock> rocks = currentWorld.getObjectsAt(getNextX(1),getNextY(1), Rock.class);
            if(!rocks.isEmpty()) {
                Rock rock = rocks.get(0);
                rock.hit();
            }
        }
    }

    
     /**
     * moves one step forward
     */
    public void move() {
        move(1);
    }
    public void wallDamage() {
        if(canMove()) {
            move();
        } else {
            hit(10);
        }

    }

}
