import greenfoot.GreenfootImage;

public class VideoLoader extends ImprovedActor{
    private final GreenfootImage[] video;
    private final ImageLoader imageLoader;
    private int frame = 0;
    private final int speed;
    private int speedCounter = 0;


    public VideoLoader(GreenfootImage[] video, int speed) {
        this.video = video;
        this.speed = speed;
        imageLoader = new ImageLoader(video[frame]);
    }

    @Override
    protected void addedToWorld(greenfoot.World world) {
        world.addObject(imageLoader, getX(), getY());
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
        imageLoader.loadImage(video[frame]);

    }
}
