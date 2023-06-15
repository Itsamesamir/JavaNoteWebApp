<%@ page import="ucl.ac.uk.model.note" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />
<html>
<head>
    <link rel="stylesheet" type="text/css" href="form.css">
</head>
<body>
<%
    note Note = (note) request.getAttribute("name");
    String title = Note.getTitle();
    String content = Note.getContent();
    String summary = Note.getSummary();
%>
<div class="main">
    <form name="formUser" method="POST" action="savenote.html">

        <h2>Edit note: <%=title%></h2>
        <input type="hidden" name="OldTitle"value = "<%=title%>">
        <div class= "input-container title">

            <label>Title</label>
            <input type="text" name="Title" placeholder = "<%=title%>" required>

        </div>

        <div class= "input-container summary">
            <label>Summary</label>
            <textarea id="Summary" name="Summary" rows="10" cols="40"><%=summary%>
                </textarea>
        </div>

        <div class= "input-container content">
            <label>Content</label>
            <textarea id="Content" name="Content" rows="10" cols="80"><%=content%>
                </textarea>
        </div>
        <button class="submit-button" type="submit" name="Confirm" value="submit">Submit</button>

    </form>
</div>
</body>
</html>
