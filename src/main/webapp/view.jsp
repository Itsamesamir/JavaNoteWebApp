<%@ page import="ucl.ac.uk.model.note" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />

<html>
<head>
    <title>View Note</title>
    <link rel="stylesheet" type="text/css" href="form.css">
</head>
<body>
<%
    note Note1 = (note) request.getAttribute("Note");
    String title = Note1.getTitle();
    String summary = Note1.getSummary();
    String content = Note1.getContent();

%>
<div class="main">
    <form name="formUser" method="POST" action="edit.html">

        <h2>Note</h2>

        <div class= "input-container title">

            <label>Title</label>
            <input type="text" name="Title" value = "<%=title%>" readonly/>

        </div>

        <div class= "input-container summary">
            <label>Summary</label>
            <textarea id="Summary" name="Summary"><%=summary%></textarea>

        </div>

        <div class= "input-container content">
            <label>Content</label>
            <textarea id="Content" name="Content" rows="10" cols="40" ><%=content%></textarea>
        </div>
        <button class="submit-button" type="submit" name="Edit" value="submit">Edit</button>

    </form>
</div>
<div class="main">
<form name ="formUser" action="/delete.html" method="post">
    <input type="hidden" name="Title" value="<%=title%>">
    <button class="submit-button" type="submit">Delete</button>
</form>
</div>
</body>
</html>
