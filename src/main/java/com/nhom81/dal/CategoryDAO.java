package com.nhom81.dal;

import com.nhom81.model.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class CategoryDAO extends DBContext{

    //Get all categories
    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        String query = "SELECT * FROM Categories";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category c = new Category(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("describe")
                );
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Category idExisted(int id) {
        String query = "SELECT * FROM Categories WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Category(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("describe")
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    //Insert a new category
    public Category insert(Category c) {
        String query = "INSERT INTO Categories(id, name, describe) VALUES(?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, String.valueOf(c.getId()));
            ps.setString(2, c.getName());
            ps.setString(3, c.getDescribe());
            ps.executeUpdate();
            return c;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
