package model.Map;

import enums.Store;

import java.util.HashMap;
import java.util.Map;

public class NpcVillage {
    private final Map<String, Store> stores=new HashMap<>(){{
        put(Store.Blacksmith.getDisplayName(),Store.Blacksmith);
        put(Store.marnieRanch.getDisplayName(),Store.marnieRanch);
        put(Store.ojaMart.getDisplayName(),Store.ojaMart);
        put(Store.fishShop.getDisplayName(),Store.fishShop);
        put(Store.CarpenterShop.getDisplayName(),Store.CarpenterShop);
        put(Store.starDropSaloon.getDisplayName(),Store.starDropSaloon);
        put(Store.Generalstore.getDisplayName(),Store.Generalstore);
    }};
    private final Location location=new Location(10,35);
    private final int width=20;
    private  final int height=89;

    public Map<String, Store> getStores() {
        return stores;
    }


    public Location getLocation() {
        return location;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
