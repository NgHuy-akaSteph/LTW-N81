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

@WebServlet(name = "AddServlet", urlPatterns = {"/add"})
public class AddServlet extends HttpServlet {
    // /category/add
    // /category/update?id=1

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        // Handle GET request
        // You can add your logic here
        RequestDispatcher rd = req.getRequestDispatcher("/templates/addForm.jsp");
        rd.forward(req, res);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String describe = req.getParameter("describe");
        Category newCategory = new Category(id, name, describe);
        // Check if the ID already exists
        CategoryDAO categoryDAO = new CategoryDAO();
        if(categoryDAO.idExisted(id) != null) {
            // ID already exists, set an error message and forward to the add form
            req.setAttribute("error", "ID " + id + " already exists");
            RequestDispatcher rd = req.getRequestDispatcher("/templates/addForm.jsp");
            rd.forward(req, res);
        } else {
            // Insert the new category
            categoryDAO.insert(newCategory);
            // Redirect to the home page or another page after successful insertion
            res.sendRedirect(req.getContextPath() + "/home");
        }
    }
}
