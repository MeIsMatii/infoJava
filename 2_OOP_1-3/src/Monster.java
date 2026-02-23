import greenfoot.*;

import java.util.List;

public class Monster extends MovingActor{
    //Atribute
    private World currentWorld;
    private int health;
    private int speed;
    private int frameCounter;
    private int x;
    private int y;

    //Konstruktoren
    public Monster() {
        currentWorld = getWorld();
        setHealth(50);
        setSpeed(10); //wv frames pro bewegung
    }


    //Methoden

    //setter/getter
    public void setHealth(int amount) {
        this.health = amount;
        draw(this.health);
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
        hitPlayer(10);
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
            x = getX();
            y = getY();
        }

    public void hitPlayer(int damage) {
        if(isTouching(Player.class)) {
            List<Player> players = currentWorld.getObjectsAt(x, y, Player.class);
            if(players.isEmpty()) { //it shouldnt be empty
               return;
            }
            Player player = players.get(0);
            player.hit(damage);
        }
    }

    public void move() {
        move(1);
    }
}
