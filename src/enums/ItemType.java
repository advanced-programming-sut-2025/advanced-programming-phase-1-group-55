package enums;

public enum ItemType {

    Cherry_Bomb("Cherry Bomb", "4 copper ore + 1 coal", "Mining Level 1", 50);



    private final int SellPrice;
    private final String names;
    private final String[] ingredients;
    private String source;

    ItemType(String names, String[] ingredients, String source, int sellPrice) {
        this.names = names;
        this.ingredients = ingredients;
        this.source = source;
        SellPrice = sellPrice;
    }



    public int getSellPrice() {
        return SellPrice;
    }

    public String getNames() {
        return names;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public String getSource() {
        return source;
    }
}
