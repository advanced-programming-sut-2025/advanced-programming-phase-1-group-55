package enums;

public record Result(boolean IsSuccess, String Message) {
    @Override
    public String toString() {
        return Message;
    }
}