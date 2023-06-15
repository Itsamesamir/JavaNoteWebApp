<%@ page import="ucl.ac.uk.model.note" %>
<%@ page import="java.util.List" %>
<jsp:include page="header.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search note</title>
    <link rel="stylesheet" type="text/css" href="form.css">
</head>
    <body>
        <div class="main">
            <form name="formUser" method="POST" action="searching.html">

                <h2>Search</h2>

                <div class= "input-container search">

                    <label>Title</label>
                    <input type="text" name="Search" required/>

                </div>
                <button class="submit-button" type="submit" name="Confirm" value="submit">Submit</button>

            </form>
        </div>

        <% String button = request.getParameter("Confirm");
            if (button != null){

            %>

        <div class="main">
              <h2>Search Result</h2>
        <%
            List<note> Notes = (List<note>) request.getAttribute("result");
            if (Notes.size() != 0)
            {
        %>
        <ul>
            <%
                for (note Note : Notes)
                {
                    String href = Note.getTitle();
            %>
            <li><a href="viewnote.html?Title=<%=href%>"><%=href%></a></li>
            <% }
            } else
            {%>
            <p>Nothing found</p>
            <%}%>
        </ul>
        </div>
        <%
                }
        %>
    </body>
</html>
