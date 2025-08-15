//package com.StardewValley.Server.Controller;
//
//import com.StardewValley.Common.model.Friendship.PlayerFriendship;
//import com.StardewValley.Common.model.Item.Item;
//import com.StardewValley.Common.model.Result;
//import com.StardewValley.Common.model.Trade;
//import com.StardewValley.Common.model.User;
//
//import java.util.ArrayList;
//
//import static com.StardewValley.Common.model.App.AllUsers;
//import static com.StardewValley.Common.model.App.currentGameModel;
//import static com.StardewValley.Common.model.Item.ItemType.getItemType;
//
//public class TradeController {
//    public Result TradeMenu() {
//        StringBuilder sb = new StringBuilder();
//        ArrayList<User> players = currentGameModel.getPlayersInGame();
//        sb.append("players username : \n");
//        for (User user : players) {
//            sb.append(user.getUsername()).append("\n");
//            for (Trade trade : user.getTrades().values()) {
//                if (!trade.isPrinted()) {
//
//                    sb.append(trade.toString()).append("\n");
//                    trade.setPrinted(true);
//                }
//            }
//        }
//        return new Result(true, sb.toString());
//    }
//
//    private int id = 1;
//
//    public Result TradeRequest(String username, String type, String item, String amount, String price, String targetItem, String targetAmount) {
//        if (AllUsers.get(username) == null) {
//            return new Result(false, "User " + username + " doesn't exist");
//        }
//        User targetUser = AllUsers.get(username);
//        int Amount, Price = 0, TargetAmount = 0;
//        try {
//            Amount = Integer.parseInt(amount);
//            if (price != null) {
//
//                Price = Integer.parseInt(price);
//            }
//            if (targetItem != null) {
//
//                TargetAmount = Integer.parseInt(targetAmount);
//            }
//            if (targetAmount != null && price != null) {
//                return new Result(false, "you can use request or offer not both!");
//            }
//        } catch (Exception e) {
//            return new Result(false, "Invalid amount " + amount);
//        }
//
//        if (getItemType(item) == null) {
//            return new Result(false, "Item " + item + " doesn't exist");
//        }
//        if (type.equals("request")) {
//
//            if (Price > currentGameModel.currentUser.getGold()) {
//                return new Result(false, "You dont have enough Gold");
//            }
//            if (targetItem != null) {
//
//                if (currentGameModel.currentUser.getBackPack().getInventory().get(targetItem) == null || currentGameModel.currentUser.getBackPack().getInventory().get(targetItem).getNumber() < TargetAmount) {
//                    return new Result(false, "You dont have enough item");
//                }
//            }
//            if (targetUser.getBackPack().getInventory().get(item) == null || targetUser.getBackPack().getInventory().get(item).getNumber() < Amount) {
//                return new Result(false, "Item " + item + " is out of stock! Remained : " + targetUser.getBackPack().getInventory().get(item).getNumber());
//
//            }
//
//            Trade trade = new Trade(currentGameModel.currentUser, targetUser, new Item(getItemType(item)), "request", Amount, Price, new Item(getItemType(targetItem)), TargetAmount, id);
//            currentGameModel.currentUser.getTrades().put(id, trade);
//            targetUser.getTrades().put(id, trade);
//            currentGameModel.addToAllTrade(trade);
//            id++;
//
//
//        } else if (type.equals("offer")) {
//            if (price != null) {
//
//                if (Price > targetUser.getGold()) {
//                    return new Result(false, "You dont have enough Gold");
//                }
//            } else {
//
//                if (currentGameModel.currentUser.getBackPack().getInventory().get(item) == null || currentGameModel.currentUser.getBackPack().getInventory().get(item).getNumber() < Amount) {
//                    return new Result(false, "You dont have enough item");
//                }
//                if (targetUser.getBackPack().getInventory().get(targetItem) == null || targetUser.getBackPack().getInventory().get(item).getNumber() < TargetAmount) {
//                    return new Result(false, "Item " + item + " is out of stock! Remained : " + targetUser.getBackPack().getInventory().get(item).getNumber());
//
//                }
//            }
//
//            Trade trade = new Trade(currentGameModel.currentUser, targetUser, new Item(getItemType(item)), "offer", Amount, Price, new Item(getItemType(targetItem)), TargetAmount, id);
//            currentGameModel.currentUser.getTrades().put(id, trade);
//            targetUser.getTrades().put(id, trade);
//            currentGameModel.addToAllTrade(trade);
//            id++;
//
//        }
//        return new Result(true, "trade registered successfully!");
//    }
//
//    public Result tradeList() {
//        if (currentGameModel.currentUser.getTrades().isEmpty()) {
//            return new Result(false, "You don't have trades");
//        }
//        for (Trade trade : currentGameModel.currentUser.getTrades().values()) {
//            System.out.println(trade);
//            System.out.println("-----------------------------------------");
//
//        }
//        return new Result(true, "all of you trades : )");
//
//    }
//
//    public Result tradeResponse(String response, String ID) {
//        int id;
//        try {
//            id = Integer.parseInt(ID);
//        } catch (Exception e) {
//            return new Result(false, "Invalid ID");
//        }
//
//        Trade trade = currentGameModel.currentUser.getTrades().get(id);
//
//        if (trade == null) {
//            return new Result(false, "Trade not found");
//        }
//        if (!currentGameModel.currentUser.getUsername().equals(trade.getReciver().getUsername())) {
//            return new Result(false, "You should be receiver to response the trade");
//        }
//        if (trade.getType().equals("request")) {
//            if (response.equals("accept")) {
//
//                trade.getSender().getBackPack().addItemToInventory(trade.getItem(), trade.getAmount());
//                if (trade.getPrice() != 0) {
//
//                    trade.getSender().increaseGold(-1 * trade.getPrice());
//                    trade.getReciver().increaseGold(trade.getPrice());
//                } else {
//                    trade.getSender().getBackPack().removeAmountFromInventory(trade.getTargetItem().getItemType(), trade.getTargetAmount());
//                    trade.getReciver().getBackPack().addItemToInventory(trade.getTargetItem(), trade.getTargetAmount());
//                }
//                trade.setAccepted(true);
//                trade.setPrinted(true);
//                trade.setAnswered(true);
//                if(!trade.getSender().getFriendsPlayer().get(trade.getReciver()).isTodayTraded()){
//                    trade.getSender().getFriendsPlayer().get(trade.getReciver()).increaseXp(50);
//                    trade.getSender().getFriendsPlayer().get(trade.getReciver()).setTodayTraded(true);
//                }
//                if(trade.getSender().getFriendsPlayer().get(trade.getReciver()).isAreMarried()){
//                    trade.getSender().increaseEnergy(50);
//                    trade.getReciver().increaseEnergy(50);
//                }
//                return new Result(true, "Trade " + id + " accepted(request)");
//            } else if (response.equals("reject")) {
//
//                trade.setAccepted(false);
//                trade.setPrinted(true);
//                trade.setAnswered(true);
//                if(!trade.getSender().getFriendsPlayer().get(trade.getReciver()).isTodayTraded()){
//                    trade.getSender().getFriendsPlayer().get(trade.getReciver()).increaseXp(-30);
//                    trade.getSender().getFriendsPlayer().get(trade.getReciver()).setTodayTraded(true);
//                }
//                return new Result(true, "Trade " + id + " rejected(request)");
//
//            } else {
//                return new Result(false, "invalid response");
//            }
//        } else if (trade.getType().equals("offer")) {
//            if (response.equals("accept")) {
//
//                trade.getSender().getBackPack().removeAmountFromInventory(trade.getItem().getItemType(), trade.getAmount());
//                trade.getReciver().getBackPack().addItemToInventory(trade.getItem(), trade.getAmount());
//
//                if (trade.getPrice() != 0) {
//                    System.out.println("price : "+trade.getPrice());
//                    trade.getReciver().increaseGold(-1 * trade.getPrice());
//                    trade.getSender().increaseGold(trade.getPrice());
//                } else {
//                    trade.getSender().getBackPack().addItemToInventory(trade.getTargetItem(), trade.getTargetAmount());
//                    trade.getReciver().getBackPack().removeAmountFromInventory(trade.getTargetItem().getItemType(), trade.getTargetAmount());
//                }
//                trade.setAccepted(true);
//                trade.setPrinted(true);
//                trade.setAnswered(true);
//                if(!trade.getSender().getFriendsPlayer().get(trade.getReciver()).isTodayTraded()){
//                    trade.getSender().getFriendsPlayer().get(trade.getReciver()).increaseXp(50);
//                    trade.getSender().getFriendsPlayer().get(trade.getReciver()).setTodayTraded(true);
//                }
//                if(trade.getSender().getFriendsPlayer().get(trade.getReciver()).isAreMarried()){
//                    trade.getSender().increaseEnergy(50);
//                    trade.getReciver().increaseEnergy(50);
//                }
//                return new Result(true, "Trade " + id + " accepted (offer)");
//            } else if (response.equals("reject")) {
//
//                trade.setAccepted(false);
//                trade.setPrinted(true);
//                trade.setAnswered(true);
//                PlayerFriendship friendship=trade.getSender().getFriendsPlayer().get(trade.getReciver());
//                friendship.setTodayTraded(false);
//                friendship.increaseXp(-30);
//                return new Result(true, "Trade " + id + " rejected(offer)");
//
//            } else {
//                return new Result(false, "invalid response");
//            }
//        }
//        return new Result(true, "aslan nabayd be inja berese");
//    }
//
//    public Result TradeHistory() {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("trade history : \n");
//        for (Trade trade : currentGameModel.currentUser.getTrades().values()) {
//            stringBuilder.append(trade.toString()).append("\n");
//        }
//        return new Result(true, stringBuilder.toString());
//    }
//
//    public Result NotAnswerdTrades() {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (Trade trade : currentGameModel.currentUser.getTrades().values()) {
//            if (!trade.isAnswered()) {
//                stringBuilder.append(trade.toString()).append("\n");
//            }
//            stringBuilder.append("---------------------------------------------------------\n");
//        }
//        return new Result(true, stringBuilder.toString());
//    }
//
//}
