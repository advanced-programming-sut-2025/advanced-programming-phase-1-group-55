package model.Store;

import model.NPC.Npc;

import java.time.LocalTime;
import java.util.HashMap;

public class OjaMartStore extends Store{

    public OjaMartStore() {
        super(9, 17, new HashMap<>(), new Npc("Morris"), "OjaMart");
    }
}

