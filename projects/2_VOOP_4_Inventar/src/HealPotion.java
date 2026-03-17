public class HealPotion extends Potion{
    public Item onPick(Character trigger) {
        Item thisItem = super.onPick(trigger);
        if(thisItem != null) {
            trigger.heal(30);
        }
        return thisItem;
    }
}
