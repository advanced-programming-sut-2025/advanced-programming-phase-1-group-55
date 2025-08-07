package com.StardewValley.model.Animal.Fishing;

import com.StardewValley.enums.Seasons;
import com.StardewValley.model.App;
import com.StardewValley.model.GameTime;
import com.StardewValley.model.Item.ItemType;
import com.StardewValley.model.Tool.FishingPoleType;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.Random;

public enum FishType {

    SALMON(ItemType.SALMON, "Salmon", 75, Seasons.fall, false,new Texture("Fish/Salmon.png")),
    SARDINE(ItemType.SARDINE, "Sardine", 40, Seasons.fall, false,new Texture("Fish/Sardine.png")),
    SHAD(ItemType.SHAD, "Shad", 60, Seasons.fall, false,new Texture("Fish/Shad.png")),
    BLUE_DISCUS(ItemType.BLUE_DISCUS, "Blue Discus", 120, Seasons.fall, false,new Texture("Fish/Blue_Discus.png")),
    MIDNIGHT_CARP(ItemType.MIDNIGHT_CARP, "Midnight Carp", 150, Seasons.winter, false,new Texture("Fish/Midnight_Carp.png")),
    SQUID(ItemType.SQUID, "Squid", 80, Seasons.winter, false,new Texture("Fish/Squid.png")),
    TUNA(ItemType.TUNA, "Tuna", 100, Seasons.winter, false,new Texture("Fish/Tuna.png")),
    PERCH(ItemType.PERCH, "Perch", 55, Seasons.winter, false,new Texture("Fish/Perch.png")),
    FLOUNDER(ItemType.FLOUNDER, "Flounder", 100, Seasons.spring, false,new Texture("Fish/Flounder.png")),
    LIONFISH(ItemType.LIONFISH, "Lionfish", 100, Seasons.spring, false,new Texture("Fish/Lionfish.png")),
    HERRING(ItemType.HERRING, "Herring", 30, Seasons.spring, false,new Texture("Fish/Herring.png")),
    GHOSTFISH(ItemType.GHOSTFISH, "Ghostfish", 45, Seasons.spring, false,new Texture("Fish/Ghostfish.png")),
    TILAPIA(ItemType.TILAPIA, "Tilapia", 75, Seasons.summer, false,new Texture("Fish/Tilapia.png")),
    DORADO(ItemType.DORADO, "Dorado", 100, Seasons.summer, false,new Texture("Fish/Dorado.png")),
    LEGEND(ItemType.LEGEND, "Legend", 5000, Seasons.spring, true,new Texture("Fish/Legend-overlay.png")),
    GLACIER_FISH(ItemType.GLACIER_FISH, "Glacier Fish", 1000, Seasons.winter, true,new Texture("Fish/Glacierfish.png")),
    ANGLER(ItemType.ANGLER, "Angler", 900, Seasons.fall, true,new Texture("Fish/Angler.png")),
    CRIMSON_FISH(ItemType.CRIMSON_FISH, "Crimson Fish", 1500, Seasons.summer, true,new Texture("Fish/Crimsonfish.png"));



    private final ItemType type;
    private final String displayName;
    private final int basePrice;
    private final Seasons season;
    private final boolean isLegendary;
    private final Texture texture;
    FishType(ItemType type, String displayName, int basePrice, Seasons season, boolean isLegendary, Texture texture) {
        this.type = type;
        this.displayName = displayName;
        this.basePrice = basePrice;
        this.season = season;
        this.isLegendary = isLegendary;
        this.texture = texture;
    }

    public ItemType getType() {
        return type;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public Seasons getSeason() {
        return season;
    }

    public boolean isLegendary() {
        return isLegendary;
    }
    public static ArrayList<FishType> getOrdinaryFishTypes(Seasons season)
    {
        ArrayList<FishType> fishTypes = new ArrayList<>();

        for (FishType fishType : FishType.values())
        {
            if (fishType.getSeason() == season && !fishType.isLegendary())
            {
                fishTypes.add(fishType);
            }
        }

        return fishTypes;
    }
    public static FishType getLegendaryFishType(Seasons season)
    {
        for (FishType fishType : FishType.values())
        {
            if (fishType.getSeason() == season && fishType.isLegendary())
            {
                return fishType;
            }
        }

        return null;
    }
    public static FishType getFishFromType(ItemType type)
    {
        for (FishType fishType : FishType.values())
        {
            if (fishType.getType() == type)
            {
                return fishType;
            }
        }

        return null;
    }
    public static boolean isCheapestOfTheSeason(FishType fishType)
    {
        for (FishType fish : FishType.values())
        {
            if (fish.getSeason() == fishType.getSeason() && fish.getBasePrice() < fishType.getBasePrice())
            {
                return false;
            }
        }

        return true;
    }

    public Texture getTexture() {
        return texture;
    }

    //    public static FishType getRandomFish(FishingPoleType poleType)
//    {
//
//        Seasons season = GameTime.getSeason();
//        switch (poleType)
//        {
//            case FishingPoleType.TRAINING_ROD:
//            {
//                switch (season)
//                {
//                    case summer: return FishType.TILAPIA;
//                    case fall: return FishType.SARDINE;
//                    case winter: return FishType.PERCH;
//                    case spring: return FishType.HERRING;
//                }
//            }
//
//            case FishingPoleType.BAMBOO_ROD:
//            case FishingPoleType.IRIDIUM_ROD:
//            case FishingPoleType.FIBERGLASS_ROD:
//            {
//                Random rand = new Random();
//                return FishType.values()[rand.nextInt(FishType.values().length)];
//            }
//        }
//
//        return null;
//    }
public static FishType getRandomFish(FishingPoleType poleType) {
    Seasons season = GameTime.getSeason();

    switch (poleType) {
        case BAMBOO_ROD:
            switch (season) {
                case summer: return FishType.DORADO;
                case fall: return FishType.CRIMSON_FISH;
                case winter: return FishType.ANGLER;
                case spring: return FishType.GHOSTFISH;
            }
            break;
        case FIBERGLASS_ROD:
            switch (season) {
                case summer: return FishType.LIONFISH;
                case fall: return FishType.MIDNIGHT_CARP;
                case winter: return FishType.SALMON;
                case spring: return FishType.SHAD;
            }
            break;
        case TRAINING_ROD:
            switch (season) {
                case summer: return FishType.TILAPIA;
                case fall: return FishType.SARDINE;
                case winter: return FishType.PERCH;
                case spring: return FishType.HERRING;
            }
            break;


        case IRIDIUM_ROD: {
            int random=App.rand.nextInt();
            if (random%3==0){
                return FishType.LEGEND;
            }
            else {
                switch (season) {
                    case summer: return FishType.BLUE_DISCUS;
                    case fall: return FishType.TUNA;
                    case winter: return FishType.SQUID;
                    case spring: return FishType.FLOUNDER;
                }
                break;
            }
        }
    }

    return null;
}
    public static String getQualityName(double quality) {
        if (quality < 0.5)
            return "normal";
        else if (quality < 0.7)
            return "silver";
        else if (quality < 0.9)
            return "gold";
        else
            return "iridium";
    }




}
