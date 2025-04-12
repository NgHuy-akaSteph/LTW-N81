package com.nhom81.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Show", urlPatterns = {"/show"})
public class Show extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<String> list = new ArrayList<>();
        list.add("Nguyen Van A");
        list.add("Nguyen Van B");
        list.add("Nguyen Van C");
        list.add("Nguyen Van D");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/templates/show.jsp");
        request.setAttribute("list", list);
        dispatcher.forward(request, response);
    }
}
