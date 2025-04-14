package enums;

public enum cookingItemType {

    Fried_egg("Fried egg", "1 egg", 50, "", "Starter", 35);






    private final String names;
    private final String indredient;
    private final int energies;
    private final String buff;
    private final String source;
    private final int sellPrice;

    cookingItemType(String names, String indredient, int energies, String buff, String source, int sellPrice) {
        this.names = names;
        this.indredient = indredient;
        this.energies = energies;
        this.buff = buff;
        this.source = source;
        this.sellPrice = sellPrice;
    }

    public String getNames() {
        return names;
    }

    public String getIndredient() {
        return indredient;
    }

    public int getEnergies() {
        return energies;
    }

    public String getBuff() {
        return buff;
    }

    public String getSource() {
        return source;
    }

    public int getSellPrice() {
        return sellPrice;
    }
}
