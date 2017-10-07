package com.nazar.controller.servlet;

import com.nazar.controller.FrontController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FrontServlet", urlPatterns = {"/servlet/*"})
public class FrontServlet extends HttpServlet {
    private FrontController context = FrontController.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        context.process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        context.process(request, response);
    }
}
