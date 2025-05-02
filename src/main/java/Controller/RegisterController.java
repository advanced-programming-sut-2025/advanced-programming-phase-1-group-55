package Controller;

import enums.Result;
import model.User;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

import static model.Game.*;

public class RegisterController {
    boolean wrongPassword = false;
    Scanner scanner = new Scanner(System.in);

    public Result Register(String username, String password, String passwordConfirmation, String nickname, String email, String gender) {
        if (!isUniqueUsername(username)) {
            System.out.println("Username is already in use");
            //todo offer new username
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
        User user = new User(username, password, nickname, email, gender);
        AllUsers.add(user);
        return new Result(true, "Registered Successfully :)" +"\nusername:"+ username + "\npassword: " + password + "\nnickname: " + nickname + "\nemail: " + email);

    }

    private String generateNewUsername(String base) {
        String newUsername;
        final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String LOWER = "abcdefghijklmnopqrstuvwxyz";
        final String DIGITS = "0123456789";
        final String SPECIAL = "!@#$%^&*()-_=+<>?/{}[]";
        SecureRandom random = new SecureRandom();
        do {
            newUsername = base + UPPER.charAt(random.nextInt(UPPER.length())) + DIGITS.charAt(random.nextInt(DIGITS.length()));
        } while (!isUniqueUsername(newUsername) || !isValidUsername(newUsername));
        return newUsername;
    }

    private boolean isUniqueUsername(String username) {
        for (User user : AllUsers) {
            if (user.getUsername().equals(username)) {
                return false;


            }
        }
        return true;
    }

    private String RandomPasswordGenerator() {
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

    private static String shuffleString(String input) {
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


    private boolean isValidUsername(String username) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+");
        if (pattern.matcher(username).matches()) {
            return true;
        }
        return false;
    }

    private boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9?><,\"';:/|\\]\\[}{+=)(*&^%$#!]+");
        if (pattern.matcher(password).matches()) {
            return true;
        }
        return false;
    }

    private boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile("^(?!.*\\.\\.)([a-zA-Z0-9][a-zA-Z0-9._-]{0,62}[a-zA-Z0-9])@([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9])\\.([a-zA-Z]{2,})$");
        if (pattern.matcher(email).matches()) {
            return true;
        }
        return false;
    }

    private boolean isStrongPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[?><,\"';:/|\\\\\\[\\]{}+=)(*&^%$#!])[A-Za-z\\d?><,\"';:/|\\\\\\[\\]{}+=)(*&^%$#!]{8,}$";
        return Pattern.matches(regex, password);
    }
}
