package com.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "createUserServlet", value = "/createUser")
public class createUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String userName = request.getParameter("uid");
        String password = request.getParameter("pass");

        boolean isTrue = CustomerDBUtil.createUser(name, email, phone, userName, password);

        if (isTrue == true) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
            dispatcher.forward(request, response);
        }
        else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("unsuccess.jsp");
            dispatcher.forward(request, response);
        }
    }
}
