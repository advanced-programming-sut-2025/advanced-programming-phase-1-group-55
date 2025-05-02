package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ProfileCommands {
    changeUsername("\\s*change\\s+username\\s+-u\\s+(?<username>\\S+)\\s*"),
    changeNickname("\\s*change\\s+nickname\\s+-u\\s+(?<nickname>\\S+)\\s*"),
    changeEmail("\\s*change\\s+email\\s+-e\\s+(?<email>\\S+)\\s*"),
    changePassword("\\s*change\\s+password\\s+-p\\s+(?<newPassword>\\S+)\\s+-o\\s+(?<oldPassword>\\S+)\\s*"),
    userInfo("\\s*user info\\s*"),
    ;
    private String pattern;

    ProfileCommands(String pattern) {
        this.pattern = pattern;
    }

    public Matcher getMatcher(String input) {
        Pattern pattern = Pattern.compile(this.pattern);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return matcher;
        }
        return null;
    }
}
