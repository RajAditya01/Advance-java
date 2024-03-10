package com.mmengineering.servlet;

import com.mmengineering.dao.ResultDAO;
import com.mmengineering.model.Result;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/publishResult")
public class ResultsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int eventId = Integer.parseInt(request.getParameter("eventId"));
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        int marks = Integer.parseInt(request.getParameter("marks"));

        Result result = new Result();
        result.setEventId(eventId);
        result.setStudentId(studentId);
        result.setMarks(marks);

        ResultDAO resultDAO = new ResultDAO();
        if (resultDAO.publishResult(result)) {
            response.sendRedirect("resultPublished.jsp");
        } else {
            response.sendRedirect("resultPublishError.jsp");
        }
    }
}
