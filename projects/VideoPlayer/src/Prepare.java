import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class Prepare extends World {
    int FRAME_AMOUNT;
    String PATH;
    int WIDTH;
    int HEIGHT;
    String FILENAME;

    World screen;


    public Prepare() {
        super(1,1,1);
        String config = "neverGonna"; //change this manually lmao
        switch (config) {
            case "badApple":
                badApple();
                screen = new Screen(WIDTH,HEIGHT,FRAME_AMOUNT,PATH);
                break;
            case "neverGonna":
                neverGonna();
                screen = new Screen(WIDTH,HEIGHT,FRAME_AMOUNT,PATH);
                break;
            case "image":
                image("test.png");
                screen = new Screen(WIDTH,HEIGHT,FRAME_AMOUNT,PATH,FILENAME);
                break;
        }
        System.out.println("prepared video");
        Greenfoot.setWorld(screen);
    }

    public void badApple() {
        System.out.println("ba");
        FRAME_AMOUNT = 2629;
        PATH = "generate/bad_apple/";
        GreenfootImage frame1 = new GreenfootImage(PATH + "out_001.png");
        WIDTH = frame1.getWidth();
        HEIGHT = frame1.getHeight();

    }

    public void neverGonna() {
        System.out.println("rick");
        FRAME_AMOUNT = 100;
        PATH = "generate/never_gonna/";
        GreenfootImage frame1 = new GreenfootImage(PATH + "out_001.png");
        WIDTH = frame1.getWidth();
        HEIGHT = frame1.getHeight();

    }

    public void image(String filename) {
        System.out.println("img");
        this.FRAME_AMOUNT = 1;
        this.PATH = "generate/";
        this.FILENAME = filename;
        GreenfootImage frame1 = new GreenfootImage(PATH + FILENAME);
        WIDTH = frame1.getWidth();
        HEIGHT = frame1.getHeight();

    }

}
