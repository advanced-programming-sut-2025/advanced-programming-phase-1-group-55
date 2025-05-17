package model;

//import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import enums.CookingItemType;
import enums.CraftingItemType;
import enums.SkillType;
import model.Animal.Animal;
import model.Animal.AnimalBuilding;
import model.CookingItems.CookingItem;
import model.Friendship.Gift;
import model.Friendship.PlayerFriendship;
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
    private int gold = 10000;
    private HashMap<User, PlayerFriendship> friendsPlayer = new HashMap<>();
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
    private int stone;
    private Map<Integer, Gift> receivedGifts = new HashMap<>();
    private Map<User, List<Gift>> sentGifts = new HashMap<>();
    private boolean hasGiftToday = false;
    private boolean hasMessageToday = false;


    public int getStone() {
        return stone;
    }

    public void setStone(int stone) {
        this.stone = stone;
    }
    private Skill farmingSkill = new Skill(SkillType.Farming);
    private Skill miningSkill = new Skill(SkillType.Mining);
    private Skill foragingSkill = new Skill(SkillType.Foraging);
    private Skill fishingSkill = new Skill(SkillType.Fishing);
    private ArrayList<CookingItem> refrigerator = new ArrayList<>();


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
        if (this.energy <= 0) {
            this.energy = 0;
            setFainted(true);
        }
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

    public boolean isHasGiftToday() {
        return hasGiftToday;
    }

    public void setHasGiftToday(boolean hasGiftToday) {
        this.hasGiftToday = hasGiftToday;
    }

    public boolean isHasMessageToday() {
        return hasMessageToday;
    }

    public void setHasMessageToday(boolean hasMessageToday) {
        this.hasMessageToday = hasMessageToday;
    }

    private ArrayList<Trade> userTrades;

    public User(String username, String password, String nickName, String email, String gender, int numberOfSecurityQuestion, String securityQuestion) {
        this.username = username;
        this.password = password;
        this.nickName = nickName;
        this.gender = gender;
        this.email = email;
        this.numberOfSecurityQuestion = numberOfSecurityQuestion;
        this.securityQuestion = securityQuestion;
        this.gold = 10000;
//        this.cookingItem = new CookingItem(CookingItemType.DISH_O_THE_SEA);
        this.refrigerator = new ArrayList<>();

//        learnRecipe(CraftingItemType.FURNACE);
//        learnRecipe(CraftingItemType.SCARECROW);
//        learnRecipe(CraftingItemType.MAYONNAISE_MACHINE);
    }
//    public ArrayList<Item> getRefrigerator() {
//        return refrigerator;
//    }


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

    public HashMap<User, PlayerFriendship> getFriendsPlayer() {
        return friendsPlayer;
    }

    public void setFriendsPlayer(HashMap<User, PlayerFriendship> friendsPlayer) {
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
        this.gold += amount;
    }


    public Map<Integer, Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public void setReceivedGifts(Map<Integer, Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    public void setFarmingSkill(Skill farmingSkill) {
        this.farmingSkill = farmingSkill;
    }

    public void setMiningSkill(Skill miningSkill) {
        this.miningSkill = miningSkill;
    }

    public void setForagingSkill(Skill foragingSkill) {
        this.foragingSkill = foragingSkill;
    }

    public void setFishingSkill(Skill fishingSkill) {
        this.fishingSkill = fishingSkill;
    }

    public void setRefrigerator(ArrayList<CookingItem> refrigerator) {
        this.refrigerator = refrigerator;
    }

    public ArrayList<Trade> getUserTrades() {
        return userTrades;
    }

    public void setUserTrades(ArrayList<Trade> userTrades) {
        this.userTrades = userTrades;
    }

    public Map<User, List<Gift>> getSentGifts() {
        return sentGifts;
    }

    public void setSentGifts(Map<User, List<Gift>> sentGifts) {
        this.sentGifts = sentGifts;
    }

    public Skill getFarmingSkill() {
        return farmingSkill;
    }

    public Skill getMiningSkill() {
        return miningSkill;
    }

    public Skill getForagingSkill() {
        return foragingSkill;
    }

    public Skill getFishingSkill() {
        return fishingSkill;
    }
    public ArrayList<CookingItem> getRefrigerator() {
        if (refrigerator == null) {
            refrigerator = new ArrayList<>();
        }
        return refrigerator;
    }

    public CookingItem getFromRefrigerator(ItemType itemType) {
        for (CookingItem refrigeratorItem : refrigerator) {
            if (refrigeratorItem.getItemType().equals(itemType)) {
                return refrigeratorItem;
            }
        }
        return null;
    }

    public int howManyInRefrigerator(ItemType itemType) {
        for (CookingItem refrigeratorItem : refrigerator) {
            if (refrigeratorItem.getItemType().equals(itemType)) {
                return refrigeratorItem.getNumber();
            }
        }
        return 0;
    }

    public void removeFromRefrigerator(ItemType itemType, int number) {
        for (CookingItem refrigeratorItem : refrigerator) {
            if (refrigeratorItem.getItemType().equals(itemType)) {
                refrigeratorItem.addNumber(-1 * number);
                if (refrigeratorItem.getNumber() <= 0) {
                    refrigerator.remove(refrigeratorItem);
                }
                break;
            }
        }
    }
    public ArrayList<Animal> getAnimals()
    {
        ArrayList<Animal> animals = new ArrayList<>();
        for (AnimalBuilding animalBuilding : farm.getAnimalBuildings())
        {
            for (Animal animal : animalBuilding.getAnimals())
            {
                animals.add(animal);
            }
        }
        return animals;
    }
    public Animal findAnimal(String name)
    {
        for (Animal animal : getAnimals())
        {
            if (animal.getName().equalsIgnoreCase(name))
            {
                return animal;
            }
        }
        return null;
    }
    public boolean validAnimalName(String name)
    {
        for (Animal animal : getAnimals())
        {
            if (animal.getName().equalsIgnoreCase(name))
            {
                return false;
            }
        }
        return true;
    }
    public boolean isNearAnimal(Animal animal)
    {
        for (Animal anim : getAnimals())
        {
            if (anim.getName().equalsIgnoreCase(animal.getName()))
            {
                Tile tile = anim.getTile();

                if (tile == null)
                {
                    return false;
                }

                Location p = tile.getLocation();
                ArrayList<Location> neighbors = currentGame.currentUser.getFarm().getNeighbors(
                        currentGame.currentUser.getLocation());

                for (Location neighbor : neighbors)
                {
                    if (neighbor.equals(p))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }
    public boolean isNear(Location otherLocation)
    {

        Location location = this.location;
        int dx = Math.abs(location.getX() - otherLocation.getX());
        int dy = Math.abs(location.getY() - otherLocation.getY());

        return (dx <= 1 && dy <= 1) && !(dx == 0 && dy == 0);
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
