package model.Store;

import model.NPC.Npc;
import model.Product;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class OjaMartStore extends Store{

    public OjaMartStore() {
        super(LocalTime.of(9,0), LocalTime.of(17,0), new HashMap<>(),
                new Npc("Morris"), "OjaMart");
    }
}

