package ucl.ac.uk.servlets;


import ucl.ac.uk.model.note;
import ucl.ac.uk.model.noteFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/viewnote.html")
public class viewNoteServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String Title = request.getParameter("Title");
        // Get the data from the model
        note Note = noteFactory.viewNote(Title);

        request.setAttribute("Note", Note);

        // Invoke the JSP.
        // A JSP page is actually converted into a Java class, so behind the scenes everything is Java.
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/view.jsp");
        dispatch.forward(request, response);
    }
}
