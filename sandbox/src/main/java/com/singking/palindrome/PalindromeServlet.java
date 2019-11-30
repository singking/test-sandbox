package com.singking.palindrome;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class PalindromeServlet
 */
public class PalindromeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Palindrome palindrome = new Palindrome();
	private List <ScoreSheet> scoresheet = new ArrayList<ScoreSheet>();
	
	/**
	 * Default constructor.
	 */
	public PalindromeServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		// Use "request" to read incoming HTTP headers

		
		// (e.g., cookies) and query data from HTML forms.
		String ps = request.getParameter("com/singking/palindrome");
		
		String user = CookieUtilities.getCookieValue(request, "user", null);
		if (user!=null){
			user = request.getParameter("user");
			Cookie c = new Cookie("user", user);
			c.setMaxAge(60*60*24*7); // One week
			response.addCookie(c);
		}

		// Use "response" to specify the HTTP response status
		// code and headers (e.g., the content type, cookies).
		
		int score = palindrome.scorePalindrome(ps);
		scoresheet.add(new ScoreSheet(user, ps, score));

		getServletContext().setAttribute("scores", scoresheet);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Palindrome.jsp");  
		 
		dispatcher.forward(request, response);
		for(ScoreSheet s: scoresheet ){
			PrintWriter out = response.getWriter();
			out.println(
			s.getUser()+" "+
			s.getDate()+" "+
			s.getPalindrome()+" "+
			s.getScore());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("goodbye!");
	}

}
