package model.NPC;

import model.ItemOfMap;

import java.util.HashMap;
import java.util.Map;

public class Quest {
    private  int id;
    private ReadyItem want;
    private ReadyItem reward;
    private boolean hasAlreadyFinished;
    private Npc npc;
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Quest(int id, ReadyItem want, ReadyItem reward, int level) {
        this.id = id;
        this.want = want;
        this.reward = reward;
        this.level=level;
    }

    public Npc getNpc() {
        return npc;
    }

    public void setNpc(Npc npc) {
        this.npc = npc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public boolean isHasAlreadyFinished() {
        return hasAlreadyFinished;
    }

    public void setHasAlreadyFinished(boolean hasAlreadyFinished) {
        this.hasAlreadyFinished = hasAlreadyFinished;
    }

    public ReadyItem getWant() {
        return want;
    }

    public void setWant(ReadyItem want) {
        this.want = want;
    }

    public ReadyItem getReward() {
        return reward;
    }

    public void setReward(ReadyItem reward) {
        this.reward = reward;
    }
}
