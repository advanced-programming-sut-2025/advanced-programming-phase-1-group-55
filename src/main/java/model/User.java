package model;

import model.Map.Location;
import model.Map.Tile;
import model.NPC.Npc;
import model.Tool.BackPack;

import java.util.*;

import static model.Game.mainUser;

public class User {
    private String username;
    private String password;
    private String nickName;
    private String gender;
    private String email;
    private int numberOfSecurityQuestion;
    private String securityQuestion;
    private BackPack backPack;
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
        int startX = mainUser.getLocation().getX();
        int startY = mainUser.getLocation().getY();

        List<Tile> path = bfs(startX, startY, targetX, targetY, map);

        if (path == null || path.isEmpty()) {
            System.out.println("there is no path");
            return;
        }

        int distance = path.size() - 1;
        System.out.println("turns :" + countTurns(path));
        int energyNeeded = (int) Math.ceil((distance + 10 * countTurns(path)) / 20.0);

        System.out.println("path found :)   distance : " + distance + " needed energy :  " + energyNeeded);
        if (mainUser.getEnergy() >= energyNeeded) {
            System.out.println("are you sure you want to move (yes/no)");
            Scanner scanner = new Scanner(System.in);
            String confirm = scanner.nextLine().trim().toLowerCase();

            if (confirm.equals("yes")) {
                mainUser.setEnergy(mainUser.getEnergy() - energyNeeded);
                mainUser.getLocation().setX(targetX);
                mainUser.getLocation().setY(targetY);
                System.out.println("you moved successfully remained energy : " + mainUser.getEnergy());
            } else {
                System.out.println("move canceled! ");
            }
        } else {
            mainUser.setFainted(true);
            System.out.println("you dont have enough energy needed energy : " + energyNeeded + "current energy : " + mainUser.getEnergy());
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


}
