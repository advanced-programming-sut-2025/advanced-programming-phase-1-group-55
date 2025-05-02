package Controller;

import enums.Result;
import model.User;

import java.security.SecureRandom;
import java.util.Random;
import java.util.regex.Pattern;

import static model.Game.*;

public class RegisterController {
    public Result Register(String username, String password, String passwordConfirmation, String email) {
        for (User user : AllUsers) {
            if (user.getUsername().equals(username)) {
                //todo add somthing to username and offer it
                return new Result(false, "Username is already in use");

            }
        }
        if (!isValidUsername(username)) {
            return new Result(false, "username is not valid");
        }
        if (!isValidEmail(email)) {
            return new Result(false, "Email is not valid");

        }
        if (!isValidPassword(password)) {
            return new Result(false, "Password is not valid");
        }
        if (!isStrongPassword(password)) {

            return new Result(false, "Password is not strong");
        }
        if (!password.equals(passwordConfirmation)) {
            return new Result(false, "Passwords do not match");
        }
        System.out.println("random password : " + RandomPasswordGenerator());
        return new Result(true, "Registered Successfully");

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
