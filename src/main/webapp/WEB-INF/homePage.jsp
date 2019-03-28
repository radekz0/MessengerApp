<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
<style>
    * {
        box-sizing: border-box;
    }

    body {
        font-family: Arial, Helvetica, sans-serif;
    }

    /* Style the header */
    .header {
        padding: 5px;
        text-align: center;
        font-size: 35px;
        background-color: #90ff6b;
    }

    /* Create three equal columns that floats next to each other */
    .column {
        float: left;
        width: 33.33%;
        padding: 5px;
        height: 100px;
    }

    /* Clear floats after the columns */
    .row:after {
        content: "";
        display: table;
        clear: both;
    }

    /* Style the footer */
    .footer {
        background-color: #f1f1f1;
        padding: 5px;
        text-align: center;
    }

    /* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
    @media (max-width: 600px) {
        .column {
            width: 100%;
        }
    }
</style>
</head>
<body>
<div class="header">
    <%--Trying to keep scroll on bottom of the textarea--%>
    <script language="JavaScript">
        var textarea = document.getElementById('myTextarea');
        textarea.scrollTop = textarea.scrollHeight;
    </script>
        <h3 style="color: red"> Messenger App</h3>
    <textarea id="myTextarea" rows="40" cols="66" disabled>
    <c:forEach var="tempMessage" items="${messages}">
    ${tempMessage.message}
    </c:forEach>
    </textarea>

</div>
<div class="row">
    <div class="column" style="background-color: #90ff6b">
    </div>
    <div class="column" style="background-color: #90ff6b">
    <form:form action="sendMessage" modelAttribute="message" method="post">
        <form:hidden path="id"/>
        <table>
            <tbody>
            <tr>
                <td><label></label></td>
                <td><form:input path="message"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Send"/></td>
            </tr>
            </tbody>
        </table>
    </form:form>
    </div>
    <div class="column" style="background-color: #90ff6b">
    </div>

</div>
<div class="footer">
    <c:url var="deleteLink" value="/deleteAll">
    </c:url>
    <a href="${deleteLink}"
       onclick="if(!(confirm('Are you sure you want to delete all messages?'))) return false">Delete all messages</a>
</div>
</body>
</html>