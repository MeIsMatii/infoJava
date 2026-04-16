import greenfoot.World;

public class TeleportScroll extends Item implements PickableItem{
    private int teleportX;
    private int teleportY;


    public void addedToWorld(World world) {
        this.teleportX = getX();
        this.teleportY = getY();
    }
    public Item onPick(Character trigger) {
        this.teleportX = getX();
        this.teleportY = getY();
        PickableItem.super.onPick(trigger);
        return this;
    }

    public Item onUse(Character trigger) {
        trigger.setLocation(teleportX,teleportY);
        return null;
    }
}
