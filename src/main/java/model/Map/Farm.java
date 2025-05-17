package model.Map;

import model.Animal.Animal;
import model.Animal.AnimalBuilding;
import model.Animal.FarmAnimalType;
import model.App;
import model.FarmingProdocts.ForagingCrops;
import model.FarmingProdocts.ForagingSeed;
import model.FarmingProdocts.Tree;
import model.Rock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Farm {
    private Location location;
    private House house;
    private Lake lake;
    private GreenHouse greenHouse;
    private int HEIGHT = 20;
    private int WIDTH = 20;
    private ArrayList<AnimalBuilding> animalBuildings = new ArrayList<>();
 
    public int getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    private Quarry quarry;
    private Map<Location, Rock> rocks = new HashMap<>();
    private Map<Location, Tree> trees = new HashMap<>();
    private Map<Location, ForagingCrops> crobs = new HashMap<>();
    private Map<Location, ForagingSeed> seeds=new HashMap<>();

    public Farm(House house, Lake lake, GreenHouse greenHouse, Quarry quarry, Location location) {
        this.house = house;
        this.lake = lake;
        this.greenHouse = greenHouse;
        this.quarry = quarry;
        this.location = location;
    }


    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Lake getLake() {
        return lake;
    }

    public void setLake(Lake lake) {
        this.lake = lake;
    }

    public GreenHouse getGreenHouse() {
        return greenHouse;
    }

    public void setGreenHouse(GreenHouse greenHouse) {
        this.greenHouse = greenHouse;
    }

    public Quarry getQuarry() {
        return quarry;
    }

    public void setQuarry(Quarry quarry) {
        this.quarry = quarry;
    }

    public Map<Location, Rock> getRocks() {
        return rocks;
    }

    public void setRocks(Map<Location, Rock> rocks) {
        this.rocks = rocks;
    }

    public Map<Location, Tree> getTrees() {
        return trees;
    }

    public void setTrees(Map<Location, Tree> trees) {
        this.trees = trees;
    }

    public Map<Location, ForagingCrops> getCrobs() {
        return crobs;
    }

    public void setCrobs(Map<Location, ForagingCrops> crobs) {
        this.crobs = crobs;
    }

    public Map<Location, ForagingSeed> getSeeds() {
        return seeds;
    }

    public void setSeeds(Map<Location, ForagingSeed> seeds) {
        this.seeds = seeds;
    }


    public boolean isInBounds(int x, int y)
    {
        return x >= 0 && x < 20 && y >= 0 && y < 20;
    }
    public Tile getTile(int x, int y)
    {
        if (!isInBounds(x, y)) return null;
//        if (isInBounds(x, y))
//        {
            return App.currentGame.getMap().tiles[x][y];
//        }
//        return null;
    }
    private boolean isTileGoodForAnimalBuilding(Tile tile) {
        return (tile.getTexture() == TileTexture.grass && tile.getItemInThisTile() == null);
    }
    public boolean isGoodForAnimalBuilding(Tile tile, int width, int height)
    {
        for (int y = 0; y <= height; y++)
        {
            for (int x = 0; x <= width; x++)
            {
                if (!isTileGoodForAnimalBuilding(tile))
                {
                    return false;
                }
            }
        }
        return true;
    }
    public ArrayList<Tile> getStartTileForAnimalBuilding(int width, int height)
    {
        ArrayList<Tile> startTiles = new ArrayList<>();
        for (int y = 0; y < HEIGHT - height; y++)
        {
            for (int x = 0; x < WIDTH - width; x++)
            {
                Tile tile = getTile(x, y);
                if (isGoodForAnimalBuilding(tile, width, height))
                {
                    startTiles.add(tile);
                }
            }
        }
        return startTiles;
    }
    public void buildAnimalBuilding(AnimalBuilding building)
    {
        animalBuildings.add(building);
        for (Tile tile : building.getTiles())
        {

            tile.setTexture(TileTexture.ANIMAL_BUILDING);
        }
    }
    public AnimalBuilding getBuildingForAnimal(FarmAnimalType animalType)
    {
        for (AnimalBuilding animalBuilding : animalBuildings)
        {
            if (animalType.getBuildings().contains(animalBuilding.getFarmBuildingType()))
            {
                if (animalBuilding.hasCapacity())
                {
                    return animalBuilding;
                }
            }
        }
        return null;
    }
    public ArrayList<AnimalBuilding> getAnimalBuildings()
    {
        return animalBuildings;
    }
    public AnimalBuilding getAnimalBuilding(Animal animal)
    {
        for (AnimalBuilding animalBuilding : animalBuildings)
        {
            if (animalBuilding.getAnimals().contains(animal))
            {
                return animalBuilding;
            }
        }
        return null;
    }
    public ArrayList<Location> getNeighbors(Location p)
    {
        ArrayList<Location> neighbors = new ArrayList<>();

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int dir = 0; dir < 4; dir++)
        {
            int newX = p.getX() + dx[dir];
            int newY = p.getY() + dy[dir];

            if (isInBounds(newX, newY))
            {
                neighbors.add(new Location(newX, newY));
            }
        }

        return neighbors;
    }



}
