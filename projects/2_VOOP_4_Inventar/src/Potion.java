import greenfoot.Actor;
import greenfoot.Greenfoot;

public class Potion extends Item{
    public Item onPick(Character trigger) {
        int number = Greenfoot.getRandomNumber(100);
        Item thisItem = this;
        super.onPick(trigger);
        if(number < 50) {
            return null; //break
        }
        return thisItem; //no break
    }
}
