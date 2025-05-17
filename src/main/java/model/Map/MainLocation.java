package model.Map;

import model.App;

public enum MainLocation {
    House,
    NearTheWater,
    GreenHouse,
    Quarry,
    Default,
    BlackSmithStore,
    CarpenterShop,
    FishingStore,
    GeneralStore,
    MarineRanchStore,
    OjaMartStore,
    StarDropSaloon,
    nearSEBASTIAN,
    nearABIGAIL
    ,nearHARVEY
    ,nearLEAH
    , nearROBIN
    ,nearTheBin;
    public static boolean isNearTheWater(Location location){
        GameMap map=App.currentGame.getMap();
        if(map.tiles[location.getY()+1][location.getX()+1].getTexture().equals(TileType.water)){
            return true;
        }else if(map.tiles[location.getY()][location.getX()+1].getTexture().equals(TileType.water)){
            return true;
        }else if(map.tiles[location.getY()+1][location.getX()].getTexture().equals(TileType.water)){
            return true;
        }else if(map.tiles[location.getY()-1][location.getX()+1].getTexture().equals(TileType.water)){
            return true;
        }else if(map.tiles[location.getY()+1][location.getX()-1].getTexture().equals(TileType.water)){
            return true;
        }else if(map.tiles[location.getY()-1][location.getX()-1].getTexture().equals(TileType.water)){
            return true;
        }else if(map.tiles[location.getY()][location.getX()-1].getTexture().equals(TileType.water)){
            return true;
        }else return map.tiles[location.getY() - 1][location.getX()].getTexture().equals(TileType.water);
    }
    public static Boolean isNearTheShippingBin(Location location){
        GameMap map=App.currentGame.getMap();
        if(map.tiles[location.getY()+1][location.getX()+1].getMohtaviat().equals("@")){
            return true;
        }else if(map.tiles[location.getY()][location.getX()+1].getMohtaviat().equals("@")){
            return true;
        }else if(map.tiles[location.getY()+1][location.getX()].getMohtaviat().equals("@")){
            return true;
        }else if(map.tiles[location.getY()-1][location.getX()+1].getMohtaviat().equals("@")){
            return true;
        }else if(map.tiles[location.getY()+1][location.getX()-1].getMohtaviat().equals("@")){
            return true;
        }else if(map.tiles[location.getY()-1][location.getX()-1].getMohtaviat().equals("@")){
            return true;
        }else if(map.tiles[location.getY()][location.getX()-1].getMohtaviat().equals("@")){
            return true;
        }else return map.tiles[location.getY() - 1][location.getX()].getMohtaviat().equals("@");
    }
    public static MainLocation findLocation(Location location){
        Farm farm=App.currentGame.currentUser.getFarm();
        if (location.isBetween(farm.getHouse().getLocation(),farm.getHouse().getWidth(),farm.getHouse().getHeight())){
            return House;
        } else if (location.isBetween(farm.getQuarry().getLocation(),farm.getQuarry().getWidth(),farm.getQuarry().getHeight())) {
            return Quarry;
        }else if (location.isBetween(farm.getGreenHouse().getLocation(),farm.getGreenHouse().getWidth(),farm.getGreenHouse().getHeight())) {
            return GreenHouse;
        }else if (isNearTheWater(location)) {
            return NearTheWater;
        } else if (isNearTheShippingBin(location)) {
            return nearTheBin;
        } else if (location.isBetween(new Location(23,36),5,7)) {

            return FishingStore;
        }else if (location.isBetween(new Location(11,36),5,7)) {
            return StarDropSaloon;
        }else if (location.isBetween(new Location(23,48),5,7)) {
            return MarineRanchStore;
        }else if (location.isBetween(new Location(11,48),5,7)) {
            return BlackSmithStore;
        }else if (location.isBetween(new Location(23,60),5,7)) {
            return nearABIGAIL;
        }else if (location.isBetween(new Location(11,60),5,7)) {
            return OjaMartStore;
        }else if (location.isBetween(new Location(23,80),5,7)) {
            return nearHARVEY;
        }else if (location.isBetween(new Location(11,80),5,7)) {
            return nearSEBASTIAN;
        }else if (location.isBetween(new Location(23,93),5,7)) {
            return nearLEAH;
        }else if (location.isBetween(new Location(11,93),5,7)) {
            return GeneralStore;
        }else if (location.isBetween(new Location(23,109),5,7)) {
            return nearROBIN;
        }else if (location.isBetween(new Location(11,109),5,7)) {
            return CarpenterShop;
        }
        return Default;
    }
}
