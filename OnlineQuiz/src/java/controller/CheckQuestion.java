/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class CheckQuestion extends HttpServlet {

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
            out.println("<title>Servlet CheckQuestion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckQuestion at " + request.getContextPath() + "</h1>");
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
    purpose :get information from jsp to check the answer and calculate mark
    author: quanndhe130577
    time : 26/02/2020
    */
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int number_of_question = Integer.parseInt(String.valueOf(request.getSession().getAttribute("number_of_question")));

        ArrayList<Integer> list_ans = new ArrayList<>();
        // i count from 1 to 4, use to get parameter
        for (int i = 1; i <= 4; i++) { 
            String ans_str = String.valueOf(request.getParameter("option" + i));
            // value of parameter is not null
            if (!ans_str.equalsIgnoreCase("null")) { 
                list_ans.add(Integer.parseInt(ans_str));
            }
        }
        ArrayList<Question> list_question = ArrayList.class.cast(request.getSession().getAttribute("list_question"));
        // compare two arraylist
        if (list_ans.equals(list_question.get(0).getAnswer())) {
            String rs = String.valueOf(request.getSession().getAttribute("rs"));
            if (rs.equals("null") || rs.equals("")) {
                // mark for one right answer
                double result = (double) 1 / number_of_question; 
                request.getSession().setAttribute("rs", result);
            } else {
                 // total mark 
                double result = Double.parseDouble(rs) + (double) 1 / number_of_question;
                request.getSession().setAttribute("rs", result);
            }
        } else {
            response.getWriter().write("Error : loading answer");
        }
        list_question.remove(0);
        request.getSession().setAttribute("list_question", list_question);
        if (list_question.size() == 0) {
            response.sendRedirect("Result.jsp");
//            
        } else {
            response.sendRedirect("TakeQuiz-DoQuestion.jsp");
//            
        }
//    
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
