package model.Map;

public class farmBuilder {
    private Farm farm1, farm1_copy, farm2, farm2_copy;

    public GameMap mapCreator() {

        Quarry quarry1 = new Quarry(4, 4, new Location(0, 0));
        Lake lake1 = new Lake(4, 4, new Location(16, 0));
        GreenHouse greenHouse1 = new GreenHouse(6, 5, new Location(15, 14));
        House house1 = new House(4, 4, new Location(0, 16));
        farm1 = new Farm(house1, lake1, greenHouse1, quarry1, new Location(0, 0));

        Quarry quarry1_copy = new Quarry(4, 4, new Location(quarry1.getLocation().getY(), quarry1.getLocation().getX()));
        Lake lake1_copy = new Lake(4, 4, new Location(lake1.getLocation().getY(), lake1.getLocation().getX()));
        GreenHouse greenHouse1_copy = new GreenHouse(6, 5, new Location(greenHouse1.getLocation().getY(), greenHouse1.getLocation().getX()));
        House house1_copy = new House(4, 4, new Location(house1.getLocation().getY(), house1.getLocation().getX()));
        farm1_copy = new Farm(house1_copy, lake1_copy, greenHouse1_copy, quarry1_copy, new Location(0, 0));

        Quarry quarry2 = new Quarry(4, 4, new Location(16, 16));
        Lake lake2 = new Lake(4, 4, new Location(16, 0));
        GreenHouse greenHouse2 = new GreenHouse(6, 5, new Location(0, 0));
        House house2 = new House(4, 4, new Location(0, 16));
        farm2 = new Farm(house2, lake2, greenHouse2, quarry2, new Location(0, 0));

        Quarry quarry2_copy = new Quarry(4, 4, new Location(quarry2.getLocation().getY(), quarry2.getLocation().getX()));
        Lake lake2_copy = new Lake(4, 4, new Location(lake2.getLocation().getY(), lake2.getLocation().getX()));
        GreenHouse greenHouse2_copy = new GreenHouse(6, 5, new Location(greenHouse2.getLocation().getY(), greenHouse2.getLocation().getX()));
        House house2_copy = new House(4, 4, new Location(house2.getLocation().getY(), house2.getLocation().getX()));
        farm2_copy = new Farm(house2_copy, lake2_copy, greenHouse2_copy, quarry2_copy, new Location(0, 0));

        return new GameMap(farm1, farm1_copy, farm2, farm2_copy,new NpcVillage());
    }


    public void fillFarmTiles(GameMap Map, Farm farm) {
        //todo bad taghir dadan tartib farm ha eslah beshe


        for (int i = farm.getQuarry().getLocation().getY(); i < farm.getQuarry().getLocation().getY() + farm.getQuarry().getWidth(); i++) {
            for (int j = farm.getQuarry().getLocation().getX(); j < farm.getQuarry().getLocation().getX() + farm.getQuarry().getHeight(); j++) {
                Map.tiles[i][j] = new Tile(new Location(i, j), "^", true, false,TileType.building);
            }
        }
        for (int i = farm.getLake().getLocation().getY(); i < farm.getLake().getLocation().getY() + farm.getLake().getWidth(); i++) {
            for (int j = farm.getLake().getLocation().getX(); j < farm.getLake().getLocation().getX() + farm.getLake().getHeight(); j++) {
                Map.tiles[i][j] = new Tile(new Location(i, j), "W", false, false,TileType.water);
            }
        }
        for (int i = farm.getHouse().getLocation().getY(); i < farm.getHouse().getLocation().getY() + farm.getHouse().getWidth(); i++) {
            for (int j = farm.getHouse().getLocation().getX(); j < farm.getHouse().getLocation().getX() + farm.getHouse().getHeight(); j++) {
                Map.tiles[i][j] = new Tile(new Location(i, j), "h", true, false,TileType.building);
            }
        }
        for (int i = farm.getGreenHouse().getLocation().getY(); i < farm.getGreenHouse().getLocation().getY() + farm.getGreenHouse().getWidth(); i++) {
            for (int j = farm.getGreenHouse().getLocation().getX(); j < farm.getGreenHouse().getLocation().getX() + farm.getGreenHouse().getHeight(); j++) {
                Map.tiles[i][j] = new Tile(new Location(i, j), "g", true, false,TileType.building);
            }
        }


    }


}
