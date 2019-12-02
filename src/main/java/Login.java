import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "login",
        urlPatterns = {"/login"},
        loadOnStartup = 1)
public class Login extends HttpServlet {

    public Login() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().setAttribute("userName", "alin");

        Enumeration e = (Enumeration) (request.getSession().getAttributeNames());

        while ( e.hasMoreElements())
        {
            Object tring;
            if((tring = e.nextElement())!=null)
            {
                System.out.println("Element"+ tring.toString());
            }
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.isEmpty() || password.isEmpty() )
        {
            RequestDispatcher req = request.getRequestDispatcher("login.jsp");
            req.include(request, response);
        }
        else
        {
            if(request.getSession().getAttribute("userName").equals(username))
            {
                RequestDispatcher req = request.getRequestDispatcher("success.jsp");
                request.getSession().setAttribute("userName2", username);
                req.include(request, response);
            }
            else{
                RequestDispatcher req = request.getRequestDispatcher("login.jsp");
                req.forward(request, response);
            }
        }
    }
}