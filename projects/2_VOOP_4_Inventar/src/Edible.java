public class Edible extends Item implements PickableItem{
    private final int weight;

    public Edible(int weight){
        this.weight = weight;
        draw(weight);
        setValue(getValue()+(2*weight));
    }

    public int getWeight() {
        return weight;
    }

    public Item onUse(Character trigger) {
        trigger.heal(weight);
        return null;
    }
}
