package com.StardewValley.Controller;

import com.StardewValley.View.NpcMenuView;
import com.StardewValley.enums.WeatherType;
import com.StardewValley.model.*;
import com.StardewValley.model.Friendship.NpcFriendship;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Item.ItemType;
import com.StardewValley.model.Map.GameMap;
import com.StardewValley.model.Map.MainLocation;
import com.StardewValley.model.NPC.*;
import com.StardewValley.model.Tool.BackPack;
import com.StardewValley.model.Tool.Tools;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Align;

public class NpcController {
    private User player;
    private GameMap map;
    private final BitmapFont font = new BitmapFont();
    public NpcController (User player, GameMap map) {
        this.player=player;
        this.map=map;
        font.getData().setScale(0.8f);
    }
    public void update(){
        drawNpc(map);
    }
    public void checkIfClickedOnNpc(float x, float y){
        for (Npc npc:map.getVillage().getNpss().values()){
            if (npc.getCollisionRect().isInside(x, y)){
                App.gameApp.setScreen(new NpcMenuView(new NpcMenuController(player,map,npc),npc,player,map));
            }
        }
    }
    public void updateDialog(Npc npc){
        if (!player.getCollisionRect().isNear(npc.getCollisionRect())) {
            npc.getDialogBox().setStatus(DialogStatus.InActive);
        }
        else  {
            if (npc.getDialogBox().getStatus() == DialogStatus.InActive) {
                npc.getDialogBox().setStatus(DialogStatus.Ready);
            }
            if( Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
                if (npc.getDialogBox().getStatus() == DialogStatus.Ready) {
                    npc.getDialogBox().setStatus(DialogStatus.InProgress);
                    return;
                }
            }
            if (npc.getDialogBox().getStatus().equals(DialogStatus.InProgress)&&npc.getDialogBox().update(Gdx.graphics.getDeltaTime())) {
                npc.getDialogBox().setStatus(DialogStatus.InProgress);
            }
        }
        drawDialog(npc);
    }
    public void drawDialog(Npc npc) {
        DialogBox dialog = npc.getDialogBox();
        if (dialog.getStatus().equals(DialogStatus.Ready)) {
            dialog.getSprite().draw(App.gameApp.getBatch());
        } else if (dialog.getStatus().equals(DialogStatus.InProgress)) {
            Sprite sprite = dialog.getSprite();
            sprite.draw(App.gameApp.getBatch());

            GlyphLayout layout = new GlyphLayout();
            float textBoxWidth = sprite.getWidth() - 20f;

            layout.setText(font, dialog.getMessage(), Color.BLACK, textBoxWidth, Align.center, true);

            float textX = sprite.getX() + (sprite.getWidth() - textBoxWidth) / 2f;
            float textY = sprite.getY() + sprite.getHeight() - 20f;

            font.draw(App.gameApp.getBatch(), layout, textX, textY);
        }
    }


