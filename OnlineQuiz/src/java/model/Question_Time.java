/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author quanh
 */
//include information about time create of question
public class Question_Time {
    int id;
    String question;
    Date time;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Question_Time() {
    }

    public Question_Time(int id, String question, Date time) {
        this.id = id;
        this.question = question;
        this.time = time;
    }

     /*
    purpose : format time
    author: quanndhe130577
    time : 27/02/2020
    */
    @Override
    public String toString() {
        SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yyyy");  
        return f.format(time);
    }
}
