import greenfoot.World;

public class Item extends Object
{
    private int value = 15;


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Object onInteract(Character trigger) {
        getWorld().removeObject(this);
        return this;
    }

    public Item onUse(Character trigger) {
        return this;
    }
    public void put(int x, int y, World world) {
        world.addObject(this, x,y);
    }

}
