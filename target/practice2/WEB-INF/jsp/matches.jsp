<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Match History</h1>
    <c:if test="${matchList == null}">
        <DIV>
            <h3>No results found</h3>
        </DIV>
    </c:if>
    <c:if test="${matchList != null}">
        <table>
            <tr>
                <th>Platform Id</th>
                <th>Account Id</th>
                <th>Game ID </th>
                <th>Champion</th>
                <th>Queue</th>
                <th>Season</th>
                <th>Time played</th>
                <th>Role</th>
                <th>Lane</th>
            </tr>
            <c:forEach var="match" items="${matchList}">
                <tr>
                    <td>${match.platformID}</td>
                    <td>${match.accountID}</td>
                    <td>${match.gameID}</td>
                    <td>${match.champion}</td>
                    <td>${match.queue}</td>
                    <td>${match.season}</td>
                    <td>${match.timePlayed}</td>
                    <td>${match.role}</td>
                    <td>${match.lane}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>




</body>
</html>
