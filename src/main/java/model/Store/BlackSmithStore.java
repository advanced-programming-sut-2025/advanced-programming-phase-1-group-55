package model.Store;

import model.NPC.Npc;
import model.Product;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class BlackSmithStore extends Store {

    public BlackSmithStore() {
        super(LocalTime.of(9,0), LocalTime.of(16,0),
                new HashMap<>(), new Npc("Clint"), "Blacksmith");
    }
}
