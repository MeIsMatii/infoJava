import static java.lang.Math.min;

public class Merchant extends Character{
    private Item[] shop;
    private final InventoryVisualizer shopDisplay;
    private boolean isShopVisible = false;
    private int currentSlot = 0;

    public Merchant(Item[] shop, int worldWidth) {
        int finalSize = Math.min(shop.length, worldWidth);
        this.shop = new Item[finalSize];

        for (int i = 0; i < finalSize; i++) {
            this.shop[i] = shop[i];
        }
        shopDisplay = new InventoryVisualizer(this.shop, this);
    }


    public int getCurrentSlot() {
        return this.currentSlot;
    }

    public void setCurrentSlot(int currentSlot) {
        this.currentSlot = currentSlot;
    }

    public Item getCurrentItem() {
        return this.shop[currentSlot];
    }


    public boolean isShopVisible() {
        return isShopVisible;
    }

    public void act() {
        wrapSlot();
        if(isShopVisible()) {
            hideShop();
        } else {
            showShop();
        }
    }

    public void wrapSlot() {
        if(currentSlot < 0) {
            currentSlot = this.shop.length;
        }
        if(currentSlot > this.shop.length) {
            currentSlot = 0;
        }
    }
    public void hideShop() {
        if(!isTouching(Player.class)) {
            getWorld().removeObject(shopDisplay);
            isShopVisible = false;
        }
    }
    public void showShop() {
        if(isTouching(Player.class)) {
            getWorld().addObject(shopDisplay, 0, getWorld().getHeight() - 2);
            isShopVisible = true;
        }
    }
}
