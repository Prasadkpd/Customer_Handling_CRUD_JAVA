package com.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "updateUserServlet", value = "/updateUserServlet")
public class updateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("uid");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String userName = request.getParameter("uname");
        String password = request.getParameter("pass");

        boolean isTrue = CustomerDBUtil.updateUser(id, name, email, phone, userName, password);

        RequestDispatcher dispatcher;
        if (isTrue == true) {
            dispatcher = request.getRequestDispatcher("success.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("unsuccess.jsp");
        }
        dispatcher.forward(request, response);
    }
}
