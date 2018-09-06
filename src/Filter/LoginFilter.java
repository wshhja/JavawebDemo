package Filter;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        // 获得当前请求的URI
        String nowPath = req.getRequestURI();

        if (req.getSession().getAttribute("user") == null) {
            if ("/login".equals(nowPath) || "/register".equals(nowPath)||"/index.jsp".equals(nowPath)
                    || "/register.jsp".equals(nowPath)|| "/login_error.jsp".equals(nowPath)|| "/findPs.jsp".equals(nowPath)) {
                filterChain.doFilter(req, resp);
                return;
            } else {
                resp.sendRedirect(req.getContextPath() + "/login_error.jsp");
                return;
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
