public class Edible extends Item{
    private final int weight;

    public Edible(int weight){
        this.weight = weight;
        draw(weight);
        setValue(getValue()+(2*weight));
    }

    public int getWeight() {
        return weight;
    }
}
