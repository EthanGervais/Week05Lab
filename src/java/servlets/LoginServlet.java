package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

/**
 *
 * @author Ethan Gervais
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String logoutLink = request.getParameter("logout");
        if (logoutLink != null) {
            request.setAttribute("message", "You have been logged out.");
            session.invalidate();
            session = request.getSession();
        }

        String usernameString = (String) session.getAttribute("username");
        if (usernameString != null) {
            response.sendRedirect("home");
        } else {
            request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String usernameString = request.getParameter("username");
        String passwordString = request.getParameter("password");

        AccountService accountService = new AccountService();
        User user = accountService.login(usernameString, passwordString);

        if (usernameString == null || usernameString.equals("") || passwordString == null || passwordString.equals("")) {
            request.setAttribute("username", usernameString);
            request.setAttribute("password", passwordString);
            request.setAttribute("message", "Please enter both username and password.");

            request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } 
        
        if (user == null) {
            request.setAttribute("username", usernameString);
            request.setAttribute("password", passwordString);
            request.setAttribute("message", "Incorect username or password.");
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else {
            session.setAttribute("username", user.getUsername());
            response.sendRedirect("home");
        }
    }

}
