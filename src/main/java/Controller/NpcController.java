package Controller;

import enums.WeatherType;
import model.*;
import model.Friendship.NpcFriendship;
import model.Item.Item;
import model.Map.MainLocation;
import model.NPC.Dialog;
import model.NPC.Npc;
import model.NPC.Quest;
import model.Tool.Tools;

public class NpcController {
    public static String getDialogMessage(int friendshipLevel, WeatherType weather, MainTime time) {
        for (Dialog dialog : App.currentGame.getAllDialogs()) {
            if (dialog.getFriendshipLevel() == friendshipLevel &&
                    dialog.getWeatherType().equals( weather) &&
                    dialog.getMainTime().equals(time)) {
                return dialog.getMessage();
            }
        }
        return "No dialog found for these conditions.";
    }
    public static Boolean npcIsValid(String name){
        return name.equals("Sebastian")||name.equals("Leah")||
                name.equals("Abigail")||name.equals("Harvey")||name.equals("Robin");
    }
    public static Npc findNpc(String name){
        if(name.equals("Sebastian")){
            if (App.currentGame.currentUser.getMainLocation().equals(MainLocation.nearSEBASTIAN)){
                return App.currentGame.getMap().getVillage().getNpss().get(name);
            }
        }if(name.equals("Harvey")){
            if (App.currentGame.currentUser.getMainLocation().equals(MainLocation.nearHARVEY)){
                return App.currentGame.getMap().getVillage().getNpss().get(name);
            }
        }if(name.equals("Abigail")){
            if (App.currentGame.currentUser.getMainLocation().equals(MainLocation.nearABIGAIL)){
                return App.currentGame.getMap().getVillage().getNpss().get(name);
            }
        }if(name.equals("Leah")){
            if (App.currentGame.currentUser.getMainLocation().equals(MainLocation.nearLEAH)){
                return App.currentGame.getMap().getVillage().getNpss().get(name);
            }
        }if(name.equals("Robin")){
            if (App.currentGame.currentUser.getMainLocation().equals(MainLocation.nearROBIN)){
                return App.currentGame.getMap().getVillage().getNpss().get(name);
            }
        }
        return null;
    }
    public Result showFriendships(){
        StringBuilder friends=new StringBuilder();
        for(NpcFriendship friendship:App.currentGame.currentUser.getFriendsNpc().values()){
            friends.append(friendship.toString()).append("\n");
        }
        return new Result(true,friends.toString());
    }
    public Result meetNpc(String name){
        if(!npcIsValid(name)){
            return new Result(false,"npc doesn't exist");
        }
        Npc npc=findNpc(name);
        if(npc==null){
            return new Result(false,"you are not near the "+name+" to speak!");
        }
        String dialog=getDialogMessage(App.currentGame.currentUser.getFriendsNpc().get(name).getLevel()
                , weather.getCurrentWeather(),GameTime.getMainTime());
        NpcFriendship  friendship=App.currentGame.currentUser.getFriendsNpc().get(name);
        if(!friendship.isTodayMet()){
            friendship.increaseXp(20);
            friendship.setTodayMet(true);
        }
        return new Result(true,"i'm "+name+"; "+dialog);
    }
    public Result giftNpc(String name,String item){
        if(!npcIsValid(name)){
            return new Result(false,"npc doesn't exist");
        }
        Npc npc=findNpc(name);
        if(npc==null){
            return new Result(false,"you are not near the "+name+" to gift!");
        }
        for (Tools tools:App.currentGame.currentUser.getBackPack().getAvailableTools().values()){
            if (item.equals(tools.getName())){
                return new Result(false,"you can't gift "+item+" to npc");
            }
        }
        if(!App.currentGame.currentUser.getBackPack().getInventory().containsKey(item)){
            return new Result(false,"you don't have this item");
        }
        Item item1=App.currentGame.currentUser.getBackPack().getInventory().get(item);
        if(!App.currentGame.currentUser.getFriendsNpc().get(name).isTodayHadGift()){
            int amount=50;
            if(npc.getType().isFavorite(item1.getItemType())){
                amount=200;
            }
            App.currentGame.currentUser.getFriendsNpc().get(name).increaseXp(amount);
        }

        App.currentGame.currentUser.getBackPack().removeAmountFromInventory(item1.getItemType(),1);
        return new Result(true,"you gifted "+item+" to your friend "+name);
    }
    public Result showQuests(){
        StringBuilder message=new StringBuilder();
        if(App.currentGame.currentUser.getQuest()==null||App.currentGame.currentUser.getQuest().isEmpty()){
            return new Result(false,"you don't have any active quest");
        }
        for (Quest quest:App.currentGame.currentUser.getQuest().values()){
            message.append(quest.toString()).append("\n");
        }
        return new Result(true,message.toString());
    }
}
