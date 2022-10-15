package com.gpti.bytego.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.gpti.bytego.controller.LoginController;
import com.gpti.bytego.utilities.JSONReader;
import org.json.JSONObject;

@WebServlet(value = "/Login")
public class LoginServlet extends HttpServlet
{
    private final LoginController loginController = new LoginController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        JSONObject jsonObject = JSONReader.readJsonReceived(req);

        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");

        PrintWriter out = resp.getWriter();
        out.println(loginController.login(username, password));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        JSONObject jsonObject = JSONReader.readJsonReceived(req);

        PrintWriter out = resp.getWriter();
        out.println(jsonObject);
    }
}
