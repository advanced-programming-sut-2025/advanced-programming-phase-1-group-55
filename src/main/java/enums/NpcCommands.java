package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum NpcCommands implements Command{
    meetNpc("^\\s*meet\\s+npc\\s+(?<name>\\S+)\\s*$"),
    giftNpc("^\\s*gift\\s+npc\\s+(?<name>\\S+)\\s+-i\\s+(?<item>\\S.*)\\s*$"),
    friendshipList("^\\s*friendship\\s+npc\\s+list\\s*$"),
    questlist("^\\s*quests\\s+list\\s*$"),
    questFinish("^\\s*quests\\s+finish\\s+-i\\s+(?<id>\\d+)\\s*$");
    private final String pattern;

    NpcCommands(String pattern) {
        this.pattern = pattern;
    }

    public Matcher getMatcher(String input) {
        Matcher matcher = Pattern.compile(pattern).matcher(input);
        if (matcher.matches()) {
            return matcher;
        }
        return null;
    }
}
