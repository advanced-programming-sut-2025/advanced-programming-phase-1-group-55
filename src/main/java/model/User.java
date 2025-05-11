package model;

import model.NPC.Npc;
import model.Tool.BackPack;

import java.util.ArrayList;
import java.util.HashMap;

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
    private int money;
    private int energy = 200;
    private boolean stayLoggedIn = false;
    private int mostAchievedMoney = 0;
    private int matchPlayed = 0;

    public boolean isFainted(int amount) {
        return this.energy - amount <= 0;
    }

    public void decreaseEnergy(int amount) {
        this.energy -= amount;
        this.energy = Math.max(0, this.energy - amount);
    }

    public void increaseEnergy(int amount) {
        this.energy += amount;
        this.energy = Math.min(200, energy);
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

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energys) {
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public ArrayList<Trade> getUserTrades() {
        return userTrades;
    }

    public void setUserTrades(ArrayList<Trade> userTrades) {
        this.userTrades = userTrades;
    }
}
