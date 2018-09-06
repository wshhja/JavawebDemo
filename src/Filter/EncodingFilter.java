package Filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private String charSet ;
    public void init(FilterConfig config)
            throws ServletException {
        // 接收初始化的参数
        this.charSet = config.getInitParameter("charset") ;
        //System.out.println("EncodingFilter init");
    }
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException,
            ServletException{
        request.setCharacterEncoding(this.charSet) ;
        response.setCharacterEncoding(charSet);
        //System.out.println("EncodingFilter running");
        chain.doFilter(request,response) ;
    }
    public void destroy(){
        //System.out.println("EncodingFilter destroy");
    }

}
