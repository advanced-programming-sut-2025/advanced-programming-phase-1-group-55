package Controller;

import model.FarmingProdocts.AllForagingCrops;
import model.FarmingProdocts.ForagingCrops;
import model.Result;

public class ForagingCropController {
    public Result getForagingCropsByName(String name) {
        for (AllForagingCrops foragingCrop : AllForagingCrops.values()) {
            if (foragingCrop.getName().equals(name)) {
                StringBuilder ab = new StringBuilder("Foraging crop found:\n");
                ab.append("Name: ").append(foragingCrop.getName()).append("\n")
                        .append("season: ").append(foragingCrop.getSeason()).append("\n")
                        .append("base sell price: ").append(foragingCrop.getBaseSellPrice()).append("\n")
                        .append("energy: ").append(foragingCrop.getEnergy()).append("\n");
                return new Result(true, ab.toString());
            }
        }
        return new Result(false, "Foraging crop with this name doesn't exist");
    }
}
