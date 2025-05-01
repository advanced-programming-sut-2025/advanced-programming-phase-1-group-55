package Controller;

import enums.Result;
import model.User;

import java.util.regex.Pattern;

import static model.Game.*;

public class RegisterController {
    public Void Register(String username, String password, String passwordConfirmation, String email) {
        for (User user : AllUsers) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username is already in use");
                //todo add somthing to username
                break;
            }
        }
        System.out.println(username);
        if (!isValidUsername(username)) {
            System.out.println("Username is not valid");
            return null;
        }
        System.out.println(email);
        if (!isValidEmail(email)) {
            System.out.println("Email is not valid");
            return null;
        }
        System.out.println("Registered successfully");
        return null;


    }

    private boolean isValidUsername(String username) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+");
        if (pattern.matcher(username).matches()) {
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
}
