package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dal.QuestionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Question;

/**
 *time : 26/02/2020
 * @author quanndhe130577
 */
// 
public class TakeQuiz extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*
    purpose : go to NumberOfQuestion.jsp
    author: quanndhe130577
    time : 26/02/2020
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/TakeQuiz-NumberOfQuestion.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*
    purpose : get number of question and get question from database
    author: quanndhe130577
    time : 26/02/2020
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int number_of_question = Integer.parseInt(String.valueOf(request.getParameter("number_of_question")));
        request.getSession().setAttribute("number_of_question", number_of_question);
        request.getSession().setAttribute("rs", 0);
        QuestionDAO qdao = new QuestionDAO();
        ArrayList<Question> list_question = qdao.getRandomQuestion(number_of_question);
        // value of getRandomeQuestion is null
        if (list_question == null) {
            response.getWriter().write("Error loading question");
        } else {
            request.getSession().setAttribute("list_question", list_question);
            int min = Integer.parseInt(String.valueOf(request.getSession().getAttribute("number_of_question")));
            // get miliseconds from 1-1-1970 to now
            long time_start = new Date().getTime();
            // calculate time end 
            long time_end = time_start + min * 60 * 1000;
            request.getSession().setAttribute("time_end", time_end);
            response.sendRedirect("TakeQuiz-DoQuestion.jsp");

        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
