package com.StardewValley.model.Animal;

import com.StardewValley.enums.Seasons;
import com.StardewValley.model.App;
import com.StardewValley.model.GameTime;
import com.StardewValley.model.Item.ItemType;
import com.StardewValley.model.Tool.FishingPoleType;

import java.util.ArrayList;
import java.util.Random;

public enum FishType {

    SALMON(ItemType.SALMON, "Salmon", 75, Seasons.fall, false),
    SARDINE(ItemType.SARDINE, "Sardine", 40, Seasons.fall, false),
    SHAD(ItemType.SHAD, "Shad", 60, Seasons.fall, false),
    BLUE_DISCUS(ItemType.BLUE_DISCUS, "Blue Discus", 120, Seasons.fall, false),
    MIDNIGHT_CARP(ItemType.MIDNIGHT_CARP, "Midnight Carp", 150, Seasons.winter, false),
    SQUID(ItemType.SQUID, "Squid", 80, Seasons.winter, false),
    TUNA(ItemType.TUNA, "Tuna", 100, Seasons.winter, false),
    PERCH(ItemType.PERCH, "Perch", 55, Seasons.winter, false),
    FLOUNDER(ItemType.FLOUNDER, "Flounder", 100, Seasons.spring, false),
    LIONFISH(ItemType.LIONFISH, "Lionfish", 100, Seasons.spring, false),
    HERRING(ItemType.HERRING, "Herring", 30, Seasons.spring, false),
    GHOSTFISH(ItemType.GHOSTFISH, "Ghostfish", 45, Seasons.spring, false),
    TILAPIA(ItemType.TILAPIA, "Tilapia", 75, Seasons.summer, false),
    DORADO(ItemType.DORADO, "Dorado", 100, Seasons.summer, false),
    LEGEND(ItemType.LEGEND, "Legend", 5000, Seasons.spring, true),
    GLACIER_FISH(ItemType.GLACIER_FISH, "Glacier Fish", 1000, Seasons.winter, true),
    ANGLER(ItemType.ANGLER, "Angler", 900, Seasons.fall, true),
    CRIMSON_FISH(ItemType.CRIMSON_FISH, "Crimson Fish", 1500, Seasons.summer, true);



    private final ItemType type;
    private final String displayName;
    private final int basePrice;
    private final Seasons season;
    private final boolean isLegendary;

    FishType(ItemType type, String displayName, int basePrice, Seasons season, boolean isLegendary) {
        this.type = type;
        this.displayName = displayName;
        this.basePrice = basePrice;
        this.season = season;
        this.isLegendary = isLegendary;
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
        case FIBERGLASS_ROD:
        case TRAINING_ROD:
            switch (season) {
                case summer: return FishType.TILAPIA;
                case fall: return FishType.SARDINE;
                case winter: return FishType.PERCH;
                case spring: return FishType.HERRING;
            }
            break;


        case IRIDIUM_ROD: {
            ArrayList<FishType> fishes = getOrdinaryFishTypes(season);

            int fishingLevel = App.currentGame.currentUser.getFishingSkill().getLevel();
            if (fishingLevel >= 4) {
                FishType legendary = getLegendaryFishType(season);
                if (legendary != null) {
                    fishes.add(legendary);
                }
            }

            Random rand = new Random();
            return fishes.get(rand.nextInt(fishes.size()));
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
