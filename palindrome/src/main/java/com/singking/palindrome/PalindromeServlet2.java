package com.singking.palindrome;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Servlet implementation class PalindromeServlet
 */
public class PalindromeServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Palindrome palindrome = new Palindrome();

    private List<ScoreSheet> scoresheet = new ArrayList<ScoreSheet>();

    public PalindromeServlet2() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        // Use "request" to read incoming HTTP headers
        String ps = request.getParameter("src/main/java/palindrome");
        String user = request.getParameter("user");

        // (e.g., cookies) and query data from HTML forms.
        // Use "response" to specify the HTTP response status
        // code and headers (e.g., the content type, cookies).
        PrintWriter out = response.getWriter();
        int score = palindrome.scorePalindrome(ps);

        Date date = new Date();
        String ss = user + " " + date + " " + score + " " + ps;
        scoresheet.add(new ScoreSheet(user, ps, score));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Palindrome.jsp");

        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {


        PrintWriter out = response.getWriter();
        out.print("goodbye!");
    }
}
