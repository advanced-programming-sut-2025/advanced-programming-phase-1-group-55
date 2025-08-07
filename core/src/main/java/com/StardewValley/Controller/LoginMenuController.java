package com.StardewValley.Controller;

import com.StardewValley.model.Result;


import static com.StardewValley.model.App.*;

public class LoginMenuController extends RegisterController {
    public Result login(String username, String password, String stayLoggedIn) {

        if (!AllUsers.containsKey(username)) {
            return new Result(false, "username doesnt exists");
        }
        if (!AllUsers.get(username).getPassword().equals(convertToSHA(password))) {

            return new Result(false, "password doesnt match");
        }
        if (stayLoggedIn.equals("-stay-logged-in")) {
            AllUsers.get(username).setStayLoggedIn(true);
            System.out.println("stay logged in");
        }
        saveUserToJson(AllUsers.get(username));
        mainUser = AllUsers.get(username);


        return new Result(true, "logged in");

    }

}
