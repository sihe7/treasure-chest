package king.drug.common.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跨域过滤器
 * @author: hemenghao
 * @date: 2022/3/19 13:43
 */
@WebFilter
public class CrosFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("========filter=========");
        HttpServletResponse resp=(HttpServletResponse) response;
        resp.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx");
        resp.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        resp.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8848");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        chain.doFilter(request, resp);

    }
}
