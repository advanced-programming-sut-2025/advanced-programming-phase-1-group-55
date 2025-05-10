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
    public Farm farm1 = new Farm(house1, lake1, greenHouse1, quarry1);
    public Farm farm2 = new Farm(house2, lake2, greenHouse2, quarry2);

    public GameMap mapCreator() {
        //todo memeber ha select konan map haro masalan map selcetive 1 ,2 ,3 ,4 dashte bashim
        //todo npc add beshe
        return new GameMap(farm1, farm1, farm2, farm2);

    }

    public void fillTiles(GameMap Map) {
        //todo bad taghir dadan tartib farm ha eslah beshe
        Farm f1 = farm1;
        Farm f2 = farm2;
        Farm f3 = farm2;
        Farm f4 = farm2;

        for (int i = f1.getQuarry().getLocation().getY(); i < f1.getQuarry().getLocation().getY() + f1.getQuarry().getHeight(); i++) {
            for (int j = f1.getQuarry().getLocation().getX(); j < f1.getQuarry().getLocation().getX() + f1.getQuarry().getWidth(); j++) {
                Map.tiles[i][j] = new Tile(new Location(i, j), "Q", true, false);
            }
        }
        for (int i = f1.getLake().getLocation().getY(); i < f1.getLake().getLocation().getY() + f1.getLake().getHeight(); i++) {
            for (int j = f1.getLake().getLocation().getX(); j < f1.getLake().getLocation().getX() + f1.getLake().getWidth(); j++) {
                Map.tiles[i][j] = new Tile(new Location(i, j), "L", false, false);
            }
        }
        for (int i = f1.getHouse().getLocation().getY(); i < f1.getHouse().getLocation().getY() + f1.getHouse().getHeight(); i++) {
            for (int j = f1.getHouse().getLocation().getX(); j < f1.getHouse().getLocation().getX() + f1.getHouse().getWidth(); j++) {
                Map.tiles[i][j] = new Tile(new Location(i, j), "H", true, false);
            }
        }
        for (int i = f1.getGreenHouse().getLocation().getY(); i < f1.getGreenHouse().getLocation().getY() + f1.getGreenHouse().getHeight(); i++) {
            for (int j = f1.getGreenHouse().getLocation().getX(); j < f1.getGreenHouse().getLocation().getX() + f1.getGreenHouse().getWidth(); j++) {
                Map.tiles[i][j] = new Tile(new Location(i, j), "G", true, false);
            }
        }


    }


}
