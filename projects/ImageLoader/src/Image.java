import java.awt.Color;
import java.awt.image.BufferedImage;


public class Image extends ImprovedActor{
    private BufferedImage img;
    private Pixel[][] pixels;


    public Image(BufferedImage img) {
        this.img = img;
    }
    public void act() {
        loadImage(this.img);
    }

    public void loadImage(BufferedImage img) {

        System.out.println("loaded new image");
        for(int x = 0; x<img.getWidth(); x++) {
            for(int y = 0; y <img.getWidth(); y++) {

                int rgb = img.getRGB(x,y);
                System.out.println(rgb);

                Pixel pixel = new Pixel(rgb);
                pixel.setImage();
                pixels[x][y] = pixel;

            }
        }
        for(int x = 0; x<img.getWidth(); x++) {
            for (int y = 0; y < img.getWidth(); y++) {
                System.out.println(pixels[x][y]);
            }
        }
    }



}
