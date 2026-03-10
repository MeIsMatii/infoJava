import greenfoot.*;
import java.util.List;

public class Merchant extends Character{
    private Item[] shop;
    private InventoryVisualizer shopDisplay;
    private boolean isShopVisible = false;

    public Merchant(Item[] shop, int worldWidth) {
        int finalSize = Math.min(shop.length, worldWidth);
        this.shop = new Item[finalSize];

        for (int i = 0; i < finalSize; i++) {
            this.shop[i] = shop[i];
        }
        shopDisplay = new InventoryVisualizer(this.shop, this);
    }


    public Item getCurrentItem() {
        return this.shop[getSelectedSlot()];
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
        if(getSelectedSlot() < 0) {
            setSelectedSlot(this.shop.length-1);
        }
        if(getSelectedSlot() >= this.shop.length) {
            setSelectedSlot(0);
        }
    }
    public void hideShop() {
        if(!isTouching(Player.class)) {
            shopDisplay.removeInventory();
            for(int i = 0; i<shop.length;i++) {
                getWorld().showText("", i, getWorld().getHeight() -2); //replace with empty string to rm old text
            }
            System.out.println("hide shop");
            isShopVisible = false;
        }
    }
    public void showShop() {
        if(isTouching(Player.class)) {
            shopDisplay = new InventoryVisualizer(this.shop, this);
            getWorld().addObject(shopDisplay, 0, getWorld().getHeight() - 2);
            for(int i = 0; i<shop.length;i++) {
                if(shop[i] == null) {
                    continue;
                }
                getWorld().showText(String.valueOf(shop[i].getValue()), i, getWorld().getHeight() -2);
            }
            System.out.println("show shop");
            isShopVisible = true;
        }
    }
    public void buyItem(int slot) {
        shop[slot] = null;
        getWorld().showText("", slot, getWorld().getHeight() -2); //replace with empty string to rm old text
    }

}
