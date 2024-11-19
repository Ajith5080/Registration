package controller;


import java.io.IOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import To.registerTo;
import Util.DBUtil;

public class registrationController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "read";

        try (Connection conn = DBUtil.getConnection()) {
            if ("read".equals(action)) {
                List<registerTo> registrations = new ArrayList<>();
                String query = "SELECT * FROM Registration";
                try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                    while (rs.next()) {
                        registerTo reg = new registerTo();
                        reg.setId(rs.getInt("ID"));
                        reg.setName(rs.getString("Name"));
                        reg.setEmail(rs.getString("Email"));
                        reg.setDateOfBirth(rs.getDate("DateOfBirth").toString());
                        reg.setPhoneNumber(rs.getString("PhoneNumber"));
                        reg.setAddress(rs.getString("Address"));
                        registrations.add(reg);
                    }
                }
                request.setAttribute("registrations", registrations);
                request.getRequestDispatcher("read.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try (Connection conn = DBUtil.getConnection()) {
            if ("create".equals(action)) {
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String dob = request.getParameter("dob");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");

                String query = "INSERT INTO Registration (Name, Email, DateOfBirth, PhoneNumber, Address) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setString(1, name);
                    pstmt.setString(2, email);
                    pstmt.setDate(3, Date.valueOf(dob));
                    pstmt.setString(4, phone);
                    pstmt.setString(5, address);
                    pstmt.executeUpdate();
                }
                response.sendRedirect("index.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
