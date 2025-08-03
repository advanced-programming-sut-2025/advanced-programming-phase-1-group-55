package com.StardewValley.Controller;

import com.StardewValley.model.Friendship.*;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Item.ItemType;
import com.StardewValley.model.Map.Location;
import com.StardewValley.model.Result;
import com.StardewValley.model.User;

import static java.lang.Math.max;
import static com.StardewValley.model.App.*;

public class FriendshipController {
    public static User findUser(String username){
        for(User user: currentGameModel.playersInGame){
            if (username.equals(user.getUsername())){
                return user;
            }
        }
        return null;
    }
    public Result showFriends(){
        StringBuilder message=new StringBuilder();
        for (PlayerFriendship friendship: currentGameModel.currentUser.getFriendsPlayer().values()){
            User friend=friendship.getUser1().equals(currentGameModel.currentUser)?friendship.getUser2():friendship.getUser1();
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
        if(user==null||user.getUsername().equals(currentGameModel.currentUser.getUsername())){
            return  new Result(false,"user not found!");
        }
        if(!locationsAreNear(user.getLocation(), currentGameModel.currentUser.getLocation())){
            return  new Result(false,"you must be near the other player to talk!");
        }
        //currentGameModel.currentUser.getFriendsPlayer().get(user).getConversation().add(message);
        if(!user.getFriendsPlayer().get(currentGameModel.currentUser).isTodayTalked()){
            user.getFriendsPlayer().get(currentGameModel.currentUser).increaseXp(20);
            user.getFriendsPlayer().get(currentGameModel.currentUser).setTodayTalked(true);
        }
        user.setHasMessageToday(true);
        if(user.getFriendsPlayer().get(currentGameModel.currentUser).isAreMarried()){
            user.increaseEnergy(50);
            currentGameModel.currentUser.increaseEnergy(50);
        }
        return new Result(true,"message successfully sent to : "+username);
    }
    public Result showTalkHistory(String username){
        User user=findUser(username);
        StringBuilder conversation=new StringBuilder();
        if(user==null||user.getUsername().equals(currentGameModel.currentUser.getUsername())){
            return  new Result(false,"user not found!");
        }
//        for (String message: currentGameModel.currentUser.getFriendsPlayer().get(user).getConversation()){
//            conversation.append(message).append("\n");
//        }
        return new Result(true,conversation.toString());
    }
    public Result hug(String username){
        User user=findUser(username);
        if(user==null||user.getUsername().equals(currentGameModel.currentUser.getUsername())){
            return  new Result(false,"user not found!");
        }
        if(!locationsAreNear(user.getLocation(), currentGameModel.currentUser.getLocation())){
            return  new Result(false,"you must be near the other player to hug!");
        }
        if(user.getFriendsPlayer().get(currentGameModel.currentUser).getLevel()<2){
            return new Result(false,"your friendship level must be more than 2 , to hug each other");
        }
        user.getFriendsPlayer().get(currentGameModel.currentUser).increaseXp(60);
        if(user.getFriendsPlayer().get(currentGameModel.currentUser).isAreMarried()){
            user.increaseEnergy(50);
            currentGameModel.currentUser.increaseEnergy(50);
        }
        return new Result(true,"you huged each other :>");
    }public Result sendFlower(String username){
        User user=findUser(username);
        if(user==null||user.getUsername().equals(currentGameModel.currentUser.getUsername())){
            return  new Result(false,"user not found!");
        }
        if(!locationsAreNear(user.getLocation(), currentGameModel.currentUser.getLocation())){
            return  new Result(false,"you must be near the other player to send flower!");
        }
        if(!currentGameModel.currentUser.getBackPack().getInventory().containsKey("bouquet")){
            return new Result(false,"you don't have flower in your inventory");
        }
        user.getBackPack().addItemToInventory(new Item(ItemType.BOUQUET),1);
        currentGameModel.currentUser.getBackPack().removeAmountFromInventory(ItemType.BOUQUET,1);
        user.getFriendsPlayer().get(currentGameModel.currentUser).setHasReceivedFlower(true);
        user.getFriendsPlayer().get(currentGameModel.currentUser).increaseXp(0);
        user.getFriendsPlayer().get(currentGameModel.currentUser)
                .setLevel(max(3,user.getFriendsPlayer().get(currentGameModel.currentUser).getLevel()));
        if(user.getFriendsPlayer().get(currentGameModel.currentUser).isAreMarried()){
            user.increaseEnergy(50);
            currentGameModel.currentUser.increaseEnergy(50);
        }
        return new Result(true,"you successfully send flower to your friend");
    }
    public Result sendGift(String username,String name,int amount){
        User user=findUser(username);
        if(user==null||user.getUsername().equals(currentGameModel.currentUser.getUsername())){
            return  new Result(false,"user not found!");
        }

        if(!locationsAreNear(user.getLocation(), currentGameModel.currentUser.getLocation())){
            return  new Result(false,"you must be near the other player to send gift!");
        }
        if(user.getFriendsPlayer().get(currentGameModel.currentUser).getLevel()==0){
            return  new Result(false,"your friendship level must be more than 0 to send gifs");
        }
        if(!currentGameModel.currentUser.getBackPack().getInventory().containsKey(name)||
                currentGameModel.currentUser.getBackPack().getInventory().get(name).getNumber()<amount){
            return new Result(false,"you don't have this item in your inventory");
        }
        Item item= currentGameModel.currentUser.getBackPack().getInventory().get(name);
        currentGameModel.currentUser.getBackPack().removeAmountFromInventory(item.getItemType(),amount);
        Item newItem=new Item(item.getItemType());
        user.getBackPack().addItemToInventory(newItem,amount);
        newItem.setNumber(amount);
        user.setHasGiftToday(true);
        user.getFriendsPlayer().get(currentGameModel.currentUser).setTodayGotGift(true);
        Gift gift=new Gift(currentGameModel.currentUser,user,newItem, currentGameModel.getNumberOfAllGifts()+1);
        currentGameModel.increaseNumberOfGifts();
        user.getReceivedGifts().put(gift.getId(),gift);
        user.getFriendsPlayer().get(currentGameModel.currentUser).getGifts().add(gift);
        if(user.getFriendsPlayer().get(currentGameModel.currentUser).isAreMarried()){
            user.increaseEnergy(50);
            currentGameModel.currentUser.increaseEnergy(50);
        }
        return new Result(true,"you gifted item successfully");
    }
    public Result showAllReceivedGifts(){
        StringBuilder gifts=new StringBuilder();
        if (currentGameModel.currentUser.getReceivedGifts()==null|| currentGameModel.currentUser.getReceivedGifts().isEmpty()){
            return  new Result(false,"you don't have any received gift");
        }
        for (Gift gift: currentGameModel.currentUser.getReceivedGifts().values()){
            gifts.append(gift.toString()).append("\n");
        }
        return new Result(true,gifts.toString());
    }public Result showAllGiftsBySpecialFriend(String username){
        User user=findUser(username);
        if(user==null||user.getUsername().equals(currentGameModel.currentUser.getUsername())){
            return  new Result(false,"user not found!");
        }
        StringBuilder gifts=new StringBuilder();
        if(user.getFriendsPlayer().get(currentGameModel.currentUser).getGifts()==null||
                user.getFriendsPlayer().get(currentGameModel.currentUser).getGifts().isEmpty()){
            return new Result(false,"there is no gifts in this friendship");
        }
        for (Gift gift:user.getFriendsPlayer().get(currentGameModel.currentUser).getGifts()){
            gifts.append(gift.toString()).append("\n");
        }
        return new Result(true,gifts.toString());
    }public Result rateGift(int rate,int id){
        if(rate>5||rate<1){
            return  new Result(false,"rate is not valid");
        }

        if(currentGameModel.currentUser.getReceivedGifts()==null|| currentGameModel.currentUser.getReceivedGifts().isEmpty()||
                !currentGameModel.currentUser.getReceivedGifts().containsKey(id)){
            return  new Result(false,"there is no gift with the given id!");
        }
        Gift gift= currentGameModel.currentUser.getReceivedGifts().get(id);
        gift.setRate(rate);
        currentGameModel.currentUser.getFriendsPlayer().get(gift.getSender()).increaseXp((rate-3)*30+15);
        return new Result(true,"you rated the gift with id "+id+" successfully\nrate: "+rate);
    }public Result askMarriage(String name, String ring){
        User user=findUser(name);
        if(user==null||user.getUsername().equals(currentGameModel.currentUser.getUsername())){
            return  new Result(false,"user not found!");
        }

         if(!currentGameModel.currentUser.getBackPack().getInventory().containsKey(ring)){
             return new Result(false,"you don't have "+ring+" to ask for marriage");
         }
         if(!locationsAreNear(user.getLocation(), currentGameModel.currentUser.getLocation())){
            return  new Result(false,"You must be near the other player to ask for marriage!");
         }
         if(user.getFriendsPlayer().get(currentGameModel.currentUser).getLevel()<3){
            return  new Result(false,"your friendship level must be more than 3 to marry each other");
         }
        if (!(user.getGender().equals("female")&& currentGameModel.currentUser.getGender().equals("male"))){
            return new Result(false,"A man must make a marriage proposal to a woman");
        }
        MarriageRequest marriageRequest=new MarriageRequest
                (currentGameModel.currentUser,user, currentGameModel.currentUser.getBackPack().getInventory().get(ring));
         user.getFriendsPlayer().get(currentGameModel.currentUser).setMarriageRequest(marriageRequest);
          return  new Result(true,"Your marriage request has been successfully submitted.");
    }public Result showMarriageRequest(String name){
        User user=findUser(name);
        if(user==null||user.getUsername().equals(currentGameModel.currentUser.getUsername())){
            return  new Result(false,"user not found!");
        }
        if(user.getFriendsPlayer().get(currentGameModel.currentUser).getMarriageRequest()==null){
            return  new Result(false,"there is no marriage request between you and "+name);
        }
        return new Result(true,user.getFriendsPlayer()
                .get(currentGameModel.currentUser).getMarriageRequest().toString());
    }
    public Result answerMarriageRequest(String answer,String username){
        User user=findUser(username);
        if(user==null||user.getUsername().equals(currentGameModel.currentUser.getUsername())){
            return  new Result(false,"user not found!");
        }
        PlayerFriendship friendship=user.getFriendsPlayer().get(currentGameModel.currentUser);
        if(friendship.getMarriageRequest()==null){
            return  new Result(false,"there is no marriage request between you and "+username);
        }
        if(answer.equals("accept")){
            if (!user.getBackPack().getInventory().containsKey(friendship.getMarriageRequest().getRing().getItemType().getDisplayName())){
                return new Result(false,username+"removed "+
                        friendship.getMarriageRequest().getRing().getItemType().getDisplayName()
                        +"from his inventory!!");
            }
            Item item=friendship.getMarriageRequest().getRing();
            friendship.getMarriageRequest().getMen().getBackPack().removeAmountFromInventory(item.getItemType(),1);
            friendship.getMarriageRequest().getWomen().getBackPack().addItemToInventory(new Item(item.getItemType()),1);
            friendship.setLevel(4);
            friendship.getMarriageRequest().setAnswer(Answer.accept);
            friendship.setAreMarried(true);
            return new Result(true,"request accepted:>");
        }else {
            friendship.setLevel(0);
            friendship.setXp(0);
            friendship.getMarriageRequest().setAnswer(Answer.reject);
            friendship.getMarriageRequest().getMen().setSad(true);
            friendship.getMarriageRequest().setAnswer(Answer.reject);
            return new Result(true,"request rejected :<");
        }
    }
}
