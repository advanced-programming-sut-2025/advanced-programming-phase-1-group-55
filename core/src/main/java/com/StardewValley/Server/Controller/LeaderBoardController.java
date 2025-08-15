package com.StardewValley.Server.Controller;



import com.StardewValley.Client.View.LeaderboardScreen;
import com.StardewValley.Common.PlayerDetails;
import com.StardewValley.Common.enums.SortBy;
import com.StardewValley.Common.model.App;

import java.util.ArrayList;
import java.util.Comparator;

public class LeaderBoardController {
    private LeaderboardScreen view;
    public void setView(LeaderboardScreen view) {
        this.view = view;
    }

    public LeaderboardScreen getView() {
        return view;
    }
    public void handleButtonClick() {
        if (view!=null){
            if (view.getBackButton().isChecked()){
                view.getBackButton().setChecked(false);
               App.gameApp.setScreen(App.currentGameGraphicView);
            }else if (view.getConfirmButton().isChecked()) {
                view.getConfirmButton().setChecked(false);

                SortBy selectedSort = view.getSortSelectBox().getSelected();

                App.lastSortBy=selectedSort;

                applySort(view.getPlayerDetails(), selectedSort);

                App.gameApp.setScreen(new LeaderboardScreen(
                    view.getPlayerDetails()
                ));
            }
        }
    }
    private ArrayList<PlayerDetails> applySort(ArrayList<PlayerDetails> userList, SortBy sortType) {
        Comparator<PlayerDetails> comparator;
        if (sortType == SortBy.gold) {
            comparator = Comparator.comparing(p -> p.gold);
        } else if (sortType == SortBy.skill) {
            comparator = Comparator.comparingInt(p -> -p.skills);
        } else {
            comparator = Comparator.comparingInt(p -> p.quests);
        }
        userList.sort(comparator);
        return userList;
    }
}
