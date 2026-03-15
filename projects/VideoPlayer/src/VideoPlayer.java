import greenfoot.GreenfootImage;
import greenfoot.World;

/**
 * Write a description of class VideoPlayer here.
 *
 * @author Mati
 * @version (a version number or a date)
 */
public class VideoPlayer extends World
{
    //load the image


    private static final int CELL_SIZE = 60;
    //video
    public VideoPlayer(int WIDTH, int HEIGHT, int FRAME_AMOUNT, String PATH){
        super(WIDTH, HEIGHT, CELL_SIZE);
        setPaintOrder(Pixel.class, ImageLoader.class);


        GreenfootImage[] frames = new GreenfootImage[FRAME_AMOUNT];
        for (int i = 0; i < frames.length; i++) {
            if(i+1<10) {
                frames[i] = new GreenfootImage(PATH + "out_00" + (i +1) + ".png");
            } else if (i+1 < 100) {
                frames[i] = new GreenfootImage(PATH + "out_0" + (i+1)+ ".png");
            } else {
                frames[i] = new GreenfootImage(PATH + "out_" + (i+1) + ".png");
            }
        }
        VideoLoader video = new VideoLoader(frames,1);
        addObject(video, 0,0);
    }

    public VideoPlayer(int WIDTH, int HEIGHT, int FRAME_AMOUNT, String PATH, String FILENAME){
        super(WIDTH, HEIGHT, CELL_SIZE);
        setPaintOrder(Pixel.class, ImageLoader.class);

        GreenfootImage[] frames = new GreenfootImage[FRAME_AMOUNT];
        frames[0] = new GreenfootImage(PATH + FILENAME);

        ImageLoader image = new ImageLoader(frames[0]);
        addObject(image, 0,0);
        image.loadImage(frames[0]);
    }



}
