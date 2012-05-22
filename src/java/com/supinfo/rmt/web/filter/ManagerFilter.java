package com.supinfo.rmt.web.filter;

import com.supinfo.rmt.entity.Manager;
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
 * Time: 6:41 PM
 */
@WebFilter(urlPatterns = { "/manager_home.xhtml", "/add_employee.xhtml", "/add_client.xhtml" })
public class ManagerFilter implements Filter {

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
                if(userController.getUser() instanceof Manager) {
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
