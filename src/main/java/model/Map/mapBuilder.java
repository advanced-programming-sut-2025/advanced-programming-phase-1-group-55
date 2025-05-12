package model.Map;


public class mapBuilder {
    public void fillOtherTiles(GameMap map) {
        //hesaar haaye mazrae
        for (int i = 0; i < 41; i++) {
            map.tiles[i][20] = new Tile(new Location(i, 20), "#", false, false, TileType.building);
            map.tiles[i][139] = new Tile(new Location(i, 139), "#", false, false, TileType.building);
        }
        //hesaar haaye mazrae
        for (int j = 0; j < 20; j++) {
            map.tiles[20][j] = new Tile(new Location(20, j), "#", false, false, TileType.building);
            map.tiles[20][j + 140] = new Tile(new Location(20, j + 140), "#", false, false, TileType.building);
        }
        //dar haaye mazrae
        for (int i = 8; i < 11; i++) {
            map.tiles[i][20] = new Tile(new Location(i, 20), "=", true, false, TileType.building);
            map.tiles[i + 22][139] = new Tile(new Location(i + 22, 139), "=", true, false, TileType.building);
            map.tiles[i + 22][20] = new Tile(new Location(i + 22, 20), "=", true, false, TileType.building);
            map.tiles[i][139] = new Tile(new Location(i, 139), "=", true, false, TileType.building);
        }
        //hesaarhaaye golkhoone
        for (int i = 15; i < 20; i++) {
            map.tiles[i][13] = new Tile(new Location(i, 13), "#", false, false, TileType.building);
            map.tiles[i + 21][13] = new Tile(new Location(i + 21, 13), "#", false, false, TileType.building);
        }
        for (int i = 0; i < 5; i++) {
            map.tiles[i][146] = new Tile(new Location(i, 146), "#", false, false, TileType.building);
            map.tiles[i + 21][146] = new Tile(new Location(i + 21, 146), "#", false, false, TileType.building);
        }
        villageBuilder(map);
    }
    public void insideOfStore(GameMap map){
        for(int i=13;i<16;i++){
            for (int j=38;j<44;j++){
                map.tiles[i][j]=new Tile(new Location(i,j),"$",true,false,TileType.building);
                map.tiles[i][j+12]=new Tile(new Location(i,j+12),"B",true,false,TileType.building);
                map.tiles[i][j+24]=new Tile(new Location(i,j+24),"O",true,false,TileType.building);
                map.tiles[i][j+44]=new Tile(new Location(i,j+44),"S",true,false,TileType.building);
                map.tiles[i][j+57]=new Tile(new Location(i,j+57),"G",true,false,TileType.building);
                map.tiles[i][j+73]=new Tile(new Location(i,j+73),"C",true,false,TileType.building);
                map.tiles[i+12][j]=new Tile(new Location(i+12,j),"F",true,false,TileType.building);
                map.tiles[i+12][j+12]=new Tile(new Location(i+12,j+12),"M",true,false,TileType.building);
                map.tiles[i+12][j+24]=new Tile(new Location(i+12,j+24),"A",true,false,TileType.building);
                map.tiles[i+12][j+44]=new Tile(new Location(i+12,j+44),"H",true,false,TileType.building);
                map.tiles[i+12][j+57]=new Tile(new Location(i+12,j+57),"L",true,false,TileType.building);
                map.tiles[i+12][j+73]=new Tile(new Location(i+12,j+73),"R",true,false,TileType.building);

            }
        }
    }
    public void placeStore(GameMap map){
        //place stores and npc
        for(int i=12;i<17;i++){
            map.tiles[i][37]=new Tile(new Location(i,37),"#",false,false,TileType.building);
            map.tiles[i][44]=new Tile(new Location(i,44),"#",false,false,TileType.building);
            map.tiles[i+12][37]=new Tile(new Location(i+12,37),"#",false,false,TileType.building);
            map.tiles[i+12][44]=new Tile(new Location(i+12,44),"#",false,false,TileType.building);
            map.tiles[i][49]=new Tile(new Location(i,49),"#",false,false,TileType.building);
            map.tiles[i][56]=new Tile(new Location(i,56),"#",false,false,TileType.building);
            map.tiles[i+12][49]=new Tile(new Location(i+12,49),"#",false,false,TileType.building);
            map.tiles[i+12][56]=new Tile(new Location(i+12,56),"#",false,false,TileType.building);
            map.tiles[i][61]=new Tile(new Location(i,61),"#",false,false,TileType.building);
            map.tiles[i][68]=new Tile(new Location(i,68),"#",false,false,TileType.building);
            map.tiles[i+12][61]=new Tile(new Location(i+12,61),"#",false,false,TileType.building);
            map.tiles[i+12][68]=new Tile(new Location(i+12,68),"#",false,false,TileType.building);
            map.tiles[i][81]=new Tile(new Location(i,81),"#",false,false,TileType.building);
            map.tiles[i][88]=new Tile(new Location(i,88),"#",false,false,TileType.building);
            map.tiles[i+12][81]=new Tile(new Location(i+12,81),"#",false,false,TileType.building);
            map.tiles[i+12][88]=new Tile(new Location(i+12,88),"#",false,false,TileType.building);
            map.tiles[i][94]=new Tile(new Location(i,94),"#",false,false,TileType.building);
            map.tiles[i][101]=new Tile(new Location(i,101),"#",false,false,TileType.building);
            map.tiles[i+12][94]=new Tile(new Location(i+12,94),"#",false,false,TileType.building);
            map.tiles[i+12][101]=new Tile(new Location(i+12,101),"#",false,false,TileType.building);
            map.tiles[i][110]=new Tile(new Location(i,110),"#",false,false,TileType.building);
            map.tiles[i][117]=new Tile(new Location(i,117),"#",false,false,TileType.building);
            map.tiles[i+12][110]=new Tile(new Location(i+12,110),"#",false,false,TileType.building);
            map.tiles[i+12][117]=new Tile(new Location(i+12,117),"#",false,false,TileType.building);
        }
        for(int j=37;j<45;j++){
            map.tiles[12][j]=new Tile(new Location(12,j),"#",false,false,TileType.building);
            map.tiles[16][j]=new Tile(new Location(16,j),"#",false,false,TileType.building);
            map.tiles[24][j]=new Tile(new Location(14,j),"#",false,false,TileType.building);
            map.tiles[28][j]=new Tile(new Location(28,j),"#",false,false,TileType.building);
            map.tiles[12][j+12]=new Tile(new Location(12,j+12),"#",false,false,TileType.building);
            map.tiles[16][j+12]=new Tile(new Location(16,j+12),"#",false,false,TileType.building);
            map.tiles[24][j+12]=new Tile(new Location(14,j+12),"#",false,false,TileType.building);
            map.tiles[28][j+12]=new Tile(new Location(28,j+12),"#",false,false,TileType.building);
            map.tiles[12][j+24]=new Tile(new Location(12,j+24),"#",false,false,TileType.building);
            map.tiles[16][j+24]=new Tile(new Location(16,j+24),"#",false,false,TileType.building);
            map.tiles[24][j+24]=new Tile(new Location(14,j+24),"#",false,false,TileType.building);
            map.tiles[28][j+24]=new Tile(new Location(28,j+24),"#",false,false,TileType.building);
            map.tiles[12][j+44]=new Tile(new Location(12,j+44),"#",false,false,TileType.building);
            map.tiles[16][j+44]=new Tile(new Location(16,j+44),"#",false,false,TileType.building);
            map.tiles[24][j+44]=new Tile(new Location(14,j+44),"#",false,false,TileType.building);
            map.tiles[28][j+44]=new Tile(new Location(28,j+44),"#",false,false,TileType.building);
            map.tiles[12][j+57]=new Tile(new Location(12,j+57),"#",false,false,TileType.building);
            map.tiles[16][j+57]=new Tile(new Location(16,j+57),"#",false,false,TileType.building);
            map.tiles[24][j+57]=new Tile(new Location(14,j+57),"#",false,false,TileType.building);
            map.tiles[28][j+57]=new Tile(new Location(28,j+57),"#",false,false,TileType.building);
            map.tiles[12][j+73]=new Tile(new Location(12,j+73),"#",false,false,TileType.building);
            map.tiles[16][j+73]=new Tile(new Location(16,j+73),"#",false,false,TileType.building);
            map.tiles[24][j+73]=new Tile(new Location(14,j+73),"#",false,false,TileType.building);
            map.tiles[28][j+73]=new Tile(new Location(28,j+73),"#",false,false,TileType.building);
            if(j==41||j==42){
                map.tiles[16][j]=new Tile(new Location(16,j),"=",true,false,TileType.building);
                map.tiles[28][j]=new Tile(new Location(28,j),"=",true,false,TileType.building);
                map.tiles[16][j+12]=new Tile(new Location(16,j+12),"=",true,false,TileType.building);
                map.tiles[28][j+12]=new Tile(new Location(28,j+12),"=",true,false,TileType.building);
                map.tiles[16][j+24]=new Tile(new Location(16,j+24),"=",true,false,TileType.building);
                map.tiles[28][j+24]=new Tile(new Location(28,j+24),"=",true,false,TileType.building);
                map.tiles[16][j+44]=new Tile(new Location(16,j+44),"=",true,false,TileType.building);
                map.tiles[28][j+44]=new Tile(new Location(28,j+44),"=",true,false,TileType.building);
                map.tiles[16][j+57]=new Tile(new Location(16,j+57),"=",true,false,TileType.building);
                map.tiles[28][j+57]=new Tile(new Location(28,j+57),"=",true,false,TileType.building);
                map.tiles[16][j+73]=new Tile(new Location(16,j+73),"=",true,false,TileType.building);
                map.tiles[28][j+73]=new Tile(new Location(28,j+73),"=",true,false,TileType.building);
            }
        }
        insideOfStore(map);

    }

