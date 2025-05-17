package model.Map;

public enum TileTexture {
    grass("grass"),
    water( "water"),
    building("building"),
    ANIMAL_BUILDING("animal_building"),;
    private final String name;

    TileTexture(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public static TileTexture mapTypeNameToTexture(String typeName)
    {
        for (TileTexture t : TileTexture.values())
        {
            if (t.name.equalsIgnoreCase(typeName))
            {
                return t;
            }
        }
        return null;
    }
}
