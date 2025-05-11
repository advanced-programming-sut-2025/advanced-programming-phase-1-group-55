package Controller;


import model.FarmingProdocts.AllTrees;
import model.FarmingProdocts.Tree;
import model.Result;

public class TreeCotroller {
    public Result getCropByName(String name) {
        for (AllTrees TreeEnum : AllTrees.values()) {
            Tree tree = TreeEnum.getTree();
            if (tree.getName().equalsIgnoreCase(name)) {
                StringBuilder sb = new StringBuilder("Tree found:\n");
                sb.append("Name: ").append(tree.getName()).append("\n")
                        .append("Source: ").append(tree.getSeedSource().getName()).append("\n")
                        .append("Stages: ").append(tree.getStages()).append("\n")
                        .append("Total Harvest Time: ").append(tree.getTotalHarvestTime()).append("\n")
                        .append("Fruits: ").append(tree.getFruits()).append("\n")
                        .append("Fruit Harvest Cycle: ").append(tree.getFruitHarvestCycle()).append("\n")
                        .append("Fruit Base Sell Price: ").append(tree.getFruitBaseSellPrice()).append("\n")
                        .append("Is Fruit Edible:").append(tree.isFruitEdible()).append("\n")
                        .append("Fruit Energy: ").append(tree.getFruitEnergy()).append("\n")
                        .append("Season: ").append(tree.getSeedSource().getSeason()).append("\n");
                return new Result(true, sb.toString());
            }
        }
        return new Result(false, "Tree with this name doesn't exist");
    }
}
