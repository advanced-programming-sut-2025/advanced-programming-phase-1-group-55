package enums;

import model.Item.ItemType;

public enum RockType {

    Quartz("Quartz",	"A clear crystal commonly found in caves and mines.",	25,ItemType.QUARTZ),
    Earth_Crystal("Earth Crystal",	"A resinous substance found near the surface.",	50,ItemType.EARTH_CRYSTAL),
    Frozen_Tear("Frozen Tear",	"A crystal fabled to be the frozen tears of a yeti.",	75,ItemType.FROZEN_TEAR),
    Fire_Quartz("Fire Quartz",	"A glowing red crystal commonly found near hot lava.",	100,ItemType.FIRE_QUARTZ),
    Emerald("Emerald",	"A precious stone with a brilliant green color.",	250,ItemType.EMERALD),
    Aquamarine("Aquamarine",	"A shimmery blue-green gem.",	180,ItemType.AQUAMARINE),
    Ruby("Ruby",	"A precious stone that is sought after for its rich color and beautiful luster.",	250,ItemType.RUBY),
    Amethyst("Amethyst",	"A purple variant of quartz.",	100,ItemType.AMETHYST),
    Topaz("Topaz",	"Fairly common but still prized for its beauty.",	80,ItemType.TOPAZ),
    Jade("Jade",	"A pale green ornamental stone.",	200,ItemType.JADE),
    Diamond("Diamond",	"A rare and valuable gem.",	750,ItemType.DIAMOND),
    Prismatic_Shard("Prismatic Shard",	"A very rare and powerful substance with unknown origins.",	2000,ItemType.PRISMATIC_SHARD),
    Copper("Copper",	"A common ore that can be smelted into bars.",	5,ItemType.COPPER),
    Iron("Iron",	"A fairly common ore that can be smelted into bars.",	10,ItemType.IRON),
    Gold("Gold",	"A precious ore that can be smelted into bars.",	25,ItemType.GOLD),
    Iriduim("Iriduim",	"An exotic ore with many curious properties. Can be smelted into bars.",	100,ItemType.IRIDIUM),
    Coal("Coal",	"A combustible rock that is useful for crafting and smelting.",	15,ItemType.COAL);





    private final String description;
    private final int SellPrice;
    private final String names;
    private final ItemType itemType;
    RockType(String names, String description, int sellPrice,ItemType itemType) {
        this.names = names;
        this.description = description;
        this.SellPrice = sellPrice;
        this.itemType=itemType;
    }

    public ItemType getItemType() {
        return itemType;
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
            case 0 -> Topaz;
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
