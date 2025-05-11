package model.playerFeature;

public class Energy {
    public static int maxEnergy = 200;
    private double energyAmount;

    public static int getMaxEnergy() {
        return maxEnergy;
    }

    public static void setMaxEnergy(int maxEnergy) {
        maxEnergy = maxEnergy;
    }

    public double getEnergyAmount() {
        return energyAmount;
    }

    public void setEnergyAmount(double energyAmount) {
        this.energyAmount = energyAmount;
    }

    public boolean isFainted(double amount) {
        return this.energyAmount - amount <= 0;
    }

    public void decreaseEnergy(double amount) {
        this.energyAmount -= amount;
        this.energyAmount = Math.max(0, this.energyAmount - amount);
    }

    public void increaseEnergy(double amount) {
        this.energyAmount += amount;
        this.energyAmount = Math.min(maxEnergy, energyAmount);
    }

}
