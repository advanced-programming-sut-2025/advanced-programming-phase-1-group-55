package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum FriendshipCommands implements Command{
    showFriends("^\\s*friendships\\s*$"),
    talk("^\\s*talk\\s+-u\\s+(?<username>\\S+)\\s+-m\\s+(?<message>\\S.*)\\s*$"),
    talkHistory("^\\s*talk\\s+history\\s+-u\\s+(?<username>\\S+)\\s*$"),
    sendGift("^\\s*gift\\s+-u\\s+(?<username>\\S+)\\s+-i\\s+(?<item>\\S.*)\\s+-a\\s+(?<amount>\\d+)\\s*$"),
    showReceivedGifts("^\\s*gift\\s+list\\s*$"),
    rateGift("^\\s*gift\\s+rate\\s+-i\\s+(?<id>\\d+)\\s+-r\\s+(?<rate>\\d+)\\s*$"),
    showLAllGifts("^\\s*gift\\s+history\\s+-u\\s+(?<username>\\S+)\\s*$"),
    hug("^\\s*hug\\s+-u\\s+(?<username>\\S+)\\s*$"),
    flower("^\\s*flower\\s+-u\\s+(?<username>\\S+)\\s*$"),
    askMarriage("^\\s*ask\\s+marriage\\s+-u\\s+(?<username>\\S+)\\s+-r\\s+(?<ring>\\S.*)\\s*$"),
    respondMarriage("^\\s*respond\\s+–(?<answer>\\S+)\\s+-u\\s+(?<username>\\S+)\\s*$");
    private final String pattern;

    FriendshipCommands(String pattern) {
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
