package model.Store;

import model.NPC.Npc;
import model.Product;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class StarDropSaloon extends Store{
    public StarDropSaloon() {
        super(LocalTime.of(12,0), LocalTime.of(0,0)
                , new HashMap<>(), new Npc("Gus"), "starDropSaloon");
    }
}