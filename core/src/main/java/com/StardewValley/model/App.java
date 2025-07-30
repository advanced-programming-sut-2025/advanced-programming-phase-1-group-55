package com.StardewValley.model;

import com.StardewValley.GameApp;
import com.StardewValley.View.newView.MainGameGraphicView;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.StardewValley.enums.Menu;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.*;

public class App {
    public static User mainUser;
    public static Scanner scanner = new Scanner(System.in);
    public static Menu currentMenu = Menu.Register;
    public static HashMap<String, User> AllUsers = new HashMap<>();
    public static GameModel currentGameModel;
    public static Random rand = new Random();
    public static GameApp gameApp;
    public static Skin skin;
    public static Map<String,User> playerInGame = new HashMap<>();
    public static MainGameGraphicView currentGameGraphicView ;

    static {
        skin = new Skin(Gdx.files.internal("skin/LibGdx-Skin-main/LibGdx-Skin-main/NzSkin.json"));
    }



    public static User getMainUser() {
        return mainUser;
    }

    public static void setMainUser(User mainUser) {
        App.mainUser = mainUser;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        App.scanner = scanner;
    }

    public static void setCurrentMenu(Menu currentMenu) {
        App.currentMenu = currentMenu;
    }

    public static HashMap<String, User> getAllUsers() {
        return AllUsers;
    }

    public static void setAllUsers(HashMap<String, User> allUsers) {
        AllUsers = allUsers;
    }

    public static GameModel getCurrentGameModel() {
        return currentGameModel;
    }

    public static void setCurrentGameModel(GameModel currentGameModel) {
        App.currentGameModel = currentGameModel;
    }

    public static Random getRand() {
        return rand;
    }

    public static void setRand(Random rand) {
        App.rand = rand;
    }

    public static GameApp getGameApp() {
        return gameApp;
    }

    public static void setGameApp(GameApp gameApp) {
        App.gameApp = gameApp;
    }

    public static Map<Integer, String> getQuestionsList() {
        return questionsList;
    }

    public static void setQuestionsList(Map<Integer, String> questionsList) {
        App.questionsList = questionsList;
    }

    public static Menu getCurrentMenu() {
        return currentMenu;
    }

    public static void readfile() {

        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileReader reader = new FileReader("users.json");

            Type userListType = new TypeToken<List<User>>() {
            }.getType();

            List<User> userList = gson.fromJson(reader, userListType);
            if (userList != null) {
                for (User user : userList) {
                    if (user.getGold() == 0) {
                        user.setGold(1000000000);
                    }
                    AllUsers.put(user.getUsername(), user);
                }


            }
            for (User user : AllUsers.values()) {
                if (user.isStayLoggedIn()) {
                    mainUser = user;
                    currentMenu = Menu.MainMenu;
                    break;
                }
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ssssasasaasasas");
        }


    }


    public static Map<Integer, String> questionsList = new HashMap<>();

    static {
        questionsList.put(1, "What was the name of your first-grade teacher?");
        questionsList.put(2, "What was the first phone number you ever memorized?");
        questionsList.put(3, "What is the name of your childhood best friend?");
    }

    public static boolean usernameExists(String arshia1) {
        return AllUsers.get(arshia1) != null;
    }
}
