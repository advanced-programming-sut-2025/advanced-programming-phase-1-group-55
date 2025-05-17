package model.NPC;

import enums.WeatherType;
import model.MainTime;

public enum Dialog {
    D1(WeatherType.Sunny, MainTime.Day, 0, "What a bright sunny day! Nice to see you."),
    D2(WeatherType.Sunny, MainTime.Day, 1, "Sun’s out and so are we! Need a hand?"),
    D3(WeatherType.Sunny, MainTime.Day, 2, "Another sunny day with my best friend!"),
    D4(WeatherType.Sunny, MainTime.Night, 0, "Even after the sun sets, I'm here for you."),
    D5(WeatherType.Sunny, MainTime.Night, 1, "A calm night after a sunny day. How can I help?"),
    D6(WeatherType.Sunny, MainTime.Night, 2, "Good evening, friend. Beautiful clear skies tonight."),

    D7(WeatherType.Rain, MainTime.Day, 0, "Rainy days make me thoughtful. How can I assist?"),
    D8(WeatherType.Rain, MainTime.Day, 1, "Don't let the rain get you down. I'm here."),
    D9(WeatherType.Rain, MainTime.Day, 2, "Rain or shine, you're always welcome."),
    D10(WeatherType.Rain, MainTime.Night, 0, "Such a good rainy night! How can I help you?"),
    D11(WeatherType.Rain, MainTime.Night, 1, "Rain at night is soothing. Let's chat."),
    D12(WeatherType.Rain, MainTime.Night, 2, "A rainy night and a good friend—perfect combo."),

    D13(WeatherType.Storm, MainTime.Day, 0, "This storm feels intense. Stay close."),
    D14(WeatherType.Storm, MainTime.Day, 1, "Stormy day, huh? Don't worry, I got your back."),
    D15(WeatherType.Storm, MainTime.Day, 2, "Even the storm can't stop us!"),
    D16(WeatherType.Storm, MainTime.Night, 0, "Scary storm tonight... want to talk?"),
    D17(WeatherType.Storm, MainTime.Night, 1, "Night storms are wild. Be careful."),
    D18(WeatherType.Storm, MainTime.Night, 2, "Through the thunder and lightning, I'm still here."),

    D19(WeatherType.Snow, MainTime.Day, 0, "Snow is falling! Let's make the best of it."),
    D20(WeatherType.Snow, MainTime.Day, 1, "Cold out there? Come warm up with a chat."),
    D21(WeatherType.Snow, MainTime.Day, 2, "Snowy days are the best when shared."),
    D22(WeatherType.Snow, MainTime.Night, 0, "Cold snowy night. Everything okay?"),
    D23(WeatherType.Snow, MainTime.Night, 1, "Winter nights are tough. I'm here to talk."),
    D24(WeatherType.Snow, MainTime.Night, 2, "Snow, stars, and friendship—can't beat that.");

    private final WeatherType weatherType;
    private final MainTime mainTime;
    private final int friendshipLevel;
    private final String message;
    Dialog( WeatherType weatherType, MainTime mainTime, int friendshipLevel,String message) {
       this.message=message;
        this.weatherType = weatherType;
        this.mainTime = mainTime;
        this.friendshipLevel = friendshipLevel;
    }

    public WeatherType getWeatherType() {
        return weatherType;
    }

    public MainTime getMainTime() {
        return mainTime;
    }

    public int getFriendshipLevel() {
        return friendshipLevel;
    }

    public String getMessage() {
        return message;
    }
}
