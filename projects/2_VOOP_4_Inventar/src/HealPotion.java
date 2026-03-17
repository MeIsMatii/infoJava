public class HealPotion extends Potion{
    private final int healAmount;
    public HealPotion(int uses, int healAmount) {
        super(uses);
        this.healAmount = healAmount;
    }

    public Item onUse(Character trigger) {
        trigger.heal(healAmount);

        setUses(getUses()-1);
        if(getUses()<=0) {
            return null;
        }
        return this; //1 use
    }
}
