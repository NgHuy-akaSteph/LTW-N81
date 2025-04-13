package com.nhom81.controller;

import com.nhom81.dal.CategoryDAO;
import com.nhom81.model.Category;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UpdateServlet", urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));
        CategoryDAO categoryDAO = new CategoryDAO();
        Category category = categoryDAO.getCategoryById(id);
        req.setAttribute("category", category);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/templates/formUpdate.jsp");
        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        // category chua thong tin can update
        Category category = new Category(
                Integer.parseInt(req.getParameter("id")),
                req.getParameter("name"),
                req.getParameter("describe"));
        CategoryDAO categoryDAO = new CategoryDAO();
        categoryDAO.update(category);
        res.sendRedirect(req.getContextPath() + "home");

    }
}
