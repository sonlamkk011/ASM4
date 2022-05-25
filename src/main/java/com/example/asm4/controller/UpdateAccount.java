package com.example.asm4.controller;


import com.example.asm4.entity.Account;
import com.example.asm4.model.AccoutModel;
import com.example.asm4.model.MySqlAccoutModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateAccount extends HttpServlet {

    private AccoutModel accoutModel;

    @Override
    public void init() throws ServletException {
        accoutModel = new MySqlAccoutModel();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Account account = accoutModel.findById(id);
        req.setAttribute("account", account);
        req.getRequestDispatcher("/account/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; chartset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String fullName = req.getParameter("fullName");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        int status = Integer.parseInt(req.getParameter("status"));
        Account account = new Account(fullName, username, email, password, status);
        if(accoutModel.update(id, account)) {
            resp.sendRedirect("/accounts");
        }
    }
}
