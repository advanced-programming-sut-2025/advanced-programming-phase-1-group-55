package com.StardewValley.Common.model.Chat;

public enum EmojiType {
    Emoji0(0, "Emoji/Emojis000.png"),
    Emoji1(1, "Emoji/Emojis001.png"),
    Emoji2(2, "Emoji/Emojis002.png"),
    Emoji3(3, "Emoji/Emojis003.png"),
    Emoji4(4, "Emoji/Emojis004.png"),
    Emoji5(5, "Emoji/Emojis005.png"),
    Emoji6(6, "Emoji/Emojis006.png"),
    Emoji7(7, "Emoji/Emojis007.png"),
    Emoji8(8, "Emoji/Emojis008.png"),
    Emoji9(9, "Emoji/Emojis009.png"),
    Emoji10(10, "Emoji/Emojis010.png"),
    Emoji11(11, "Emoji/Emojis011.png"),
    Emoji12(12, "Emoji/Emojis012.png"),
    Emoji13(13, "Emoji/Emojis013.png"),
    Emoji14(14, "Emoji/Emojis014.png"),
    Emoji15(15, "Emoji/Emojis015.png"),
    Emoji16(16, "Emoji/Emojis016.png"),
    Emoji17(17, "Emoji/Emojis017.png"),
    Emoji18(18, "Emoji/Emojis018.png"),
    Emoji19(19, "Emoji/Emojis019.png"),
    Emoji20(20, "Emoji/Emojis020.png"),
    Emoji21(21, "Emoji/Emojis021.png"),
    Emoji22(22, "Emoji/Emojis022.png"),
    Emoji23(23, "Emoji/Emojis023.png"),
    Emoji24(24, "Emoji/Emojis024.png"),
    Emoji25(25, "Emoji/Emojis025.png"),
    Emoji26(26, "Emoji/Emojis026.png"),
    Emoji27(27, "Emoji/Emojis027.png"),
    Emoji28(28, "Emoji/Emojis028.png"),
    Emoji29(29, "Emoji/Emojis029.png"),
    Emoji30(30, "Emoji/Emojis030.png"),
    Emoji31(31, "Emoji/Emojis031.png"),
    Emoji32(32, "Emoji/Emojis032.png"),
    Emoji33(33, "Emoji/Emojis033.png"),
    Emoji34(34, "Emoji/Emojis034.png"),
    Emoji35(35, "Emoji/Emojis035.png"),
    Emoji36(36, "Emoji/Emojis036.png"),
    Emoji37(37, "Emoji/Emojis037.png"),
    Emoji38(38, "Emoji/Emojis038.png"),
    Emoji39(39, "Emoji/Emojis039.png"),
    Emoji40(40, "Emoji/Emojis040.png"),
    Emoji41(41, "Emoji/Emojis041.png"),
    Emoji42(42, "Emoji/Emojis042.png"),
    Emoji43(43, "Emoji/Emojis043.png"),
    Emoji44(44, "Emoji/Emojis044.png"),
    Emoji45(45, "Emoji/Emojis045.png"),
    Emoji46(46, "Emoji/Emojis046.png"),
    Emoji47(47, "Emoji/Emojis047.png"),
    Emoji48(48, "Emoji/Emojis048.png"),
    Emoji49(49, "Emoji/Emojis049.png");

    private final int id;
    private final String path;

    EmojiType(int id, String path) {
        this.id = id;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public String getPath() {
        return path;
    }
    public static EmojiType getFromId(int id) {
        for (EmojiType emojiType : EmojiType.values()) {
            if (emojiType.getId() == id) {
                return emojiType;
            }
        }
        return Emoji0;
    }
}
