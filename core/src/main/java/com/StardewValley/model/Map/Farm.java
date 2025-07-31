package com.StardewValley.model.Map;

import com.StardewValley.model.Animal.Animal;
import com.StardewValley.model.Animal.AnimalBuilding;
import com.StardewValley.model.Animal.FarmAnimalType;
import com.StardewValley.model.App;
import com.StardewValley.model.FarmingProdocts.ForagingCrops;
import com.StardewValley.model.FarmingProdocts.ForagingSeed;
import com.StardewValley.model.FarmingProdocts.Tree;
import com.StardewValley.model.Item.CollisionRect;
import com.StardewValley.model.Rock;
import com.StardewValley.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Farm {

    private House house;
    private Lake lake;
    private GreenHouse greenHouse;
    private CollisionRect collisionRect;
    private int numberOfRocksInTheQuery=0;
    private ArrayList<AnimalBuilding> animalBuildings = new ArrayList<>();
    private ArrayList<Fence> doors = new ArrayList<>();


    private Quarry quarry;
    private Map<Location, Rock> rocks = new HashMap<>();
    private Map<Location, Tree> trees = new HashMap<>();
    private Map<Location, ForagingCrops> crobs = new HashMap<>();
    private Map<Location, ForagingSeed> seeds=new HashMap<>();

    public Farm(House house, Lake lake, GreenHouse greenHouse, Quarry quarry, CollisionRect collisionRect) {
        this.house = house;
        this.lake = lake;
        this.greenHouse = greenHouse;
        this.quarry = quarry;
        this.collisionRect = collisionRect;

    }
   public void increaseRocks(){
        numberOfRocksInTheQuery++;
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
            return App.currentGameModel.getMap().tiles[x][y];
//        }
//        return null;
    }
    private boolean isTileGoodForAnimalBuilding(Tile tile) {
        return (tile.getType() == TileType.grass && tile.getItemInThisTile() == null);
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
    public void buildAnimalBuilding(AnimalBuilding building)
    {
        animalBuildings.add(building);
        for (Tile tile : building.getTiles())
        {

            tile.setType(TileType.ANIMAL_BUILDING);
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


    public int getNumberOfRocksInTheQuery() {
        return numberOfRocksInTheQuery;
    }

    public void setNumberOfRocksInTheQuery(int numberOfRocksInTheQuery) {
        this.numberOfRocksInTheQuery = numberOfRocksInTheQuery;
    }
    public void draw(){
        lake.getSprite().setPosition(lake.getCollisionRect().getX(), lake.getCollisionRect().getY());
        quarry.getSprite().setPosition(quarry.getCollisionRect().getX(), quarry.getCollisionRect().getY());
        house.getSprite().setPosition(house.getCollisionRect().getX(), house.getCollisionRect().getY());
        greenHouse.getSprite().setPosition(greenHouse.getCollisionRect().getX(), greenHouse.getCollisionRect().getY());
        lake.getSprite().draw(App.gameApp.getBatch());
        quarry.getSprite().draw(App.gameApp.getBatch());
        house.getSprite().draw(App.gameApp.getBatch());
        greenHouse.getSprite().draw(App.gameApp.getBatch());
    }

    public CollisionRect getCollisionRect() {
        return collisionRect;
    }

    public void setCollisionRect(CollisionRect collisionRect) {
        this.collisionRect = collisionRect;
    }

    public void setAnimalBuildings(ArrayList<AnimalBuilding> animalBuildings) {
        this.animalBuildings = animalBuildings;
    }


    public ArrayList<Fence> getDoors() {
        return doors;
    }

    public void setDoors(ArrayList<Fence> doors) {
        this.doors = doors;
    }
}
