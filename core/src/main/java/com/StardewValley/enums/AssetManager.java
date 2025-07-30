package com.StardewValley.enums;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public enum AssetManager {


    DAY_BACKGROUND("Flooring/Flooring_86.png"),
    NIGHT_BACKGROUND("Flooring/Flooring_61.png"),

    PinkBackground("background/pastel-pink.jpg"),
    Wood_background("Flooring/Flooring_35.png"),
    Wood_background2("Flooring/Flooring_51.png"),
    Stone_background("Flooring/Flooring_55.png"),
    blueBackground("Flooring/Flooring_45.png"),


    heart("Heart/Secret_Heart.png"),
    STONE_FENCE("Fence/Stone_Fence.png"),
    WOOD_FENCE("Fence/Wood_Fence.png"),
    GATE("Fence/Gate.png"),
    IRON_FENCE("Fence/Iron_Fence.png"),

    ShippingBin("Buildings/Shipping Bin.png"),
    TrashCan("sprites/trashcan.png"),


    PLAYER("sprites/Mariner.png"),


    JOJA_MART_STORE("Stores/jojaMart.png"),
    BLACKSMITH_STORE("Stores/store4.png"),
    CARPENTER_STORE("Stores/store5.png"),
    FISHING_STORE("Stores/store2.png"),
    GENERAL_STORE("Stores/preiers.png"),
    MARINE_RANCH_STORE("Stores/store3.png"),
    STAR_DROP_STORE("Stores/stardropSalon.png"),
    SEBASTIAN_HOUSE("Stores/store 1.png"),
    ABIGAIL_HOUSE("Stores/store6.png"),
    HARVEY_HOUSE("Stores/store7.png"),
    LEAH_HOUSE("Stores/store8.png"),
    ROBIN_HOUSE("Stores/store9.png"),


    ALEX("Npc/Alex/Alex.png"),
    ALEX_2("Npc/Alex/Alex2.png"),
    ALEX_3("Npc/Alex/Alex3.png"),


    ABIGAIL("Npc/Abigail/Abigail.png"),
    ABIGAIL_2("Npc/Abigail/Abigail2.png"),
    ABIGAIL_3("Npc/Abigail/Abigail3.png"),


    GUS("Npc/Gus/Gus.png"),
    GUS_2("Npc/Gus/Gus2.png"),
    GUS_3("Npc/Gus/Gus3.png"),


    SEBASTIAN("Npc/Sebastian/Sebastian.png"),
    SEBASTIAN_2("Npc/Sebastian/Sebastian2.png"),
    SEBASTIAN_3("Npc/Sebastian/Sebastian3.png"),


    WILLY("Npc/Willy/Willy.png"),
    WILLY_2("Npc/Willy/Willy2.png"),
    WILLY_3("Npc/Willy/Willy3.png"),


    ROBIN("Npc/Robin/Robin.png"),
    ROBIN_2("Npc/Robin/Robin2.png"),
    ROBIN_3("Npc/Robin/Robin3.png"),


    PIERRE("Npc/Pierre/Pierre.png"),
    PIERRE_2("Npc/Pierre/Pierre2.png"),
    PIERRE_3("Npc/Pierre/Pierre3.png"),


    MARNIE("Npc/Marnie/Marnie.png"),
    MARNIE_2("Npc/Marnie/Marnie2.png"),
    MARNIE_3("Npc/Marnie/Marnie3.png"),


    LEAH("Npc/Leah/Leah.png"),
    LEAH_2("Npc/Leah/Leah2.png"),
    LEAH_3("Npc/Leah/Leah3.png"),


    JOJA("Npc/Joja/Joja.png"),
    JOJA_2("Npc/Joja/Joja2.png"),
    JOJA_3("Npc/Joja/Joja3.png"),


    HARVEY("Npc/Harvey/Harvey.png"),
    HARVEY_2("Npc/Harvey/Harvey2.png"),
    HARVEY_3("Npc/Harvey/Harvey3.png"),


    CLINT("Npc/Clint/Clint.png"),
    CLINT_2("Npc/Clint/Clint2.png"),
    CLINT_3("Npc/Clint/Clint3.png"),

    IRON_LAMP("Craftable_lighting/Iron_Lamp-post.png"),
    WOOD_LAMP("Craftable_lighting/Wood_Lamp-post.png"),
    STONE_BRAZIER("Craftable_lighting/Stone_Brazier.png"),
    IRIDIUM_BRAZIER("Craftable_lighting/Marble_Brazier.png"),


    SHEARS("Tools/Shears/Shears.png"),

    MILK_PAIL("Tools/Milk_Pail/Milk_Pail.png"),

    HOE("Tools/Hoe/Hoe.png"),
    COPPER_HOE("Tools/Hoe/Copper_Hoe.png"),
    STEEL_HOE("Tools/Hoe/Steel_Hoe.png"),
    GOLD_HOE("Tools/Hoe/Gold_Hoe.png"),
    IRIDIUM_HOE("Tools/Hoe/Iridium_Hoe.png"),

    AXE("Tools/Axe/Axe.png"),
    COPPER_AXE("Tools/Axe/Copper_Axe.png"),
    STEEL_AXE("Tools/Axe/Steel_Axe.png"),
    GOLD_AXE("Tools/Axe/Gold_Axe.png"),
    IRIDIUM_AXE("Tools/Axe/Iridium_Axe.png"),

    PICKAXE("Tools/Pickaxe/Pickaxe.png"),
    COPPER_PICKAXE("Tools/Pickaxe/Copper_Pickaxe.png"),
    STEEL_PICKAXE("Tools/Pickaxe/Steel_Pickaxe.png"),
    GOLD_PICKAXE("Tools/Pickaxe/Gold_Pickaxe.png"),
    IRIDIUM_PICKAXE("Tools/Pickaxe/Iridium_Pickaxe.png"),

    SCYTHE("Tools/Scythe/Scythe.png"),
    COPPER_SCYTHE("Tools/Scythe/Golden_Scythe.png"),
    STEEL_SCYTHE("Tools/Scythe/Scythe.png"),
    GOLD_SCYTHE("Tools/Scythe/Golden_Scythe.png"),
    IRIDIUM_SCYTHE("Tools/Scythe/Iridium_Scythe.png"),

    WATERING_CAN("Tools/Watering_Can/Watering_Can.png"),
    COPPER_WATERING_CAN("Tools/Watering_Can/Copper_Watering_Can.png"),
    STEEL_WATERING_CAN("Tools/Watering_Can/Steel_Watering_Can.png"),
    GOLD_WATERING_CAN("Tools/Watering_Can/Gold_Watering_Can.png"),
    IRIDIUM_WATERING_CAN("Tools/Watering_Can/Iridium_Watering_Can.png"),

    COPPER_TRASHCAN("Tools/TrashCan/Trash_Can_Copper.png"),
    STEEL_TRASHCAN("Tools/TrashCan/Trash_Can_Steel.png"),
    GOLD_TRASHCAN("Tools/TrashCan/Trash_Can_Gold.png"),
    IRIDIUM_TRASHCAN("Tools/TrashCan/Trash_Can_Iridium.png"),

    SIMPLE_FISHING_POLE("Tools/Fishing_Pole/Training_Rod.png"),
    BAMBOO_FISHING_POLE("Tools/Fishing_Pole/Bamboo_Pole.png"),
    FIBER_FISHING_POLE("Tools/Fishing_Pole/Fiberglass_Rod.png"),
    IRIDIUM_FISHING_POLE("Tools/Fishing_Pole/Iridium_Rod.png"),

    Dialog("dialog/pngtree-pixel-art-text-box-game-dialog-png-image_3132975.png"),
    LockTexture("Emoji/lock.png"),
    progressTexture("Emoji/runner.png"),
    Completed("Emoji/white_check_mark.png"),
    Unlocked("Emoji/heavy_check_mark.png"),

    Gift("Emoji/gift.png"),
    Balloon("Emoji/balloon.png")
    ,Star("Emoji/star2.png"),
    gear("Emoji/gear.png"),

    FARMING("Skill/Farming_Skill_Icon.png"),
    MINING("Skill/Mining_Skill_Icon.png"),
    FISHING("Skill/Fishing_Skill_Icon.png"),
    FORAGING("Skill/Foraging_Skill_Icon.png"),



    ;



    private final String path;
    private final Texture texture;
    private final TextureRegion textureRegion;


    AssetManager(String path) {
        this.path = path;
        this.texture = new Texture(Gdx.files.internal(path));
        this.textureRegion = new TextureRegion(texture);
    }
    public String getPath() {
        return path;
    }
    public  static TextureRegion getByPath(String path) {
        for (AssetManager assetManager:AssetManager.values()){
            if (assetManager.path.equals(path)){
                return assetManager.textureRegion;
            }
        }
        return null;
    }
    public TextureRegion getTextureRegion() {
        return textureRegion;
    }

    public Texture getTexture() {
        return texture;
    }
    public Sprite getSprite() {
        return new Sprite(texture);
    }

    public void dispose() {
        texture.dispose();
    }
    public static Animation<TextureRegion> animation(String name) {
        TextureRegion frame1 = new TextureRegion(getByPath(name+".png"));
        TextureRegion frame2 = new TextureRegion(getByPath(name+"2.png"));
        TextureRegion frame3 = new TextureRegion(getByPath(name+".png"));
        TextureRegion frame4 = new TextureRegion(getByPath(name+"3.png"));
        Array<TextureRegion> frames = new Array<>();
        frames.add(frame1);
        frames.add(frame2);
        frames.add(frame3);
        frames.add(frame4);
        return new Animation<>(3f, frames, Animation.PlayMode.LOOP);
    }
}
