package com.StardewValley.Controller;


import com.StardewValley.View.ChooseArtisanMenuView;
import com.StardewValley.View.MainGameGraphicView;
import com.StardewValley.View.PauseMenuView;
import com.StardewValley.model.App;
import com.StardewValley.model.Artisan.ArtisanMachine;
import com.StardewValley.model.Artisan.ArtisanMachineType;
import com.StardewValley.model.Item.CollisionRect;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Map.*;
import com.StardewValley.enums.WeatherType;
import com.StardewValley.model.NPC.Npc;
import com.StardewValley.model.Store.ShippingBin;
import com.StardewValley.model.Store.Store;
import com.StardewValley.model.Tool.Tools;
import com.StardewValley.model.Tool.Trashcan;
import com.StardewValley.model.Tool.WateringCan;
import com.StardewValley.model.Result;



import static com.StardewValley.model.Item.ItemType.*;

import com.StardewValley.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;

import static com.StardewValley.model.weather.*;


import static com.StardewValley.model.App.*;
import static com.StardewValley.model.GameTime.*;

public class MainGameController {
    private MainGameGraphicView view;
    private PlayerController playerController;
    private ToolController toolController;
    private NpcController npcController;
    private StoresStatusController storeController;
    private User currentPlayer;
    public void setView(MainGameGraphicView view) {
        this.view = view;
        currentPlayer=view.getPlayer();
       //todo ino bade zadan menu haa tavasot arshia ok kn
        // currenPlayer=App.currentplayer
        playerController=new PlayerController(currentPlayer);
        toolController=new ToolController(currentPlayer);
        npcController=new NpcController(currentPlayer,view.getMap());
        storeController=new StoresStatusController(currentPlayer,view.getMap());
        currentPlayer.setGold(5000);
    }
    public boolean canPlace(Sprite sprite,float x,float y) {
        CollisionRect collisionRect=new CollisionRect(x,y,sprite.getWidth(),sprite.getHeight());
        if (x>view.getMap().getWORLD_WIDTH()/2||x<-view.getMap().getWORLD_WIDTH()/2||
            y>view.getMap().getWORLD_HEIGHT()/2||y<-view.getMap().getWORLD_HEIGHT()/2) {
            return false;
        }
        for(Fence fence:view.getMap().getFences()){
            if (collisionRect.collidesWith(fence.getCollisionRect())){
                return false;
            }
        }
        for (Store store:view.getMap().getVillage().getStores().values()){
            if (collisionRect.collidesWith(store.getCollisionRect())){
                return false;
            }
        }
        for (Npc npc:view.getMap().getVillage().getNpss().values()){
            if (collisionRect.collidesWith(npc.getCollisionRect())){
                return false;
            }
            if (collisionRect.collidesWith(npc.getType().getHouse().getCollisionRect())){
                return false;
            }
        }
        for (ShippingBin bin :view.getMap().getVillage().getShippingBins()){
            if (collisionRect.collidesWith(bin.getCollisionRect())){
                return false;
            }
        }
        for (ArtisanMachine artisanMachine:view.getMap().getArtisanMachines()){
            if (artisanMachine.getCollisionRect().collidesWith(collisionRect)) {
                return false;
            }
        }
        return true;
    }
    public void choosingPlace(float x,float y){
        Sprite sprite =view.getChosenArtisanSprite();
        sprite.setPosition(x,y);
        if (canPlace(sprite,x,y)){
            sprite.setColor(Color.GREEN);
        }else {
            sprite.setColor(Color.RED);
        }
    }
    public void handleInput() {
        //todo handle if the gate was not your farm gate -->>message box -->>send error -->> you can not enter other player,s farm
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            passTheGate();
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.P)){
            gameApp.setScreen(new PauseMenuView(new PauseMenuController(),currentPlayer));
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.K)) {
            gameApp.setScreen(new ChooseArtisanMenuView(currentPlayer,view.getMap(),new ChooseArtisanController(currentPlayer,view.getMap())));
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.J)) {
            if (view.isChoosingPlace()){
                if (view.getChosenArtisanSprite().getColor().equals(Color.GREEN)) {
                    Sprite sprite =new Sprite(view.getChosenArtisanSprite());
                    ArtisanMachine artisanMachine=new ArtisanMachine(view.getChosenArtisanType(),currentPlayer,
                        new CollisionRect(sprite.getX(),sprite.getY(),sprite.getWidth(),sprite.getHeight()));
                    view.getMap().getArtisanMachines().add(artisanMachine);
                    view.setChoosingPlace(false);
                }
            }
        }
    }

    private void passTheGate() {
        for (Fence fence : view.getMap().fences) {
            if (fence.getFenceType().equals(FenceType.door)) {
                float playerX = playerController.getPlayer().getCollisionRect().getX();
                float playerY = playerController.getPlayer().getCollisionRect().getY();

                float fenceX = fence.getCollisionRect().getX();
                float fenceY = fence.getCollisionRect().getY();

                float dx = playerX - fenceX;
                float dy = playerY - fenceY;
                float distance = (float)Math.sqrt(dx * dx + dy * dy);

                if (distance < 60) {
                    if (playerX < fenceX) {
                        playerController.getPlayer().getLocation().setX((int)playerX + 75);
                    } else {
                        playerController.getPlayer().getLocation().setX((int)playerX - 75);
                    }


                    playerController.getPlayer().getCollisionRect().updateCollisionRect(
                        playerController.getPlayer().getLocation().getX(),
                        playerController.getPlayer().getLocation().getY()
                    );
                    return;
                }
            }
        }
    }

    public void updateGame(float delta) {
        if (view != null) {
            handleInput();
            playerController.update();
            toolController.update(delta);
            npcController.update();
        }
    }
    public Result equipToolFromBackPack(String toolsName) {
        if (currentGameModel.currentUser.getBackPack() == null || !currentGameModel.currentUser.getBackPack().getAvailableTools().containsKey(toolsName)) {
            return new Result(false, "you don't have this tool :(");
        }
        currentGameModel.currentUser.getBackPack().setCurrentTool(currentGameModel.currentUser.getBackPack().getAvailableTools().get(toolsName));
        return new Result(true, "you equipped " + toolsName);
    }

    public Result showCurrentTools() {
        return new Result(true, currentGameModel.currentUser.getBackPack().showCurrentTool());
    }

    public Result showAvailableTools() {
        if (currentGameModel.currentUser.getBackPack() == null || currentGameModel.currentUser.getBackPack().getAvailableTools().isEmpty()) {
            return new Result(false, "your backpackis empty:(");
        }
        return new Result(true, currentGameModel.currentUser.getBackPack().showAvailableTools());
    }

    public Result time() {

        return new Result(true, String.valueOf(getHour()));
    }

    public Result date() {
        StringBuilder sb = new StringBuilder();
        sb.append(getDayofMonth()).append(" of ").append(getSeason());

        return new Result(true, sb.toString());
    }

    public Result dateTime() {
        StringBuilder sb = new StringBuilder();
        sb.append("hour : ").append(getHour()).append("\nday : ").append(getDay()).append("\nseason : ").append(getSeason());
        return new Result(true, sb.toString());
    }

    public Result dayOfWeek() {

        return new Result(true, getDay().toString());
    }

    public Result cheatHour(String X) {
        int hour;
        try {
            hour = Integer.parseInt(X);
        } catch (Exception e) {
            return new Result(false, "invalid cheat hour");
        }
        increaseHour(hour);
        return new Result(true, "cheat hour " + hour + " confirmed");
    }

    public Result cheatDay(String X) {
        int Day;
        try {
            Day = Integer.parseInt(X);
        } catch (Exception e) {
            return new Result(false, "invalid cheat Day");
        }
        increaseDay(Day);
        return new Result(true, "cheat Day " + Day + " confirmed");
    }

    public Result cheatThor(String X, String Y) {
        int x, y;

        try {
            x = Integer.parseInt(X);
            y = Integer.parseInt(Y);
        } catch (Exception e) {
            return new Result(false, "invalid cheat Thor");
        }
        if (currentGameModel.getMap().tiles[y][x].getMohtaviat().equals("T")) {
            currentGameModel.getMap().tiles[y][x].setMohtaviat("Z");
            currentGameModel.getMap().tiles[y][x].setItemInThisTile(new Item(COAL));

        }
        return new Result(true, "cheat Thor " + x + " " + y + " confirmed");

    }

    public Result season() {
        return new Result(true, String.valueOf(getSeason()));
    }

    public Result showEnergy() {
        return new Result(true, "your energy : " + currentGameModel.currentUser.getEnergy());
    }

    public Result setEnergy(String energy) {
        try {
            currentGameModel.currentUser.setEnergy(Integer.parseInt(energy));
        } catch (Exception e) {
            return new Result(false, "invalid energy");
        }
        return new Result(true, "your energy set to " + energy);

    }

    public Result unlimitedEnergy() {
        currentGameModel.currentUser.setEnergy(Double.MAX_VALUE * 2);
        return new Result(true, "your energy unlimited");
    }

    public Result weather() {
        return new Result(true, getCurrentWeather().name());
    }

    public Result weatherForecast() {
        return new Result(true, getTomorrowWeather().name());
    }

    public Result weatherCheat(String type) {
        if (type.equals("Sunny")) {
            setTomorrowWeather(WeatherType.Sunny);
        } else if (type.equals("Rain")) {
            setTomorrowWeather(WeatherType.Rain);
        } else if (type.equals("Storm")) {
            setTomorrowWeather(WeatherType.Storm);
            System.out.println(RandomThor());
        } else if (type.equals("Snow")) {
            setTomorrowWeather(WeatherType.Snow);
        } else {
            return new Result(false, "invalid weather type");
        }
        return new Result(true, "weather successfully changed to : " + getTomorrowWeather().name());
    }

    public Result levelUpTool(String name) {
        Tools tool = currentGameModel.currentUser.getBackPack().getAvailableTools().get(name);
        if (!currentGameModel.currentUser.getMainLocation().equals(MainLocation.BlackSmithStore)) {
            return new Result(false, "you should go to blacksmith store to upgrade your tool!");
        }
        if (tool.getLevel() == 5) {
            return new Result(false, "level of your tool is max , you can't upgrade it !");
        }

        if (name.equals("trashcan")) {
            Trashcan can = currentGameModel.currentUser.getBackPack().getTrashcan();
            if (can.getPriceToLevelUp() > currentGameModel.currentUser.getGold()) {
                return new Result(false, "you don't have enough money to levelUp your tool");
            } else {
                currentGameModel.currentUser.setGold(currentGameModel.currentUser.getGold() - can.getPriceToLevelUp());
                can.increaseLevel(1);
            }
        } else if (tool instanceof WateringCan can) {
            if (can.getPriceToLevelUp() > currentGameModel.currentUser.getGold()) {
                return new Result(false, "you don't have enough money to levelUp your tool");
            } else {
                currentGameModel.currentUser.setGold(currentGameModel.currentUser.getGold() - can.getPriceToLevelUp());
                can.increaseLevel(1);
            }
        } else {
            if (tool.getPriceToLevelUp() > currentGameModel.currentUser.getGold()) {
                return new Result(false, "you don't have enough money to levelUp your tool");
            } else {
                currentGameModel.currentUser.setGold(currentGameModel.currentUser.getGold() - tool.getPriceToLevelUp());
                tool.increaseLevel(1);
            }
        }
        return new Result(true, name + " upgraded successfully");
    }

    public Result helpReadMap() {
        String message = "";
        message += "T: trees\n&: Foraging Crobs\n*: Foraging Seeds\nh: house area\n#: walls\n" +
                "=: doors\ng: greenhouse area\n" + "W: water area(lake)\n^: quarry area\n" +
                "0: rocks\n$: starDropSaloon\ns: SEBASTIAN's house\n" + "B: blacksmith store\n" +
                "O: ojaMart store\nA: ABIGAIL's house\nH: HARVEY's house\n" + "L: LEAH's house\n" +
                "R: ROBIN's house\n" + "G: General store\nC: Carpenter Shop\nF: fish store\nM: marnieRanch store";
        return new Result(true, message);
    }

    public Result showFullMap() {
        return new Result(true, currentGameModel.getMap().printMap(new Location(0, 0), 160, 41));
    }

    public Result showMap(int x, int y, int size) {
        return new Result(true, currentGameModel.getMap().printMap(new Location(y, x), size, size));
    }

    //cheat code baraye test map hamintori zadam trlrport kone;
    public Result teleport(int x, int y) {
        currentGameModel.currentUser.setLocation(new Location(y, x));
        return new Result(true, " you teleported to " + "y:" + y + " x:" + x);
    }

    public Result buildGreenHouse() {
        User user = currentGameModel.currentUser;
        if (user.getGold() < 1000 || user.getBackPack().getInventory().get("wood") == null || user.getBackPack().getInventory().get("wood").getNumber() < 500) {
            return new Result(false, "you dont have enough material to build green house");
        } else {

            user.setGreenHouse(user.getFarm().getGreenHouse());
            user.getGreenHouse().setRepaired(true);
            user.increaseGold(-1000);
            user.getBackPack().getInventory().get("wood").addNumber(-500);
            return new Result(true, "green house build successfully");
        }
    }

    public Result showOwner(int x, int y) {
        if (currentGameModel.getMap().tiles[y][x].getOwner() == null) {
            return new Result(false, "Default tile");
        }
        return new Result(true, "this tile is in " + currentGameModel.getMap().tiles[y][x].getOwner().getUsername() + "'s farm" + "Mohtaviat :" + currentGameModel.getMap().tiles[y][x].getMohtaviat());
    }

    public Result changePlayer(String username) {
        User user = FriendshipController.findUser(username);
        if (user == null) {
            return new Result(false, "user not found!");
        }
        currentGameModel.currentUser = user;
        StringBuilder message = new StringBuilder();
        if (currentGameModel.currentUser.isHasGiftToday()) {
            message.append("you received new gift!\n");
            currentGameModel.currentUser.setHasGiftToday(false);
        }
        if (currentGameModel.currentUser.isHasMessageToday()) {
            message.append("you received new message!");
            currentGameModel.currentUser.setHasMessageToday(false);
        }
        return new Result(true, username + " is now the main player\n" + message);
    }

    public Result trashItem(String name, int amount) {
        if (!App.currentGameModel.currentUser.getBackPack().getInventory().containsKey(name)) {
            return new Result(false, "you don't have this item");
        }
        Item item = App.currentGameModel.currentUser.getBackPack().getInventory().get(name);
        if (item.getNumber() < amount) {
            return new Result(false, "you don't have enough item to trash");
        }

        if (item.getPrice()==0) {
            item.setPrice(150);
        }
        App.currentGameModel.currentUser.getBackPack().removeAmountFromInventory(item.getItemType(), amount);
        double sum=(amount * item.getPrice() * currentGameModel.currentUser.getBackPack().getTrashcan().getRatio());
        App.currentGameModel.currentUser.increaseGold
                ((int) (sum/100));
        return new Result(true, "you sold " + name + "successfully!");
    }

    public NpcController getNpcController() {
        return npcController;
    }

    public void setNpcController(NpcController npcController) {
        this.npcController = npcController;
    }

    public MainGameGraphicView getView() {
        return view;
    }

    public PlayerController getPlayerController() {
        return playerController;
    }

    public ToolController getToolController() {
        return toolController;
    }

    public void setToolController(ToolController toolController) {
        this.toolController = toolController;
    }

    public User getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(User currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setPlayerController(PlayerController playerController) {
        this.playerController = playerController;
    }

    public StoresStatusController getStoreController() {
        return storeController;
    }

    public void setStoreController(StoresStatusController storeController) {
        this.storeController = storeController;
    }
}
