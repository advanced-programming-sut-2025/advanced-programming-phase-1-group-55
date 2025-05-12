package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum mainGameCommands implements Command {
    toolEquipFromBackPack("^\\s*tools\\s+equip\\s+(?<name>\\S+)\\s*$"),
    showAvailableTools("^\\s*tools\\s+show\\s+available\\s*$"),
    showCurrentTool("^\\s*tools\\s+show\\s+current\\s*$"),
    upgradeTool("^\\s*tools\\s+upgrade\\s+(?<name>\\S+)\\s*$"),
    trashItem("^\\s*inventory\\s+trash\\s+-i\\s+(?<name>\\S+)\\s*$"),
    showInventory("^\\s*inventory\\s+show\\s*$"),
    useTool("^\\s*tools\\s+use\\s+-d\\s+(?<direction>\\S.*)\\s*"),
    time("\\s*time\\s*"),
    date("\\s*date\\s*"),
    dateTime("\\s*datetime\\s*"),
    dayOfWeek("\\s*day of the week\\s*"),
    cheatHour("\\s*cheat advance time\\s+(?<X>\\S+)h\\s*"),
    cheatday("\\s*cheat advance date\\s+(?<X>\\S+)d\\s*"),
    season("\\s*season\\s*"),
    cheatThor("\\s*cheat Thor -l (?<x>\\d+)\\s(?<y>\\d+)\\s*"),
    weather("\\s*weather\\s*"),
    weatherForecast("\\s*weather\\s+forecast\\s*"),
    cheatWeatherSet("^\\s*cheat weather set (?<type>\\S+)\\s*$"),
    greenhouse("^\\s*greenhouse build\\s*"),
    energyShow("\\s*energy\\s+show\\s*"),
    energySet("\\s*energy\\s+set\\s+-v\\s+(?<V>\\S+)\\s*"),
    UnlimitedEnergy("\\s*energy\\s+unlimited\\s*"),
    helpReadMap("^\\s*help\\s+reading\\s+map\\s*$"),
    printMap("^\\s*print\\s+map\\s+-l\\s+(?<x>\\d+)\\s+(?<y>\\d+)\\s+-s\\s+(?<size>\\d+)\\s*$"),
    printFullMap("^\\s*print\\s+map\\s*$"),
    gameNew("\\s*game\\s+new\\s+-u\\s+(?<user1>\\S+)(?:\\s+(?<user2>\\S+))?(?:\\s+(?<user3>\\S+))?\\s*"),
    chooseMap("\\s*game\\s+map\\s+(?<X>\\S+)\\s*");
    private final String pattern;

    mainGameCommands(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public Matcher getMatcher(String input) {
        Matcher matcher = Pattern.compile(this.pattern).matcher((input));
        if (matcher.matches()) {
            return matcher;
        }
        return null;
    }
    }
