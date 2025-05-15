package model;

import enums.CraftingItemType;
import model.CookingItems.CookingItem;
import model.Item.Item;
import model.Item.ItemType;
import model.Map.Farm;
import model.Map.Location;
import model.Map.MainLocation;
import model.Map.Tile;
import model.NPC.Npc;
import model.Tool.BackPack;

import java.util.*;

import static model.App.currentGame;
import static model.App.mainUser;

public class User {
    private String username;
    private String password;
    private String nickName;
    private String gender;
    private String email;
    private int numberOfSecurityQuestion;
    private String securityQuestion;
    private BackPack backPack = new BackPack();
    private User wife = null;
    private HashMap<String, Npc> friendsNpc = new HashMap<>();
    private HashMap<String, User> friendsPlayer = new HashMap<>();
    private static int gold = 10000;
    private int dailyMoney = 0;
    private int wood;
    private double energy = 200;
    private boolean stayLoggedIn = false;
    private int mostAchievedMoney = 0;
    private int matchPlayed = 0;
    private Location location = new Location(0, 0);//todo ino bayad bokonm location aval farmesh
    private boolean fainted = false;
    private Location playerTommorowLocation;
    private Game playedGame;
    private Farm farm;
    private MainLocation mainLocation = MainLocation.House;
    private HashMap<Integer, Trade> trades = new HashMap<>();
    private CookingItem cookingItem;

    public HashMap<Integer, Trade> getTrades() {
        return trades;
    }

    public void setTrades(HashMap<Integer, Trade> trades) {
        this.trades = trades;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public Game getPlayedGame() {
        return playedGame;
    }

    public void setPlayedGame(Game playedGame) {
        this.playedGame = playedGame;
    }


    public Location getPlayerTommorowLocation() {
        return playerTommorowLocation;
    }

    public void setPlayerTommorowLocation(Location playerTommorowLocation) {
        this.playerTommorowLocation = playerTommorowLocation;
    }

    public boolean isFainted() {
        return fainted;
    }

    public void setFainted(boolean fainted) {
        this.fainted = fainted;
    }

    public void decreaseEnergy(int amount) {

        this.energy = Math.max(0, this.energy - amount);
    }

    public void increaseEnergy(int amount) {
        this.energy += amount;
        this.energy = Math.min(200, energy);
    }

    public int getWood() {
        return wood;
    }

    public void setWood(int wood) {
        this.wood = wood;
    }

    public int getMostAchievedMoney() {
        return mostAchievedMoney;
    }

    public void setMostAchievedMoney(int mostAchievedMoney) {
        this.mostAchievedMoney = mostAchievedMoney;
    }

    public int getMatchPlayed() {
        return matchPlayed;
    }

    public void setMatchPlayed(int matchPlayed) {
        this.matchPlayed = matchPlayed;
    }

    public boolean isStayLoggedIn() {
        return stayLoggedIn;
    }

    public void setStayLoggedIn(boolean stayLoggedIn) {
        this.stayLoggedIn = stayLoggedIn;
    }

    public int getNumberOfSecurityQuestion() {
        return numberOfSecurityQuestion;
    }

    public void setNumberOfSecurityQuestion(int numberOfSecurityQuestion) {
        this.numberOfSecurityQuestion = numberOfSecurityQuestion;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    private ArrayList<Trade> userTrades;

    public User(String username, String password, String nickName, String gender, String email, int numberOfSecurityQuestion, String securityQuestion) {
        this.username = username;
        this.password = password;
        this.nickName = nickName;
        this.gender = gender;
        this.email = email;
        this.numberOfSecurityQuestion = numberOfSecurityQuestion;
        this.securityQuestion = securityQuestion;
//        learnRecipe(CraftingItemType.FURNACE);
//        learnRecipe(CraftingItemType.SCARECROW);
//        learnRecipe(CraftingItemType.MAYONNAISE_MACHINE);
    }

    public void addTrade(Trade trade) {
        userTrades.add(trade);
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energys) {
        energy = energys;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BackPack getBackPack() {
        return backPack;
    }

    public void setBackPack(BackPack backPack) {
        this.backPack = backPack;
    }

    public User getWife() {
        return wife;
    }

    public void setWife(User wife) {
        this.wife = wife;
    }

    public HashMap<String, Npc> getFriendsNpc() {
        return friendsNpc;
    }

    public void setFriendsNpc(HashMap<String, Npc> friendsNpc) {
        this.friendsNpc = friendsNpc;
    }

    public HashMap<String, User> getFriendsPlayer() {
        return friendsPlayer;
    }

    public void setFriendsPlayer(HashMap<String, User> friendsPlayer) {
        this.friendsPlayer = friendsPlayer;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ArrayList<Trade> getUserTrades() {
        return userTrades;
    }

    public void setUserTrades(ArrayList<Trade> userTrades) {
        this.userTrades = userTrades;
    }

    public CookingItem getCookingItem() {
        return cookingItem;
    }

    public void setCookingItem(CookingItem cookingItem) {
        this.cookingItem = cookingItem;
    }

    public MainLocation getMainLocation() {
        mainLocation = MainLocation.findLocation(location);
        return mainLocation;
    }

    public void setMainLocation(MainLocation mainLocation) {
        this.mainLocation = mainLocation;
    }

    public int getDailyMoney() {
        return dailyMoney;
    }

    public void setDailyMoney(int dailyMoney) {
        this.dailyMoney = dailyMoney;
    }

    public void increaseDailyMoney(int amount) {
        dailyMoney += amount;
    }

    public void increaseGold(int amount) {
        gold += amount;
    }
    //    public void learnRecipe(CraftingItemType recipe) {
//        learnedCraftingRecipes.add(recipe);
//    }
//
//    public boolean hasLearnedRecipe(CraftingItemType recipe) {
//        return learnedCraftingRecipes.contains(recipe);
//    }
//
//    public Set<CraftingItemType> getLearnedCraftingRecipes() {
//        return Collections.unmodifiableSet(learnedCraftingRecipes);
//    }


}
