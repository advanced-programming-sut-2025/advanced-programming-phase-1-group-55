package Controller;

import model.App;
import model.GameTime;
import model.Map.MainLocation;
import model.Result;
import model.Store.Product;
import model.Store.Store;

public class StoreController {
    public Store findStore(){
        MainLocation location=App.currentGame.currentUser.getMainLocation();
        if(location.equals(MainLocation.BlackSmithStore)){
            return App.currentGame.getMap().getVillage().getStores().get("BlackSmith");
        } else if (location.equals(MainLocation.FishingStore)) {
            return App.currentGame.getMap().getVillage().getStores().get("FishShop");
        }else if (location.equals(MainLocation.GeneralStore)) {
            return App.currentGame.getMap().getVillage().getStores().get("Generalstore");
        }else if (location.equals(MainLocation.CarpenterShop)) {
            return App.currentGame.getMap().getVillage().getStores().get("CarpenterShop");
        }else if (location.equals(MainLocation.MarineRanchStore)) {
            return App.currentGame.getMap().getVillage().getStores().get("MarnieRanch");
        }else if (location.equals(MainLocation.OjaMartStore)) {
            return App.currentGame.getMap().getVillage().getStores().get("OjaMart");
        }else if (location.equals(MainLocation.StarDropSaloon)) {
            return App.currentGame.getMap().getVillage().getStores().get("StarDropSaloon");
        }
        return  null;
    }
    public Result showAllProducts(){
        Store store=findStore();
        if(store==null){
            return new Result(false,"you are not in the store!");
        }
        if(!(GameTime.getHour()>=store.getOpeningTime()&&GameTime.getHour()< store.getClosingTime())){
            return  new Result(false,"Sorry , the store is not open;\nworking hours: "
                    +store.getOpeningTime()+"-"+store.getClosingTime()+" current time: "+GameTime.getHour());
        }
        StringBuilder message=new StringBuilder();
        for(Product product:store.getProductsOfStore().values()){
            message.append("name:").append(product.getItem().getItemType().getDisplayName())
                    .append(" price:").append(product.getGoldCost()).append("\n");
        }
        return new Result(true,message.toString());
    }
    public Result showAvailableProducts(){
        Store store=findStore();
        if(store==null){
            return new Result(false,"you are not in the store!");
        }
        if(!(GameTime.getHour()>=store.getOpeningTime()&&GameTime.getHour()< store.getClosingTime())){
            return  new Result(false,"Sorry , the store is not open;\nworking hours: "
                    +store.getOpeningTime()+"-"+store.getClosingTime()+" current time: "+GameTime.getHour());
        }
        StringBuilder message=new StringBuilder();
        for(Product product:store.getProductsOfStore().values()){
            if(product.getDailyLimit()> product.getTodaySell()){
                message.append("name:").append(product.getItem().getItemType().getDisplayName())
                        .append(" price:").append(product.getGoldCost()).append("\n");
            }
        }
        return new Result(true,message.toString());
    }
    public Result sellItem(int amount,String name){
        //todo add shipping bin in the map,error for not being near shipping bin
        return new Result(true,"you sold "+name+"successfully!");
    }

    public Result purchaseItem(int amount , String name){
        Store store=findStore();
        if(store==null){
            return new Result(false,"you are not in the store!");
        }
        if(!(GameTime.getHour()>=store.getOpeningTime()&&GameTime.getHour()< store.getClosingTime())){
            return  new Result(false,"Sorry , the store is not open;\nworking hours: "
                    +store.getOpeningTime()+"-"+store.getClosingTime()+" current time: "+GameTime.getHour());
        }
        //todo purchase item
        return new Result(true,"you purchased "+name+" successfully!");
    }
    public Result cheatAddMoney(int amount){
        App.currentGame.currentUser.setGold(App.currentGame.currentUser.getGold()+amount);
        return  new Result(true,amount +" added to your account:)");
    }
}
