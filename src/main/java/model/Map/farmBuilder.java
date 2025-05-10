package model.Map;

public class farmBuilder {
    private Quarry quarry1 = new Quarry(4, 4, new Location(0, 0));
    private Lake lake1 = new Lake(4, 4, new Location(16, 0));
    private GreenHouse greenHouse1 = new GreenHouse(6, 5, new Location(15, 14));
    private House house1 = new House(4, 4, new Location(0, 16));
    private Quarry quarry2 = new Quarry(4, 4, new Location(16, 16));
    private Lake lake2 = new Lake(4, 4, new Location(16, 0));
    private GreenHouse greenHouse2 = new GreenHouse(6, 5, new Location(0, 0));
    private House house2 = new House(4, 4, new Location(0, 16));
    public Farm farm1 = new Farm(house1, lake1, greenHouse1, quarry1, new Location(0, 0));
    public Farm farm2 = new Farm(house2, lake2, greenHouse2, quarry2, new Location(0, 0));

    public GameMap mapCreator() {
        //todo memeber ha select konan map haro masalan map selcetive 1 ,2 ,3 ,4 dashte bashim
        //todo npc add beshe
        return new GameMap(farm1, farm1, farm2, farm2);

    }

    public void fillTiles(GameMap Map, Farm farm) {
        //todo bad taghir dadan tartib farm ha eslah beshe


        for (int i = farm.getQuarry().getLocation().getY(); i < farm.getQuarry().getLocation().getY() + farm.getQuarry().getHeight(); i++) {
            for (int j = farm.getQuarry().getLocation().getX(); j < farm.getQuarry().getLocation().getX() + farm.getQuarry().getWidth(); j++) {
                Map.tiles[i][j] = new Tile(new Location(i, j), "Q", true, false);
            }
        }
        for (int i = farm.getLake().getLocation().getY(); i < farm.getLake().getLocation().getY() + farm.getLake().getHeight(); i++) {
            for (int j = farm.getLake().getLocation().getX(); j < farm.getLake().getLocation().getX() + farm.getLake().getWidth(); j++) {
                Map.tiles[i][j] = new Tile(new Location(i, j), "L", false, false);
            }
        }
        for (int i = farm.getHouse().getLocation().getY(); i < farm.getHouse().getLocation().getY() + farm.getHouse().getHeight(); i++) {
            for (int j = farm.getHouse().getLocation().getX(); j < farm.getHouse().getLocation().getX() + farm.getHouse().getWidth(); j++) {
                Map.tiles[i][j] = new Tile(new Location(i, j), "H", true, false);
            }
        }
        for (int i = farm.getGreenHouse().getLocation().getY(); i < farm.getGreenHouse().getLocation().getY() + farm.getGreenHouse().getHeight(); i++) {
            for (int j = farm.getGreenHouse().getLocation().getX(); j < farm.getGreenHouse().getLocation().getX() + farm.getGreenHouse().getWidth(); j++) {
                Map.tiles[i][j] = new Tile(new Location(i, j), "G", true, false);
            }
        }


    }


}
