package Controller;

import model.Friendship.PlayerFriendship;
import model.Item.Item;
import model.Item.ItemType;
import model.Map.Location;
import model.Result;
import model.User;

import java.util.ArrayList;

import static java.lang.Math.max;
import static model.App.*;

public class FriendshipController {
    public static User findUser(String username){
        for(User user:currentGame.playersInGame){
            if (username.equals(user.getUsername())){
                return user;
            }
        }
        return null;
    }
    public Result showFriends(){
        StringBuilder message=new StringBuilder();
        for (PlayerFriendship friendship:currentGame.currentUser.getFriendsPlayer().values()){
            User friend=friendship.getUser1().equals(currentGame.currentUser)?friendship.getUser2():friendship.getUser1();
            message.append("Friend name: ").append(friend.getUsername())
            .append("  level: ").append(friendship.getLevel())
                    .append(" xp: ").append(friendship.getXp());
            message.append("\n----------------------------------\n");
        }
        return new Result(true,message.toString());
    }
    public boolean locationsAreNear(Location location1, Location location2) {
        int dx = Math.abs(location1.getX() - location2.getX());
        int dy = Math.abs(location1.getY() - location2.getY());

        return (dx <= 1 && dy <= 1) ;
    }

    public Result talk(String username,String message){
        User user=findUser(username);
        if(user==null){
            return  new Result(false,"user not found!");
        }
        if(!locationsAreNear(user.getLocation(),currentGame.currentUser.getLocation())){
            return  new Result(false,"you must be near the other player to talk!");
        }
        currentGame.currentUser.getFriendsPlayer().get(user).getConversation().add(message);
        if(!user.getFriendsPlayer().get(currentGame.currentUser).isTodayTalked()){
            user.getFriendsPlayer().get(currentGame.currentUser).increaseXp(20);
            user.getFriendsPlayer().get(currentGame.currentUser).setTodayTalked(true);
        }
        user.setHasMessageToday(true);
        return new Result(true,"message successfully sent to : "+username);
    }
    public Result showTalkHistory(String username){
        User user=findUser(username);
        StringBuilder conversation=new StringBuilder();
        if(user==null){
            return  new Result(false,"user not found!");
        }
        for (String message:currentGame.currentUser.getFriendsPlayer().get(user).getConversation()){
            conversation.append(message).append("\n");
        }
        return new Result(true,conversation.toString());
    }
    public Result hug(String username){
        User user=findUser(username);
        if(user==null){
            return  new Result(false,"user not found!");
        }
        if(!locationsAreNear(user.getLocation(),currentGame.currentUser.getLocation())){
            return  new Result(false,"you must be near the other player to hug!");
        }
        if(user.getFriendsPlayer().get(currentGame.currentUser).getLevel()<2){
            return new Result(false,"your friendship level must be more than 2 , to hug each other");
        }
        user.getFriendsPlayer().get(currentGame.currentUser).increaseXp(60);
        return new Result(true,"you huged each other :>");
    }public Result sendFlower(String username){
        User user=findUser(username);
        if(user==null){
            return  new Result(false,"user not found!");
        }
        if(!locationsAreNear(user.getLocation(),currentGame.currentUser.getLocation())){
            return  new Result(false,"you must be near the other player to send flower!");
        }
        if(!currentGame.currentUser.getBackPack().getInventory().containsKey("BOUQUET")){
            return new Result(false,"you don't have flower in your inventory");
        }
        user.getBackPack().addItemToInventory(new Item(ItemType.BOUQUET),1);
        currentGame.currentUser.getBackPack().removeAmountFromInventory(ItemType.BOUQUET,1);
        user.getFriendsPlayer().get(currentGame.currentUser).setHasReceivedFlower(true);
        user.getFriendsPlayer().get(currentGame.currentUser).increaseXp(0);
        user.getFriendsPlayer().get(currentGame.currentUser)
                .setLevel(max(3,user.getFriendsPlayer().get(currentGame.currentUser).getLevel()));
        return new Result(true,"you successfully send flower to your friend");
    }
}
