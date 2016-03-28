<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
<%@ page import="palindrome.ScoreSheet" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Palindrome title</title>
</head>
<body>
<CENTER>
<H1>Palindrome Words &amp; Phrases</H1>
</CENTER>

<FORM ACTION="http://localhost:8080/Playfish_Palindrome/PalindromeServlet">
Palindrome: 
<INPUT TYPE="TEXT" NAME="palindrome" VALUE="">
<BR>
User:
<INPUT TYPE="TEXT" NAME="user" VALUE="">
<BR><BR>
<INPUT TYPE="SUBMIT"> <!-- Press this button to submit form -->
</FORM>


<%

List <ScoreSheet> scoresheet = (List<ScoreSheet>) application.getAttribute("scores");
if(scoresheet!=null){
	for(ScoreSheet s: scoresheet ){
		out.println(
			s.getUser()+" "+
			s.getDate()+" "+
			s.getPalindrome()+" "+
			s.getScore()+"<br>");
	}
}

%>
</body>
</html>