package com.StardewValley.Common;

import com.StardewValley.Common.model.User;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static Connection connection;


    public static void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:user_datas.db");
            createTableIfNeeded();
            System.out.println("Database connected successfully.");
        } catch (SQLException e) {
            System.out.println("Error while connecting to database");
            e.printStackTrace();
        }
    }


    private static void  createTableIfNeeded() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS user (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "username TEXT NOT NULL UNIQUE," +
            "password TEXT NOT NULL," +
            "nickname TEXT," +
            "email TEXT," +
            "gender TEXT," +
            "securityQuestion TEXT," +
            "securityAnswer TEXT," +
            "avatarPath TEXT," +
            "gold INTEGER" +
            ");";
        Statement stmt = connection.createStatement();
        stmt.execute(sql);
    }


    public static void insertUser(User user) {
        if (connection == null) {
            System.out.println("Database not connected!");
            return;
        }
//        try {
//            String sql = "INSERT INTO user (username, password, nickname, email, gender, securityQuestion, securityAnswer, avatarPath, gold) " +
//                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//            PreparedStatement pstmt = connection.prepareStatement(sql);
//            pstmt.setString(1, user.getUsername());
//            pstmt.setString(2, user.getPassword());
//            pstmt.setString(3, user.getNickName());
//            pstmt.setString(4, user.getEmail());
//            pstmt.setString(5, user.getGender());
//            pstmt.setString(6, user.getSecurityQuestion());
//            pstmt.setString(7, user.getAnswerOfSecurityQuestion());
//            pstmt.setString(8, user.getAvatarPath());
//            pstmt.setInt(9, user.getGold());
//            pstmt.executeUpdate();
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
    }


    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        if (connection == null) return users;

        try {
            String sql = "SELECT * FROM user";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User user = new User(
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("nickname"),
                    rs.getString("email"),
                    rs.getString("gender"),
                    rs.getString("securityQuestion"),
                    rs.getString("securityAnswer"),
                    rs.getString("avatarPath")
                );
                user.setGold(rs.getInt("gold"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


    public static void updateUser(User user) {
        if (connection == null) return;
        try {
            String sql = "UPDATE user SET password = ?, securityQuestion = ?, securityAnswer = ?, avatarPath = ?, gold = ? " +
                "WHERE username = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, user.getPassword());
            pstmt.setString(2, user.getSecurityQuestion());
            pstmt.setString(3, user.getAnswerOfSecurityQuestion());
            pstmt.setString(4, user.getAvatarPath());
            pstmt.setInt(5, user.getGold());
            pstmt.setString(6, user.getUsername());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("No user found with username: " + user.getUsername());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void deleteUser(String username) {
        if (connection == null) return;
        try {
            String sql = "DELETE FROM user WHERE username = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, username);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted == 0) {
                System.out.println("No user found with username: " + username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static  void disconnect() {
        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
