package model.FarmingProdocts;

public class ForagingTree {
    private AllForagingTrees foragingTreeType;

    public AllForagingTrees getForagingTreeType() {
        return foragingTreeType;
    }

    public void setForagingTreeType(AllForagingTrees foragingTreeType) {
        this.foragingTreeType = foragingTreeType;
    }

    @Override
    public String toString() {
        return "Crop{" +
                "name='" + foragingTreeType.getName() + '\'' +
                ", season=" + foragingTreeType.getSeason() +
                '}';
    }
}
