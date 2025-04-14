package model;

public class Food {
    private String name;
    private int energyBoost;
    private Buff buff;
    private int buffDurationHours;

    public Food(String name, int energyBoost, Buff buff, int buffDurationHours) {
        this.name = name;
        this.energyBoost = energyBoost;
        this.buff = buff;
        this.buffDurationHours = buffDurationHours;
    }

    public String getName() {
        return name;
    }

    public int getEnergyBoost() {
        return energyBoost;
    }

    public Buff getBuff() {
        return buff;
    }

    public int getBuffDurationHours() {
        return buffDurationHours;
    }
}
