import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

import java.util.logging.Level;

public class PrepareVideo extends World {
    int FRAME_AMOUNT;
    String PATH;
    int WIDTH;
    int HEIGHT;
    String FILENAME;

    World videoPlayer;


    public PrepareVideo() {
        super(1,1,1);
        String config = "image"; //change this manually lmao
        switch (config) {
            case "badApple":
                badApple();
                videoPlayer = new VideoPlayer(WIDTH,HEIGHT,FRAME_AMOUNT,PATH);
                break;
            case "neverGonna":
                neverGonna();
                videoPlayer = new VideoPlayer(WIDTH,HEIGHT,FRAME_AMOUNT,PATH);
                break;
            case "image":
                image("test.png");
                videoPlayer = new VideoPlayer(WIDTH,HEIGHT,FRAME_AMOUNT,PATH,FILENAME);
                break;
        }
        System.out.println("prepared video");
        Greenfoot.setWorld(videoPlayer);

    }

    public void badApple() {
        FRAME_AMOUNT = 2629;
        PATH = "generate/bad_apple/";
        GreenfootImage frame1 = new GreenfootImage(PATH + "/out_001.png");
        WIDTH = frame1.getWidth();
        HEIGHT = frame1.getHeight();
    }

    public void neverGonna() {
        FRAME_AMOUNT = 100;
        PATH = "generate/never_gonna/";
        GreenfootImage frame1 = new GreenfootImage(PATH + "/out_001.png");
        WIDTH = frame1.getWidth();
        HEIGHT = frame1.getHeight();

    }

    public void image(String filename) {
        this.FRAME_AMOUNT = 1;
        this.PATH = "generate/";
        this.FILENAME = filename;
        GreenfootImage frame1 = new GreenfootImage(PATH + FILENAME);
        WIDTH = frame1.getWidth();
        HEIGHT = frame1.getHeight();

    }

}
