package com.StardewValley.model.Map;

import com.StardewValley.model.NPC.Npc;
import com.StardewValley.model.NPC.NpcType;
import com.StardewValley.model.Store.*;

import java.util.HashMap;
import java.util.Map;

public class NpcVillage {
    private final Map<String, Store> stores=new HashMap<>(){{
        put("BlackSmith",new BlackSmithStore());
        put("MarnieRanch",new MarineRanchStore());
        put("OjaMart",new OjaMartStore());
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

    public Map<String, Npc> getNpss() {
        return nps;
    }
}
