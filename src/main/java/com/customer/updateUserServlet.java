package com.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

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
            List<Customer> customerDetails = CustomerDBUtil.getCustomerDetails(id);
            request.setAttribute("customerDetails",customerDetails);
            dispatcher = request.getRequestDispatcher("userAccount.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("unSuccess.jsp");
        }
        dispatcher.forward(request, response);
    }
}
