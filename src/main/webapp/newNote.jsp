
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />
<html>
<head>
    <link rel="stylesheet" type="text/css" href="form.css">
</head>
<body>
    <div class="main">
        <form name="formUser" method="POST" action="savenote.html">

            <h2>Create new note</h2>

            <div class= "input-container title">

                <label>Title</label>
                    <input type="text" name="Title" required/>

            </div>

            <div class= "input-container summary">
                <label>Summary</label>
                <textarea id="Summary" name="Summary" rows="10" cols="40">
                </textarea>
            </div>

            <div class= "input-container content">
                <label>Content</label>
                <textarea id="Content" name="Content" rows="10" cols="80">
                </textarea>
            </div>
            <button class="submit-button" type="submit" name="Confirm" value="submit">Submit</button>

        </form>
    </div>
</body>
</html>
