package enums;

public enum AnsiColor {
    RESET("\u001B[0m"),

    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m"),
    BRIGHT_BLACK("\u001B[90m"),
    BRIGHT_RED("\u001B[91m"),
    BRIGHT_GREEN("\u001B[92m"),
    BRIGHT_YELLOW("\u001B[93m"),
    BRIGHT_BLUE("\u001B[94m"),
    BRIGHT_PURPLE("\u001B[95m"),
    BRIGHT_CYAN("\u001B[96m"),
    BRIGHT_WHITE("\u001B[97m"),
    // Background colors
    BG_BLACK("\u001B[40m"),
    BG_RED("\u001B[41m"),
    BG_GREEN("\u001B[42m"),
    BG_YELLOW("\u001B[43m"),
    BG_BLUE("\u001B[44m"),
    BG_PURPLE("\u001B[45m"),
    BG_CYAN("\u001B[46m"),
    BG_WHITE("\u001B[47m"),

    // Bright background colors
    BG_BRIGHT_BLACK("\u001B[100m"),
    BG_BRIGHT_RED("\u001B[101m"),
    BG_BRIGHT_GREEN("\u001B[102m"),
    BG_BRIGHT_YELLOW("\u001B[103m"),
    BG_BRIGHT_BLUE("\u001B[104m"),
    BG_BRIGHT_PURPLE("\u001B[105m"),
    BG_BRIGHT_CYAN("\u001B[106m"),
    BG_BRIGHT_WHITE("\u001B[107m"),

    // Styles
    BOLD("\u001B[1m"),
    UNDERLINE("\u001B[4m"),
    REVERSED("\u001B[7m");

    private final String code;

    AnsiColor(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
