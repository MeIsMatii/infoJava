public class Character extends MovingActor{
    //Atr
    private int life;


    //konstr



    //methoden

    //setter/getter
    public int getLife() {
        return life;
    }
    public void setLife(int newLife) {
        life = newLife;
        draw(life);
    }




    public void hit(int damage) {
        getWorld().addObject(new Star(), getX(), getY()); //Bei einem Treffer wird kurz ein Stern eingeblendet
        setLife(getLife()-damage);
        if(getLife()<=0) {
            getWorld().removeObject(this);
        }
        draw(getLife());
    }
}
