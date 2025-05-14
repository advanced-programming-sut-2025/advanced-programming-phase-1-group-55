package model.Store;

import model.NPC.Npc;

import java.time.LocalTime;
import java.util.HashMap;

public class FishingStore extends Store{
    public FishingStore() {
        super(LocalTime.of(9,0), LocalTime.of(17,0), new HashMap<>(), new Npc("Willy"), "FishShop");
    }
}
