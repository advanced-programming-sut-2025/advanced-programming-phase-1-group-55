package model.Store;

import model.NPC.Npc;


import java.time.LocalTime;
import java.util.HashMap;


public class CarpenterShop extends Store{
    public CarpenterShop() {
        super(LocalTime.of(9,0), LocalTime.of(20,0), new HashMap<>(), new Npc("Robin"), "CarpenterShop");
    }
}



