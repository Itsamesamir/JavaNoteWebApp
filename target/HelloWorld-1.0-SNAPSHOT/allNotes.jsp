<%@ page import="ucl.ac.uk.model.note" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />
<html>
<head>
    <title>view all notes</title>
    <link rel="stylesheet" type="text/css" href="form.css">
</head>
<style>.links{

}</style>
<body>

<div class="main">
    <form name="formUser" method="POST" action="sorting.html">

        <h2>Search</h2>

        <div class= "input-container sort">

            <label>Option</label>
            <select name = "option">
                 <option value = 1>Alphabetical</option>
                <option value = 2 >Oldest->Newest</option>

            </select>
        </div>
        <button class="submit-button" type="submit" name="Confirm" value="submit">Submit</button>

    </form>
</div>

<% String button = request.getParameter("Confirm");
    if (button == null){
        List<note> notes = (List<note>) request.getAttribute("notes");
        for (note Note : notes)
        {
            String href = Note.getTitle();
            %>
            <li><a href="viewnote.html?Title=<%=href%>"><%=href%></a>
            </li>
     <% }
    }
    else{
         List<String>  notes = (List<String>) request.getAttribute("results");
         for (String title: notes){
             String href = title;
             %>

          <li><a href="viewnote.html?Title=<%=href%>"><%=href%></a>
        </li>
        <% }
        }

        %>



</body>
</html>
