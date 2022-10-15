package com.gpti.bytego.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import com.gpti.bytego.controller.LoginController;
import org.hibernate.annotations.Filter;
import org.json.JSONObject;

@WebServlet(value = "/Login")
public class LoginServlet extends HttpServlet
{
    private final LoginController loginController = new LoginController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        resp.setHeader("Access-Control-Allow-Origin", "*");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        PrintWriter out = resp.getWriter();
        out.println(loginController.login(username, password));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader bufferedReader = req.getReader();

        String jsonData = "";
        String lineRead = bufferedReader.readLine();

        while (lineRead != null)
        {
            jsonData = jsonData.concat(lineRead);
            lineRead = bufferedReader.readLine();
        }

        JSONObject jsonObject = new JSONObject(jsonData);
        System.out.println(jsonObject);
        System.out.println(jsonObject.get("name"));
        System.out.println(jsonObject.get("exam"));

        PrintWriter out = resp.getWriter();
        out.println(jsonObject);
    }
}
