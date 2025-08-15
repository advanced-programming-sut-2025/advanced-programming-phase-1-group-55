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



                App.gameApp.setScreen(new LeaderboardScreen(
                    applySort(view.getPlayerDetails(), selectedSort)
                ));
            }
        }
    }
    private ArrayList<PlayerDetails> applySort(ArrayList<PlayerDetails> userList, SortBy sortType) {
        Comparator<PlayerDetails> comparator;

        if (sortType == SortBy.gold) {
            comparator = Comparator.comparingInt(PlayerDetails::getGold).reversed();
        } else if (sortType == SortBy.skill) {
            comparator = Comparator.comparingInt(PlayerDetails::getSkills).reversed();
        } else {
            comparator = Comparator.comparingInt(PlayerDetails::getQuests).reversed();
        }

        userList.sort(comparator);
        return userList;
    }

}
