package model.Map;


public class mapBuilder {
    public void fillOtherTiles(GameMap map){
        //hesaar haaye mazrae
        for(int i=0;i<41;i++){
            map.tiles[i][20]=new Tile(new Location(i,20),"#",false,false,TileType.building);
            map.tiles[i][139]=new Tile(new Location(i,139),"#",false,false,TileType.building);
        }
        //hesaar haaye mazrae
        for(int j=0;j<20;j++){
            map.tiles[20][j]=new Tile(new Location(20,j),"#",false,false,TileType.building);
            map.tiles[20][j+140]=new Tile(new Location(20,j+140),"#",false,false,TileType.building);
        }
        //dar haaye mazrae
        for(int i=8;i<11;i++){
            map.tiles[i][20]=new Tile(new Location(i,20),"=",true,false,TileType.building);
            map.tiles[i+22][139]=new Tile(new Location(i+22,139),"=",true,false,TileType.building);
            map.tiles[i+22][20]=new Tile(new Location(i+22,20),"=",true,false,TileType.building);
            map.tiles[i][139]=new Tile(new Location(i,139),"=",true,false,TileType.building);
        }
        //hesaarhaaye golkhoone
        for(int i=15;i<20;i++){
            map.tiles[i][13]=new Tile(new Location(i,13),"#",false,false,TileType.building);
            map.tiles[i+21][13]=new Tile(new Location(i+21,13),"#",false,false,TileType.building);
        }
        for(int i=0;i<5;i++){
            map.tiles[i][146]=new Tile(new Location(i,146),"#",false,false,TileType.building);
            map.tiles[i+21][146]=new Tile(new Location(i+21,146),"#",false,false,TileType.building);
        }
        villageBuilder(map);
    }
    public  void villageBuilder(GameMap map){
         for(int i=10;i<31;i++){
             map.tiles[i][35]=new Tile(new Location(i,35),"#",false,false,TileType.building);
             map.tiles[i][124]=new Tile(new Location(i,124),"#",false,false,TileType.building);
             if(i==19||i==20||i==21){
                 map.tiles[i][124]=new Tile(new Location(i,124),"=",true,false,TileType.building);
                 map.tiles[i][35]=new Tile(new Location(i,124),"=",true,false,TileType.building);
             }
         }
         for (int j=35;j<125;j++){
             map.tiles[10][j]=new Tile(new Location(10,j),"#",false,false,TileType.building);
             map.tiles[31][j]=new Tile(new Location(31,j),"#",false,false,TileType.building);
             if(j==79||j==80||j==81||j==82||j==83){
                 map.tiles[10][j]=new Tile(new Location(10,j),"=",true,false,TileType.building);
                 map.tiles[31][j]=new Tile(new Location(31,j),"=",true,false,TileType.building);
             }
         }
    }
}
