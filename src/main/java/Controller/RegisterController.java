package Controller;

import enums.Result;
import model.User;

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
        return new Result(true, "Registered Successfully");

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
