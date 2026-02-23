// imports Actor, World, Greenfoot, GreenfootImage
import greenfoot.*;

/**
 * @author SAE
 * @version 1.0
 */
public class Inventory extends World
{

    /**
     * Erzeuge eine Welt.
     */
    public Inventory()
    {
        super(30, 2, 60);
        setBackground("cell.jpg");
        setPaintOrder(Star.class, Player.class, Carrot.class, Rock.class);

        Rock rock =  new Rock();
        Player player =  new Player(5000, 0);

        addObject(player, 0, 1);

        for(int i=0;i< player.getCarrotInventory().length;i++) {
            Carrot carrot = player.getCarrotInSlot(player.getCarrotAmount()-1);
        }

    }

}