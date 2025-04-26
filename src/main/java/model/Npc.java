package model;

import enums.NpcType;

import java.util.HashMap;
import java.util.Map;

public class Npc {
    private  String name;
    private NpcType type;
    //mahal sokunat ezaafe beshe
    private Map<User,FriendShip> friends=new HashMap<>(); // miroonim badan ye shey friendship tarif konim
    public Npc(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NpcType getType() {
        return type;
    }

    public void setType(NpcType type) {
        this.type = type;
    }

    public Map<User,FriendShip> getFriends() {
        return friends;
    }

    public void setFriends(Map<User,FriendShip> friends) {
        this.friends = friends;
    }
    public  void receiveGift(){

    }
    public  void  sendGift(){

    }
}
