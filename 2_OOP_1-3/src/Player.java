import greenfoot.*;

import java.util.List;
import java.util.Objects;


public class Player extends Character {
    //Attribute


    private Carrot[] carrotInventory = new Carrot[30];
    public int x;
    public int y;

    //Konstruktoren
    public Player() {
        setLife(100);
        for (int i = 0; i < 20; i++) {
            Carrot carrot = new Carrot(3);
            setCarrotInSlot(carrot, getCarrotAmount());
        }

    }

    public Player(int life, int carrotAmount) {
        setLife(life);
        for (int i = 0; i < carrotAmount; i++) {
            Carrot carrot = new Carrot(3);
            setCarrotInSlot(carrot, getCarrotAmount());
        }

    }


    //Methoden
    //getter/setter
    public void setCarrotInSlot(Carrot newCarrot, int slot) {
        if (slot >= 0 && slot < carrotInventory.length) {
            carrotInventory[slot] = newCarrot;
        }

    }

    public Carrot[] getCarrotInventory() {
        return carrotInventory;
    }

    public int getCarrotAmount() {
        for (int slotNum = carrotInventory.length - 1; slotNum >= 0; slotNum--) {
            if (carrotInventory[slotNum] != null) {
                return slotNum + 1;
            }
        }
        return 0;
    }

    public Carrot getCarrotInSlot(int slot) {
        if (slot >= 0 && slot < 25) {
            return carrotInventory[slot];
        }
        return null;
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
        hitMonster();
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


        if (Greenfoot.isKeyDown("R")) {

            System.out.println(getCarrotAmount());

            if (getCarrotAmount() > 0) {
                Carrot carrot = getCarrotInSlot(getCarrotAmount() - 1);
                getWorld().addObject(carrot, x, y);
                setCarrotInSlot(null, getCarrotAmount() - 1);
            }
        }
    }

    public void takeCarrot() {

        if (Greenfoot.isKeyDown("T")) {
            List<Carrot> carrots = getWorld().getObjectsAt(x, y, Carrot.class);
            if (!carrots.isEmpty()) {
                Carrot carrot = carrots.get(0);
                setCarrotInSlot(carrot, getCarrotAmount());
                getWorld().removeObject(carrot);
            }
        }
    }

    public void eatCarrot() {

        if (Greenfoot.isKeyDown("Q")) {
            List<Carrot> carrots = getWorld().getObjectsAt(x, y, Carrot.class);
            if (!carrots.isEmpty()) {
                Carrot carrot = carrots.get(0);
                getWorld().removeObject(carrot);
                setLife(getLife() + carrot.getWeight());
            }
        }
    }

    public void hitStone() {
        if (Greenfoot.isKeyDown("E")) {
            List<Rock> rocks = getWorld().getObjectsAt(getNextX(1), getNextY(1), Rock.class);
            if (!rocks.isEmpty()) {
                Rock rock = rocks.get(0);
                rock.hit();
            }
        }
    }

    public void hitMonster() {
        if (Greenfoot.isKeyDown("F")) {
            List<Monster> monstersInRange = getNeighbours(1, true, Monster.class);
            for (Monster monster : monstersInRange) {
                monster.hit(10);
            }
        }
    }

    /**
     * moves one step forward
     */
    public void move() {
        move(1);
        if (getNextX(1) > getWorld().getWidth()-1 && getWorld() instanceof Level1) {
            World level2 = new Level2();
            Greenfoot.setWorld(level2);
        }

    }

    public void wallDamage() {
        if (canMove()) {
            move();
        } else {
            hit(10);
        }
    }

}
