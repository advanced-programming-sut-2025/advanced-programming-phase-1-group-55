package model;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import enums.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.*;

public class Game {
    public static User mainUser;
    public static Menu currentMenu = Menu.Register;
    public static HashMap<String, User> playersInGame = new HashMap<>();

    public static WeatherType currentWeather;
    public static HashMap<String, User> AllUsers = new HashMap<>();

    public static void readfile() {

        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader("users.json");

            Type userListType = new TypeToken<List<User>>() {
            }.getType();
            AllUsers = gson.fromJson(reader, userListType);

            if (AllUsers != null) {
                for (String user : AllUsers.keySet()) {
                    System.out.println(user);
                }
            } else {
                System.out.println("لیست کاربران خالی یا نال است.");
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("فایل users.json پیدا نشد.");
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            System.out.println("فرمت JSON اشتباه است.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("خطای غیرمنتظره:");
            e.printStackTrace();
        }

    }

    public static Map<Integer, String> questionsList = new HashMap<>();

    static {
        questionsList.put(1, "What was the name of your first-grade teacher?");
        questionsList.put(2, "What was the first phone number you ever memorized?");
        questionsList.put(3, "What is the name of your childhood best friend?");
    }


    public static Menu getCurrentMenu() {
        return currentMenu;
    }
}
