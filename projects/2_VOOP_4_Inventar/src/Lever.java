public class Lever extends Item{
    private boolean isLeverActivated = false;


    public Item onPick(Character trigger) {
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
