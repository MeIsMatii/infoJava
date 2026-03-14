import greenfoot.GreenfootImage;
import greenfoot.World;

import java.util.Timer;

/**
 * Write a description of class Level1 here.
 *
 * @author Mati
 * @version (a version number or a date)
 */
public class Level1 extends World
{
    //load the image
    private static int CELL_SIZE = 1;

    private static GreenfootImage[] frames = new GreenfootImage[frameAmount];
    static int width = 1920;
    static int height = 1080;

    public Level1(){
        super(width,height, CELL_SIZE);
        setPaintOrder(Pixel.class, ImageLoader.class);
        //ImageLoader image = new ImageLoader(gImg);
        VideoLoader video = new VideoLoader(frames,1);
        addObject(video, 0,0);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

    }

    public void act(){

    }

}
