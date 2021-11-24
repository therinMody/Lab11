package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AccountService;

public class ResetPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("uuid") != null) {
            //request.setAttribute("action", request.getParameter("action"));
            request.setAttribute("uuidTag", request.getParameter("uuid"));
            request.setAttribute("uuidHolder", request.getParameter("uuid"));
            getServletContext().getRequestDispatcher("/WEB-INF/resetNewPassword.jsp").forward(request, response);
            return;
        }

        getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
        return;

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        System.out.println(action);

        AccountService as = new AccountService();

        if (action.equals("email")) {
            //for forgot password link
            String url = request.getRequestURL().toString();
            String email = request.getParameter("confirmEmail");
            String path = getServletContext().getRealPath("/WEB-INF");

            
            try {
                as.resetPassword(email, path, url);
            } catch (Exception ex) {
                Logger.getLogger(ResetPasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            getServletContext().getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
            return;
            
            
        } else if (action.equals("new")) {
            String uuid = request.getParameter("uuid");
            String password = request.getParameter("newPassword");
            System.out.println(uuid);
            System.out.println(password);

            boolean flag = as.changePassword(uuid, password);
            
            if (flag) {
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            }
            
        }


    }

}
