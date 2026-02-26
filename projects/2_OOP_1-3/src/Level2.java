// imports Actor, World, Greenfoot, GreenfootImage
import greenfoot.*;

/**
 * @author SAE
 * @version 1.0
 */
public class Level2 extends World
{

    /**
     * Erzeuge eine Welt.
     */
    public Level2()
    {
        super(8, 8, 60);
        setBackground("cell.jpg");
        setPaintOrder(Star.class, Player.class, Carrot.class, Rock.class);

        Rock rock =  new Rock();
        Player player =  new Player(5000, 20);
        Carrot carrot =  new Carrot();
        Carrot lightCarrot =  new Carrot(3);
        Monster monster = new Monster(50,1);

        addObject(player, 3, 3);
        addObject(monster, 5, 4);
        addObject(rock, 5, 5);
        addObject(carrot, 1, 5);
        addObject(lightCarrot, 0, 6);
        }



}