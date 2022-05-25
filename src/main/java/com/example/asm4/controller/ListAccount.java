package com.example.asm4.controller;

import com.example.asm4.HelloServlet;
import com.example.asm4.entity.Account;
import com.example.asm4.model.AccoutModel;
import com.example.asm4.model.MySqlAccoutModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListAccount extends HttpServlet {
    private AccoutModel accoutModel;

    @Override
    public void init() throws ServletException {
        accoutModel = new MySqlAccoutModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Account> accounts =  accoutModel.findAll();
        req.setAttribute("accounts", accounts);
        req.getRequestDispatcher("/account/list.jsp").forward(req, resp);
    }
}
