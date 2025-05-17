package model.NPC;

import model.Item.Item;
import model.Item.ItemType;
import model.ItemOfMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public enum NpcType {
    SEBASTIAN(
            new HashMap<>(){{
                put("Wool",new Item(ItemType.WOOL));
                put(ItemType.PUMPKIN_PIE.getDisplayName(), new Item(ItemType.PUMPKIN_PIE));
                put("pizza",new Item(ItemType.PIZZA));
            }},
            new HashMap<>(){{
                put(new ReadyItem(ItemType.IRON,50),new ReadyItem(ItemType.DIAMOND,2));
                put(new ReadyItem(ItemType.STONE,150),new ReadyItem(ItemType.QUARTZ,50));
                put(new ReadyItem(ItemType.PUMPKIN_PIE,1),new ReadyItem(ItemType.GOLD,5000));
            }}),

    ABIGAIL(
            new HashMap<>(){{
                put("stone",new Item(ItemType.GOLD_BAR));
                put("iron ore", new Item(ItemType.IRON_ORE));
                put("coffee",new Item(ItemType.COFFEE));
            }},
            new HashMap<>(){{
                put(new ReadyItem(ItemType.GOLD_BAR,1),new ReadyItem(ItemType.LevelUpFriendship,1));
                put(new ReadyItem(ItemType.PUMPKIN,1),new ReadyItem(ItemType.GOLD,500));
                put(new ReadyItem(ItemType.WHEAT,50),new ReadyItem(ItemType.IRIDIUM_SPRINKLER,1));
            }}),

    HARVEY(
            new HashMap<>(){{
                put(ItemType.COFFEE.getDisplayName(), new Item(ItemType.COFFEE));
                put(ItemType.PICKLE.getDisplayName(), new Item(ItemType.PICKLE));
                put(ItemType.BEER.getDisplayName(), new Item(ItemType.BEER));
            }},
            new HashMap<>(){{
                put(new ReadyItem(ItemType.EGGPLANT,12),new ReadyItem(ItemType.GOLD,750));
                put(new ReadyItem(ItemType.SALMON,1),new ReadyItem(ItemType.LevelUpFriendship,1));
                put(new ReadyItem(ItemType.BEER,1),new ReadyItem(ItemType.SALAD,5));
            }}),

    LEAH(
            new HashMap<>(){{
                put(ItemType.SALAD.getDisplayName(), new Item(ItemType.SALAD));
                put(ItemType.GRAPES.getDisplayName(), new Item(ItemType.GRAPES));
                put(ItemType.BEER.getDisplayName(), new Item(ItemType.BEER));
            }},
            new HashMap<>(){{
                put(new ReadyItem(ItemType.HARD_WOOD,10),new ReadyItem(ItemType.GOLD,500));
                put(new ReadyItem(ItemType.SALMON,1),new ReadyItem(ItemType.SALMON_DINNER,1));
                put(new ReadyItem(ItemType.WOOD,200),new ReadyItem(ItemType.DELUXE_SCARECROW,1));
            }}),

    ROBIN(
            new HashMap<>(){{
                put(ItemType.IRON_BAR.getDisplayName(), new Item(ItemType.IRON_BAR));
                put(ItemType.SPAGHETTI.getDisplayName(), new Item(ItemType.SPAGHETTI));
                put(ItemType.WOOD.getDisplayName(), new Item(ItemType.WOOD));
            }},
            new HashMap<>(){{
                put(new ReadyItem(ItemType.WOOD,80),new ReadyItem(ItemType.GOLD,1000));
                put(new ReadyItem(ItemType.IRON_BAR,10),new ReadyItem(ItemType.BEE_HOUSE,3));
                put(new ReadyItem(ItemType.WOOD,1000),new ReadyItem(ItemType.GOLD,25000));
            }});

    private final Map<String, Item> favorites;
    private final Map<ReadyItem,ReadyItem> exchange;
    private ArrayList<Dialog> dialogs; //todo taghir be shey dialog va ezafe kardan ertebaat baa fasl
    private  String job;
    private ArrayList<Quest> quests; //todo shey quest ezaafe beshe
    NpcType( Map<String,Item> favorites, Map<ReadyItem,ReadyItem> exchange) {
        this.favorites = favorites;
        this.exchange=exchange;
    }


    public Map<String,Item> getFavorites() {
        return favorites;
    }

    public Map<ReadyItem,ReadyItem> getRequest() {
        return exchange;
    }


    public ArrayList<Dialog> getDialogs() {
        return dialogs;
    }

    public void setDialogs(ArrayList<Dialog> dialogs) {
        this.dialogs = dialogs;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public ArrayList<Quest> getQuests() {
        return quests;
    }

    public void setQuests(ArrayList<Quest> quests) {
        this.quests = quests;
    }
}
