package Controller;

import model.FarmingProdocts.AllForagingTrees;
import model.FarmingProdocts.AllForagingTrees;
import model.FarmingProdocts.ForagingTree;
import model.Result;

public class ForagingTreeController {
    public Result getForagingTreesByName(String name) {
        for (AllForagingTrees foragingTreesEnum : AllForagingTrees.values()) {
            ForagingTree foragingTree = foragingTreesEnum.getForagingTree();
            if (foragingTree.getName().equals(name)) {
                StringBuilder ab = new StringBuilder("Foraging crop found:\n");
                ab.append("Name: ").append(foragingTree.getName()).append("\n")
                        .append("season: ").append(foragingTree.getSeason()).append("\n");
                return new Result(true, ab.toString());
            }
        }
        return new Result(false, "Foraging tree with this name doesn't exist");
    }
}
