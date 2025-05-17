package model.Map;

public enum TileType {
    grass("grass"),
    water( "water"),
    building("building"),
    ANIMAL_BUILDING("animal_building"),;
    private final String name;

    TileType(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public static TileType mapTypeNameToTexture(String typeName)
    {
        for (TileType t : TileType.values())
        {
            if (t.name.equalsIgnoreCase(typeName))
            {
                return t;
            }
        }
        return null;
    }
}
