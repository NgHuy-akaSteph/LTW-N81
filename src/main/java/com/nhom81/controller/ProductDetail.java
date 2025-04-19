package com.nhom81.controller;

import com.nhom81.dal.CategoryDAO;
import com.nhom81.dal.ProductDAO;
import com.nhom81.model.Category;
import com.nhom81.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name="ProductDetail", urlPatterns = "/detail")
public class ProductDetail extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ProductDAO dao = new ProductDAO();
        CategoryDAO cdao = new CategoryDAO();
        List<Category> categories = cdao.getAll();
        Product p = dao.getById(id);
        if (p != null) {
            request.setAttribute("product", p);
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("/templates/detail.jsp").forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + "/products");
        }
    }
}
