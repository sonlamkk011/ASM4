package com.example.asm4.controller;

import com.example.asm4.model.AccoutModel;
import com.example.asm4.model.MySqlAccoutModel;

import javax.imageio.IIOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteAccount extends HttpServlet {

    private AccoutModel accountModel;

    @Override
    public void init() throws ServletException {
        accountModel = new MySqlAccoutModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        if (accountModel.delete(id)); {
            resp.sendRedirect("/accounts");
        }
    }
}
