package com.tests.jsplogin.controller;

import com.tests.jspmodel.Dao.UsersDao;
import com.tests.jsplogin.model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rohit
 */
public class UsersController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String uid = request.getParameter("uid");
        String password = request.getParameter("password");
        Users u = new Users();
        UsersDao ud = new UsersDao();
        u = ud.getUser(uid);
        if (u.getUname() == null) {
            RequestDispatcher rd = request.getRequestDispatcher("errorpg.jsp");
            rd.forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", u);
            RequestDispatcher rd = request.getRequestDispatcher("welcomepg.jsp");
            rd.forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        Users u = new Users();
        u.setUname(request.getParameter("uname"));
        u.setEmail(request.getParameter("email"));
        u.setPassword(request.getParameter("password"));

        UsersDao ud = new UsersDao();
        u = ud.addUser(u);
        HttpSession session = request.getSession();
        session.setAttribute("user", u);
        RequestDispatcher rd = request.getRequestDispatcher("welcomepg.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
