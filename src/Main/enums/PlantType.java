package enums;

public enum PlantType {

    Quartz("Quartz", 25, "A clear crystal commonly found in caves and mines."),
    Earth_Crystal("Earth Crystal", 50, "A resinous substance found near the surface."),
    Frozen_Tear("Frozen Tear", 75, "A crystal fabled to be the frozen tears of a yeti."),
    Fire_Quartz("Fire Quartz", 100, "A glowing red crystal commonly found near hot lava."),
    Emerald("Emerald", 250, "A precious stone with a brilliant green color."),
    Aquamarine("Aquamarine", 180, "A shimmery blue-green gem."),
    Ruby("Ruby", 250, "A precious stone that is sought after for its rich color and beautiful luster."),
    Amethyst("Amethyst", 100, "A purple variant of quartz."),
    Topaz("Topaz", 80, "Fairly common but still prized for its beauty."),
    Jade("Jade", 200, "A pale green ornamental stone."),
    Diamond("Diamond", 750, "A rare and valuable gem."),
    Prismatic_Shard("Prismatic Shard", 2000, "A very rare and powerful substance with unknown origins."),
    Copper("Copper", 5, "A common ore that can be smelted into bars."),
    Iron("Iron", 10, "A fairly common ore that can be smelted into bars."),
    Gold("Gold", 25, "A precious ore that can be smelted into bars."),
    Iriduim("Iriduim", 100, "An exotic ore with many curious properties. Can be smelted into bars."),
    Coal("Coal", 15, "A combustible rock that is useful for crafting and smelting.");


    private final String description;
    private final int SellPrice;
    private final String names;

    PlantType(String names, int sellPrice, String description) {
        this.names = names;
        this.SellPrice = sellPrice;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getSellPrice() {
        return SellPrice;
    }

    public String getNames() {
        return names;
    }
}
