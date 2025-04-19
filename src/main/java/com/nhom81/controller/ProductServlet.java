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

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO dao = new ProductDAO();
        CategoryDAO cdao = new CategoryDAO();
        List<Product> productList = dao.getAll();
        List<Category> categoryList = cdao.getAll();
        request.setAttribute("products", productList);
        request.setAttribute("categories", categoryList);
        request.getRequestDispatcher("/templates/products.jsp").forward(request, response);
    }
}
