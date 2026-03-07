import greenfoot.Actor;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class Carrot extends Item
{
    //TODO: Identifiziere Attribute, Methoden und Konstruktoren und markiere diese entsprechend durch Kommentare.
    private final int weight;


    public Carrot(){
        this(5);
    }

    public Carrot(int weight){
        this.weight = weight;
        draw(weight);
        setValue(getValue()+(2*weight));
    }

    public int getWeight() {
        return weight;
    }

}
