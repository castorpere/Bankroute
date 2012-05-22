package com.supinfo.rmt.web.filter;

import com.supinfo.rmt.entity.Employee;
import com.supinfo.rmt.web.controller.UserController;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: bargenson
 * Date: 5/2/12
 * Time: 6:40 PM
 */
@WebFilter(urlPatterns = { "/employee_home.xhtml", "/add_worktime.xhtml" })
public class EmployeeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Do nothing
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        if(session != null) {
            UserController userController = (UserController) session.getAttribute("userController");
            if(userController != null) {
                if(userController.getUser() instanceof Employee) {
                    chain.doFilter(request, response);
                    return;
                }
            }
        }
        ((HttpServletResponse) response).sendRedirect(httpServletRequest.getContextPath() + "/login.xhtml");
    }

    @Override
    public void destroy() {
        // Do nothing
    }

}
