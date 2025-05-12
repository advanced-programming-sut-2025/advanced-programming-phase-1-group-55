package Controller;

import model.FarmingProdocts.AllForagingTrees;
import model.FarmingProdocts.AllForagingTrees;
import model.FarmingProdocts.ForagingTree;
import model.Result;

public class ForagingTreeController {
    public Result getForagingTreesByName(String name) {
        for (AllForagingTrees foragingTrees : AllForagingTrees.values()) {
            if (foragingTrees.getName().equals(name)) {
                StringBuilder ab = new StringBuilder("Foraging crop found:\n");
                ab.append("Name: ").append(foragingTrees.getName()).append("\n")
                        .append("season: ").append(foragingTrees.getSeason()).append("\n");
                return new Result(true, ab.toString());
            }
        }
        return new Result(false, "Foraging tree with this name doesn't exist");
    }
}
