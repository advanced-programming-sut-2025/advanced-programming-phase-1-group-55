package Controller;

import enums.Result;
import model.User;

import static model.Game.*;

public class LoginMenuController {
    public Result login(String username, String password, String stayLoggedIn) {
        if (!AllUsers.containsKey(username)) {
            return new Result(false, "username doesnt exists");
        }
        if (!AllUsers.get(username).getPassword().equals(password)) {
            return new Result(false, "password doesnt match");
        }
        return new Result(true, "logged in");

    }

    public Result forgetPassword(String username) {
        return null;
    }

}
