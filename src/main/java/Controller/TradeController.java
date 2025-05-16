package Controller;

import model.Item.Item;
import model.Result;
import model.Trade;
import model.User;

import java.util.ArrayList;
import java.util.Arrays;

import static model.App.*;
import static model.Item.ItemType.*;
import static model.Game.*;

public class TradeController {
    public Result TradeMenu() {
        StringBuilder sb = new StringBuilder();
        ArrayList<User> players = currentGame.getPlayersInGame();
        sb.append("players username : \n");
        for (User user : players) {
            sb.append(user.getUsername()).append("\n");
        }
        return new Result(true, sb.toString());
    }

    private int id = 1;

    public Result TradeRequest(String username, String type, String item, String amount, String price, String targetItem, String targetAmount) {
        if (AllUsers.get(username) == null) {
            return new Result(false, "User " + username + " doesn't exist");
        }
        User targetUser = AllUsers.get(username);
        int Amount, Price = 0, TargetAmount = 0;
        try {
            Amount = Integer.parseInt(amount);
            if (price != null) {

                Price = Integer.parseInt(price);
            }
            if (targetItem != null) {

                TargetAmount = Integer.parseInt(targetAmount);
            }
            if (targetAmount != null && price != null) {
                return new Result(false, "you can use request or offer");
            }
        } catch (Exception e) {
            return new Result(false, "Invalid amount " + amount);
        }

        if (getItemType(item) == null) {
            return new Result(false, "Item " + item + " doesn't exist");
        }
        if (type.equals("request")) {

            if (Price > currentGame.currentUser.getGold()) {
                return new Result(false, "You dont have enough Gold");
            }
            if (targetItem != null) {

                if (currentGame.currentUser.getBackPack().getInventory().get(targetItem) == null || currentGame.currentUser.getBackPack().getInventory().get(targetItem).getNumber() < TargetAmount) {
                    return new Result(false, "You dont have enough item");
                }
            }
            if (targetUser.getBackPack().getInventory().get(item) == null || targetUser.getBackPack().getInventory().get(item).getNumber() < Amount) {
                return new Result(false, "Item " + item + " is out of stock! Remained : " + targetUser.getBackPack().getInventory().get(item).getNumber());

            }

            Trade trade = new Trade(currentGame.currentUser, targetUser, new Item(getItemType(item)), "request", Amount, Price, new Item(getItemType(targetItem)), TargetAmount, id++);
            currentGame.currentUser.getTrades().put(id, trade);
            targetUser.getTrades().put(id, trade);
            currentGame.addToAllTrade(trade);

        } else if (type.equals("offer")) {

            if (Price > targetUser.getGold()) {
                return new Result(false, "You dont have enough Gold");
            }
            if (currentGame.currentUser.getBackPack().getInventory().get(item) == null || currentGame.currentUser.getBackPack().getInventory().get(item).getNumber() < Amount) {
                return new Result(false, "You dont have enough item");
            }
            if (targetUser.getBackPack().getInventory().get(targetItem) == null || targetUser.getBackPack().getInventory().get(item).getNumber() < TargetAmount) {
                return new Result(false, "Item " + item + " is out of stock! Remained : " + targetUser.getBackPack().getInventory().get(item).getNumber());

            }

            Trade trade = new Trade(currentGame.currentUser, targetUser, new Item(getItemType(item)), "offer", Amount, Price, new Item(getItemType(targetItem)), TargetAmount, id++);
            currentGame.currentUser.getTrades().put(id, trade);
            targetUser.getTrades().put(id, trade);
            currentGame.addToAllTrade(trade);

        }
        return new Result(true, "trade registered successfully!");
    }

}
