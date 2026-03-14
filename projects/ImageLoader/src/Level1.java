import greenfoot.World;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Write a description of class Level1 here.
 *
 * @author Mati
 * @version (a version number or a date)
 */
public class Level1 extends World
{
    //load the image
    static String filename = "images/5Gold.png";
    static BufferedImage bimg;
    static {
        try {
            bimg = ImageIO.read(new File(filename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static int width = bimg.getWidth();
    static int height = bimg.getHeight();

    public Level1(){
        super(width,height, 1);
        Image image = new Image(bimg);
        addObject(image, 0,0);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

    }

    public BufferedImage getImage() {
        return bimg;
    }
}
