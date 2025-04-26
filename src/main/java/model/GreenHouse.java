package model;

public class GreenHouse {
    private Boolean isRepaired = false;
    private final int width = 5;
    private final int height = 6;
    private final int woodForGreenHouse = 500;
    private final int goldForGreenHouse = 1000;
    private int waterSupply;

    public void setRepaired(Boolean repaired) {
        isRepaired = repaired;
    }

    public int getWaterSupply() {
        return waterSupply;
    }

    public void setWaterSupply(int waterSupply) {
        this.waterSupply = waterSupply;
    }
}
