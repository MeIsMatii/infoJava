import greenfoot.World;

/**
 * Write a description of class Level2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Level1 extends World
{

    /**
     * Constructor for objects of class Level2.
     */
    public Level1()
    {
        super(8, 8, 60);
        setBackground("cell.jpg");
        setPaintOrder(HotbarSelector.class,InventorySlot.class, Player.class, Carrot.class, Rock.class);
        Player player = new Player();
        addObject(player, 4, 4);

        prepare();
        Foot foot = new Foot();
        addObject(foot, 1,1);
        HotbarSelector hotbarSelector = new HotbarSelector();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //Apple apple = new Apple();
        //addObject(apple,2,2);
        Item[] merchantShop = new Item[]{new Carrot(3), new Carrot(54), new Apple(), null};
        //Item[] merchantShop = new Item[3];
        Merchant merchant = new Merchant(merchantShop, getWidth());
        addObject(merchant,0,0);
        Carrot carrot = new Carrot(2);
        addObject(carrot,6,4);
        Potion potion = new Potion();
        addObject(potion,6,4);
        Carrot carrot2 = new Carrot(5);
        addObject(carrot2,3,3);
        Carrot carrot3 = new Carrot(7);
        addObject(carrot3,2,6);
        Rock rock = new Rock();
        addObject(rock, 4, 5);
    }
}
