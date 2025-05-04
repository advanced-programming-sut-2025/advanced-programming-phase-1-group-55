package model.NPC;

import model.ItemOfMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public enum NpcType {
    SEBASTIAN(
            new HashMap<>(),
            new HashMap<>(),
            new HashMap<>()),

    ABIGAIL(
            new HashMap<>(),
            new HashMap<>(),
            new HashMap<>()),

    HARVEY(
            new HashMap<>(),
            new HashMap<>(),
            new HashMap<>()),

    LEAH(
            new HashMap<>(),
            new HashMap<>(),
            new HashMap<>()),

    ROBIN(
            new HashMap<>(),
            new HashMap<>(),
            new HashMap<>());

    private final Map<String,ItemOfMap> favorites;
    private final Map<String,ItemOfMap> request;
    private final Map<String,ItemOfMap> reward;
    private ArrayList<Dialog> dialogs; // taghir be shey dialog va ezafe kardan ertebaat baa fasl
    private  String job;
    private ArrayList<Quest> quests; //shey quest ezaafe beshe
    NpcType( Map<String,ItemOfMap> favorites, Map<String,ItemOfMap> request, Map<String,ItemOfMap>reward) {
        this.favorites = favorites;
        this.request = request;
        this.reward = reward;
    }


    public Map<String,ItemOfMap> getFavorites() {
        return favorites;
    }

    public Map<String,ItemOfMap> getRequest() {
        return request;
    }

    public Map<String,ItemOfMap> getReward() {
        return reward;
    }

    public ArrayList<Dialog> getDialogs() {
        return dialogs;
    }

    public void setDialogs(ArrayList<Dialog> dialogs) {
        this.dialogs = dialogs;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public ArrayList<Quest> getQuests() {
        return quests;
    }

    public void setQuests(ArrayList<Quest> quests) {
        this.quests = quests;
    }
}
