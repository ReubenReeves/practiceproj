<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title></title>
    <script type="text/javascript">
        <!-- TODO redo this -->
        function validateNameForm() {
            var searchVal = document.forms["accountForm"]["accountName"].value;
            if(searchVal == null || searchVal == "") {
                return false;
            }
            return true;
        }

        function validatIdForm() {
            var searchVal = document.forms["accountIdForm"]["accounId"].value;
            if(searchVal == null || searchVal == "") {
                return false;
            }
            return true;
        }
        function validatIdForm() {
            var searchVal = document.forms["matchIdForm"]["matchAccountId"].value;
            if(searchVal == null || searchVal == "") {
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <h1>League info page</h1>

    <div>
        <h2>find account by Name</h2>
        <form action="/getAccountByName" onsubmit="return validateNameForm()" method="get" id="accountNameForm" name="accountNameForm">
            <input name="accountName" id="accountName"/>
        </form>
        <div>
            <button type="submit" form="accountNameForm">Search</button>
        </div>
    </div>

    <div>
        <h2>find account by ID</h2>
        <form action="/getAccountById" onsubmit="return validatIdForm()" method="get" id="accountIdForm" name="accountIdForm">
            <input name="accountId" id="accountId"/>
        </form>
        <div>
            <button type="submit" form="accountIdForm">Search</button>
        </div>
    </div>

    <div>
        <h2>find matches by account ID</h2>
        <form action="getMatches" method="get" id="matchIdForm" name="matchForm">
            <input name="accountId" id="matchAccountId" />
        </form>
        <div>
            <button type="submit" form="matchIdForm">Search</button>
        </div>
    </div>
</body>

</html>