<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<div>
    <%--Trying to keep scroll on bottom of the textarea--%>
    <script language="JavaScript">
        var textarea = document.getElementById('myTextarea');
        textarea.scrollTop = textarea.scrollHeight;
    </script>

    <textarea id="myTextarea" rows="10" cols="50" disabled style="background-color: aliceblue">
    <c:forEach var="tempMessage" items="${messages}">
    ${tempMessage.message}
    </c:forEach>
    </textarea>

</div>
<div>
    <form:form action="sendMessage" modelAttribute="message" method="post">
        <form:hidden path="id"/>
        <table>
            <tbody>
            <c:url var="deleteLink" value="/deleteAll">
            </c:url>
            <tr>
                <td><label></label></td>
                <td><form:input path="message"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Send"/></td>
            </tr>
            <td>
                <a href="${deleteLink}"
                   onclick="if(!(confirm('Are you sure you want to delete all messages?'))) return false">Delete</a>
            </td>
            </tbody>
        </table>
    </form:form>
</div>
</body>
</html>