package com.StardewValley.model.Map;


import com.StardewValley.enums.AssetManager;
import com.StardewValley.model.App;
import com.StardewValley.model.Item.CollisionRect;
import com.StardewValley.model.Store.Store;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class MapBuilder {
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
        // baaghi tile haa ke khaali an
        for(int i=0;i<41;i++){
            for ( int j=0;j<160;j++){
                if(map.tiles[i][j]==null){
                    map.tiles[i][j]=new Tile(new Location(i,j),".",true,true, TileType.grass);
                }
            }
        }
    }
    public void insideOfStore(GameMap map){
        for(int i=13;i<16;i++){
            for (int j=38;j<44;j++){
                map.tiles[i][j]=new Tile(new Location(i,j),"$",true,false, TileType.building);
                map.tiles[i][j+12]=new Tile(new Location(i,j+12),"B",true,false, TileType.building);
                map.tiles[i][j+24]=new Tile(new Location(i,j+24),"O",true,false, TileType.building);
                map.tiles[i][j+44]=new Tile(new Location(i,j+44),"S",true,false, TileType.building);
                map.tiles[i][j+57]=new Tile(new Location(i,j+57),"G",true,false, TileType.building);
                map.tiles[i][j+73]=new Tile(new Location(i,j+73),"C",true,false, TileType.building);
                map.tiles[i+12][j]=new Tile(new Location(i+12,j),"F",true,false, TileType.building);
                map.tiles[i+12][j+12]=new Tile(new Location(i+12,j+12),"M",true,false, TileType.building);
                map.tiles[i+12][j+24]=new Tile(new Location(i+12,j+24),"A",true,false, TileType.building);
                map.tiles[i+12][j+44]=new Tile(new Location(i+12,j+44),"H",true,false, TileType.building);
                map.tiles[i+12][j+57]=new Tile(new Location(i+12,j+57),"L",true,false, TileType.building);
                map.tiles[i+12][j+73]=new Tile(new Location(i+12,j+73),"R",true,false, TileType.building);

            }
        }
    }
    public void placeStore(GameMap map){
        //place stores and npc
        for(int i=12;i<17;i++){
            map.tiles[i][37]=new Tile(new Location(i,37),"#",false,false, TileType.building);
            map.tiles[i][44]=new Tile(new Location(i,44),"#",false,false, TileType.building);
            map.tiles[i+12][37]=new Tile(new Location(i+12,37),"#",false,false, TileType.building);
            map.tiles[i+12][44]=new Tile(new Location(i+12,44),"#",false,false, TileType.building);
            map.tiles[i][49]=new Tile(new Location(i,49),"#",false,false, TileType.building);
            map.tiles[i][56]=new Tile(new Location(i,56),"#",false,false, TileType.building);
            map.tiles[i+12][49]=new Tile(new Location(i+12,49),"#",false,false, TileType.building);
            map.tiles[i+12][56]=new Tile(new Location(i+12,56),"#",false,false, TileType.building);
            map.tiles[i][61]=new Tile(new Location(i,61),"#",false,false, TileType.building);
            map.tiles[i][68]=new Tile(new Location(i,68),"#",false,false, TileType.building);
            map.tiles[i+12][61]=new Tile(new Location(i+12,61),"#",false,false, TileType.building);
            map.tiles[i+12][68]=new Tile(new Location(i+12,68),"#",false,false, TileType.building);
            map.tiles[i][81]=new Tile(new Location(i,81),"#",false,false, TileType.building);
            map.tiles[i][88]=new Tile(new Location(i,88),"#",false,false, TileType.building);
            map.tiles[i+12][81]=new Tile(new Location(i+12,81),"#",false,false, TileType.building);
            map.tiles[i+12][88]=new Tile(new Location(i+12,88),"#",false,false, TileType.building);
            map.tiles[i][94]=new Tile(new Location(i,94),"#",false,false, TileType.building);
            map.tiles[i][101]=new Tile(new Location(i,101),"#",false,false, TileType.building);
            map.tiles[i+12][94]=new Tile(new Location(i+12,94),"#",false,false, TileType.building);
            map.tiles[i+12][101]=new Tile(new Location(i+12,101),"#",false,false, TileType.building);
            map.tiles[i][110]=new Tile(new Location(i,110),"#",false,false, TileType.building);
            map.tiles[i][117]=new Tile(new Location(i,117),"#",false,false, TileType.building);
            map.tiles[i+12][110]=new Tile(new Location(i+12,110),"#",false,false, TileType.building);
            map.tiles[i+12][117]=new Tile(new Location(i+12,117),"#",false,false, TileType.building);
        }
        for(int j=37;j<45;j++){
            map.tiles[12][j]=new Tile(new Location(12,j),"#",false,false, TileType.building);
            map.tiles[16][j]=new Tile(new Location(16,j),"#",false,false, TileType.building);
            map.tiles[24][j]=new Tile(new Location(14,j),"#",false,false, TileType.building);
            map.tiles[28][j]=new Tile(new Location(28,j),"#",false,false, TileType.building);
            map.tiles[12][j+12]=new Tile(new Location(12,j+12),"#",false,false, TileType.building);
            map.tiles[16][j+12]=new Tile(new Location(16,j+12),"#",false,false, TileType.building);
            map.tiles[24][j+12]=new Tile(new Location(14,j+12),"#",false,false, TileType.building);
            map.tiles[28][j+12]=new Tile(new Location(28,j+12),"#",false,false, TileType.building);
            map.tiles[12][j+24]=new Tile(new Location(12,j+24),"#",false,false, TileType.building);
            map.tiles[16][j+24]=new Tile(new Location(16,j+24),"#",false,false, TileType.building);
            map.tiles[24][j+24]=new Tile(new Location(14,j+24),"#",false,false, TileType.building);
            map.tiles[28][j+24]=new Tile(new Location(28,j+24),"#",false,false, TileType.building);
            map.tiles[12][j+44]=new Tile(new Location(12,j+44),"#",false,false, TileType.building);
            map.tiles[16][j+44]=new Tile(new Location(16,j+44),"#",false,false, TileType.building);
            map.tiles[24][j+44]=new Tile(new Location(14,j+44),"#",false,false, TileType.building);
            map.tiles[28][j+44]=new Tile(new Location(28,j+44),"#",false,false, TileType.building);
            map.tiles[12][j+57]=new Tile(new Location(12,j+57),"#",false,false, TileType.building);
            map.tiles[16][j+57]=new Tile(new Location(16,j+57),"#",false,false, TileType.building);
            map.tiles[24][j+57]=new Tile(new Location(14,j+57),"#",false,false, TileType.building);
            map.tiles[28][j+57]=new Tile(new Location(28,j+57),"#",false,false, TileType.building);
            map.tiles[12][j+73]=new Tile(new Location(12,j+73),"#",false,false, TileType.building);
            map.tiles[16][j+73]=new Tile(new Location(16,j+73),"#",false,false, TileType.building);
            map.tiles[24][j+73]=new Tile(new Location(14,j+73),"#",false,false, TileType.building);
            map.tiles[28][j+73]=new Tile(new Location(28,j+73),"#",false,false, TileType.building);
            if(j==41||j==42){
                map.tiles[16][j]=new Tile(new Location(16,j),"=",true,false, TileType.building);
                map.tiles[28][j]=new Tile(new Location(28,j),"=",true,false, TileType.building);
                map.tiles[16][j+12]=new Tile(new Location(16,j+12),"=",true,false, TileType.building);
                map.tiles[28][j+12]=new Tile(new Location(28,j+12),"=",true,false, TileType.building);
                map.tiles[16][j+24]=new Tile(new Location(16,j+24),"=",true,false, TileType.building);
                map.tiles[28][j+24]=new Tile(new Location(28,j+24),"=",true,false, TileType.building);
                map.tiles[16][j+44]=new Tile(new Location(16,j+44),"=",true,false, TileType.building);
                map.tiles[28][j+44]=new Tile(new Location(28,j+44),"=",true,false, TileType.building);
                map.tiles[16][j+57]=new Tile(new Location(16,j+57),"=",true,false, TileType.building);
                map.tiles[28][j+57]=new Tile(new Location(28,j+57),"=",true,false, TileType.building);
                map.tiles[16][j+73]=new Tile(new Location(16,j+73),"=",true,false, TileType.building);
                map.tiles[28][j+73]=new Tile(new Location(28,j+73),"=",true,false, TileType.building);
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
        map.tiles[20][44]=new Tile(new Location(20,44),"@",true,false, TileType.building);
        map.tiles[20][57]=new Tile(new Location(20,57),"@",true,false, TileType.building);
        map.tiles[20][72]=new Tile(new Location(20,72),"@",true,false, TileType.building);
        map.tiles[20][89]=new Tile(new Location(20,89),"@",true,false, TileType.building);
        map.tiles[20][104]=new Tile(new Location(20,104),"@",true,false, TileType.building);
        map.tiles[20][115]=new Tile(new Location(20,115),"@",true,false, TileType.building);
        placeStore(map);

    }
    public void drawStores(GameMap map) {
        for (Store store : map.getVillage().getStores().values()) {
            Sprite sprite = new Sprite(store.getTexture());

            sprite.setPosition(store.getCollisionRect().getX(), store.getCollisionRect().getY());

            sprite.draw(App.gameApp.getBatch());
            Sprite woodLamp=new Sprite(AssetManager.WOOD_LAMP.getTexture());
            if (store.getCollisionRect().getX()>0){
                woodLamp.setPosition(store.getCollisionRect().getX()+store.getCollisionRect().getWidth()+80, store.getCollisionRect().getY());
                Sprite ironLamp=new Sprite(AssetManager.IRON_LAMP.getTexture());
                ironLamp.setPosition(store.getCollisionRect().getX()-130, store.getCollisionRect().getY());
                ironLamp.draw(App.gameApp.getBatch());
            }else {
                woodLamp.setPosition(store.getCollisionRect().getX()-130, store.getCollisionRect().getY());
                Sprite ironLamp=new Sprite(AssetManager.IRON_LAMP.getTexture());
                ironLamp.setPosition(store.getCollisionRect().getX()+store.getCollisionRect().getWidth()+80, store.getCollisionRect().getY());
                ironLamp.draw(App.gameApp.getBatch());
            }
            woodLamp.draw(App.gameApp.getBatch());
        }
    }
    public void drawFences(GameMap map) {
        for (Fence fence :map.fences) {
            Sprite sprite = new Sprite(fence.fenceType.getTexture());

            sprite.setPosition(
                fence.collisionRect.getX() - fence.collisionRect.getWidth() / 2,
                fence.collisionRect.getY() - fence.collisionRect.getHeight() / 2
            );


            sprite.setOriginCenter();


            if (fence.fenceType.equals(FenceType.door)) {
                if (fence.collisionRect.getX()>0){
                    sprite.setRotation(90);
                }
                else {
                    sprite.setRotation(270);
                }
            }

            sprite.draw(App.gameApp.getBatch());
        }
    }

    public void BuildFences(int WORLD_WIDTH, int WORLD_HEIGHT,GameMap map) {
        FenceType fenceType=FenceType.stone;
        outSideFences(WORLD_WIDTH, WORLD_HEIGHT, fenceType,map);
        fenceType=FenceType.wood;
        farmFences(WORLD_WIDTH, fenceType,map);
        farmGates(WORLD_WIDTH, WORLD_HEIGHT, fenceType,map);
        fenceType=FenceType.iron;
        VillageFences(WORLD_WIDTH,WORLD_HEIGHT, fenceType,map);
    }

    private void farmGates(int WORLD_WIDTH, int WORLD_HEIGHT, FenceType fenceType,GameMap map) {
        for (int y = -WORLD_HEIGHT / 2+ fenceType.getTexture().getHeight(); y < WORLD_HEIGHT / 2; y += fenceType.getTexture().getHeight()) {
            fenceType =FenceType.wood;
            if (y==-WORLD_HEIGHT /2+21* fenceType.getTexture().getHeight()||
                y==-WORLD_HEIGHT /2+23* fenceType.getTexture().getHeight()||
                y==-WORLD_HEIGHT /2+22* fenceType.getTexture().getHeight()||
                y==-WORLD_HEIGHT /2+66* fenceType.getTexture().getHeight()||
                y==-WORLD_HEIGHT /2+68* fenceType.getTexture().getHeight()||
                y==-WORLD_HEIGHT /2+67* fenceType.getTexture().getHeight()) {
                fenceType =FenceType.door;
            }
           map.fences.add(new Fence(fenceType,new CollisionRect(
                -WORLD_WIDTH /2+2* WORLD_WIDTH /7,y, fenceType.getTexture().getWidth()/2, fenceType.getTexture().getHeight()/2)));
           map.fences.add(new Fence(fenceType,new CollisionRect(
                -WORLD_WIDTH /2+5* WORLD_WIDTH /7,y, fenceType.getTexture().getWidth()/2, fenceType.getTexture().getHeight()/2)));
        }
    }

    private void farmFences(int WORLD_WIDTH, FenceType fenceType,GameMap map) {
        for (int x = -WORLD_WIDTH /2+ fenceType.getTexture().getWidth()/2;
             x<-WORLD_WIDTH /2+2* WORLD_WIDTH /7; x+= fenceType.getTexture().getWidth()/2) {
           map.fences.add(new Fence(fenceType,new CollisionRect(
                x,0, fenceType.getTexture().getWidth()/2, fenceType.getTexture().getHeight()/2)));
           map.fences.add(new Fence(fenceType,new CollisionRect(
                x, fenceType.getTexture().getHeight(),
                fenceType.getTexture().getWidth()/2, fenceType.getTexture().getHeight()/2)));
           map.fences.add(new Fence(fenceType,new CollisionRect(
                x+5* WORLD_WIDTH /7,0, fenceType.getTexture().getWidth()/2, fenceType.getTexture().getHeight()/2)));
           map.fences.add(new Fence(fenceType,new CollisionRect(
                x+5* WORLD_WIDTH /7, fenceType.getTexture().getHeight(),
                fenceType.getTexture().getWidth()/2, fenceType.getTexture().getHeight()/2)));
        }
    }
    private void VillageFences(int WORLD_WIDTH, int WORLD_HEIGHT, FenceType fenceType,GameMap map) {
        int texW = fenceType.getTexture().getWidth();
        int texH = fenceType.getTexture().getHeight();
        int startX = -WORLD_WIDTH / 2 + WORLD_WIDTH / 3 + 100;
        int endX = WORLD_WIDTH / 2 - WORLD_WIDTH / 3 - 100;
        int middleX = (startX + endX) / 2;
        int gapX = texW * 5;
        for (int x = startX; x < endX; x += texW) {

            if (x >= middleX - gapX / 2 && x <= middleX + gapX / 2) continue;

           map.fences.add(new Fence(fenceType, new CollisionRect(
                x, -WORLD_HEIGHT / 2 + 400,
                texW, texH / 2)));

           map.fences.add(new Fence(fenceType, new CollisionRect(
                x, WORLD_HEIGHT / 2 - 400,
                texW, texH / 2)));
        }
        int startY = -WORLD_HEIGHT / 2 + 400 + texH / 2;
        int endY = WORLD_HEIGHT / 2 - 400 + texH / 2;
        int middleY = (startY + endY) / 2;
        int gapY = texH * 5;
        for (int y = startY; y < endY; y += texH) {

            if (y >= middleY - gapY / 2 && y <= middleY + gapY / 2) continue;

           map.fences.add(new Fence(fenceType, new CollisionRect(
                -WORLD_WIDTH / 2 + 100 + WORLD_WIDTH / 3, y,
                texW, texH)));

           map.fences.add(new Fence(fenceType, new CollisionRect(
                WORLD_WIDTH / 2 - WORLD_WIDTH / 3 - 100, y,
                texW, texH)));
        }
    }

    private void outSideFences(int WORLD_WIDTH, int WORLD_HEIGHT, FenceType fenceType,GameMap map) {
        for (int x = -WORLD_WIDTH / 2; x < WORLD_WIDTH / 2; x += fenceType.getTexture().getWidth()/2) {
           map.fences.add(new Fence(fenceType,new CollisionRect(x,
                -WORLD_HEIGHT /2, fenceType.getTexture().getWidth()/2, fenceType.getTexture().getHeight()/2)));
           map.fences.add(new Fence(fenceType,new CollisionRect(x,
                WORLD_HEIGHT /2, fenceType.getTexture().getWidth()/2, fenceType.getTexture().getHeight()/2)));

        }

        for (int y = -WORLD_HEIGHT / 2; y < WORLD_HEIGHT / 2; y += fenceType.getTexture().getHeight()) {
           map.fences.add(new Fence(fenceType,new CollisionRect(
                -WORLD_WIDTH /2,y, fenceType.getTexture().getWidth()/2, fenceType.getTexture().getHeight()/2)));
           map.fences.add(new Fence(fenceType,new CollisionRect(
                +WORLD_WIDTH /2,y, fenceType.getTexture().getWidth()/2, fenceType.getTexture().getHeight()/2)));

        }
    }

}
