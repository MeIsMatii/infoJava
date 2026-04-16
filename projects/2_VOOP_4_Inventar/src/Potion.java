import greenfoot.Greenfoot;

public class Potion extends Item implements PickableItem{
    private int uses;
    public Potion(int uses) {
        this.uses = uses;
    }
    public Item onPick(Character trigger) {
        int number = Greenfoot.getRandomNumber(100);
        Item thisItem = this;
        PickableItem.super.onPick(trigger);
        if(number < 5) {
            return null; //break
        }
        return thisItem; //no break
    }

    public int getUses() {
        return uses;
    }

    public void setUses(int uses) {
        this.uses = uses;
    }
}
