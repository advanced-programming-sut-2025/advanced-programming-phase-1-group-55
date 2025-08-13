package com.StardewValley.model.Animal;

import com.StardewValley.enums.AssetManager;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Map.Tile;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.StardewValley.model.Animal.AnimalSheets;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Animal extends Item {
    private String name;
    private FarmAnimalType animalType;
    private int friendship = 0;
    private boolean isFed = false;
    private boolean isIn = true;
    private boolean isPet = false;
//    private final ArrayList<Item> products;
//    private final List<Item> products;
    private Tile tile = null;
    private boolean hasProduct = false;
    private boolean secondProduct = false;
    private double quality = 0;
    private Sprite sprite;
    private float worldX, worldY;
    public float getWorldX() { return worldX; }
    public float getWorldY() { return worldY; }
    private boolean moving = false;
    private float targetX, targetY;
    private float speed = 200f;
    private static final float MAX_STEP = 10f;
    private Animation<TextureRegion> moveAnim;
    private TextureRegion idleFrame;
    private float animTime = 0f;




    public Animal(String name, FarmAnimalType animalType)
    {
        this.itemType = animalType.getType();
        this.name = name;
        this.animalType = animalType;
        this.price = animalType.getPrice();
        this.isFed = false;
        this.isIn = true;
        this.isPet = false;
        this.sprite = AssetManager.valueOf(animalType.name()).getSprite();
        this.sprite.setOriginCenter();
        initAnimationFromType();
//        this.products = (ArrayList<Item>) animalType.getProduct();
//        this.products = new ArrayList<>(animalType.getProduct());
    }
    public Animal(FarmAnimalType type) {
        this.animalType = type;
        this.name = type.name();
        this.sprite = AssetManager.valueOf(type.name()).getSprite();
        this.sprite.setOriginCenter();
        initAnimationFromType();
    }

    public Sprite getSprite() { return sprite; }

    public void setWorldPosition(float x, float y) {
        this.worldX = x;
        this.worldY = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FarmAnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(FarmAnimalType animalType) {
        this.animalType = animalType;
    }

    public int getFriendship() {
        return friendship;
    }

    public boolean isFed() {
        return isFed;
    }

    public void setFed(boolean fed) {
        isFed = fed;
    }

    public boolean isIn() {
        return isIn;
    }

    public void setIn(boolean in) {
        isIn = in;
    }

    public boolean isPet() {
        return isPet;
    }

    public void setPet(boolean pet) {
        isPet = pet;
    }

//    public ArrayList<Item> getProducts() {
//        return products;
//    }


//    public List<Item> getProducts() {
//        return products;
//    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public boolean isHasProduct() {
        return hasProduct;
    }

    public void setHasProduct(boolean hasProduct) {
        this.hasProduct = hasProduct;
    }

    public boolean isSecondProduct() {
        return secondProduct;
    }

    public void setSecondProduct(boolean secondProduct) {
        this.secondProduct = secondProduct;
    }


    public void setQuality(double quality) {
        this.quality = quality;
    }

    public void increaseFriendship(int amount)
    {
        this.friendship += amount;
        if(friendship >= 1000) friendship = 1000;
    }
    public void decreaseFriendship(int amount) {
        this.friendship -= amount;
    }
    public void feed() {
        if (!isFed) {
            increaseFriendship(8);
            isFed = true;
        }
    }
    public void pet() {
        if (!isPet) {
            increaseFriendship(15);
            isPet = true;
        }
    }

    public void setFriendship(int friendship) {
        this.friendship = Math.min(friendship, 1000);
    }
    public void checkAndReset()
    {
        if(!isFed)
        {
            decreaseFriendship(20);
        }

        if(!isIn)
        {
            decreaseFriendship(20);
        }

        if(!isPet)
        {
            decreaseFriendship(10 - getFriendship() / 200);
        }

        hasProduct = isFed;

        isFed = false;
        isPet = false;
        isIn = true;

        secondProduct = false;

        if (friendship > 100)
        {
            Random rand = new Random();
            if ((friendship + (rand.nextInt(3) / 3.0 + 1)) / 1500 >= 1)
            {
                secondProduct = true;
            }
        }
    }
    public void goOut()
    {
        isIn = false;
        isFed = true;
        increaseFriendship(8);
    }
    public void goIn()
    {
        isIn = true;
    }
//    public Item getProduct()
//    {
//        Item product = products.get(0);
//        if (secondProduct && products.size() > 1)
//        {
//            product = products.get(1);
//        }
//
//        return product;
//    }
    public void calculateProductPrice(Item product)
    {
        quality = getQuality();

        if(quality <= 0.5)
        {
            product.setPrice(price);
        } else if(quality > 0.5 && quality <= 0.7) {
            product.setPrice((int) (price * 1.25));
        } else if(quality > 0.7 && quality <= 0.9) {
            product.setPrice((int) (price * 1.5));
        } else {
            product.setPrice((int) (price * 2.0));
        }
    }
    public double getQuality()
    {
        Random rand = new Random();
        return ((double) friendship / 1000) * (0.5 + 0.5 * rand.nextDouble());
    }
    public int getPrice()
    {
        return (int) (animalType.getPrice() * (((double) friendship / 1000) + 0.3));
    }


    public String getInfo()
    {
        StringBuilder output = new StringBuilder();

        output.append(name).append("\n");
        output.append("\t").append("kind: ").append(animalType.getName()).append("\n");
        output.append("\t").append("friendship: ").append(friendship).append(" xp \n");
        output.append("\t").append("is fed today: ").append(isFed ? "positive" : "negative").append("\n");
        output.append("\t").append("is pet today: ").append(isPet ? "positive" : "negative").append("\n");
        output.append("--------------------------------");
        return output.toString();
    }
    public void resetDailyStatus() {
        this.isFed = false;
        this.isPet = false;
    }
    public void setTarget(float x, float y) {
        this.targetX = x;
        this.targetY = y;
        this.moving = true;
    }

    public void update(float delta) {
        if (!moving) return;
        float dx = targetX - worldX;
        float dy = targetY - worldY;
        float dist2 = dx*dx + dy*dy;
        if (dist2 < 1f) {
            worldX = targetX;
            worldY = targetY;
            moving = false;
            return;
        }
        float dist = (float) Math.sqrt(dist2);
        float step = speed * delta;

        if (step > MAX_STEP) step = MAX_STEP;

        if (step >= dist) {
            worldX = targetX;
            worldY = targetY;
            moving = false;
        } else {
            worldX += dx / dist * step;
            worldY += dy / dist * step;
        }
    }

    private void setupAnimationFromSheet(com.badlogic.gdx.graphics.Texture sheet, int cols, int rows, float frameDurationSec) {
        int frameW = sheet.getWidth() / cols;
        int frameH = sheet.getHeight() / rows;

        TextureRegion[][] grid = TextureRegion.split(sheet, frameW, frameH);
        Array<TextureRegion> frames = new Array<>(cols * rows);
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                frames.add(grid[r][c]);
            }
        }
        moveAnim = new Animation<>(frameDurationSec, frames, Animation.PlayMode.LOOP);
        idleFrame = frames.get(0);
    }


    public TextureRegion getCurrentFrame(float delta) {
        if (moving && moveAnim != null) {
            animTime += delta;
             System.out.println("animTime=" + animTime);
            return moveAnim.getKeyFrame(animTime);
        }
        animTime = 0f;
        return (moveAnim != null) ? idleFrame : sprite;


    }


    private void initAnimationFromType() {
        var spec = AnimalSheets.forType(animalType);
        if (spec != null) {
            setupAnimationFromSheet(spec.texture, spec.cols, spec.rows, spec.frameDuration);

            if (sprite != null && idleFrame != null) {
                float w = sprite.getWidth(), h = sprite.getHeight();
                float ox = sprite.getOriginX(), oy = sprite.getOriginY();

                sprite.setRegion(idleFrame);
                sprite.setSize(w, h);
                sprite.setOrigin(ox, oy);
            }
        }
    }


}
