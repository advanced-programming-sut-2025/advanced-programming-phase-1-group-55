package enums;

public enum RecipeType {
    CRAFTING("Crafting"),
    COOKING("Cooking");
    private  final String DisplayName;

    public String getDisplayName() {
        return DisplayName;
    }

    RecipeType(String displayName) {
        DisplayName = displayName;
    }
}
