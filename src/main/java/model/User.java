package model;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String nickName;
    private String gender;
    private String email;
    private int energy = 200;
    private ArrayList<Trade> userTrades;

    public void addTrade(Trade trade) {
        userTrades.add(trade);
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        energy = energy;
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
}
