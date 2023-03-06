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
                .forward(request, response);
    }

    //grab what user typed in from their text boxed based upon the parameters of first & lastname 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Edit the servlet to obtain the form parameters from the form submission
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");

        //set attribute that will be forwarded to the JSP so those are not availabel within our JSP
        //it needs access to those variables to be able to insert them into the form
        request.setAttribute("firstname", firstname);
        request.setAttribute("lastname", lastname);

        //ADD VALIDATION LAST STEP
        //check null(firstname does not exist like someone hacked the form) first and then empty strings if you reverse, 
        //you could end up with a null pointer exception because we want to make sure that first name is not null
        if (firstname == null || firstname.equals("") || lastname == null || lastname.equals("")) {

            //send them back to the other JSP 
            getServletContext().getRequestDispatcher("/WEB-INF/helloWorldForm.jsp")
                    .forward(request, response);

            //stop execution, do not read the rest
            return;
        }

        //Use the dispatcher to forward the JSP
        getServletContext().getRequestDispatcher("/WEB-INF/sayHello.jsp")
                .forward(request, response);

    }

}
