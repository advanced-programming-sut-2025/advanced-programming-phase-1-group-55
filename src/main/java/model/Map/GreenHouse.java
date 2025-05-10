package model.Map;

public class GreenHouse extends place {
    private Boolean isRepaired = false;
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
