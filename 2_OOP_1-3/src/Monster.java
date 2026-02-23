import greenfoot.*;

import java.util.List;

public class Monster extends MovingActor{
    //Atribute
    private int health;
    private int speed;
    private int frameCounter;

    //Konstruktoren
    public Monster() {
        setHealth(50);
        setSpeed(10); //wv frames pro bewegung
    }


    //Methoden

    //setter/getter
    public void setHealth(int amount) {
        this.health = amount;
    }
    public int getHealth() {
        return this.health;
    }
    public void setSpeed(int amount) {
        this.speed = amount;
    }
    public int getSpeed() {
        return this.speed;
    }


    public void act() {
        randomMove(speed);
    }


    public void randomMove(int speed) {
        if (frameCounter == speed -1) {
            frameCounter = 0;
        } else {
            frameCounter++;
        }


        if (frameCounter != 0) {
            return;
        }
        switch(Greenfoot.getRandomNumber(4)) {
            case 0:
                turn(Direction.NORTH);
                break;
            case 1:
                turn(Direction.SOUTH);
                break;
            case 2:
                turn(Direction.EAST);
                break;
            case 3:
                turn(Direction.WEST);
                break;

            }
            move();
        }



    public void move() {
        move(1);
    }
}
