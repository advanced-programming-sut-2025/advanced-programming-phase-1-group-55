package model.Store;

import model.NPC.Npc;

import java.time.LocalTime;
import java.util.HashMap;

public class GeneralStore extends Store {

    public GeneralStore() {
        super(9, 17, new HashMap<>(), new Npc("Pierre"), "Generalstore");
    }
}

