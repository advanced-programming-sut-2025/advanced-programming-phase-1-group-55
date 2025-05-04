package Controller;

import model.Result;

import static model.Game.*;

public class ProfileMenuController extends RegisterController {
    public Result changeUsername(String Username) {
        if (Username.equals(mainUser.getUsername())) {
            return new Result(false, "enter new username !");
        }
        mainUser.setUsername(Username);
        return new Result(true, "username changed !");
    }

    public Result changenickName(String nickname) {
        if (nickname.equals(mainUser.getNickName())) {
            return new Result(false, "enter new nickname !");
        }
        mainUser.setNickName(nickname);
        return new Result(true, "nickname changed !");

    }

    public Result changeEmail(String email) {
        if (email.equals(mainUser.getEmail())) {
            return new Result(false, "enter new email !");
        }
        if (!isValidEmail(email)) {
            return new Result(false, "email is not valid !");
        }
        mainUser.setEmail(email);
        return new Result(true, "email changed !");

    }

    public Result changePassword(String newPassword, String OldPassword) {
        if (newPassword.equals(mainUser.getPassword())) {
            return new Result(false, "enter new password !");
        }
        if (!OldPassword.equals(OldPassword)) {
            return new Result(false, "Old password does not match !");
        }
        mainUser.setPassword(newPassword);
        return new Result(true, "password changed !");
    }


    public Result userInfo() {
        StringBuilder userInfo = new StringBuilder();
        userInfo.append("username : " + mainUser.getUsername()).append("\n");
        userInfo.append("nickname : " + mainUser.getNickName()).append("\n");
        userInfo.append("most achieved money : " + mainUser.getMostAchievedMoney()).append("\n");
        userInfo.append("email : " + mainUser.getMatchPlayed()).append("\n");
        return new Result(true, userInfo.toString());
    }


}
