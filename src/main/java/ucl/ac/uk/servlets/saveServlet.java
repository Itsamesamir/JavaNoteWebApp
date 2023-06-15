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

@WebServlet("/savenote.html")
public class saveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String old = request.getParameter("OldTitle");
        String Title = request.getParameter("Title");
        String Summary = request.getParameter("Summary");
        String Content = request.getParameter("Content");

            if (old != null) {
                note oldNote = noteFactory.viewNote(old);
                oldNote.deleteNote();
            }
        note note = noteFactory.getNote(Title,Summary,Content);
        note.newNote();
        request.setAttribute("note", note);

        // Invoke the JSP page.

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/index.jsp");
        dispatch.forward(request, response);
    }
}
