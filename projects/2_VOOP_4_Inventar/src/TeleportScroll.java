import greenfoot.World;

public class TeleportScroll extends Item{
    private int teleportX;
    private int teleportY;


    public void addedToWorld(World world) {
        teleportX = getX();
        teleportY = getY();
    }

    public Item onUse(Character trigger) {
        trigger.setLocation(teleportX,teleportY);
        return null;
    }
}
