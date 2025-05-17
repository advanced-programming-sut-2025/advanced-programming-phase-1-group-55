package model.Animal;

import model.App;
import model.Item.Item;
import model.Map.Location;
import model.Map.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class AnimalBuilding extends Item {
    private final Tile startTile;
    private final FarmBuildingType farmBuildingType;
    private final int cost;
    private final int capacity;
    private final ArrayList<Animal> animals = new ArrayList<>();
    private final int height;
    private final int width;
    public AnimalBuilding(Tile startTile, FarmBuildingType farmBuilding)
    {
        this.startTile = startTile;
        this.farmBuildingType = farmBuilding;
        this.capacity = farmBuilding.getCapacity();
        this.cost = farmBuilding.getPrice();
        super.itemType = itemType.ANIMAL_BUILDING;
        this.height = farmBuilding.getHeight();
        this.width = farmBuilding.getWidth();
    }
    public FarmBuildingType getFarmBuildingType() {
        return farmBuildingType;
    }
    public Location getLocation(){
        return  startTile.getLocation();
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
//    public ArrayList<Location> getTiles() {
//        ArrayList<Location> tiles = new ArrayList<>();
//        for (int y = 0; y < height; y++) {
//            for (int x = 0; x < width; x++) {
//                tiles.add(new Location(x, y));
//            }
//        }
//        return tiles;
//    }
    public ArrayList<Tile> getTiles()
    {
        int baseX = startTile.getLocation().getX();
        int baseY = startTile.getLocation().getY();

        ArrayList<Tile> temp = new ArrayList<>();
        for (int y = 0; y <= height; y++)
        {
            for (int x = 0; x <= width; x++)
            {
                Tile tile = App.currentGame.currentUser.getFarm().getTile(baseX + x, baseY + y);
                temp.add(tile);
            }
        }

        return temp;
    }






    public boolean hasCapacity()
    {
//        if (capacity == -1)
//        {
//            return true;
//        }
//
////        return (capacity - faghatVaseShipingBin.size()) > 0;
//        return false;
        return true;
    }
//    public void putAnimalInBuilding(Animal animal, ArrayList<Tile> tiles, ArrayList<Animal> animals) {
//        animals.add(animal); // اضافه کردن حیوان به لیست حیوانات
//
//        ArrayList<Tile> copy = new ArrayList<>(tiles);
//
//        // حذف کاشی‌هایی که قبلاً اشغال شده‌اند
//        copy.removeIf(tile -> tile.getItemInThisTile() != null);
//
//        // بررسی اینکه کاشی آزاد وجود دارد یا نه
//        if (!copy.isEmpty()) {
//            Collections.shuffle(copy); // برای تصادفی بودن مکان حیوان
//
//            for (Tile tile : copy) {
//                if (tile.isEmpty() && tile.isWalkable()) {
//                    tile.setItemInThisTile(animal); // قرار دادن حیوان روی کاشی
//                    tile.setEmpty(false);
//                    animal.setTile(tile); // ثبت مکان حیوان در خودش
//                    break;
//                }
//            }
//        }
//    }
public void putAnimalInBuilding(Animal animal)
{
    animals.add(animal);

    ArrayList<Tile> tiles = getTiles();
    ArrayList<Tile> copy = new ArrayList<>(tiles);

    Iterator<Tile> iterator = copy.iterator();
    while (iterator.hasNext()) {
        Tile tile = iterator.next();
        if (tile.getItemInThisTile() != null) {
            iterator.remove();
        }
    }

    // TODO
//        if (copy.size() > 0)
//       {
    Collections.shuffle(copy);

    Tile tile = copy.get(0);
    animal.setTile(tile);
    tile.setItemInThisTile(animal);
//       }
}
    public void sellAnimal(Animal animal)
    {
        animals.remove(animal);
    }

    public Tile getStartTile() {
        return startTile;
    }

    public int getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
