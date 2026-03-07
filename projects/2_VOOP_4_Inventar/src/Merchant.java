import static java.lang.Math.min;

public class Merchant extends ImprovedActor{
    private Item[] shop;
    private final InventoryVisualizer shopDisplay;
    private boolean isShopVisible = false;

    public Merchant(Item[] shop, int worldWidth) {
        int finalSize = Math.min(shop.length, worldWidth);
        this.shop = new Item[finalSize];

        for (int i = 0; i < finalSize; i++) {
            this.shop[i] = shop[i];
        }
        shopDisplay = new InventoryVisualizer(this.shop);
    }

    public boolean isShopVisible() {
        return isShopVisible;
    }

    public void act() {
        if(isShopVisible()) {
            hideShop();
        } else {
            showShop();
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
