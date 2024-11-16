package tyit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GradeServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		 int sub1 = Integer.parseInt(request.getParameter("sub1"));
		 int sub2 = Integer.parseInt(request.getParameter("sub2"));
		 int sub3 = Integer.parseInt(request.getParameter("sub3"));
		 int sub4 = Integer.parseInt(request.getParameter("sub4"));
		 int sub5 = Integer.parseInt(request.getParameter("sub5"));
		
		int totalMarks = sub1 + sub2 + sub3 + sub4 + sub5;
		float percentage = (totalMarks /500.0f)*100;
		
		PrintWriter out = response.getWriter(); 
		out.write("<h1> Total marks is  : "+ totalMarks +"/500"+ "<h1>");
		out.write("<h1> Total marks percentage is  : "+ percentage +"%"+ "<h1>");
		
		if (totalMarks >= 450 && totalMarks <= 500) {
		    out.write("<h1> Your grade is A </h1>");
		} else if (totalMarks >= 400 && totalMarks < 450) {
		    out.write("<h1> Your grade is B+ </h1>");
		} else if (totalMarks >= 350 && totalMarks < 400) {
		    out.write("<h1> Your grade is B </h1>");
		} else if (totalMarks >= 300 && totalMarks < 350) {
		    out.write("<h1> Your grade is C </h1>");
		} else if (totalMarks >= 250 && totalMarks < 300) {
		    out.write("<h1> Your grade is D </h1>");
		} else {
		    out.write("<h1> Your grade is F </h1>"); 
		}

		out.close();
		
	}

}
