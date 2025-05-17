package model.NPC;

import model.App;
import model.Item.Item;
import model.Item.ItemType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.App.*;
public enum NpcType {
    SEBASTIAN(
            new HashMap<>(){{
                put("Wool",new Item(ItemType.WOOL));
                put(ItemType.PUMPKIN_PIE.getDisplayName(), new Item(ItemType.PUMPKIN_PIE));
                put("pizza",new Item(ItemType.PIZZA));
            }},
            new HashMap<>(){{
                put(0,new Quest(0,new ReadyItem(ItemType.IRON,50),new ReadyItem(ItemType.DIAMOND,2),
                        App.currentGame.getMap().getVillage().getNpss().get("Sebastian"),1));
                put(1,new Quest(1,new ReadyItem(ItemType.STONE,150),new ReadyItem(ItemType.QUARTZ,50)
                        ,App.currentGame.getMap().getVillage().getNpss().get("Sebastian"),2));
                put(2,new Quest(2,new ReadyItem(ItemType.PUMPKIN_PIE,1),new ReadyItem(ItemType.GOLD,5000),
                        App.currentGame.getMap().getVillage().getNpss().get("Sebastian"),3));
            }},"Sebastian"),

    ABIGAIL(
            new HashMap<>(){{
                put("stone",new Item(ItemType.GOLD_BAR));
                put("iron ore", new Item(ItemType.IRON_ORE));
                put("coffee",new Item(ItemType.COFFEE));
            }},
            new HashMap<>(){{
                put(3,new Quest(1,new ReadyItem(ItemType.GOLD_BAR,1),new ReadyItem(ItemType.LevelUpFriendship,1),
                        App.currentGame.getMap().getVillage().getNpss().get("Abigail"),1));
                put(4,new Quest(1,new ReadyItem(ItemType.PUMPKIN,1),new ReadyItem(ItemType.GOLD,500)
                        ,App.currentGame.getMap().getVillage().getNpss().get("Abigail"),2));
                put(5,new Quest(1,new ReadyItem(ItemType.WHEAT,50),new ReadyItem(ItemType.IRIDIUM_SPRINKLER,1),
                        App.currentGame.getMap().getVillage().getNpss().get("Abigail"),3));
            }},"Abigail"),

    HARVEY(
            new HashMap<>(){{
                put(ItemType.COFFEE.getDisplayName(), new Item(ItemType.COFFEE));
                put(ItemType.PICKLE.getDisplayName(), new Item(ItemType.PICKLE));
                put(ItemType.BEER.getDisplayName(), new Item(ItemType.BEER));
            }},
            new HashMap<>(){{
                put(6,new Quest(1,new ReadyItem(ItemType.EGGPLANT,12),new ReadyItem(ItemType.GOLD,750),
                        App.currentGame.getMap().getVillage().getNpss().get("Harvey"),1));
                put(7,new Quest(1,new ReadyItem(ItemType.SALMON,1),new ReadyItem(ItemType.LevelUpFriendship,1),
                        App.currentGame.getMap().getVillage().getNpss().get("Harvey"),2));
                put(8,new Quest(1,new ReadyItem(ItemType.BEER,1),new ReadyItem(ItemType.SALAD,5),
                        App.currentGame.getMap().getVillage().getNpss().get("Harvey"),3));
            }},"Harvey"),

    LEAH(
            new HashMap<>(){{
                put(ItemType.SALAD.getDisplayName(), new Item(ItemType.SALAD));
                put(ItemType.GRAPES.getDisplayName(), new Item(ItemType.GRAPES));
                put(ItemType.BEER.getDisplayName(), new Item(ItemType.BEER));
            }},
            new HashMap<>(){{
                put(9,new Quest(1,new ReadyItem(ItemType.HARD_WOOD,10),new ReadyItem(ItemType.GOLD,500),
                        App.currentGame.getMap().getVillage().getNpss().get("Leah"),1));
                put(10,new Quest(1,new ReadyItem(ItemType.SALMON,1),new ReadyItem(ItemType.SALMON_DINNER,1),
                        App.currentGame.getMap().getVillage().getNpss().get("Leah"),2));
                put(11,new Quest(1,new ReadyItem(ItemType.WOOD,200),new ReadyItem(ItemType.DELUXE_SCARECROW,1),
                        App.currentGame.getMap().getVillage().getNpss().get("Leah"),3));
            }},"Leah"),

    ROBIN(
            new HashMap<>(){{
                put(ItemType.IRON_BAR.getDisplayName(), new Item(ItemType.IRON_BAR));
                put(ItemType.SPAGHETTI.getDisplayName(), new Item(ItemType.SPAGHETTI));
                put(ItemType.WOOD.getDisplayName(), new Item(ItemType.WOOD));
            }},
            new HashMap<>(){{
                put(12,new Quest(1,new ReadyItem(ItemType.WOOD,80),new ReadyItem(ItemType.GOLD,1000),
                        App.currentGame.getMap().getVillage().getNpss().get("Robin"),1));
                put(13,new Quest(1,new ReadyItem(ItemType.IRON_BAR,10),new ReadyItem(ItemType.BEE_HOUSE,3),
                        App.currentGame.getMap().getVillage().getNpss().get("Robin"),2));
                put(14,new Quest(1,new ReadyItem(ItemType.WOOD,1000),new ReadyItem(ItemType.GOLD,25000),
                        App.currentGame.getMap().getVillage().getNpss().get("Robin"),3));
            }},"Robin");
    private final String DisplayName;
    private final Map<String, Item> favorites;
    private final Map<Integer,Quest> quests;
    private ArrayList<Dialog> dialogs; //todo taghir be shey dialog va ezafe kardan ertebaat baa fasl
    private  String job;
    NpcType( Map<String,Item> favorites, Map<Integer,Quest> quest,String names) {
        this.favorites = favorites;
        this.quests =quest;
        this.DisplayName=names;
    }


    public Map<String,Item> getFavorites() {
        return favorites;
    }

    public Map<Integer,Quest> getRequest() {
        return quests;
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

    public String getDisplayName() {
        return DisplayName;
    }

    public Map<Integer, Quest> getQuests() {
        return quests;
    }

}
