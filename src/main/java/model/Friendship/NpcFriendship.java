package model.Friendship;

import model.NPC.Npc;
import model.User;

public class NpcFriendship extends FriendShip {
    private User user;
    private Npc npc;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Npc getNpc() {
        return npc;
    }

    public void setNpc(Npc npc) {
        this.npc = npc;
    }
}
