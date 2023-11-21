package com.example.avpl1;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private Map<String, String> usersDb;
    private static final String SUPER_USER = "SuperUser";

    @Override
    public void init() throws ServletException {
        usersDb = new HashMap<>();
        usersDb.put("user1", "password1");
        usersDb.put("user2", "password2");
        usersDb.put(SUPER_USER, "SuperUserPassword");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (usersDb.containsKey(username) && usersDb.get(username).equals(password)) {
            if (SUPER_USER.equals(username)) {
                resp.sendRedirect("superUserPage.html");
            } else {
                resp.sendRedirect("timePage.html");
            }
        } else {
            resp.sendRedirect("index.html");
        }
    }
}
