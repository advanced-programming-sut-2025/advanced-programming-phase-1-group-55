package model.Map;

import model.Store.*;

import java.util.HashMap;
import java.util.Map;

public class NpcVillage {
    private final Map<String, Store> stores=new HashMap<>(){{
        put("BlackSmith",new BlackSmithStore());
        put("MarnieRanch",new MarineRanchStore());
        put("OjaMart",new OjaMartStore());
        put("FishShop",new FishingStore());
<<<<<<< HEAD
//        put("CarpenterShop",new CarpenterShop());
        put("starDropSaloon",new StarDropSaloon());
=======
        put("CarpenterShop",new CarpenterShop());
        put("StarDropSaloon",new StarDropSaloon());
>>>>>>> 8d138e353235d79a1e42c69942ab1287af212d92
        put("Generalstore",new GeneralStore());
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
