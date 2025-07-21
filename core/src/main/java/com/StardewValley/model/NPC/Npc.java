package com.StardewValley.model.NPC;

import com.StardewValley.model.Friendship.FriendShip;
import com.StardewValley.model.Item.CollisionRect;
import com.StardewValley.model.User;

import java.util.HashMap;
import java.util.Map;

public class Npc {
    private  String name;
    private NpcType type;
    private Map<User, FriendShip> friends=new HashMap<>();
    private CollisionRect collisionRect;
    private float stateTime = 0f;
    public Npc(NpcType ty){
        this.type=ty;
        collisionRect=new CollisionRect(
            ty.getHouse().getCollisionRect().getX()+ty.getHouse().getCollisionRect().getWidth()/2
            ,ty.getHouse().getCollisionRect().getY()-20
            ,ty.getSprite().getWidth()*2,ty.getSprite().getHeight()*2);
    }

    public CollisionRect getCollisionRect() {
        return collisionRect;
    }

    public void setCollisionRect(CollisionRect collisionRect) {
        this.collisionRect = collisionRect;
    }
    public void update(float delta) {
        stateTime += delta;
    }

    public float getStateTime() {
        return stateTime;
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
