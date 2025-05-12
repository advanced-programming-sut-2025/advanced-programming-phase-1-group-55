package enums;

import model.Map.Location;
import model.NPC.Npc;
import model.Product;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public enum Store {
    Blacksmith("Blacksmith",new Npc("Clint"),LocalTime.of(9,0),LocalTime.of(16,0),new HashMap<>()),
    ojaMart("ojaMart",new Npc("Morris"),LocalTime.of(9,0),LocalTime.of(17,0),new HashMap<>()),
    Generalstore("Generalstore",new Npc("Pierre"),LocalTime.of(9,0),LocalTime.of(17,0),new HashMap<>()),
    CarpenterShop("CarpenterShop",new Npc("Robin"),LocalTime.of(9,0),LocalTime.of(20,0),new HashMap<>()),
    fishShop("fishShop",new Npc("Willy"),LocalTime.of(9,0),LocalTime.of(17,0),new HashMap<>()),
    marnieRanch("marnieRanch",new Npc("Marnie"),LocalTime.of(9,0),LocalTime.of(16,0),new HashMap<>()),
    starDropSaloon("starDropSaloon",new Npc("Gus"),LocalTime.of(12,0),LocalTime.of(0,0),new HashMap<>());
    private final LocalTime openingTime;
    private final LocalTime closingTime;
    private Map<String, Product> productsOfStore=new HashMap<>();
    private final Npc owner;
    private final String DisplayName;
    private final ArrayList<Location> location=new ArrayList<>();
    Store(String DisplayName,Npc owner,LocalTime openingTime,LocalTime closingTime,Map<String,Product> productsOfStore){
        this.openingTime=openingTime;
        this.closingTime=closingTime;
        this.productsOfStore=productsOfStore;
        this.owner=owner;
        this.DisplayName=DisplayName;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public Map<String, Product> getProductsOfStore() {
        return productsOfStore;
    }

    public Npc getOwner() {
        return owner;
    }
    public  String showAvailableProducts(){
        String message="";
        return message;
    }
    public  String showAllProducts(){
        String message="";
        return  message;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public ArrayList<Location> getLocation() {
        return location;
    }

    public void setProductsOfStore(Map<String, Product> productsOfStore) {
        this.productsOfStore = productsOfStore;
    }
}
