package com.StardewValley.model.Map;

import com.StardewValley.model.Item.CollisionRect;
import com.StardewValley.model.NPC.Npc;
import com.StardewValley.model.NPC.NpcType;
import com.StardewValley.model.Store.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NpcVillage implements Serializable {
    private final Map<String, Store> stores=new HashMap<>(){{
        put("BlackSmith",new BlackSmithStore());
        put("MarnieRanch",new MarineRanchStore());
        put("JOjaMart",new JojaMartStore());
        put("FishShop",new FishingStore());
        put("starDropSaloon",new StarDropSaloon());
        put("CarpenterShop",new CarpenterShop());
        put("StarDropSaloon",new StarDropSaloon());
        put("Generalstore",new GeneralStore());
    }};
    private final Map<String, Npc> nps=new HashMap<>(){{
        put("Abigail",new Npc(NpcType.ABIGAIL));
        put("Sebastian",new Npc(NpcType.SEBASTIAN));
        put("Harvey",new Npc(NpcType.HARVEY));
        put("Robin",new Npc(NpcType.ROBIN));
        put("Leah",new Npc(NpcType.LEAH));
    }};
    private final ArrayList<ShippingBin> shippingBins=new ArrayList<>();

    public Map<String, Npc> getNps() {
        return nps;
    }

    public ArrayList<ShippingBin> getShippingBins() {
        return shippingBins;
    }

    public Map<String, Store> getStores() {
        return stores;
    }
    public Map<String, Npc> getNpss() {
        return nps;
    }
}
