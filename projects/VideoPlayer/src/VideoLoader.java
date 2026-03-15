import greenfoot.GreenfootImage;

public class VideoLoader extends ImprovedActor{
    private GreenfootImage[] video;
    private ImageLoader currImg;
    private int frame = 0;
    private int speed;
    private int speedCounter = 0;


    public VideoLoader(GreenfootImage[] video, int speed) {
        this.video = video;
        this.speed = speed;
        currImg = new ImageLoader(video[frame]);
    }

    @Override
    protected void addedToWorld(greenfoot.World world) {
        world.addObject(currImg, getX(), getY());
    }

    public void act() {
        playVideo();
    }

    public void playVideo() {
        if(speedCounter < speed) {
            speedCounter++;
            return;
        }
        speedCounter = 0;
        frame++;
        if (frame >= video.length) { //to not go out of bounds and loop it
            frame = 0;
        }
        currImg.loadImage(video[frame]);

    }
}
