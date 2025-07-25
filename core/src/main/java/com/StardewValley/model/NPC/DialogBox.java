package com.StardewValley.model.NPC;

import com.StardewValley.Controller.NpcController;
import com.StardewValley.enums.AssetManager;
import com.StardewValley.model.GameTime;
import com.StardewValley.model.Item.CollisionRect;
import com.StardewValley.model.weather;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;



public class DialogBox {
    private Npc npc;
    private DialogStatus status;
    private  final Texture texture;
    private CollisionRect rect;
    private float timeSinceStart = 0;
    public DialogBox(Npc npc, DialogStatus status) {
       this.npc = npc;
       this.status = status;
       texture= AssetManager.Dialog.getTexture();
       rect=new CollisionRect(npc.getCollisionRect().getX()+5,npc.getCollisionRect().getY()+10, texture.getWidth(), texture.getHeight());

    }
    public boolean update(float delta) {
        timeSinceStart+=delta;
        if (timeSinceStart>4f){
            timeSinceStart=0;
            return true;
        }
        return false;
    }
    public Sprite getSprite() {
        if (status == DialogStatus.InActive) {
            return null;
        }

        Sprite sprite = new Sprite(texture);

        if (status == DialogStatus.Ready) {
            sprite.setSize(texture.getWidth()/3, texture.getHeight()/3);
            sprite.setPosition(rect.getX()-20, rect.getY()+30);
        } else if (status == DialogStatus.InProgress) {
            sprite.setSize((float) (texture.getHeight()*1.15), (float) (texture.getHeight()*1.15));
            sprite.setPosition(rect.getX()- texture.getHeight() * 0.25f, rect.getY() + texture.getHeight() * 0.25f);
        }

        return sprite;
    }

    public Npc getNpc() {
        return npc;
    }

    public void setNpc(Npc npc) {
        this.npc = npc;
    }

    public float getTimeSinceStart() {
        return timeSinceStart;
    }

    public void setTimeSinceStart(float timeSinceStart) {
        this.timeSinceStart = timeSinceStart;
    }

    public String getMessage() {
        return NpcController.getDialogMessage(weather.getCurrentWeather(), GameTime.getMainTime());
    }


    public DialogStatus getStatus() {
        return status;
    }

    public void setStatus(DialogStatus status) {
        this.status = status;
    }

    public Texture getTexture() {
        return texture;
    }

    public CollisionRect getRect() {
        return rect;
    }

    public void setRect(CollisionRect rect) {
        this.rect = rect;
    }
}
