/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.Date;
import java.util.Iterator;
import model.Question;
import java.util.List;
import java.util.ListIterator;
import model.Question_Time;

/**
 *
 * @author quanh
 */
//include funtion to work with question in database
public class QuestionDAO extends DBContext {

    /*
    purpose : return number of randome question
    author: quanndhe130577
    time : 26/02/2020
    */
    public ArrayList<Question> getRandomQuestion(int number) {
        ArrayList<Question> list = new ArrayList();
        try {
            String sql = "SELECT T.id, T.question, T.option_1,T.option_2,T.option_3, T.option_4, answer_number\n"
                    + "FROM (SELECT top (?) * FROM questions ORDER BY NEWID()) as T, answer\n"
                    + "WHERE T.id = answer.id_question\n"
                    + "ORDER BY id, answer_number asc";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, number);
            ResultSet rs = pst.executeQuery();

            boolean check_next = true;
            rs.next();
            while (check_next) {
                int id = rs.getInt("id");

                Question q = new Question();
                q.setId(id);
                q.setQuestion(rs.getString("question"));
                q.setOption_1(rs.getString("option_1"));
                q.setOption_2(rs.getString("option_2"));
                q.setOption_3(rs.getString("option_3"));
                q.setOption_4(rs.getString("option_4"));

                ArrayList<Integer> list_answer = new ArrayList<>();
                list_answer.add(rs.getInt("answer_number"));
                //set check_next = result of re.next()
                while (check_next = rs.next()) {
                    //  id of this rs is different from previous rs
                    if (rs.getInt("id") != id) {
                        break;
                    } else {
                        list_answer.add(rs.getInt("answer_number"));
                    }
                }
                q.setAnswer(list_answer);
                list.add(q);
            }
        } catch (Exception e) {
            return null;
        }
        return list;
    }

    /*
    purpose : return new id for new question
    author: quanndhe130577
    time : 26/02/2020
    */
    public int getNewId() {
        int max = 0;
        try {
            String sql = "SELECT MAX(id) as max\n"
                    + "FROM questions";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                max = rs.getInt("max");
            }

        } catch (Exception e) {
            return -1;
        }
        return max + 1;
    }

    /*
    purpose : insert question to database
    author: quanndhe130577
    time : 02/2020
    */
    public String insertQuestion(Question q) throws SQLException {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        try {
            connection.setAutoCommit(false);
            String sql_question = "INSERT INTO questions(id, question, option_1, option_2, option_3, option_4, DateCreated)\n"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = connection.prepareCall(sql_question);
            pst.setInt(1, q.getId());
            pst.setString(2, q.getQuestion());
            pst.setString(3, q.getOption_1());
            pst.setString(4, q.getOption_2());
            pst.setString(5, q.getOption_3());
            pst.setString(6, q.getOption_4());
            pst.setDate(7, date);
            pst.executeUpdate();

            for (Integer i : q.getAnswer()) {
                String sql_answer = "INSERT INTO answer(id_question, answer_number)\n"
                        + "VALUES (?, ?)";
                pst = connection.prepareCall(sql_answer);
                pst.setInt(1, q.getId());
                pst.setInt(2, i);
                pst.executeUpdate();
            }
        } catch (Exception e) {
            connection.rollback();
            connection.setAutoCommit(true);
            return e.getMessage();
        }
        connection.setAutoCommit(true);
        return "success";
    }

    public ArrayList<Question_Time> getAllQuestionWithTime() {
        ArrayList<Question_Time> list = new ArrayList();
        try {
            String sql = "SELECT id\n"
                    + "      ,[question]\n"
                    + "      ,[DateCreated]\n"
                    + "  FROM [J3_L_P0001].[dbo].[questions]\n"
                    + " ORDER BY [DateCreated] desc";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Question_Time qt = new Question_Time(rs.getInt("id"), rs.getString("question"), rs.getDate("DateCreated"));
                list.add(qt);
            }
        } catch (Exception e) {
            return null;
        }
        return list;
    }
}
