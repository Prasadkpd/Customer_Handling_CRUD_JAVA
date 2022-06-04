package com.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("uid");
        String password = request.getParameter("pass");

        try {
            List<Customer> customerDetails = CustomerDBUtil.validate(userName, password);
            request.setAttribute("customerDetails", customerDetails);
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("userAccount.jsp");
        dispatcher.forward(request, response);
    }
}
