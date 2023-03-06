package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lynnh
 */
public class HelloWorldServelet extends HttpServlet {


    @Override
    //take this and display this .jsp
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            getServletContext().getRequestDispatcher("/WEB-INF/helloWorldForm.jsp")
                    .forward(request,response);
    }
    
    //grab what user typed in from their text boxed based upon the parameters of first & lastname 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Edit the servlet to obtain the form parameters from the form submission
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        
        //set attribute that will be forwarded to the JSP so those are not availabel within our JSP
        request.setAttribute("firstname", firstname);
        request.setAttribute("lastname", lastname);
        
        //Use the dispatcher to forward the JSP
        getServletContext().getRequestDispatcher("/WEB-INF/sayHello.jsp")
                .forward(request,response);
       
    }

}
