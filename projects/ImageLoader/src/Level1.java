import greenfoot.GreenfootImage;
import greenfoot.World;

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

    private static GreenfootImage[] frames = new GreenfootImage[191]; //it has 191 frames
    static int width = 1920;
    static int height = 1080;

    public Level1(){
        super(width,height, CELL_SIZE);
        for (int i = 0; i < frames.length; i++) {
            if(i+1<10) {
                frames[i] = new GreenfootImage("generate/bad_apple/out_00" + (i +1) + ".png");
            } else if (i+1 < 100) {
                frames[i] = new GreenfootImage("generate/bad_apple/out_0" + (i+1)+ ".png");
            } else {
                frames[i] = new GreenfootImage("generate/bad_apple/out_" + (i+1) + ".png");
            }

        }
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
