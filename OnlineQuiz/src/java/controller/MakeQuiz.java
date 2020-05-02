/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.QuestionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Question;

/**
 *
 * @author quanndhe130577
 */
// 
public class MakeQuiz extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MakeQuiz</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MakeQuiz at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
    purpose : get information from jsp to insert question to Database
    author: quanndhe130577
    time : 26/02/2020
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String question = String.valueOf(request.getParameter("question"));
        String option1 = String.valueOf(request.getParameter("option1"));
        String option2 = String.valueOf(request.getParameter("option2"));
        String option3 = String.valueOf(request.getParameter("option3"));
        String option4 = String.valueOf(request.getParameter("option4"));
        
        ArrayList<Integer> list_ans = new ArrayList<>();
        // i from 1 to 4, user to get parameter
        for (int i = 1; i <= 4; i++) {
            String ans_str = String.valueOf(request.getParameter("ans_option_" + i));
            // value of parameter is not null
            if (!ans_str.equalsIgnoreCase("null")) {
                list_ans.add(Integer.parseInt(ans_str));
            }
        }
        QuestionDAO qdao = new QuestionDAO();
        Question q = new Question(qdao.getNewId(), question, option1, option2, option3, option4, list_ans);
        try {
            String x = qdao.insertQuestion(q);
        } catch (Exception ex) {
            response.getWriter().write(ex.getMessage());
        }
        response.sendRedirect("ManageQuiz");
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
