package com.StardewValley.Common.model.Artisan;

import com.StardewValley.Common.model.Item.ItemType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public enum ArtisanMachineType {

    HONEY(ItemType.HONEY, ItemType.BEE_HOUSE_RECIPE, "It's a sweet syrup produced by bees.", 75, 56, null, 350,new Texture(Gdx.files.internal("Craftable_item/Bee_House.png"))),

    CHEESE_1(ItemType.CHEESE, ItemType.CHEESE_PRESS_RECIPE, "It's your basic cheese.", 100, 3,
            new HashMap<>() {{
                put(ItemType.MILK, 1);
            }}, 230,new Texture(Gdx.files.internal("Craftable_item/Cheese_Press.png"))),

    BEER(ItemType.BEER, ItemType.KEG_RECIPE, "Drink in moderation.", 50, 14,
            new HashMap<>() {{
                put(ItemType.WHEAT, 1);
            }}, 200,new Texture(Gdx.files.internal("Craftable_item/Charcoal_Kiln.png"))),

    VINEGAR(ItemType.VINEGAR, ItemType.KEG_RECIPE, "An aged fermented liquid used in many cooking recipes.", 13, 10,
            new HashMap<>() {{
                put(ItemType.RICE, 1);
            }}, 100,new Texture(Gdx.files.internal("Craftable_item/Crab_Pot.png"))),

    COFFEE(ItemType.COFFEE, ItemType.KEG_RECIPE, "It smells delicious. This is sure to give you a boost.", 75, 2,
            new HashMap<>() {{
                put(ItemType.COFFEE_BEAN, 5);
            }}, 150,new Texture(Gdx.files.internal("Craftable_item/Crystalarium.png"))),

    MEAD(ItemType.MEAD, ItemType.KEG_RECIPE, "A fermented beverage made from honey. Drink in moderation.", 100, 10,
            new HashMap<>() {{
                put(ItemType.HONEY, 1);
            }}, 300,new Texture(Gdx.files.internal("Craftable_item/Deluxe_Worm_Bin.png"))),

    PALE_ALE(ItemType.PALE_ALE, ItemType.KEG_RECIPE, "Drink in moderation.", 50, 42,
            new HashMap<>() {{
                put(ItemType.HOPS_CROP, 1);
            }}, 300,new Texture(Gdx.files.internal("Craftable_item/Farm_Computer.png"))),

    RAISINS(ItemType.RAISIN, ItemType.DEHYDRATOR_RECIPE, "It's said to be the Junimos' favorite food.", 125, 3,
            new HashMap<>() {{
                put(ItemType.GRAPE, 5);
            }}, 600,new Texture(Gdx.files.internal("Craftable_item/Furnace_On.png"))),

    COAL(ItemType.COAL, ItemType.CHARCOAL_KILN_RECIPE, "Turns 10 pieces of wood into one piece of coal.", -1, 1,
            new HashMap<>() {{
                put(ItemType.WOOD, 10);
            }}, 50,new Texture(Gdx.files.internal("Craftable_item/Geode_Crusher_On.png"))),

    CLOTH(ItemType.CLOTH, ItemType.LOOM_RECIPE, "A bolt of fine wool cloth.", -1, 4,
            new HashMap<>() {{
                put(ItemType.WOOL, 1);
            }}, 470,new Texture(Gdx.files.internal("Craftable_item/Heavy_Furnace.png"))),

    MAYONNAISE_1(ItemType.MAYONNAISE, ItemType.MAYONNAISE_MACHINE_RECIPE, "It looks spreadable.", 50, 3,
            new HashMap<>() {{
                put(ItemType.EGG, 1);
            }}, 190,new Texture(Gdx.files.internal("Craftable_item/Hopper.png"))),


    DUCK_MAYONNAISE(ItemType.DUCK_MAYONNAISE, ItemType.MAYONNAISE_MACHINE_RECIPE, "It's a rich, yellow mayonnaise.", 75, 3,
            new HashMap<>() {{
                put(ItemType.DUCK_EGG, 1);
            }}, 37,new Texture(Gdx.files.internal("Craftable_item/Loom.png"))),

    DINOSAUR_MAYONNAISE(ItemType.DINOSAUR_MAYONNAISE, ItemType.MAYONNAISE_MACHINE_RECIPE, "It's thick and creamy, with a vivid green hue. It smells like grass and leather.", 125, 3,
            new HashMap<>() {{
                put(ItemType.DINOSAUR_EGG, 1);
            }}, 800,new Texture(Gdx.files.internal("Craftable_item/Mini-Jukebox_Off.png"))),

    TRUFFLE_OIL(ItemType.TRUFFLE_OIL, ItemType.OIL_MAKER_RECIPE, "A gourmet cooking ingredient.", 38, 6,
            new HashMap<>() {{
                put(ItemType.TRUFFLE, 1);
            }}, 1065,new Texture(Gdx.files.internal("Craftable_item/Oil_Maker.png"))),



    SMOKED_FISH(ItemType.SMOKED_FISH, ItemType.FISH_SMOKER_RECIPE, "A whole fish, smoked to perfection.", -1, 1, null, -1,new Texture(Gdx.files.internal("Craftable_item/Fish_Smoker_On.png"))),


    ;


    private final ItemType product;
    private final ItemType entryItem;
    private final String description;
    private final int energy;
    private final int processTime;
    private final Map<ItemType, Integer> ingredients;
    private final int sellPrice;
    private final Texture texture;

    ArtisanMachineType(ItemType type, ItemType entryItem, String description, int energy, int processTime, Map<ItemType, Integer> ingredients, int sellPrice, Texture texture) {
        this.product = type;
        this.entryItem = entryItem;
        this.description = description;
        this.energy = energy;
        this.processTime = processTime;
        this.ingredients = ingredients;
        this.sellPrice = sellPrice;
        this.texture = texture;
    }

    public ItemType getEntryItem() {
        return entryItem;
    }

    public String getDescription() {
        return description;
    }

    public int getEnergy() {
        return energy;
    }

    public Map<ItemType, Integer> getIngredients() {
        return ingredients;
    }

    public int getProcessTime() {
        return processTime;
    }



    public int getSellPrice() {
        return sellPrice;
    }

    public ItemType getType()
    {
        if (product == null)
        {
            Random rand = new Random();
            int random = rand.nextInt(4);

            if (random == 0)
            {
                return ItemType.COPPER_BAR;
            }

            if (random == 1)
            {
                return ItemType.IRIDIUM_BAR;
            }

            if (random == 2)
            {
                return ItemType.IRON_BAR;
            }

            return ItemType.GOLD_BAR;
        }

        return product;
    }
    public boolean isEdible()
    {
        if ( product == null || product.equals(ItemType.COAL) || product.equals(ItemType.CLOTH))
        {
            return false;
        }

        return true;
    }
    public boolean hasIngredient(ItemType type) {
        if (this.ingredients == null || this.ingredients.isEmpty()) {
            return false;
        }
        return this.ingredients.containsKey(type);
    }


    public static ArtisanMachineType getTypeFromDevicesAndIngredient(ItemType craftingItem, ItemType ingredient) {
        for (ArtisanMachineType type : ArtisanMachineType.values()) {
            if (type.getEntryItem().equals(craftingItem) && type.ingredients != null && type.ingredients.containsKey(ingredient)) {
                return type;
            }
        }
        return null;
    }

    public ItemType getProduct() {
        return product;
    }

    public Texture getTexture() {
        return texture;
    }
}
