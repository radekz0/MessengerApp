<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<div>
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
                <td><input type="submit" value="Save"/></td>
            </tr>
            </tbody>
        </table>
    </form:form>
    <p>
        <a href="/">Back to home</a>
    </p>
</div>
</body>
</html>