package enums;

public enum NpcType {
    SEBASTIAN(
            "پشم، پای کدو، پیتزا",
            "تحویل ۵۰ واحد آهن",
            "۲ عدد الماس"),

    ABIGAIL(
            "سنگ، کان آهن، قهوه",
            "تحویل ۱۵۰ واحد سنگ",
            "۵۰ عدد کوارتز"),

    HARVEY(
            "قهوه، ترشی، شراب",
            "تحویل یک ماهی سالمون",
            "۱ سطح دوستی"),

    LEAH(
            "سالاد، انگور، شراب",
            "تحویل یک ماهی سالمون",
            "۱ دستورالعمل آشپزی dinner(salmon)"),

    ROBIN(
            "اسپاگتی، چوب، شمش آهن",
            "تحویل ۱۰ شمش آهن",
            "۳ عدد خانه زنبور عسل");

    private final String favorites;
    private final String request;
    private final String reward;
    private String[] dialogs; // taghir be shey dialog va ezafe kardan ertebaat baa fasl
    private  String job;
    private String[] quests; //shey quest ezaafe beshe
    NpcType( String favorites, String request, String reward) {
        this.favorites = favorites;
        this.request = request;
        this.reward = reward;
    }


    public String getFavorites() {
        return favorites;
    }

    public String getRequest() {
        return request;
    }

    public String getReward() {
        return reward;
    }

    public String[] getDialogs() {
        return dialogs;
    }

    public void setDialogs(String[] dialogs) {
        this.dialogs = dialogs;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String[] getQuests() {
        return quests;
    }

    public void setQuests(String[] quests) {
        this.quests = quests;
    }
}
