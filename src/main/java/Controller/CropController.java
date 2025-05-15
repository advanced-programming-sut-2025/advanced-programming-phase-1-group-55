package Controller;

import model.FarmingProdocts.*;
import model.Result;

public class CropController {

//    public Result getAllCrops() {
//        StringBuilder sb = new StringBuilder("List of all crops:\n");
//        for (AllCrops cropEnum : AllCrops.values()) {
//            Crop crop = cropEnum.getCrop();
//            sb.append("- ").append(crop.getName())
//                    .append(" (Season: ").append(crop.getSeason()).append(", ")
//                    .append("Growth Days: ").append(crop.getDaysToGrow()).append(")\n");
//        }
//        return new Result(true, sb.toString().trim());
//    }

    public Result getCropByName(String name) {
        for (AllCrops crop : AllCrops.values()) {
            if (crop.getName().equals(name)) {
                StringBuilder sb = new StringBuilder("Crop found:\n");
                sb.append("Name: ").append(crop.getName()).append("\n")
                        .append("Source: ").append(crop.getSeed().getName()).append("\n")
                        .append("Stages: ").append(crop.getStages()).append("\n")
                        .append("Total Harvest Time: ").append(crop.getTotalHarvestTime()).append("\n")
                        .append("One Time: ").append(crop.isOneTime()).append("\n")
                        .append("Regrowth Time: ").append(crop.getRegrowthTime()).append("\n")
                        .append("Base Sell Price: ").append(crop.getBaseSellPrice()).append("\n")
                        .append("Is Edible:").append(crop.isEdible()).append("\n")
                        .append("Base Energy: ").append(crop.getBaseEnergy()).append("\n")
                        .append("Season: ").append(crop.getSeed().getSeason()).append("\n")
                        .append("Can become Giant: ").append(crop.isCanBecomeGiant());
                return new Result(true, sb.toString());
            }
        }
        return new Result(false, "Crop with this name doesn't exist");
    }

    public Result getTreeByName(String name) {
        for (AllTrees tree : AllTrees.values()) {
            if (tree.getName().equalsIgnoreCase(name)) {
                StringBuilder sb = new StringBuilder("Tree found:\n");
                sb.append("Name: ").append(tree.getName()).append("\n")
                        .append("Source: ").append(tree.getSeedSource().getName()).append("\n")
                        .append("Stages: ").append(tree.getStages()).append("\n")
                        .append("Total Harvest Time: ").append(tree.getTotalHarvestTime()).append("\n")
                        .append("Fruits: ").append(tree.getFruits().getType().getName()).append("\n")
                        .append("Fruit Harvest Cycle: ").append(tree.getFruits().getType().getFruitHarvestCycle()).append("\n")
                        .append("Fruit Base Sell Price: ").append(tree.getFruits().getType().getFruitBaseSellPrice()).append("\n")
                        .append("Is Fruit Edible:").append(tree.getFruits().getType().isFruitEdible()).append("\n")
                        .append("Fruit Energy: ").append(tree.getFruits().getType().getFruitEnergy()).append("\n")
                        .append("Season: ").append(tree.getSeedSource().getSeason());
                return new Result(true, sb.toString());
            }
        }
        return new Result(false, "Tree with this name doesn't exist");
    }

    public Result getForagingCropsByName(String name) {
        for (AllForagingCrops foragingCrop : AllForagingCrops.values()) {
            if (foragingCrop.getName().equals(name)) {
                StringBuilder ab = new StringBuilder("Foraging crop found:\n");
                ab.append("Name: ").append(foragingCrop.getName()).append("\n")
                        .append("season: ").append(foragingCrop.getSeason()).append("\n")
                        .append("base sell price: ").append(foragingCrop.getBaseSellPrice()).append("\n")
                        .append("energy: ").append(foragingCrop.getEnergy());
                return new Result(true, ab.toString());
            }
        }
        return new Result(false, "Foraging crop with this name doesn't exist");
    }

    public Result getForagingTreesByName(String name) {
        for (AllForagingTrees foragingTrees : AllForagingTrees.values()) {
            if (foragingTrees.getName().equals(name)) {
                StringBuilder ab = new StringBuilder("Foraging crop found:\n");
                ab.append("Name: ").append(foragingTrees.getName()).append("\n")
                        .append("season: ").append(foragingTrees.getSeason());
                return new Result(true, ab.toString());
            }
        }
        return new Result(false, "Foraging tree with this name doesn't exist");
    }


//    public Result getCropsBySeason(String season) {
//        StringBuilder sb = new StringBuilder("Crops in season '").append(season).append("':\n");
//        boolean found = false;
//        for (AllCrops cropEnum : AllCrops.values()) {
//            Crop crop = cropEnum.getCrop();
//            String cropSeason = crop.getSeason();
//            if (cropSeason.equalsIgnoreCase(season) || cropSeason.contains(season)) {
//                sb.append("- ").append(crop.getName())
//                        .append(" (Growth Days: ").append(crop.getDaysToGrow()).append(")\n");
//                found = true;
//            }
//        }
//
//        if (!found) {
//            return new Result(false, "No crops available in this season");
//        }
//
//        return new Result(true, sb.toString().trim());
//    }
}
