<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin Login</title>
</head>
<body>
<style type="text/css">
    body {
        font-family: SansSerif;
        font-size: small;
    }
</style>
<div>
    <div style="float: left;">
        <p>
            &nbsp;|&nbsp;
            <a href="<c:url value='/home'/>">Home</a>
            &nbsp;|&nbsp;
            <a href="<c:url value='/member/home'/>">Member Area</a>
            &nbsp;|&nbsp;
            <a href="<c:url value='/admin/home'/>">Admin Area</a>
        </p>
    </div>
    <div style="float: right;">
        <c:choose>
            <c:when test="${not empty requestScope.username}">
                <p>
                    Logged in as <strong> ${requestScope.username} </strong>
                    &nbsp;|&nbsp;
                    <a href="<c:url value='/logout'/>">Logout</a>
                </p>
            </c:when>
            <c:otherwise>
                <p>
                    Not Logged in.
                </p>
            </c:otherwise>
        </c:choose>
    </div>

</div>
<div style="clear: both;"/>
<hr/>
<h3>Admin Login</h3>

<form id="logInForm" method="POST" action="/login">

    <fieldset>
        <label>
            <span>
                <input type="text" id="username" name="username"/>
            </span>
        </label>

        <label>
            <span>
                <input type="password"  name="password" id="password"/>
            </span>
        </label>

        <div>
            <button>
                Login
            </button>
        </div>
    </fieldset>

</form>


</body>
</html>