package model.FarmingProdocts;

import enums.Seasons;
import model.App;
import model.Item.Item;
import model.Item.ItemType;
import model.Map.Tile;

import java.util.List;

import static enums.mainGameCommands.weather;

public class Plant extends Item {
    protected String name;
    protected Enum<?> type;
    protected Item source;
    protected List<Integer> stages;
    protected int totalHarvestTime;
    protected int baseSellPrice;
    protected boolean isEdible;
    protected int energy;
    protected List<Seasons> seasons;

    protected boolean hasStarted = false;
    protected int lastWatered = 1;
    protected int currentStage = 0;
    protected int lastHarvested = 0;
    protected boolean isHarvested = false;
    protected int harvestTime;
    protected Tile tile;

    public Plant(ItemType itemtype) {
        super(itemtype);
    }

    public void water()
    {
        if (!hasStarted)
        {
            hasStarted = true;
        }

        lastWatered = 0;
    }
    private void grow() {
        if (currentStage < totalHarvestTime) {
            if (seasons.contains(App.currentGame.getGameTime().getSeason())) {
                currentStage++;
            }
        }
    }
    public boolean hasBeenWateredToday()
    {
        if (!hasStarted)
        {
            return false;
        }

        return lastWatered == 0;
    }
    public void update() {
        if (hasBeenWateredToday()) {
            grow();
        }
        if (isHarvested) {
            lastHarvested = Math.min(harvestTime, lastWatered + 1);
        }
        lastWatered = lastWatered + 1;
    }
    public boolean canBeHarvested() {
        if (!isHarvested) {
            return (currentStage == totalHarvestTime);
        }
        return lastHarvested >= harvestTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Enum<?> getType() {
        return type;
    }
    public int getLastWatered()
    {
        if (!hasStarted)
        {
            return -1;
        }

        return lastWatered;
    }

    public void setType(Enum<?> type) {
        this.type = type;
    }

    public Item getSource() {
        return source;
    }

    public void setSource(Item source) {
        this.source = source;
    }

    public List<Integer> getStages() {
        return stages;
    }

    public void setStages(List<Integer> stages) {
        this.stages = stages;
    }

    public int getTotalHarvestTime() {
        return totalHarvestTime;
    }

    public void setTotalHarvestTime(int totalHarvestTime) {
        this.totalHarvestTime = totalHarvestTime;
    }

    public int getBaseSellPrice() {
        return baseSellPrice;
    }

    public void setBaseSellPrice(int baseSellPrice) {
        this.baseSellPrice = baseSellPrice;
    }

    public boolean isEdible() {
        return isEdible;
    }

    public void setEdible(boolean edible) {
        isEdible = edible;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public List<Seasons> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Seasons> seasons) {
        this.seasons = seasons;
    }

    public boolean isHasStarted() {
        return hasStarted;
    }

    public void setHasStarted(boolean hasStarted) {
        this.hasStarted = hasStarted;
    }
    public void setHasStarted()
    {
        this.hasStarted = true;
    }
    protected void setGrowFaster()
    {
        totalHarvestTime -= 1;
    }



    public void setLastWatered(int lastWatered) {
        this.lastWatered = lastWatered;
    }

    public int getCurrentStage() {
        return currentStage;
    }

    public void setCurrentStage(int currentStage) {
        this.currentStage = currentStage;
    }

    public int getLastHarvested() {
        return lastHarvested;
    }

    public void setLastHarvested(int lastHarvested) {
        this.lastHarvested = lastHarvested;
    }

    public boolean isHarvested() {
        return isHarvested;
    }

    public void setHarvested(boolean harvested) {
        isHarvested = harvested;
    }

    public int getHarvestTime() {
        return harvestTime;
    }

    public void setHarvestTime(int harvestTime) {
        this.harvestTime = harvestTime;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }
//    public String showDetails(Plant plant, Tile tile) {
//        StringBuilder sb = new StringBuilder();
//        if (plant instanceof Tree) {
//
//        }
//    }

}
