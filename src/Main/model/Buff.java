package model;

public class Buff {
    private String name;
    private int effectAmount;

    public Buff(String name, int effectAmount) {
        this.name = name;
        this.effectAmount = effectAmount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEffectAmount(int effectAmount) {
        this.effectAmount = effectAmount;
    }

    public String getName() {
        return name;
    }

    public int getEffectAmount() {
        return effectAmount;
    }
}
