package model.Store;

import model.NPC.Npc;

import java.time.LocalTime;
import java.util.HashMap;

public class MarineRanchStore extends Store{
    public MarineRanchStore() {
        super(9, 16, new HashMap<>(), new Npc("Marnie"), "marnieRanch");
    }
}
