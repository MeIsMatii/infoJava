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
    private static GreenfootImage gImg1 = new GreenfootImage("generate/vanquish.png");
    private static GreenfootImage gImg2 = new GreenfootImage("generate/alcremeow.png");
    private static GreenfootImage gImg3 = new GreenfootImage("generate/febfeb.png");

    private static GreenfootImage[] mov = new GreenfootImage[]{gImg1,gImg2, gImg3};
    static int width = Math.max(Math.max(gImg1.getWidth(),gImg2.getWidth()),gImg3.getWidth());
    static int height = Math.max(Math.max(gImg1.getHeight(),gImg2.getHeight()),gImg3.getHeight());

    public Level1(){
        super(width,height, CELL_SIZE);
        setPaintOrder(Pixel.class, ImageLoader.class);
        //ImageLoader image = new ImageLoader(gImg);
        VideoLoader video = new VideoLoader(mov,1);
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
