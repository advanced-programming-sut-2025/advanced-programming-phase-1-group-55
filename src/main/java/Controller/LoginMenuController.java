package Controller;

import enums.Result;
import model.User;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static model.Game.*;

public class LoginMenuController extends RegisterController {
    public Result login(String username, String password, String stayLoggedIn) {
        if (!AllUsers.containsKey(username)) {
            return new Result(false, "username doesnt exists");
        }
        if (!AllUsers.get(username).getPassword().equals(password)) {

            return new Result(false, "password doesnt match");
        }
        if (stayLoggedIn.equals("-stay-logged-in")) {
            AllUsers.get(username).setStayLoggedIn(true);
            System.out.println("stay logged in");
        }
        return new Result(true, "logged in");

    }

    public Result forgetPassword(String username) {
        if (!AllUsers.containsKey(username)) {
            return new Result(false, "username doesnt exists");
        }
        User user = AllUsers.get(username);
        int indexOfQuestion = user.getNumberOfSecurityQuestion();
        String question = questionsList.get(indexOfQuestion);
        System.out.println(question);
        System.out.println("enter the answer :");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String pattern = "answer -a (?<answer>\\S+)\\s*";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);
        while (true) {


            if (matcher.matches()) {
                String answer = matcher.group("answer");

                if (answer.equals(user.getSecurityQuestion())) {
                    RegisterController controller = new RegisterController();

                    System.out.println("for random password enter 1 else press enter to continue");
                    String voroudi = scanner.nextLine();
                    if (voroudi.equals("1")) {
                        user.setPassword(controller.RandomPasswordGenerator());
                        return new Result(true, "random password generated" + "\nyour password : " + user.getPassword());
                    } else {
                        System.out.println("enter your password :");
                        String newPassword = scanner.nextLine();
                        while (true) {
                            if (!isValidPassword(newPassword) || !isStrongPassword(newPassword)) {
                                System.out.println("your password is not strong");
                                System.out.println("for random password enter 1 else press enter another password");
                                String A = scanner.nextLine();
                                if (A.equals("1")) {
                                    user.setPassword(controller.RandomPasswordGenerator());
                                    return new Result(true, "random password generated" + "\nyour password : " + user.getPassword());
                                }
                            } else {
                                user.setPassword(newPassword);
                                return new Result(true, "your password changed" + "\nyour password : " + user.getPassword());
                            }

                        }

                    }


                } else {
                    return new Result(false, "Incorrect answer.");
                }
            } else {
                System.out.println("Invalid format. Use: answer -a <answer>");
            }
        }
    }

}
