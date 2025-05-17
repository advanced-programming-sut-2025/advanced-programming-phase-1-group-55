package model.NPC;

import model.Friendship.FriendShip;
import model.User;

import java.util.HashMap;
import java.util.Map;

public class Npc {
    private  String name;
    private NpcType type;
    private Map<User, FriendShip> friends=new HashMap<>();
    public Npc(NpcType ty){
        this.type=ty;
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
