<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Event Listing</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>Event Listing</h2>
    <!-- Display the list of upcoming events -->
    <ul>
        <c:forEach var="event" items="${events}">
            <li>${event.eventName} - ${event.eventDate}</li>
        </c:forEach>
    </ul>
</body>
</html>
