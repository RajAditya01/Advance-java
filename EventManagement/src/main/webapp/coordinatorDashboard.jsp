<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Coordinator Dashboard</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>Coordinator Dashboard</h2>
    <!-- Display coordinator-specific data, like created events, etc. -->
    <ul>
        <c:forEach var="event" items="${coordinatorEvents}">
            <li>${event.eventName} - ${event.eventDate}</li>
        </c:forEach>
    </ul>
</body>
</html>
