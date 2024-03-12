<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSTL Core Tags Page</title>
</head>
<body>
    <!-- Using SQL Tags -->
    <sql:setDataSource var="ds" driver="oracle.jdbc.driver.OracleDriver"
        url="jdbc:oracle:thin:@localhost:1521:XE"
        user="sys as sysdba" password="1234"/>

    <sql:query dataSource="${ds}" var="rset">
        SELECT * FROM employee
    </sql:query>

    <h2>Employee Table:</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Salary</th>
        </tr>
        <c:forEach var="row" items="${rset.rows}">
            <tr>
                <td><c:out value="${row.ID}"/></td>
                <td><c:out value="${row.NAME}"/></td>
                <td><c:out value="${row.SALARY}"/></td>
            </tr>

            <!-- Using If statement in JSP -->
            <c:if test="${row.SALARY eq 2000}">
                <tr>
                    <td colspan="3"><h2>Yes SALARY is 2000 and Condition is True!!!</h2></td>
                </tr>
            </c:if>

            <!-- Alternative to Switch in JSP -->
            <c:choose>
                <c:when test="${row.SALARY le 2000}">
                    <tr>
                        <td colspan="3"><h2>SALARY is not good.</h2></td>
                    </tr>
                </c:when>
                <c:when test="${row.SALARY > 2000}">
                    <tr>
                        <td colspan="3"><h2>SALARY is good.</h2></td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="3"><h2>SALARY is undetermined...</h2></td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </table>

    <!-- Using For-Each loop -->
    <c:forEach var="i" begin="1" end="5">
        <h2>Hello & Welcome to JSTL Page!!!</h2>
    </c:forEach>
</body>
</html>
