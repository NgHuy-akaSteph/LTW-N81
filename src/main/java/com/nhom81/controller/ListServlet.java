package com.nhom81.controller;

import com.nhom81.dal.ProductDAO;
import com.nhom81.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListServlet", value = "/list")
public class ListServlet extends HttpServlet {

    private static final int PAGE_SIZE = 4;

//    @Override
//    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setCharacterEncoding("UTF-8");
//        //Lấy số trang hiện tại
//        String page_raw = request.getParameter("page");
//        int page;
//        try {
//            page = Integer.parseInt(page_raw);
//        } catch (NumberFormatException e){
//            page = 1;
//        }
//        // Lấy ra số sản phẩm
//        ProductDAO productDAO = new ProductDAO();
//        List<Product> productList = productDAO.getAll();
//        int totalProducts = productList.size(); //Tong so san pham
//        // Tinh toán số trang và start, end của trang hiện tại
//        int totalPages = totalProducts / PAGE_SIZE + (totalProducts % PAGE_SIZE == 0 ? 0 : 1);
//        int start = (page - 1) * PAGE_SIZE;
//        int end;
//        if (page * PAGE_SIZE > totalProducts) {
//            end = totalPages;
//        } else {
//            end = page * PAGE_SIZE;
//        }
//        // Lấy danh sách sản phẩm theo trang
//        List<Product> products = productDAO.getListByPage(productList, start, end);
//        // Gán dữ liệu vào request
//        request.setAttribute("data", products);
//        request.setAttribute("page", page);
//        request.setAttribute("totalPages", totalPages);
//        request.getRequestDispatcher("/templates/page.jsp").forward(request, response);
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Lấy số trang hiện tại và keyword tìm kiếm từ đường dẫn
        String keyword = request.getParameter("search");
        String page_raw = request.getParameter("page");
        int page = 1;
        try {
            page = Integer.parseInt(page_raw);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        if (keyword == null) {
            keyword = "";
        }
        //Lấy ra danh sách sản phẩm tìm kiếm theo keyword
        ProductDAO dao = new ProductDAO();
        List<Product> searchList = dao.searchProductByName(keyword);
        //Phân trang kết quả tìm kiếm
        int totalProducts = searchList.size();
        int totalPages = totalProducts / PAGE_SIZE + (totalProducts % PAGE_SIZE == 0 ? 0 : 1);
        int start = (page - 1) * PAGE_SIZE;
        int end;
        if (page * PAGE_SIZE > totalProducts) {
            end = totalProducts;
        } else {
            end = page * PAGE_SIZE;
        }
        List<Product> pageList = dao.getListByPage(searchList, start, end);
        //Gán lại giá trị cho jsp
        request.setAttribute("data", pageList);
        request.setAttribute("page", page);
        request.setAttribute("keyword", keyword);
        request.setAttribute("totalPages", totalPages);
        request.getRequestDispatcher("/templates/page.jsp").forward(request, response);

    }
}
