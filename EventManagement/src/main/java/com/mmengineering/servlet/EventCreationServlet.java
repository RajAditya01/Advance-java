package com.mmengineering.servlet;

import com.mmengineering.dao.EventDAO;
import com.mmengineering.model.Event;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;
@WebServlet("/createEvent")
public class EventCreationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eventName = request.getParameter("eventName");
        // You can parse the date parameter here if needed

        Event event = new Event();
        event.setEventName(eventName);
        // Set other event properties as needed

        EventDAO eventDAO = new EventDAO();
        if (eventDAO.addEvent(event)) {
            response.sendRedirect("eventCreationSuccess.jsp");
        } else {
            response.sendRedirect("eventCreationError.jsp");
        }
    }
}