    public void initializeMapTiles(GameMap map) {
        for (int i = 0; i < 41; i++) {
            for (int j = 0; j < 160; j++) {
                if (map.tiles[i][j] == null) {
                    map.tiles[i][j] = new Tile(new Location(i, j), ".", true, false, TileType.grass);
                }
            }
        }
    }


    public void insideOfStore(GameMap map) {
        for (int i = 13; i < 16; i++) {
            for (int j = 38; j < 44; j++) {
                //todo daakhel maghaaze
            }
        }
    }

    public void placeStore(GameMap map) {
        //place stores and npc
        for (int i = 12; i < 17; i++) {
            map.tiles[i][37] = new Tile(new Location(i, 37), "#", false, false, TileType.building);
            map.tiles[i][44] = new Tile(new Location(i, 44), "#", false, false, TileType.building);
            map.tiles[i + 12][37] = new Tile(new Location(i + 12, 37), "#", false, false, TileType.building);
            map.tiles[i + 12][44] = new Tile(new Location(i + 12, 44), "#", false, false, TileType.building);
            map.tiles[i][49] = new Tile(new Location(i, 49), "#", false, false, TileType.building);
            map.tiles[i][56] = new Tile(new Location(i, 56), "#", false, false, TileType.building);
            map.tiles[i + 12][49] = new Tile(new Location(i + 12, 49), "#", false, false, TileType.building);
            map.tiles[i + 12][56] = new Tile(new Location(i + 12, 56), "#", false, false, TileType.building);
            map.tiles[i][61] = new Tile(new Location(i, 61), "#", false, false, TileType.building);
            map.tiles[i][68] = new Tile(new Location(i, 68), "#", false, false, TileType.building);
            map.tiles[i + 12][61] = new Tile(new Location(i + 12, 61), "#", false, false, TileType.building);
            map.tiles[i + 12][68] = new Tile(new Location(i + 12, 68), "#", false, false, TileType.building);
            map.tiles[i][81] = new Tile(new Location(i, 81), "#", false, false, TileType.building);
            map.tiles[i][88] = new Tile(new Location(i, 88), "#", false, false, TileType.building);
            map.tiles[i + 12][81] = new Tile(new Location(i + 12, 81), "#", false, false, TileType.building);
            map.tiles[i + 12][88] = new Tile(new Location(i + 12, 88), "#", false, false, TileType.building);
            map.tiles[i][94] = new Tile(new Location(i, 94), "#", false, false, TileType.building);
            map.tiles[i][101] = new Tile(new Location(i, 101), "#", false, false, TileType.building);
            map.tiles[i + 12][94] = new Tile(new Location(i + 12, 94), "#", false, false, TileType.building);
            map.tiles[i + 12][101] = new Tile(new Location(i + 12, 101), "#", false, false, TileType.building);
            map.tiles[i][110] = new Tile(new Location(i, 110), "#", false, false, TileType.building);
            map.tiles[i][117] = new Tile(new Location(i, 117), "#", false, false, TileType.building);
            map.tiles[i + 12][110] = new Tile(new Location(i + 12, 110), "#", false, false, TileType.building);
            map.tiles[i + 12][117] = new Tile(new Location(i + 12, 117), "#", false, false, TileType.building);
        }
        for (int j = 37; j < 45; j++) {
            map.tiles[12][j] = new Tile(new Location(12, j), "#", false, false, TileType.building);
            map.tiles[16][j] = new Tile(new Location(16, j), "#", false, false, TileType.building);
            map.tiles[24][j] = new Tile(new Location(14, j), "#", false, false, TileType.building);
            map.tiles[28][j] = new Tile(new Location(28, j), "#", false, false, TileType.building);
            map.tiles[12][j + 12] = new Tile(new Location(12, j + 12), "#", false, false, TileType.building);
            map.tiles[16][j + 12] = new Tile(new Location(16, j + 12), "#", false, false, TileType.building);
            map.tiles[24][j + 12] = new Tile(new Location(14, j + 12), "#", false, false, TileType.building);
            map.tiles[28][j + 12] = new Tile(new Location(28, j + 12), "#", false, false, TileType.building);
            map.tiles[12][j + 24] = new Tile(new Location(12, j + 24), "#", false, false, TileType.building);
            map.tiles[16][j + 24] = new Tile(new Location(16, j + 24), "#", false, false, TileType.building);
            map.tiles[24][j + 24] = new Tile(new Location(14, j + 24), "#", false, false, TileType.building);
            map.tiles[28][j + 24] = new Tile(new Location(28, j + 24), "#", false, false, TileType.building);
            map.tiles[12][j + 44] = new Tile(new Location(12, j + 44), "#", false, false, TileType.building);
            map.tiles[16][j + 44] = new Tile(new Location(16, j + 44), "#", false, false, TileType.building);
            map.tiles[24][j + 44] = new Tile(new Location(14, j + 44), "#", false, false, TileType.building);
            map.tiles[28][j + 44] = new Tile(new Location(28, j + 44), "#", false, false, TileType.building);
            map.tiles[12][j + 57] = new Tile(new Location(12, j + 57), "#", false, false, TileType.building);
            map.tiles[16][j + 57] = new Tile(new Location(16, j + 57), "#", false, false, TileType.building);
            map.tiles[24][j + 57] = new Tile(new Location(14, j + 57), "#", false, false, TileType.building);
            map.tiles[28][j + 57] = new Tile(new Location(28, j + 57), "#", false, false, TileType.building);
            map.tiles[12][j + 73] = new Tile(new Location(12, j + 73), "#", false, false, TileType.building);
            map.tiles[16][j + 73] = new Tile(new Location(16, j + 73), "#", false, false, TileType.building);
            map.tiles[24][j + 73] = new Tile(new Location(14, j + 73), "#", false, false, TileType.building);
            map.tiles[28][j + 73] = new Tile(new Location(28, j + 73), "#", false, false, TileType.building);
            if (j == 41 || j == 42) {
                map.tiles[16][j] = new Tile(new Location(16, j), "=", true, false, TileType.building);
                map.tiles[28][j] = new Tile(new Location(28, j), "=", true, false, TileType.building);
                map.tiles[16][j + 12] = new Tile(new Location(16, j + 12), "=", true, false, TileType.building);
                map.tiles[28][j + 12] = new Tile(new Location(28, j + 12), "=", true, false, TileType.building);
                map.tiles[16][j + 24] = new Tile(new Location(16, j + 24), "=", true, false, TileType.building);
                map.tiles[28][j + 24] = new Tile(new Location(28, j + 24), "=", true, false, TileType.building);
                map.tiles[16][j + 44] = new Tile(new Location(16, j + 44), "=", true, false, TileType.building);
                map.tiles[28][j + 44] = new Tile(new Location(28, j + 44), "=", true, false, TileType.building);
                map.tiles[16][j + 57] = new Tile(new Location(16, j + 57), "=", true, false, TileType.building);
                map.tiles[28][j + 57] = new Tile(new Location(28, j + 57), "=", true, false, TileType.building);
                map.tiles[16][j + 73] = new Tile(new Location(16, j + 73), "=", true, false, TileType.building);
                map.tiles[28][j + 73] = new Tile(new Location(28, j + 73), "=", true, false, TileType.building);
            }
        }

    }

    public void villageBuilder(GameMap map) {
        for (int i = 10; i < 31; i++) {
            map.tiles[i][35] = new Tile(new Location(i, 35), "#", false, false, TileType.building);
            map.tiles[i][124] = new Tile(new Location(i, 124), "#", false, false, TileType.building);
            if (i == 19 || i == 20 || i == 21) {
                map.tiles[i][124] = new Tile(new Location(i, 124), "=", true, false, TileType.building);
                map.tiles[i][35] = new Tile(new Location(i, 124), "=", true, false, TileType.building);
            }
        }
        for (int j = 35; j < 125; j++) {
            map.tiles[10][j] = new Tile(new Location(10, j), "#", false, false, TileType.building);
            map.tiles[31][j] = new Tile(new Location(31, j), "#", false, false, TileType.building);
            if (j == 79 || j == 80 || j == 81 || j == 82 || j == 83) {
                map.tiles[10][j] = new Tile(new Location(10, j), "=", true, false, TileType.building);
                map.tiles[31][j] = new Tile(new Location(31, j), "=", true, false, TileType.building);
            }
        }
        placeStore(map);

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
         placeStore(map);
    }
}
