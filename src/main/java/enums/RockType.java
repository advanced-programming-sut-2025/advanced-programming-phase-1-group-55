package enums;

public enum RockType {

    Quartz("Quartz",	"A clear crystal commonly found in caves and mines.",	25),
    Earth_Crystal("Earth Crystal",	"A resinous substance found near the surface.",	50),
    Frozen_Tear("Frozen Tear",	"A crystal fabled to be the frozen tears of a yeti.",	75),
    Fire_Quartz("Fire Quartz",	"A glowing red crystal commonly found near hot lava.",	100),
    Emerald("Emerald",	"A precious stone with a brilliant green color.",	250),
    Aquamarine("Aquamarine",	"A shimmery blue-green gem.",	180),
    Ruby("Ruby",	"A precious stone that is sought after for its rich color and beautiful luster.",	250),
    Amethyst("Amethyst",	"A purple variant of quartz.",	100),
    Topa("Topaz",	"Fairly common but still prized for its beauty.",	80),
    Jade("Jade",	"A pale green ornamental stone.",	200),
    Diamond("Diamond",	"A rare and valuable gem.",	750),
    Prismatic_Shard("Prismatic Shard",	"A very rare and powerful substance with unknown origins.",	2000),
    Copper("Copper",	"A common ore that can be smelted into bars.",	5),
    Iron("Iron",	"A fairly common ore that can be smelted into bars.",	10),
    Gold("Gold",	"A precious ore that can be smelted into bars.",	25),
    Iriduim("Iriduim",	"An exotic ore with many curious properties. Can be smelted into bars.",	100),
    Coal("Coal",	"A combustible rock that is useful for crafting and smelting.",	15);





    private final String description;
    private final int SellPrice;
    private final String names;

    RockType(String names, String description, int sellPrice) {
        this.names = names;
        this.description = description;
        SellPrice = sellPrice;
    }

    public String getDescription() {
        return description;
    }

    public int getSellPrice() {
        return SellPrice;
    }

    public  String getNames() {
        return names;
    }
    public  static RockType getTypeByInt(int x){
        return switch (x) {
            case 0 -> Topa;
            case 1 -> Quartz;
            case 2 -> Fire_Quartz;
            case 3 -> Frozen_Tear;
            case 4 -> Emerald;
            case 5 -> Earth_Crystal;
            case 6 -> Iron;
            case 7 -> Diamond;
            case 8 -> Iriduim;
            case 9 -> Aquamarine;
            case 10 -> Prismatic_Shard;
            case 11 -> Amethyst;
            case 12 -> Coal;
            case 13 -> Copper;
            case 14 -> Gold;
            case 15 -> Ruby;
            default -> Jade;
        };
    }
}
