package Controller;

import model.FarmingProdocts.AllCrops;
import model.FarmingProdocts.Crop;
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
        for (AllCrops cropEnum : AllCrops.values()) {
            Crop crop = cropEnum.getCrop();
            if (crop.getName().equalsIgnoreCase(name)) {
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
                        .append("Can become Giant: ").append(crop.canBecomeGiant()).append("\n");
                return new Result(true, sb.toString());
            }
        }
        return new Result(false, "Crop with this name doesn't exist");
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
