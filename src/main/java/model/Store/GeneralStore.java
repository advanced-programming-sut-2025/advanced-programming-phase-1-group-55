package model.Store;

import model.NPC.Npc;
import model.Product;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class GeneralStore extends Store {

    public GeneralStore() {
        super(LocalTime.of(9,0), LocalTime.of(17,0), new HashMap<>(), new Npc("Pierre"), "Generalstore");
    }
}

