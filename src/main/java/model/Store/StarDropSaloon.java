package model.Store;

import model.NPC.Npc;

import java.time.LocalTime;
import java.util.HashMap;

public class StarDropSaloon extends Store{
    public StarDropSaloon() {
        super(12, 24, new HashMap<>(), new Npc("Gus"), "starDropSaloon");
    }
}