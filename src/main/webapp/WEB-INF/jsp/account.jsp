<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Account information</h1>
    <c:if test="${account == null}">
        <DIV>
            <h3>No results found</h3>
        </DIV>
    </c:if>
    <c:if test="${account != null}">
        <table>
            <tr>
                <td>
                    <p>ID</p>
                </td>
                <td>
                    <p>${account.id}</p>
                </td>
            </tr>
            <tr>
                <td>
                    <p>Account ID</p>
                </td>
                <td>${account.accountID}</td>
            </tr>
            <tr>
                <td>
                    <p>Name</p>
                </td>
                <td>${account.name}</td>
            </tr>
            <tr>
                <td>
                    <p>Icon</p>
                </td>
                <td>${account.profileIconId}</td>
            </tr>
            <tr>
                <td>
                    <p>Revision Date</p>
                </td>
                <td>${account.revisionDate}</td>
            </tr>
            <tr>
                <td>
                    <p>Level</p>
                </td>
                <td>${account.summonerLevel}</td>
            </tr>
        </table>
    </c:if>


</body>
</html>
