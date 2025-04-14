package model;

import java.util.HashMap;
import java.util.Map;

public class Quest {
    private  int id;
    private Map<String,ItemOfMap> reward=new HashMap<>();
    private boolean hasAlreadyFinished;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, ItemOfMap> getReward() {
        return reward;
    }

    public void setReward(Map<String, ItemOfMap> reward) {
        this.reward = reward;
    }

    public boolean isHasAlreadyFinished() {
        return hasAlreadyFinished;
    }

    public void setHasAlreadyFinished(boolean hasAlreadyFinished) {
        this.hasAlreadyFinished = hasAlreadyFinished;
    }
}
