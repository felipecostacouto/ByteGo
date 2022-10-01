package com.gpti.bytego.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.gpti.bytego.controller.LoginController;
import com.gpti.bytego.controller.LoginInterface;

@WebServlet(value = "/Login")
public class LoginServlet extends HttpServlet
{
    private final LoginInterface loginController = new LoginController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        PrintWriter out = resp.getWriter();
        out.println(loginController.login(username, password));
    }
}
