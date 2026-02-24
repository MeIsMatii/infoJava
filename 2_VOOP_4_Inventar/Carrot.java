import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Carrot extends ImprovedActor
{
    //TODO: Identifiziere Attribute, Methoden und Konstruktoren und markiere diese entsprechend durch Kommentare.
    private final int weight;
   
    
    public Carrot(){
        this(5);
    }
    
    public Carrot(int weight){
        this.weight = weight;
        draw(weight);
    }

    public int getWeight() {
        return weight;
    }    
}
