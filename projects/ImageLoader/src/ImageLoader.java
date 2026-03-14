import greenfoot.Color;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

import java.util.List;


public class ImageLoader extends ImprovedActor {
    private final GreenfootImage img;
    private final Pixel[][] pixels;
    private World world;

    public ImageLoader(GreenfootImage img) {
        this.img = img;

        pixels = new Pixel[this.img.getHeight()][this.img.getWidth()];
    }


    @Override
    protected void addedToWorld(World world) {
        this.world = world;

        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                Pixel pixel = new Pixel(world.getCellSize());
                pixel.setImage(Color.BLACK);
                world.addObject(pixel,x,y);

                pixels[y][x] = pixel;
            }
        }
    }

    public void loadImage(GreenfootImage newImg) {
        for (int y = 0; y < Math.min(newImg.getHeight(), pixels.length); y++) {
            for (int x = 0; x < Math.min(newImg.getWidth(), pixels[y].length); x++) {
                Color color = newImg.getColorAt(x,y);
                pixels[y][x].setImage(color);
            }
        }
        System.out.println("loaded new image");
    }

    public void removeImage() {
        if (world == null) {
            System.out.println("cannot remove image");
            Greenfoot.stop();
        }
        for(Pixel[] pixels: this.pixels) {
            for(Pixel pixel: pixels) {
                if (pixel != null) {
                    world.removeObject(pixel);
                }
                else {
                    System.out.println("cannot remove image");
                    Greenfoot.stop();
                }
            }
        }
        System.out.println("rmd img");
    }


}
