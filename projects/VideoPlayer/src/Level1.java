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

    //bad apple config

    private static final int FRAME_AMOUNT = 2629; //I am lazy and don't want to make a counter
    private static final String PATH = "generate/bad_apple/"; // u gotta change this too
    static int WIDTH = 480;
    static int HEIGHT = 360;


    //other config
    /*
    private static final int FRAME_AMOUNT = 100; //I am lazy and don't want to make a counter
    private static final String PATH = "generate/never_gonna/"; // u gotta change this too
    static int WIDTH = 1280;
    static int HEIGHT = 720;
    */

    //image
    /*
    private static final int FRAME_AMOUNT = 1;
    private static final String PATH = "generate/"; // u gotta change this too
    static int WIDTH = 1280;
    static int HEIGHT =1000;
    static String FILENAME = "febfeb";
    */


    private static final GreenfootImage[] frames = new GreenfootImage[FRAME_AMOUNT];
    private static final int CELL_SIZE = 2;
    public Level1(){
        super(WIDTH, HEIGHT, CELL_SIZE);
        //video

        for (int i = 0; i < frames.length; i++) {
            if(i+1<10) {
                frames[i] = new GreenfootImage(PATH + "out_00" + (i +1) + ".png");
            } else if (i+1 < 100) {
                frames[i] = new GreenfootImage(PATH + "out_0" + (i+1)+ ".png");
            } else {
                frames[i] = new GreenfootImage(PATH + "out_" + (i+1) + ".png");
            }
        }

        //image
        //frames[0] = new GreenfootImage(PATH + FILENAME + ".png");
        setPaintOrder(Pixel.class, ImageLoader.class);
        //ImageLoader image = new ImageLoader(gImg);
        VideoLoader video = new VideoLoader(frames,1);
        addObject(video, 0,0);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
   

}
