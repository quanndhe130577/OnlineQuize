/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author quanh
 */

//include funtion to work with account in database
public class AccountDAO extends DBContext {

    /*
    purpose : return account of user with username and password
    author: quanndhe130577
    time : 02/2020
    */
    public Account checkAccount(String username, String password) {
        try {
            String sql = "SELECT [id]\n"
                    + "      ,[username]\n"
                    + "      ,[password]\n"
                    + "      ,[type]\n"
                    + "      ,[email]\n"
                    + "  FROM [J3_L_P0001].[dbo].[account]";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String ck_username = rs.getString("username");
                // username is right
                if (ck_username.equalsIgnoreCase(username)) {
                    String ck_password = rs.getString("password");
                    // password is right
                    if (ck_password.equals(password)) {
                        Account x = new Account(rs.getInt("id"), username, password, String.valueOf(rs.getString("type")), String.valueOf(rs.getString("email")));
                        return x;
                    }
                }
            }
        } catch (Exception ex) {
            return null;
        }
        return null;
    }

    /*
    purpose : insert account to database
    author: quanndhe130577
    time : 02/2020
    */
    public String insertAccount(Account p) throws SQLException {
        //  username has  exiteds 
        if(!checkUsername(p.getUsername()) ){
            return "username_error";
        }
        //  email has existed
        if(!checkEmail(p.getEmail()) ){
            return "email_error";
        }
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO account (id, username, [password], type, email) \n"
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, p.getId());
            pst.setString(2, p.getUsername());
            pst.setString(3, p.getPassword());
            pst.setString(4, p.getType());
            pst.setString(5, p.getEmail());
            pst.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            connection.rollback();
            return "loi user: " + ex.getMessage();
        }
        connection.setAutoCommit(true);
        return "Success";
    }

    /*
    purpose : return the max of id account from database
    author: quanndhe130577
    time : 02/2020
    */
    public int getIdAccountMax() throws SQLException {
        int max = 0;
        String sql = "SELECT max(id) as max FROM account";
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            max = rs.getInt("max");
        }
        return max;
    }

    /*
    purpose : return username for register has exited or not
    author: quanndhe130577
    time : 02/2020
    */
    public boolean checkUsername(String username) {
        try {
            String sql = "SELECT [username]\n"
                    + "  FROM [J3_L_P0001].[dbo].[account]";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String ck_username = rs.getString("username");
                //username has existed
                if (ck_username.equalsIgnoreCase(username)) {
                    return false;
                }
            }
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    /*
    purpose : return email for register has exited or not
    author: quanndhe130577
    time : 02/2020
    */
    public boolean checkEmail(String email) {
        try {
            String sql = "SELECT [email]\n"
                    + "  FROM [J3_L_P0001].[dbo].[account]";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String ck_email = rs.getString("email");
                // email has existed
                if (ck_email.equalsIgnoreCase(email)) {
                    return false;
                }
            }
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
