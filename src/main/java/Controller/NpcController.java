package Controller;

import model.App;
import model.Friendship.NpcFriendship;
import model.Result;

public class NpcController {
    public Result showFriendships(){
        StringBuilder friends=new StringBuilder();
        for(NpcFriendship friendship:App.currentGame.currentUser.getFriendsNpc().values()){
            friends.append(friendship.toString()).append("\n");
        }
        return new Result(true,friends.toString());
    }
}
