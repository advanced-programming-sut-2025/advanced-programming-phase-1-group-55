package com.StardewValley.model.Friendship;

import com.StardewValley.model.Item.Item;
import com.StardewValley.model.User;

public class MarriageRequest {
    private User men;
    private User women;
    private Item ring;
    private Answer answer=Answer.unanswered;

    public MarriageRequest(User men, User women, Item ring) {
        this.men = men;
        this.women = women;
        this.ring = ring;
    }

    public User getMen() {
        return men;
    }

    public void setMen(User men) {
        this.men = men;
    }

    public User getWomen() {
        return women;
    }

    public void setWomen(User women) {
        this.women = women;
    }

    public Item getRing() {
        return ring;
    }

    public void setRing(Item ring) {
        this.ring = ring;
    }

    public Answer isAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "MarriageRequest{" +
                "men=" + men.getUsername() +
                ", women=" + women.getUsername() +
                ", ring=" + ring.getItemType().getDisplayName() +
                ", answer=" + answer.getDisplayName() +
                '}';
    }

    public Answer getAnswer() {
        return answer;
    }
}
