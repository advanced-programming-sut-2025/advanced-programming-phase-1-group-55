package com.StardewValley.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class AssetManager {
    public static Texture DayBackGround=new Texture(Gdx.files.internal("Flooring/Flooring_86.png"));
    public static Texture NightBackGround=new Texture(Gdx.files.internal("Flooring/Flooring_61.png"));
    public static Texture stoneFenceTexture = new Texture(Gdx.files.internal("Fence/Stone_Fence.png"));
    //todo feln player texture ro ye kossheri mizaarm , badan arshia baraye zadan animation harekat va taghir nobt , ye aks dorost bezaare
    public static Sprite playerSprite = new Sprite(new Texture(Gdx.files.internal("sprites/Mariner.png")));
}
