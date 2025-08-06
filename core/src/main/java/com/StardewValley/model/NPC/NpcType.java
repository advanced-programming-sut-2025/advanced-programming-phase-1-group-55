package com.StardewValley.model.NPC;

import com.StardewValley.enums.AssetManager;
import com.StardewValley.model.App;
import com.StardewValley.model.Item.CollisionRect;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Item.ItemType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.StardewValley.model.App.*;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public enum NpcType {
    SEBASTIAN(
            new HashMap<>(){{
                put("Wool",new Item(ItemType.WOOL));
                put(ItemType.PUMPKIN_PIE.getDisplayName(), new Item(ItemType.PUMPKIN_PIE));
                put("pizza",new Item(ItemType.PIZZA));
            }},
            new HashMap<>(){{
                put(0,new Quest(0,new ReadyItem(ItemType.IRON,50),new ReadyItem(ItemType.DIAMOND,2),1));
                put(1,new Quest(1,new ReadyItem(ItemType.STONE,150),new ReadyItem(ItemType.QUARTZ,50),2));
                put(2,new Quest(2,new ReadyItem(ItemType.PUMPKIN_PIE,1),new ReadyItem(ItemType.GOLD,5000), 3));
            }},"Sebastian","Npc/Sebastian/Sebastian",new NpcHouse( new CollisionRect(392, 1252,
        AssetManager.SEBASTIAN_HOUSE.getTexture().getWidth(),
        AssetManager.SEBASTIAN_HOUSE.getTexture().getHeight()),AssetManager.SEBASTIAN_HOUSE.getSprite()),
        AssetManager.SEBASTIAN.getSprite(),0),

    ABIGAIL(
            new HashMap<>(){{
                put("stone",new Item(ItemType.GOLD_BAR));
                put("iron ore", new Item(ItemType.IRON_ORE));
                put("coffee",new Item(ItemType.COFFEE));
            }},
            new HashMap<>(){{
                put(3,new Quest(3,new ReadyItem(ItemType.GOLD_BAR,1),new ReadyItem(ItemType.LevelUpFriendship,1)
                       ,1));
                put(4,new Quest(4,new ReadyItem(ItemType.PUMPKIN,1),new ReadyItem(ItemType.GOLD,500)
                        ,2));
                put(5,new Quest(5,new ReadyItem(ItemType.WHEAT,50),new ReadyItem(ItemType.IRIDIUM_SPRINKLER,1)
                       ,3));
            }},"Abigail","Npc/Abigail/Abigail",new NpcHouse(new CollisionRect(-394, 1252,
        AssetManager.ABIGAIL_HOUSE.getTexture().getWidth(),
        AssetManager.ABIGAIL_HOUSE.getTexture().getHeight()),AssetManager.ABIGAIL_HOUSE.getSprite()),
        AssetManager.ABIGAIL.getSprite(),3),

    HARVEY(
            new HashMap<>(){{
                put(ItemType.COFFEE.getDisplayName(), new Item(ItemType.COFFEE));
                put(ItemType.PICKLE.getDisplayName(), new Item(ItemType.PICKLE));
                put(ItemType.BEER.getDisplayName(), new Item(ItemType.BEER));
            }},
            new HashMap<>(){{
                put(6,new Quest(6,new ReadyItem(ItemType.EGGPLANT,12),new ReadyItem(ItemType.GOLD,750)
                        ,1));
                put(7,new Quest(7,new ReadyItem(ItemType.SALMON,1),new ReadyItem(ItemType.LevelUpFriendship,1)
                        ,2));
                put(8,new Quest(8,new ReadyItem(ItemType.BEER,1),new ReadyItem(ItemType.SALAD,5)
                        ,3));
            }},"Harvey","Npc/Harvey/Harvey",new NpcHouse(new CollisionRect(392,  750,
        AssetManager.HARVEY_HOUSE.getTexture().getWidth(),
        AssetManager.HARVEY_HOUSE.getTexture().getHeight()),AssetManager.HARVEY_HOUSE.getSprite()),
        AssetManager.HARVEY.getSprite(),6),

    LEAH(
            new HashMap<>(){{
                put(ItemType.SALAD.getDisplayName(), new Item(ItemType.SALAD));
                put(ItemType.GRAPES.getDisplayName(), new Item(ItemType.GRAPES));
                put(ItemType.BEER.getDisplayName(), new Item(ItemType.BEER));
            }},
            new HashMap<>(){{
                put(9,new Quest(9,new ReadyItem(ItemType.HARD_WOOD,10),new ReadyItem(ItemType.GOLD,500)
                        ,1));
                put(10,new Quest(10,new ReadyItem(ItemType.SALMON,1),new ReadyItem(ItemType.SALMON_DINNER,1)
                        ,2));
                put(11,new Quest(11,new ReadyItem(ItemType.WOOD,200),new ReadyItem(ItemType.DELUXE_SCARECROW,1)
                        ,3));
            }},"Leah","Npc/Leah/Leah",new NpcHouse(new CollisionRect(-394,  750,
        AssetManager.LEAH_HOUSE.getTexture().getWidth(),
        AssetManager.LEAH_HOUSE.getTexture().getHeight()),AssetManager.LEAH_HOUSE.getSprite())
        ,AssetManager.LEAH.getSprite(),9),

    ROBIN(
            new HashMap<>(){{
                put(ItemType.IRON_BAR.getDisplayName(), new Item(ItemType.IRON_BAR));
                put(ItemType.SPAGHETTI.getDisplayName(), new Item(ItemType.SPAGHETTI));
                put(ItemType.WOOD.getDisplayName(), new Item(ItemType.WOOD));
            }},
            new HashMap<>(){{
                put(12,new Quest(12,new ReadyItem(ItemType.WOOD,80),new ReadyItem(ItemType.GOLD,1000), 1));
                put(13,new Quest(13,new ReadyItem(ItemType.IRON_BAR,10),new ReadyItem(ItemType.BEE_HOUSE,3), 2));
                put(14,new Quest(14,new ReadyItem(ItemType.WOOD,1000),new ReadyItem(ItemType.GOLD,25000), 3));
            }},"Robin","Npc/Robin/Robin",
        new NpcHouse(new CollisionRect(392,  248,
            AssetManager.ROBIN_HOUSE.getTexture().getWidth(),
            AssetManager.ROBIN_HOUSE.getTexture().getHeight()),AssetManager.ROBIN_HOUSE.getSprite()),
        AssetManager.ROBIN.getSprite(),12);
    private final String DisplayName;
    private final Map<String, Item> favorites;
    private final Map<Integer,Quest> quests;
    private  String job;
    private Animation<TextureRegion> animation;
    private final NpcHouse house;
    private transient final Sprite sprite;
    private int firstQuestIndex;
    NpcType( Map<String,Item> favorites, Map<Integer,Quest> quest,String names,String nameToFindAnimation,NpcHouse house,Sprite sprite,int firstQuestIndex) {
        this.favorites = favorites;
        this.quests =quest;
        this.DisplayName=names;
        this.animation= AssetManager.animation(nameToFindAnimation);
        this.house=house;
        this.sprite=sprite;
        this.firstQuestIndex=firstQuestIndex;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public Animation<TextureRegion> getAnimation() {
        return animation;
    }

    public void setAnimation(Animation<TextureRegion> animation) {
        this.animation = animation;
    }

    public NpcHouse getHouse() {
        return house;
    }

    public Map<String,Item> getFavorites() {
        return favorites;
    }

    public Map<Integer,Quest> getRequest() {
        return quests;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public Map<Integer, Quest> getQuests() {
        return quests;
    }
    public boolean isFavorite(ItemType itemType){
        for (Item item:favorites.values()){
            if (item.getItemType().equals(itemType)){
                return true;
            }
        }
        return false;
    }

    public int getFirstQuestIndex() {
        return firstQuestIndex;
    }

    public void setFirstQuestIndex(int firstQuestIndex) {
        this.firstQuestIndex = firstQuestIndex;
    }
}
