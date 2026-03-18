import greenfoot.Greenfoot;

public class Potion extends Item{
    private int uses;
    public Potion(int uses) {
        this.uses = uses;
    }
    public Object onInteract(Character trigger) {
        int number = Greenfoot.getRandomNumber(100);
        Item thisItem = this;
        super.onInteract(trigger);
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
