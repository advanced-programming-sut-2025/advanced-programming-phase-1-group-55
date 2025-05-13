package model;

import enums.CraftingItemType;
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
    private int gold;
    private int wood;
    private int Money;
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

    private Set<CraftingItemType> learnedCraftingRecipes = new HashSet<>();


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

    public int getMoney() {
        return Money;
    }

    public void setMoney(int money) {
        Money = money;
    }


    public void decreaseEnergy(int amount) {
        this.energy -= amount;
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

    public MainLocation getMainLocation() {
        mainLocation = MainLocation.findLocation(location);
        return mainLocation;
    }

    public void setMainLocation(MainLocation mainLocation) {
        this.mainLocation = mainLocation;
    }

    private int countTurns(List<Tile> path) {
        if (path == null || path.size() < 3) return 0;

        int turns = 0;
        int prevDx = path.get(1).getLocation().getX() - path.get(0).getLocation().getX();
        int prevDy = path.get(1).getLocation().getY() - path.get(0).getLocation().getY();

        for (int i = 2; i < path.size(); i++) {
            int currDx = path.get(i).getLocation().getX() - path.get(i - 1).getLocation().getX();
            int currDy = path.get(i).getLocation().getY() - path.get(i - 1).getLocation().getY();

            if (currDx != prevDx || currDy != prevDy) {
                turns++;
            }

            prevDx = currDx;
            prevDy = currDy;
        }

        return turns / 10;
    }


    public void moveTo(int targetX, int targetY, Tile[][] map) {
        int startX = currentGame.currentUser.getLocation().getX();
        int startY = currentGame.currentUser.getLocation().getY();

        List<Tile> path = bfs(startX, startY, targetX, targetY, map);

        if (path == null || path.isEmpty()) {
            System.out.println("there is no path");
            return;
        }

        int distance = path.size() - 1;
        System.out.println("turns :" + countTurns(path));
        int energyNeeded = (int) Math.ceil((distance + 10 * countTurns(path)) / 20.0);

        System.out.println("path found :)   distance : " + distance + " needed energy :  " + energyNeeded);
        if (currentGame.currentUser.getEnergy() >= energyNeeded) {
            System.out.println("are you sure you want to move (yes/no)");
            Scanner scanner = new Scanner(System.in);
            String confirm = scanner.nextLine().trim().toLowerCase();

            if (confirm.equals("yes")) {
                currentGame.currentUser.setEnergy(currentGame.currentUser.getEnergy() - energyNeeded);
                playerTommorowLocation = new Location(targetY, targetX);

                System.out.println("you moved successfully remained energy : " + currentGame.currentUser.getEnergy());
            } else {
                System.out.println("move canceled! ");
            }
        } else {
            currentGame.currentUser.setFainted(true);
            System.out.println("you dont have enough energy needed energy : " + energyNeeded + "current energy : " + currentGame.currentUser.getEnergy());
        }
    }

    private List<Tile> bfs(int startX, int startY, int endX, int endY, Tile[][] map) {
        int n = map.length;
        int m = map[0].length;

        boolean[][] visited = new boolean[n][m];
        Tile[][] parent = new Tile[n][m];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == endX && y == endY) {
                List<Tile> path = new ArrayList<>();
                Tile step = map[x][y];
                while (step != null) {
                    path.add(0, step);
                    int px = step.getLocation().getX();
                    int py = step.getLocation().getY();
                    step = parent[px][py];
                }
                return path;
            }

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && map[nx][ny].isWalkable()) {
                    visited[nx][ny] = true;
                    parent[nx][ny] = map[x][y];
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return null;
    }

    private ArrayList<CraftingItemType> craftingRecipes = new ArrayList<>();

    public void setCraftingRecipes(ArrayList<CraftingItemType> craftingRecipes) {
        this.craftingRecipes = craftingRecipes;
    }

    public Set<CraftingItemType> getLearnedCraftingRecipes() {
        return learnedCraftingRecipes;
    }

    public void setLearnedCraftingRecipes(Set<CraftingItemType> learnedCraftingRecipes) {
        this.learnedCraftingRecipes = learnedCraftingRecipes;
    }

    public ArrayList<CraftingItemType> getCraftingRecipes() {
        return craftingRecipes;
    }

    public void learnRecipe(CraftingItemType recipe) {
        if (!craftingRecipes.contains(recipe)) {
            craftingRecipes.add(recipe);
        }
    }

    public Map<String,Item> getInventory() {
        return backPack.getInventory();
    }

    public Item getItemInInventory(ItemType itemType) {
        for (Item item : this.backPack.getInventory().values()) {
            if (item.getItemType().equals(itemType)) {
                return item;
            }
        }
        return null;
    }

    public boolean inventoryHasCapacity() {
        int capacity = backPack.getSize();
        int currentSize = backPack.getInventory().size();

        return currentSize < capacity;
    }

    public void addToInventory(Item item) {
        backPack.getInventory().put(item.getItemType().getDisplayName(),item);
    }

    public void addItemToInventory(ItemType itemType, int quantity) {
        Item item = getItemInInventory(itemType);
        if (item != null) {
            item.addNumber(quantity);
        } else {
            if (inventoryHasCapacity()) {
                Item newItem = new Item(itemType, quantity);
                backPack.getInventory().put(newItem.getItemType().getDisplayName(),newItem);
            }
        }
    }

    public int getInventoryCapacity() {
        int capacity = backPack.getSize();
        if (capacity == -1) {
            return -1;
        }
        return capacity - backPack.getInventorySize();
    }

    public boolean hasEnoughInInventory(ItemType itemType, int quantity) {
        for (Item item : backPack.getInventory().values()) {
            if (item.getItemType().equals(itemType) && item.getNumber() >= quantity) {
                return true;
            }
        }
        return false;
    }

    public int howManyInInventory(ItemType itemType) {
        for (Item item : backPack.getInventory().values()) {
            if (item.getItemType().equals(itemType)) {
                return item.getNumber();
            }
        }
        return 0;
    }

    public void removeAmountFromInventory(ItemType itemType, int quantity) {
        for (Item item : backPack.getInventory().values()) {
            if (item.getItemType().equals(itemType)) {
                item.addNumber(-quantity);
                if (item.getNumber() <= 0) {
                    this.backPack.getInventory().remove(item.getItemType().getDisplayName());
                }
                break;
            }
        }
    }
    public void removeItemFromInventory(Item item) {
        if (this.backPack.getInventory().containsKey(item.getItemType().getDisplayName())) {
            item.addNumber(-1);
            if (item.getNumber() == 0) {
                this.backPack.getInventory().remove(item.getItemType().getDisplayName());
            }
        }
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
