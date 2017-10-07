package com.nazar.controller.filters;

import com.nazar.dto.User;
import com.nazar.dto.UserRole;
import com.nazar.util.PathManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static com.nazar.util.GlobalConst.USER;

@WebFilter(urlPatterns = {"/view/jsp/*"})
public class SecurityFilter implements Filter {
    private PathManager pathManager = PathManager.getInstance();
    private Set<String> guestUri = new HashSet<>();
    private Set<String> userUri = new HashSet<>();
    private Set<String> adminUri = new HashSet<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        guestUri.add(pathManager.getLoginUri());
        guestUri.add(pathManager.getRegistrationUri());

        userUri.add(pathManager.getUserCabinetUri());
        userUri.add(pathManager.getUserAccountReviewUri());
        userUri.add(pathManager.getUserAccountPageUri());
        userUri.add(pathManager.getUserCardReviewUri());
        userUri.add(pathManager.getUserReplenishUri());
        userUri.add(pathManager.getUserReplenishInfoUri());
        userUri.add(pathManager.getUserPaymentUri());
        userUri.add(pathManager.getUserPaymentInfoUri());

        adminUri.add(pathManager.getAdminCabinetUri());
        adminUri.add(pathManager.getAdminUnblockingInfoUri());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute(USER);
        String currentPath = request.getServletPath();

        boolean guestPermission = (user == null) && guestUri.contains(currentPath);
        boolean userPermission = (user != null) && userUri.contains(currentPath);
        boolean adminPermission = (user != null) &&
                user.getRole().equals(UserRole.ADMIN) && adminUri.contains(currentPath);

        if(!(guestPermission || userPermission || adminPermission)){
            //response.sendRedirect(pathManager.getLoginUri());
            request.getRequestDispatcher(pathManager.getLoginUri()).forward(servletRequest, servletResponse);
        }

        request.getRequestDispatcher(currentPath).forward(servletRequest, servletResponse);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        guestUri = null;
        adminUri = null;
        userUri = null;
    }
}
