package model.Store;

import model.NPC.Npc;

import java.time.LocalTime;
import java.util.HashMap;

public class FishingStore extends Store{
    public FishingStore() {
        super(9, 17, new HashMap<>(), new Npc("Willy"), "FishShop");
    }
}
