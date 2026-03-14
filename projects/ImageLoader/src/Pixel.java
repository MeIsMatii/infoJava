import greenfoot.*;

import java.awt.image.BufferedImage;

public class Pixel extends ImprovedActor{
    //private World world = getWorld();
    private final int rgb;
    private final BufferedImage img = new BufferedImage(1,1, BufferedImage.TYPE_INT_ARGB);
    public Pixel(int rgb) {
        this.rgb = rgb;
    }
    public void setImage() {
        //super.setImage(image);
        this.img.setRGB(0, 0, rgb);
    }
}
