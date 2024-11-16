package tyit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/GuessServlet")
public class GuessServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer randomNumber = (Integer) session.getAttribute("randomNumber");
        Integer attempts = (Integer) session.getAttribute("attempts");
        Integer score = (Integer) session.getAttribute("score");

        if (randomNumber == null) {
            randomNumber = (int) (Math.random() * 100) + 1;
            attempts = 0;
            score = 0;
            session.setAttribute("randomNumber", randomNumber);
        }

        int userGuess = Integer.parseInt(request.getParameter("guess"));
        attempts++;
        String resultMessage;

        if (userGuess < randomNumber) {
            resultMessage = "Too low! Try again.";
        } else if (userGuess > randomNumber) {
            resultMessage = "Too high! Try again.";
        } else {
            resultMessage = "Correct! The number was " + randomNumber + ".";
            score++;
            session.invalidate(); // Reset game
        }

        session.setAttribute("attempts", attempts);
        session.setAttribute("score", score);
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>" + resultMessage + "</h1>");
        response.getWriter().println("<p>Attempts: " + attempts + "</p>");
        response.getWriter().println("<p>Score: " + score + "</p>");
        response.getWriter().println("<a href='index.html'>Play Again</a>");
        response.getWriter().println("</body></html>");
    }
}