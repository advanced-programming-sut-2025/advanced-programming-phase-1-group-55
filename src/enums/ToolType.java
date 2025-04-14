package enums;

import model.Product;

public enum ToolType {
    HOE("Hoe",5,Store.Blacksmith),
    PICKAXE("Pickaxe",5,Store.Blacksmith),
    AXE("Axe",5,Store.Blacksmith),
    WATERING_CAN("WateringCan",5,Store.Blacksmith),
    SCYTHE("Scythe",2,null),
    MILK_PAIL("MilkPair",4,Store.marnieRanch),
    SHEARS("Shears",4,Store.marnieRanch);
    private int PrimaryEnergyCost;
    private  final String DisplayName;
    private  final Store store;
    ToolType(String DisplayName, int primaryEnergyCost,Store store){
        this.DisplayName=DisplayName;
        this.PrimaryEnergyCost=primaryEnergyCost;
        this.store=store;
    }
}
