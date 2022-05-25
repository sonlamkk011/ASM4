package com.example.asm4.controller;

import com.example.asm4.entity.Account;
import com.example.asm4.model.MySqlAccoutModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateAccount extends HttpServlet {
    private MySqlAccoutModel mySqlAccoutModel;

    @Override
    public void init() throws ServletException {
        mySqlAccoutModel = new MySqlAccoutModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Account/register.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullname = req.getParameter("fullName");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Integer status = Integer.parseInt(req.getParameter("status"));
        Account account = new Account(fullname, username, email, password, status);
        mySqlAccoutModel.save(account);
        resp.sendRedirect("/");



    }
}
