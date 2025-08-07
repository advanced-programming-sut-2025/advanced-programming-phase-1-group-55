package com.StardewValley.model.Map;


import com.StardewValley.View.newView.FarmLand;
import com.StardewValley.enums.AssetManager;
import com.StardewValley.model.App;
import com.StardewValley.model.Artisan.ArtisanMachine;
import com.StardewValley.model.GameTime;
import com.StardewValley.model.Item.CollisionRect;
import com.StardewValley.model.NPC.Npc;
import com.StardewValley.model.Store.ShippingBin;
import com.StardewValley.model.Store.Store;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

public class MapBuilder {

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

    public void drawBins(GameMap map) {
        for (ShippingBin bin:map.getVillage().getShippingBins()){
            bin.getSprite().setPosition(bin.getCollisionRect().getX(), bin.getCollisionRect().getY());
            bin.getSprite().setScale(1.6f);
            bin.getSprite().draw(App.gameApp.getBatch());
        }
    }
    public void drawNpcHouses(GameMap map) {
        for (Npc npc:map.getVillage().getNpss().values()){
            Sprite sprite=npc.getType().getHouse().getSprite();
            sprite.setPosition(npc.getType().getHouse().getCollisionRect().getX(),npc.getType().getHouse().getCollisionRect().getY());
            sprite.draw(App.gameApp.getBatch());
            Sprite woodLamp=new Sprite(AssetManager.WOOD_LAMP.getTexture());
            if (npc.getType().getHouse().getCollisionRect().getX()>0){
                woodLamp.setPosition(npc.getType().getHouse().getCollisionRect().getX()+npc.getType().getHouse().getCollisionRect().getWidth()+80, npc.getType().getHouse().getCollisionRect().getY());
                Sprite ironLamp=new Sprite(AssetManager.IRON_LAMP.getTexture());
                ironLamp.setPosition(npc.getType().getHouse().getCollisionRect().getX()-130, npc.getType().getHouse().getCollisionRect().getY());
                ironLamp.draw(App.gameApp.getBatch());
            }else {
                woodLamp.setPosition(npc.getType().getHouse().getCollisionRect().getX()-130, npc.getType().getHouse().getCollisionRect().getY());
                Sprite ironLamp=new Sprite(AssetManager.IRON_LAMP.getTexture());
                ironLamp.setPosition(npc.getType().getHouse().getCollisionRect().getX()+npc.getType().getHouse().getCollisionRect().getWidth()+80, npc.getType().getHouse().getCollisionRect().getY());
                ironLamp.draw(App.gameApp.getBatch());
            }
            woodLamp.draw(App.gameApp.getBatch());
        }

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
    public void drawArtisans(GameMap map) {
        for (ArtisanMachine artisanMachine : map.getArtisanMachines()) {
            Sprite sprite=new Sprite(artisanMachine.getArtisanType().getTexture());
            sprite.setPosition(artisanMachine.getCollisionRect().getX(), artisanMachine.getCollisionRect().getY());
            sprite.draw(App.gameApp.getBatch());
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
        drawLamps( map.getWORLD_HEIGHT(), map.getWORLD_WIDTH());

    }
    public void drawLamps(int WORLD_HEIGHT,int WORLD_WIDTH) {
        farmEntranceLamps(WORLD_HEIGHT, WORLD_WIDTH);

        villageLamps(WORLD_HEIGHT,WORLD_WIDTH);
    }
    public void drawFarms(GameMap map) {
        map.getFarm1().draw();
        map.getFarm2().draw();
        if (App.getCurrentGameModel().playersInGame.size()>2){
            map.getFarm3().draw();
            if (App.getCurrentGameModel().playersInGame.size()>3){
                map.getFarm4().draw();
            }
        }
    }

    private void villageLamps(int WORLD_HEIGHT,int WORLD_WIDTH) {
        Sprite iridiumLamp=AssetManager.IRIDIUM_BRAZIER.getSprite();
        iridiumLamp.setPosition(-2*FenceType.iron.getTexture().getWidth()
            ,-WORLD_HEIGHT / 2 + 400-FenceType.iron.getTexture().getHeight()/2);
        iridiumLamp.draw(App.gameApp.getBatch());
        iridiumLamp.setPosition(2*FenceType.iron.getTexture().getWidth()
            ,-WORLD_HEIGHT / 2 + 400-FenceType.iron.getTexture().getHeight()/2);
        iridiumLamp.draw(App.gameApp.getBatch());
        iridiumLamp.setPosition(-2*FenceType.iron.getTexture().getWidth()
            , WORLD_HEIGHT / 2 - 400-FenceType.iron.getTexture().getHeight()/2);
        iridiumLamp.draw(App.gameApp.getBatch());
        iridiumLamp.setPosition(2*FenceType.iron.getTexture().getWidth()
            , WORLD_HEIGHT / 2 - 400-FenceType.iron.getTexture().getHeight()/2);
        iridiumLamp.draw(App.gameApp.getBatch());

        iridiumLamp.setPosition(-WORLD_WIDTH / 2 + 100 + WORLD_WIDTH / 3-FenceType.iron.getTexture().getWidth()/2
            ,-2*FenceType.iron.getTexture().getHeight()+20);
        iridiumLamp.draw(App.gameApp.getBatch());
        iridiumLamp.setPosition(-WORLD_WIDTH / 2 + 100 + WORLD_WIDTH / 3-FenceType.iron.getTexture().getWidth()/2
            ,+2*FenceType.iron.getTexture().getHeight()+20);
        iridiumLamp.draw(App.gameApp.getBatch());
        iridiumLamp.setPosition(WORLD_WIDTH / 2 - WORLD_WIDTH / 3 - 100-FenceType.iron.getTexture().getWidth()/2
            ,-2*FenceType.iron.getTexture().getHeight()+20);
        iridiumLamp.draw(App.gameApp.getBatch());
        iridiumLamp.setPosition(WORLD_WIDTH / 2 - WORLD_WIDTH / 3 - 100-FenceType.iron.getTexture().getWidth()/2
            ,+2*FenceType.iron.getTexture().getHeight()+20);
        iridiumLamp.draw(App.gameApp.getBatch());
    }

    private void farmEntranceLamps(int WORLD_HEIGHT, int WORLD_WIDTH) {
        Sprite stoneBrazier=AssetManager.STONE_BRAZIER.getSprite();
        stoneBrazier.setPosition(-WORLD_WIDTH /2+2* WORLD_WIDTH /7+25,-WORLD_HEIGHT /2+20* FenceType.wood.getTexture().getHeight());
        stoneBrazier.draw(App.gameApp.getBatch());
        stoneBrazier.setPosition(-WORLD_WIDTH /2+2* WORLD_WIDTH /7+25,-WORLD_HEIGHT /2+24* FenceType.wood.getTexture().getHeight());
        stoneBrazier.draw(App.gameApp.getBatch());
        stoneBrazier.setPosition(-WORLD_WIDTH /2+2* WORLD_WIDTH /7+25,-WORLD_HEIGHT /2+65* FenceType.wood.getTexture().getHeight());
        stoneBrazier.draw(App.gameApp.getBatch());
        stoneBrazier.setPosition(-WORLD_WIDTH /2+2* WORLD_WIDTH /7+25,-WORLD_HEIGHT /2+69* FenceType.wood.getTexture().getHeight());
        stoneBrazier.draw(App.gameApp.getBatch());
        stoneBrazier.setPosition(-WORLD_WIDTH /2+5* WORLD_WIDTH /7-42,-WORLD_HEIGHT /2+20* FenceType.wood.getTexture().getHeight());
        stoneBrazier.draw(App.gameApp.getBatch());
        stoneBrazier.setPosition(-WORLD_WIDTH /2+5* WORLD_WIDTH /7-42,-WORLD_HEIGHT /2+24* FenceType.wood.getTexture().getHeight());
        stoneBrazier.draw(App.gameApp.getBatch());
        stoneBrazier.setPosition(-WORLD_WIDTH /2+5* WORLD_WIDTH /7-42,-WORLD_HEIGHT /2+65* FenceType.wood.getTexture().getHeight());
        stoneBrazier.draw(App.gameApp.getBatch());
        stoneBrazier.setPosition(-WORLD_WIDTH /2+5* WORLD_WIDTH /7-42,-WORLD_HEIGHT /2+69* FenceType.wood.getTexture().getHeight());
        stoneBrazier.draw(App.gameApp.getBatch());
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
            Fence fenceLeft=new Fence(fenceType,new CollisionRect(
                -WORLD_WIDTH /2+2* WORLD_WIDTH /7,y, fenceType.getTexture().getWidth()/2, fenceType.getTexture().getHeight()/2));
           map.fences.add(fenceLeft);
            Fence fenceRight=new Fence(fenceType,new CollisionRect(
                -WORLD_WIDTH /2+5* WORLD_WIDTH /7,y, fenceType.getTexture().getWidth()/2, fenceType.getTexture().getHeight()/2));
           map.fences.add(fenceRight);
            if (fenceType==FenceType.door) {
                if (y<-WORLD_HEIGHT /2+30* fenceType.getTexture().getHeight()){
                    map.getFarm2().getDoors().add(fenceLeft);
                    if (App.getCurrentGameModel().playersInGame.size()>3){
                        map.getFarm4().getDoors().add(fenceRight);
                    }

                }else {
                    map.getFarm1().getDoors().add(fenceLeft);
                    if (App.getCurrentGameModel().playersInGame.size()>2) {
                        map.getFarm3().getDoors().add(fenceRight);
                    }
                }
            }
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
    public void BuildFarms(String map2, String map3, String map4, GameMap map, int WORLD_WIDTH, int WORLD_HEIGHT) {
        farm1(map, WORLD_WIDTH, WORLD_HEIGHT);
        farm2(map2, map, WORLD_WIDTH, WORLD_HEIGHT);
        if (App.getCurrentGameModel().playersInGame.size()>2){
            farm3(map3, map, WORLD_WIDTH, WORLD_HEIGHT);
            if (App.getCurrentGameModel().playersInGame.size()>3){
                farm4(map, WORLD_WIDTH, WORLD_HEIGHT,map4);
            }
        }

    }

    private void farm4(GameMap map, int WORLD_WIDTH, int WORLD_HEIGHT,String map4) {
        CollisionRect collisionRect4 = new CollisionRect(-WORLD_WIDTH /2+5*WORLD_WIDTH/7,-WORLD_HEIGHT /2,2* WORLD_WIDTH /7, WORLD_HEIGHT /2);
        CollisionRect collisionRectHouse;
        CollisionRect collisionRectLake;
        if (map4.equals("Map1")){
            collisionRectHouse=new CollisionRect(-WORLD_WIDTH /2+30+5*WORLD_WIDTH/7,-AssetManager.House.getTexture().getHeight()-20,
                AssetManager.House.getTexture().getWidth(),AssetManager.House.getTexture().getHeight());
            collisionRectLake=new CollisionRect(WORLD_WIDTH/2-AssetManager.Lake.getTexture().getWidth(),
                -AssetManager.Lake.getTexture().getHeight()-10,AssetManager.Lake.getTexture().getWidth(),AssetManager.Lake.getTexture().getHeight());
        } else  {
            collisionRectHouse=new CollisionRect(WORLD_WIDTH/2-AssetManager.House.getTexture().getWidth(),
                -AssetManager.House.getTexture().getHeight()-10,AssetManager.House.getTexture().getWidth(),AssetManager.House.getTexture().getHeight());
            collisionRectLake=new CollisionRect(-WORLD_WIDTH /2+30+5*WORLD_WIDTH/7,-AssetManager.Lake.getTexture().getHeight()-20,
                AssetManager.Lake.getTexture().getWidth(),AssetManager.Lake.getTexture().getHeight());
        }
        House house4 = new House(collisionRectHouse);
        Lake lake4 = new Lake(collisionRectLake);
        Quarry quarry4 = new Quarry(new CollisionRect(-WORLD_WIDTH /2+30+5*WORLD_WIDTH/7,35-WORLD_HEIGHT/2
            ,AssetManager.Quarry.getTexture().getWidth(),AssetManager.Quarry.getTexture().getHeight()));
        GreenHouse greenHouse4 = new GreenHouse(new CollisionRect(WORLD_WIDTH/2
            -AssetManager.GreenHouse.getTexture().getWidth()-20,35-WORLD_HEIGHT/2
            ,AssetManager.GreenHouse.getTexture().getWidth(),AssetManager.GreenHouse.getTexture().getHeight()));
        Farm farm4=new Farm(house4,lake4,greenHouse4,quarry4,collisionRect4);
        App.getCurrentGameModel().playersInGame.get(3).setFarm(farm4);
        map.setFarm4(farm4);
    }

    private void farm3(String map3, GameMap map, int WORLD_WIDTH, int WORLD_HEIGHT) {
        CollisionRect collisionRect3 = new CollisionRect(-WORLD_WIDTH /2+5*WORLD_WIDTH/7,0,2* WORLD_WIDTH /7, WORLD_HEIGHT /2);
        CollisionRect collisionRectHouse;
        CollisionRect collisionRectLake;
        if (map3.equals("Map1")){
            collisionRectHouse=new CollisionRect(-WORLD_WIDTH /2+30+5*WORLD_WIDTH/7,WORLD_HEIGHT /2-AssetManager.House.getTexture().getHeight()-20,
                AssetManager.House.getTexture().getWidth(),AssetManager.House.getTexture().getHeight());
            collisionRectLake=new CollisionRect(WORLD_WIDTH/2-AssetManager.Lake.getTexture().getWidth(),
                WORLD_HEIGHT /2-AssetManager.Lake.getTexture().getHeight()-10,AssetManager.Lake.getTexture().getWidth(),AssetManager.Lake.getTexture().getHeight());
        } else  {
            collisionRectHouse=new CollisionRect(WORLD_WIDTH/2-AssetManager.House.getTexture().getWidth(),
                WORLD_HEIGHT /2-AssetManager.House.getTexture().getHeight()-10,AssetManager.House.getTexture().getWidth(),AssetManager.House.getTexture().getHeight());
            collisionRectLake=new CollisionRect(-WORLD_WIDTH /2+30+5*WORLD_WIDTH/7,WORLD_HEIGHT /2-AssetManager.Lake.getTexture().getHeight()-20,
                AssetManager.Lake.getTexture().getWidth(),AssetManager.Lake.getTexture().getHeight());
        }
        House house3 = new House(collisionRectHouse);
        Lake lake3 = new Lake(collisionRectLake);
        Quarry quarry3 = new Quarry(new CollisionRect(-WORLD_WIDTH /2+30+5*WORLD_WIDTH/7,85
            ,AssetManager.Quarry.getTexture().getWidth(),AssetManager.Quarry.getTexture().getHeight()));
        GreenHouse greenHouse3 = new GreenHouse(new CollisionRect(WORLD_WIDTH/2
            -AssetManager.GreenHouse.getTexture().getWidth()-20,85
            ,AssetManager.GreenHouse.getTexture().getWidth(),AssetManager.GreenHouse.getTexture().getHeight()));
        Farm farm3=new Farm(house3,lake3,greenHouse3,quarry3,collisionRect3);
        App.getCurrentGameModel().playersInGame.get(2).setFarm(farm3);
        map.setFarm3(farm3);
    }

    private void farm2(String map2, GameMap map, int WORLD_WIDTH, int WORLD_HEIGHT) {
        CollisionRect collisionRect2 = new CollisionRect(-WORLD_WIDTH /2,-WORLD_HEIGHT /2,2* WORLD_WIDTH /7, WORLD_HEIGHT /2);
        CollisionRect collisionRectHouse;
        CollisionRect collisionRectLake;
        if (map2.equals("Map1")){
            collisionRectHouse=new CollisionRect(-WORLD_WIDTH /2+30,-AssetManager.House.getTexture().getHeight()-20,
                AssetManager.House.getTexture().getWidth(),AssetManager.House.getTexture().getHeight());
            collisionRectLake=new CollisionRect(-WORLD_WIDTH /2+2* WORLD_WIDTH /7-AssetManager.Lake.getTexture().getWidth(),
                -AssetManager.Lake.getTexture().getHeight()-10,AssetManager.Lake.getTexture().getWidth(),AssetManager.Lake.getTexture().getHeight());
        } else  {
            collisionRectHouse=new CollisionRect(-WORLD_WIDTH /2+2* WORLD_WIDTH /7-AssetManager.House.getTexture().getWidth(),
                -AssetManager.House.getTexture().getHeight()-10,AssetManager.House.getTexture().getWidth(),AssetManager.House.getTexture().getHeight());
            collisionRectLake=new CollisionRect(-WORLD_WIDTH /2+30,-AssetManager.Lake.getTexture().getHeight()-20,
                AssetManager.Lake.getTexture().getWidth(),AssetManager.Lake.getTexture().getHeight());
        }
        House house2 = new House(collisionRectHouse);
        Lake lake2 = new Lake(collisionRectLake);
        Quarry quarry2 = new Quarry(new CollisionRect(-WORLD_WIDTH /2+30,35- WORLD_HEIGHT /2
            ,AssetManager.Quarry.getTexture().getWidth(),AssetManager.Quarry.getTexture().getHeight()));
        GreenHouse greenHouse2 = new GreenHouse(new CollisionRect(-WORLD_WIDTH /2+2* WORLD_WIDTH /7
            -AssetManager.GreenHouse.getTexture().getWidth()-20,35- WORLD_HEIGHT /2
            ,AssetManager.GreenHouse.getTexture().getWidth(),AssetManager.GreenHouse.getTexture().getHeight()));
        Farm farm2=new Farm(house2,lake2,greenHouse2,quarry2,collisionRect2);
        App.getCurrentGameModel().playersInGame.get(1).setFarm(farm2);
        map.setFarm2(farm2);
    }

    private void farm1(GameMap map, int WORLD_WIDTH, int WORLD_HEIGHT) {
        CollisionRect collisionRect1 = new CollisionRect(-WORLD_WIDTH /2,0 ,2* WORLD_WIDTH /7, WORLD_HEIGHT /2);
        House house1 = new House(new CollisionRect(-WORLD_WIDTH /2+30, WORLD_HEIGHT /2-AssetManager.House.getTexture().getHeight()-20,
            AssetManager.House.getTexture().getWidth(),AssetManager.House.getTexture().getHeight()));
        Lake lake1 = new Lake(new CollisionRect(-WORLD_WIDTH /2+2* WORLD_WIDTH /7-AssetManager.Lake.getTexture().getWidth(),
            WORLD_HEIGHT /2-AssetManager.Lake.getTexture().getHeight()-10,AssetManager.Lake.getTexture().getWidth(),AssetManager.Lake.getTexture().getHeight()));
        Quarry quarry1 = new Quarry(new CollisionRect(-WORLD_WIDTH /2+30,85
            ,AssetManager.Quarry.getTexture().getWidth(),AssetManager.Quarry.getTexture().getHeight()));
        GreenHouse greenHouse1 = new GreenHouse(new CollisionRect(-WORLD_WIDTH /2+2* WORLD_WIDTH /7
            -AssetManager.GreenHouse.getTexture().getWidth()-20,85
            ,AssetManager.GreenHouse.getTexture().getWidth(),AssetManager.GreenHouse.getTexture().getHeight()));
        Farm farm1=new Farm(house1,lake1,greenHouse1,quarry1,collisionRect1);
        App.getCurrentGameModel().playersInGame.getFirst().setFarm(farm1);
        ArrayList<FarmLand> lands = new ArrayList<>();
        float tileW = 16;
        float tileH = 16;

        for (float x = collisionRect1.getX(); x < collisionRect1.getX()+collisionRect1.getWidth(); x += tileW) {
            for (float y = collisionRect1.getY(); y < collisionRect1.getY()+collisionRect1.getHeight(); y += tileH) {
                CollisionRect landRect = new CollisionRect(x, y, tileW, tileH);

                if (!house1.getCollisionRect().collidesWith(landRect) &&
                    !lake1.getCollisionRect().collidesWith(landRect) &&
                    !greenHouse1.getCollisionRect().collidesWith(landRect) &&
                    !quarry1.getCollisionRect().collidesWith(landRect)) {

//                    FarmLand land = new FarmLand(landRect, AssetManager.NIGHT_BACKGROUND.getTexture());
                    FarmLand land = new FarmLand(landRect, GameTime.getCurrentBackgroundTexture());

                    lands.add(land);
                }
            }
        }

        farm1.getFarmLands().addAll(lands);
        map.setFarm1(farm1);
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
        placeShippingBins(map);

    }
    private void placeShippingBins(GameMap map) {
        ArrayList<ShippingBin> bins=map.getVillage().getShippingBins();
        Sprite sprite=AssetManager.ShippingBin.getSprite();
        for(Store store:map.getVillage().getStores().values()) {
            if (store.getCollisionRect().getX()>0){
                bins.add(new ShippingBin(new CollisionRect(store.getCollisionRect().getX()+600,store.getCollisionRect().getY()+20, (float) (sprite.getWidth()*1.6), (float) (sprite.getHeight()*1.6))));
            }else {
                bins.add(new ShippingBin(new CollisionRect(store.getCollisionRect().getX()-600,store.getCollisionRect().getY()+20, (float) (sprite.getWidth()*1.6), (float) (sprite.getHeight()*1.6))));
            }
        }
        for(Npc npc:map.getVillage().getNpss().values()) {
            if (npc.getType().getHouse().getCollisionRect().getX()>0){
                bins.add(new ShippingBin(new CollisionRect(npc.getType().getHouse().getCollisionRect().getX()+600,npc.getType().getHouse().getCollisionRect().getY()+20, (float) (sprite.getWidth()*1.6), (float) (sprite.getHeight()*1.6))));
            }else {
                bins.add(new ShippingBin(new CollisionRect(npc.getType().getHouse().getCollisionRect().getX()-600,npc.getType().getHouse().getCollisionRect().getY()+20, (float) (sprite.getWidth()*1.6), (float) (sprite.getHeight()*1.6))));
            }
        }
    }

}
