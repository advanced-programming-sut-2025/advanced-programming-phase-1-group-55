package Controller;

import model.App;
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
        StringBuilder message=new StringBuilder();
        //baraye test bood in
        //App.currentGame.getMap().getVillage().getStores().get("CarpenterShop").getProductsOfStore().get("barn").setTodaySell(1);
        for(Product product:store.getProductsOfStore().values()){
            if(product.getDailyLimit()> product.getTodaySell()){
                message.append("name:").append(product.getItem().getItemType().getDisplayName())
                        .append(" price:").append(product.getGoldCost()).append("\n");
            }
        }
        return new Result(true,message.toString());
    }
//    public Result sellItem(int amount,String name){}
//    public Result purchaseItem(int amount , String name){}
    public Result cheatAddMoney(int amount){
        App.currentGame.currentUser.setGold(App.currentGame.currentUser.getGold()+amount);
        return  new Result(true,amount +" added to your account:)");
    }
}
