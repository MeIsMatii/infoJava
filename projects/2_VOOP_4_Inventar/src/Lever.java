public class Lever extends Object{
    private boolean isLeverActivated = false;


    public Item onInteract(Character trigger) {
        isLeverActivated = !isLeverActivated;
        setState();

        //do something with the input ig

        return null;
    }
    public void setState() {
        if(isLeverActivated) {
            setImage("Lever_on.png");
        } else {
            setImage("Lever_off.png");
        }
    }
}
