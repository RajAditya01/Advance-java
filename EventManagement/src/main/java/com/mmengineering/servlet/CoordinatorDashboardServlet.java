package com.mmengineering.servlet;

import com.mmengineering.dao.EventDAO;
import com.mmengineering.model.Event;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/coordinatorDashboard")
public class CoordinatorDashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve coordinator ID from the session or other means
        int coordinatorId = 1; // Replace with the actual logic to get coordinator ID

        // Fetch events created by the coordinator
        EventDAO eventDAO = new EventDAO();
        List<Event> coordinatorEvents = eventDAO.getEventsByCoordinatorId(coordinatorId);

        // Set the events attribute to be used in the JSP
        request.setAttribute("coordinatorEvents", coordinatorEvents);

        // Forward to the coordinatorDashboard.jsp
        request.getRequestDispatcher("coordinatorDashboard.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve coordinator ID from the session or other means
        int coordinatorId = 1; // Replace with the actual logic to get coordinator ID

        // Handle event creation form submission
        String eventName = request.getParameter("eventName");
        // You may want to add validation for the date parameter
        String eventDateStr = request.getParameter("eventDate");

        // Convert the date string to a java.sql.Date object
        java.sql.Date eventDate = java.sql.Date.valueOf(eventDateStr);

        // Create an Event object
        Event event = new Event();
        event.setEventName(eventName);
        event.setEventDate(eventDate);

        // Set the coordinator ID for the event
        event.setCoordinatorId(coordinatorId);

        // Insert the event into the database
        EventDAO eventDAO = new EventDAO();
        eventDAO.addEvent(event);

        // Redirect back to the coordinator dashboard
        response.sendRedirect(request.getContextPath() + "/coordinatorDashboard");
    }
}
