package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum LoginCommands {
    Login("\\s*login\\s+-u\\s+(?<username>\\S+)\\s+-p\\s+(?<password>\\S+)\\s+(?<stay>\\S+)?"),


    ForgetPassword("\\s*forget password\\s+-u\\s+(?<username>\\S+)\\s*");


    private String pattern;

    LoginCommands(String pattern) {
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
