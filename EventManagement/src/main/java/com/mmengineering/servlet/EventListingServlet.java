package com.mmengineering.servlet;

import com.mmengineering.dao.EventDAO;
import com.mmengineering.model.Event;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.List;

@WebServlet("/eventListing")
public class EventListingServlet extends HttpServlet {
    protected void doGet(HttpRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventDAO eventDAO = new EventDAO();
        List<Event> events = eventDAO.getAllEvents();

        request.setAttribute("events", events);
        request.getRequestDispatcher("eventListing.jsp").forward(request, response);
    }
}
