package Controller;

import com.google.gson.GsonBuilder;
import enums.Menu;
import model.Result;
import model.User;

import java.security.MessageDigest;
import java.security.SecureRandom;

import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.*;

import static model.Game.*;

public class RegisterController {

    Scanner scanner = new Scanner(System.in);

    public Result Register(String username, String password, String passwordConfirmation, String nickname, String email, String gender)  {
        if (!isUniqueUsername(username)) {
            System.out.println("Username is already in use");

            boolean exit = false;
            while (!exit) {
                String newusername = generateNewUsername(username);
                System.out.println("if you want this username enter 1 else press enter " + "username : " + "(" + newusername + ")");
                String input = scanner.nextLine();
                if (input.equals("1")) {
                    username = newusername;
                    exit = true;
                }
            }

        }
        if (!isValidUsername(username)) {
            return new Result(false, "username is not valid");
        }
        if (!isValidEmail(email)) {
            return new Result(false, "Email is not valid");

        }
        if (password.equals("r") && passwordConfirmation.equals("r")) {

            System.out.println("random password : " + (password = RandomPasswordGenerator()));

        } else if (!password.equals(passwordConfirmation)) {
            return new Result(false, "Passwords do not match");
        } else if (!isValidPassword(password)) {
            return new Result(false, "Password is not valid");
        } else if (!isStrongPassword(password)) {

            return new Result(false, "Password is not strong");
        }
        System.out.println("select one of these questions and answer it");
        for (Map.Entry<Integer, String> question : questionsList.entrySet()) {
            System.out.println(question.getKey() + ": " + question.getValue());
        }


        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("pick\\s+question\\s+-q\\s+(?<number>\\S+)\\s+-a\\s+(?<answer>\\S+)\\s+-c\\s+(?<confirm>\\S+)\\s*");
        int number;
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            return new Result(false, "wrong answer type");
        } else if (!matcher.group("confirm").trim().equals(matcher.group("answer").trim())) {

            return new Result(false, "wrong confirm answer ");

        }
        try {
            number = Integer.parseInt(matcher.group("number"));
        } catch (IllegalStateException e) {
            return new Result(false, "Invalid number");
        }
        if (number > 3) {
            return new Result(false, "wrong number number should be between 1 up to 3");
        }


        User user = new User(username, convertToSHA(password), nickname, email, gender, number, matcher.group("answer"));
        mainUser = user;
        saveUserToJson(user);
        readfile();
        currentMenu = Menu.MainMenu;
        return new Result(true, "Registered Successfully :)" + "\nusername:" + username + "\npassword: " + password + "\nnickname: " + nickname + "\nemail: " + email + "\ngender: " + gender + "\nchoice: " + number + "\nanswer: " + matcher.group("answer"));

    }

    protected String convertToSHA(String input) {
        try {

            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes());

            StringBuilder hex = new StringBuilder();
            for (byte b : hash) {
                hex.append(String.format("%02x", b));

            }
            return hex.toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;

    }


    //JSON for saving user
    protected void saveUserToJson(User user) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // JSON PATH
        File file = new File("users.json");

        // if file dosent exist we should make a new one
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // if file exist read it
        List<User> userList = new ArrayList<>();
        if (file.length() > 0) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                userList = gson.fromJson(reader, new TypeToken<List<User>>() {
                }.getType());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // add new user to list of users that are in file
        userList.add(user);

        // write new list in file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            gson.toJson(userList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected String generateNewUsername(String base) {
        String newUsername;
        final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String DIGITS = "0123456789";
        SecureRandom random = new SecureRandom();
        do {
            newUsername = base + UPPER.charAt(random.nextInt(UPPER.length())) + DIGITS.charAt(random.nextInt(DIGITS.length()));
        } while (!isUniqueUsername(newUsername) || !isValidUsername(newUsername));
        return newUsername;
    }

    protected boolean isUniqueUsername(String username) {
        if (AllUsers == null) return true;
        for (String X : AllUsers.keySet()) {
            if (X.equals(username)) {
                return false;
            }
        }
        return true;
    }

    protected String RandomPasswordGenerator() {
        final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String LOWER = "abcdefghijklmnopqrstuvwxyz";
        final String DIGITS = "0123456789";
        final String SPECIAL = "!@#$%^&*()-_=+<>?/{}[]";
        final String ALL_CHARS = UPPER + LOWER + DIGITS + SPECIAL;
        SecureRandom rand = new SecureRandom();
        StringBuilder RandomPassword = new StringBuilder(10);
        RandomPassword.append(UPPER.charAt(rand.nextInt(UPPER.length())));
        RandomPassword.append(LOWER.charAt(rand.nextInt(LOWER.length())));
        RandomPassword.append(DIGITS.charAt(rand.nextInt(DIGITS.length())));
        RandomPassword.append(SPECIAL.charAt(rand.nextInt(SPECIAL.length())));
        for (int i = 0; i < 6; i++) {
            RandomPassword.append(ALL_CHARS.charAt(rand.nextInt(ALL_CHARS.length())));

        }
        return shuffleString(RandomPassword.toString());

    }

    protected String shuffleString(String input) {
        char[] a = input.toCharArray();
        SecureRandom rand = new SecureRandom();

        for (int i = 0; i < a.length; i++) {
            int j = rand.nextInt(a.length);
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        return new String(a);
    }


    protected boolean isValidUsername(String username) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+");
        return pattern.matcher(username).matches();
    }

    protected boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9?><,\"';:/|\\]\\[}{+=)(*&^%$#!]+");
        return pattern.matcher(password).matches();
    }

    protected boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile("^(?!.*\\.\\.)([a-zA-Z0-9][a-zA-Z0-9._-]{0,62}[a-zA-Z0-9])@([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9])\\.([a-zA-Z]{2,})$");
        return pattern.matcher(email).matches();
    }

    protected boolean isStrongPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[?><,\"';:/|\\\\\\[\\]{}+=)(*&^%$#!])[A-Za-z\\d?><,\"';:/|\\\\\\[\\]{}+=)(*&^%$#!]{8,}$";
        return Pattern.matches(regex, password);
    }
}
