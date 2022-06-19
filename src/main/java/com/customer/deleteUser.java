package com.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "deleteUser", value = "/deleteUser")
public class deleteUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("uid");
        boolean isTrue = CustomerDBUtil.deleteUser(id);

        if (isTrue == true) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("createUser.jsp");
            dispatcher.forward(request, response);
        }
        else {
            List<Customer> customerDetails = CustomerDBUtil.getCustomerDetails(id);
            request.setAttribute("customerDetails",customerDetails);
            RequestDispatcher dispatcher = request.getRequestDispatcher("userAccount.jsp");
        }
    }
}
