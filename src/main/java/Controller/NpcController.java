package Controller;

import enums.WeatherType;
import model.*;
import model.Friendship.NpcFriendship;
import model.Map.MainLocation;
import model.NPC.Dialog;
import model.NPC.Npc;

public class NpcController {
    public static String getDialogMessage(int friendshipLevel, WeatherType weather, MainTime time) {
        for (Dialog dialog : App.currentGame.getAllDialogs()) {
            if (dialog.getFriendshipLevel() == friendshipLevel &&
                    dialog.getWeatherType().equals( weather) &&
                    dialog.getMainTime().equals(time)) {
                System.out.println(weather.name());
                System.out.println(time.name());
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
}
