import greenfoot.*;
import java.util.ArrayList;
import java.util.List;

public class Merchant extends Character{
    private Item[] shop;
    private InventoryVisualizer shopDisplay;
    private boolean isShopVisible = false;
    private List<ImprovedActor> mobList = new ArrayList<ImprovedActor>();;

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
            System.out.println("hide shop");
            isShopVisible = false;
        }
    }
    public void showShop() {
        if(isTouching(Player.class)) {
            checkCollision(shop.length, getWorld().getHeight() - 2);
            shopDisplay = new InventoryVisualizer(this.shop, this);
            getWorld().addObject(shopDisplay, 0, getWorld().getHeight() - 2);
            System.out.println("show shop");
            isShopVisible = true;
        }
    }
    public void buyItem(int slot) {
        shop[slot] = null;
    }
    //incase there is anything in the way of the shop inventory
    public void checkCollision(int length, int y) {
        World currentWorld = getWorld();
        for(int x = 0; x<length;x++) {
            List<ImprovedActor> objs = currentWorld.getObjectsAt(x,y,ImprovedActor.class);
            if(!objs.isEmpty()) {
                mobList.addAll(objs);
            }

        }
        for(ImprovedActor obj: mobList) {
            currentWorld.removeObject(obj);
            //need to get the old location somehow
        }
    }

    //shitty name
    public void addObjectsBack() {
        //need to get the old location somehow
    }
}
