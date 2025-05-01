package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum mainGameCommands implements Command {
    toolEquipFromBackPack("^\\s*tools\\s+equip\\s+(?<name>\\S+)\\s*$");
    private final String pattern;
    mainGameCommands(String pattern){
        this.pattern=pattern;
    }
    @Override
    public Matcher getMatcher(String input) {
        Matcher matcher= Pattern.compile(this.pattern).matcher((input));
        if(matcher.matches()){
            return matcher;
        }
        return null;
    }
}