    public void drawNpc(GameMap map) {
        for (Npc npc : map.getVillage().getNpss().values()) {
            npc.update(Gdx.graphics.getDeltaTime());
            TextureRegion frame = npc.getType().getAnimation().getKeyFrame(npc.getStateTime(), true);

            float x = npc.getCollisionRect().getX();
            float y = npc.getCollisionRect().getY();
            float width = frame.getRegionWidth() * 2f;
            float height = frame.getRegionHeight() * 2f;

            App.gameApp.getBatch().draw(frame, x, y, width, height);
            updateDialog(npc);
        }

    }
    public static String getDialogMessage(/*int friendshipLevel,*/ WeatherType weather, MainTime time) {
        //todo add friendship effect on dialog after arshia done game setup
        for (Dialog dialog : Dialog.values()) {
            if (//dialog.getFriendshipLevel() == friendshipLevel &&
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
            if (App.currentGameModel.currentUser.getMainLocation().equals(MainLocation.nearSEBASTIAN)){
                return App.currentGameModel.getMap().getVillage().getNpss().get(name);
            }
        }if(name.equals("Harvey")){
            if (App.currentGameModel.currentUser.getMainLocation().equals(MainLocation.nearHARVEY)){
                return App.currentGameModel.getMap().getVillage().getNpss().get(name);
            }
        }if(name.equals("Abigail")){
            if (App.currentGameModel.currentUser.getMainLocation().equals(MainLocation.nearABIGAIL)){
                return App.currentGameModel.getMap().getVillage().getNpss().get(name);
            }
        }if(name.equals("Leah")){
            if (App.currentGameModel.currentUser.getMainLocation().equals(MainLocation.nearLEAH)){
                return App.currentGameModel.getMap().getVillage().getNpss().get(name);
            }
        }if(name.equals("Robin")){
            if (App.currentGameModel.currentUser.getMainLocation().equals(MainLocation.nearROBIN)){
                return App.currentGameModel.getMap().getVillage().getNpss().get(name);
            }
        }
        return null;
    }
    public Result showFriendships(){
        StringBuilder friends=new StringBuilder();
        for(NpcFriendship friendship:App.currentGameModel.currentUser.getFriendsNpc().values()){
            friends.append(friendship.toString()).append("\n");
        }
        return new Result(true,friends.toString());
    }
//    public Result meetNpc(String name){
//        if(!npcIsValid(name)){
//            return new Result(false,"npc doesn't exist");
//        }
//        Npc npc=findNpc(name);
//        if(npc==null){
//            return new Result(false,"you are not near the "+name+" to speak!");
//        }
//        String dialog=getDialogMessage(App.currentGameModel.currentUser.getFriendsNpc().get(name).getLevel()
//                , weather.getCurrentWeather(),GameTime.getMainTime());
//        NpcFriendship  friendship=App.currentGameModel.currentUser.getFriendsNpc().get(name);
//        if(!friendship.isTodayMet()){
//            friendship.increaseXp(20);
//            friendship.setTodayMet(true);
//        }
//        return new Result(true,"i'm "+name+"; "+dialog);
//    }
    public Result giftNpc(String name,String item){
        if(!npcIsValid(name)){
            return new Result(false,"npc doesn't exist");
        }
        Npc npc=findNpc(name);
        if(npc==null){
            return new Result(false,"you are not near the "+name+" to gift!");
        }
        for (Tools tools:App.currentGameModel.currentUser.getBackPack().getAvailableTools().values()){
            if (item.equals(tools.getName())){
                return new Result(false,"you can't gift "+item+" to npc");
            }
        }
        if(!App.currentGameModel.currentUser.getBackPack().getInventory().containsKey(item)){
            return new Result(false,"you don't have this item");
        }
        Item item1=App.currentGameModel.currentUser.getBackPack().getInventory().get(item);
        if(!App.currentGameModel.currentUser.getFriendsNpc().get(name).isTodayHadGift()){
            int amount=50;
            if(npc.getType().isFavorite(item1.getItemType())){
                amount=200;
            }
            App.currentGameModel.currentUser.getFriendsNpc().get(name).increaseXp(amount);
        }

        App.currentGameModel.currentUser.getBackPack().removeAmountFromInventory(item1.getItemType(),1);
        return new Result(true,"you gifted "+item+" to your friend "+name);
    }
    public Result showQuests(){
        StringBuilder message=new StringBuilder();
        if(App.currentGameModel.currentUser.getQuest()==null||App.currentGameModel.currentUser.getQuest().isEmpty()){
            return new Result(false,"you don't have any active quest");
        }
        for (Quest quest:App.currentGameModel.currentUser.getQuest().values()){
            message.append(quest.toString()).append("\n");
        }
        return new Result(true,message.toString());
    }public Result doQuest(int id){
        if(id>14){
            return new Result(false,"the id is not valid");
        }
        if(!App.currentGameModel.currentUser.getQuest().containsKey(id)){
            return new Result(false,"you don't have this quest ");
        }
        Quest quest=App.currentGameModel.currentUser.getQuest().get(id);
        String name=quest.getNpc().getType().getDisplayName();
        if(!npcIsValid(name)){
            return new Result(false,"npc doesn't exist");
        }
        Npc npc=findNpc(name);
        if(npc==null){
            return new Result(false,"you are not near the "+name+" to finish quest!");
        }
        BackPack backPack=App.currentGameModel.currentUser.getBackPack();
        ItemType itemType=quest.getWant().getItem();
        if(!backPack.getInventory().containsKey(itemType.getDisplayName())||
       backPack.getInventory().get(itemType.getDisplayName()).getNumber()<quest.getWant().getAmount()){
            return new Result(false,"you don't have enough item");
        }
        int zarib=1;
        if(App.currentGameModel.currentUser.getFriendsNpc().get(quest.getNpc().getType().getDisplayName()).getLevel()>=2){
            zarib=2;
        }
        if(quest.getReward().getItem().equals(ItemType.LevelUpFriendship)){
            App.currentGameModel.currentUser.getFriendsNpc().get(quest.getNpc().getType().getDisplayName()).increaseXp(201);
        } else if (quest.getReward().getItem().equals(ItemType.GOLD)) {
            App.currentGameModel.currentUser.increaseGold(quest.getReward().getAmount()*zarib);
        }else{
            backPack.addItemToInventory(new Item(quest.getReward().getItem()),quest.getReward().getAmount()*zarib);
        }
        backPack.removeAmountFromInventory(quest.getWant().getItem(),quest.getWant().getAmount());
        for(User user:App.currentGameModel.playersInGame){
            user.getQuest().remove(quest.getId());
        }
        quest.setHasAlreadyFinished(true);
        return new Result(true,"quest successfully finished");
    }

    public User getPlayer() {
        return player;
    }

    public void setPlayer(User player) {
        this.player = player;
    }
}
