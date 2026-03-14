import greenfoot.Color;


public class Pixel extends ImprovedActor {
    private Color color;
    private final ImprovedGreenfootImage img;

    public Pixel(int cellSize) {
        this.img = new ImprovedGreenfootImage(cellSize, cellSize);
    }

    public void setImage(Color newColor) {
        if(newColor.equals(this.color)) {
            return;
        }
        if(newColor.getAlpha() == 0) {
            newColor = Color.BLACK;
        }
        this.img.setColor(newColor);
        this.img.fill();
        super.setImage(img);

        this.color = newColor;
    }
}
