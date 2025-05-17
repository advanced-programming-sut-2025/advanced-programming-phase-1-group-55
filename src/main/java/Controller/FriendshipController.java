package Controller;

import model.Friendship.Gift;
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
    public Result sendGift(String username,String name,int amount){
        User user=findUser(username);
        if(user==null){
            return  new Result(false,"user not found!");
        }

        if(!locationsAreNear(user.getLocation(),currentGame.currentUser.getLocation())){
            return  new Result(false,"you must be near the other player to send gift!");
        }
        if(user.getFriendsPlayer().get(currentGame.currentUser).getLevel()==0){
            return  new Result(false,"your friendship level must be more than 0 to send gifs");
        }
        if(!currentGame.currentUser.getBackPack().getInventory().containsKey(name)||
                currentGame.currentUser.getBackPack().getInventory().get(name).getNumber()<amount){
            return new Result(false,"you don't have this item in your inventory");
        }
        Item item=currentGame.currentUser.getBackPack().getInventory().get(name);
        currentGame.currentUser.getBackPack().removeAmountFromInventory(item.getItemType(),amount);
        Item newItem=new Item(item.getItemType());
        user.getBackPack().addItemToInventory(newItem,amount);
        newItem.setNumber(amount);
        user.setHasGiftToday(true);
        user.getFriendsPlayer().get(currentGame.currentUser).setTodayGotGift(true);
        Gift gift=new Gift(currentGame.currentUser,user,newItem,currentGame.getNumberOfAllGifts()+1);
        currentGame.increaseNumberOfGifts();
        user.getReceivedGifts().put(gift.getId(),gift);
        user.getFriendsPlayer().get(currentGame.currentUser).getGifts().add(gift);
        return new Result(true,"you gifted item successfully");
    }
    public Result showAllReceivedGifts(){
        StringBuilder gifts=new StringBuilder();
        if (currentGame.currentUser.getReceivedGifts()==null||currentGame.currentUser.getReceivedGifts().isEmpty()){
            return  new Result(false,"you don't have any received gift");
        }
        for (Gift gift:currentGame.currentUser.getReceivedGifts().values()){
            gifts.append(gift.toString()).append("\n");
        }
        return new Result(true,gifts.toString());
    }public Result showAllGiftsBySpecialFriend(String username){
        User user=findUser(username);
        if(user==null){
            return  new Result(false,"user not found!");
        }
        StringBuilder gifts=new StringBuilder();
        if(user.getFriendsPlayer().get(currentGame.currentUser).getGifts()==null||
                user.getFriendsPlayer().get(currentGame.currentUser).getGifts().isEmpty()){
            return new Result(false,"there is no gifts in this friendship");
        }
        for (Gift gift:user.getFriendsPlayer().get(currentGame.currentUser).getGifts()){
            gifts.append(gift.toString()).append("\n");
        }
        return new Result(true,gifts.toString());
    }public Result rateGift(int rate,int id){
        if(rate>5||rate<1){
            return  new Result(false,"rate is not valid");
        }
        if(currentGame.currentUser.getReceivedGifts()==null||currentGame.currentUser.getReceivedGifts().isEmpty()||
                !currentGame.currentUser.getReceivedGifts().containsKey(id)){
            return  new Result(false,"there is no gift with the given id!");
        }
        Gift gift=currentGame.currentUser.getReceivedGifts().get(id);
        gift.setRate(rate);
        currentGame.currentUser.getFriendsPlayer().get(gift.getSender()).increaseXp((rate-3)*30+15);
        return new Result(true,"you rated the gift with id "+id+" successfully\nrate: "+rate);
    }
}
