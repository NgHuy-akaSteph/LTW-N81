package com.nhom81.dal;

import com.nhom81.model.Category;
import com.nhom81.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends DBContext{

    //Lấy toàn bộ sản phẩm từ db
    public List<Product> getAll() {
        String query = "select p.id, p.name, p.price, p.quantity, p.releaseDate, p.describe, p.image, p.cid cid, c.name cname " +
                "from products p inner join Categories c on p.cid = c.id";
        List<Product> products = new ArrayList<Product>();
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category(rs.getInt("cid"), rs.getString("cname"));
                Product product = new Product(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getDate("releaseDate"),
                        rs.getString("describe"),
                        rs.getString("image"),
                        category
                );
                products.add(product);
            }
            return products;
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }


    // Tim kiem san pham theo ten
    public List<Product> searchProductByName(String keyword) {
        String query = "select p.id, p.name, p.price, p.quantity, p.releaseDate," +
                "p.describe, p.image, p.cid cid, c.name cname " +
                "from Products p inner join Categories c on p.cid = c.id where p.name LIKE ?";
        List<Product> res = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category(rs.getInt("cid"), rs.getString("name"));
                Product product = new Product(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getDate("releaseDate"),
                        rs.getString("describe"),
                        rs.getString("image"),
                        category
                );
                res.add(product);
            }
            return res;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public Product getById(String id) {
        //Alias : đặt bí danh
        String query = "select p.id, p.name, p.price, p.quantity, p.releaseDate," +
                "p.describe, p.image, p.cid cid, c.name cname " +
                "from Products p inner join Categories c on p.cid = c.id where id = ?";
        Product product = null;
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Category category = new Category(rs.getInt("cid"), rs.getString("cname"));
                product = new Product(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getDate("releaseDate"),
                        rs.getString("describe"),
                        rs.getString("image"),
                        category
                );
                return product;
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    //Phan trang san pham dua vao List san pham co san
    public List<Product> getListByPage(List<Product> products, int start, int end){
        List<Product> list = new ArrayList<>();
        for(int i = start; i < end; i++){
            list.add(products.get(i)); // a[i] -> a.get(i)
         }
        return list;
    }

    // Lay danh sach san pham theo category
    public List<Product> getListByCategory(int cateId){
        List<Product> list = new ArrayList<>();
        String query = "select p.id, p.name, p.price, p.quantity, p.releaseDate," +
                "p.describe, p.image, p.cid cid, c.name cname " +
                "from Products p inner join Categories c on p.cid = c.id where p.cid = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, cateId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category(rs.getInt("cid"), rs.getString("name"));
                Product product = new Product(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getDate("releaseDate"),
                        rs.getString("describe"),
                        rs.getString("image"),
                        category
                );
                list.add(product);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

//    public Product insert(Product product) {
//        String sql = "INSERT INTO Products (id, name, quantity, price, releaseDate, describe, image, cid) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, product.getId());
//            ps.setString(2, product.getName());
//            ps.setDouble(3, product.getQuantity());
//            ps.setDouble(4, product.getPrice());
//            ps.setDate(5, product.getReleaseDate());
//            ps.setString(6, product.getDescribe());
//            ps.setString(7, product.getImage());
//            ps.setInt(8, product.getCid());
//            ps.executeUpdate();
//            return product;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }
//
//    public Product update(Product product) {
//        String sql = "UPDATE Products SET(id, name, quantity, price, releaseDate, describe, image, cid) WHERE id = ? ";
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//
//        } catch (SQLException e){
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }

    public void delete(int id) {
        String sql = "DELETE FROM Products WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
