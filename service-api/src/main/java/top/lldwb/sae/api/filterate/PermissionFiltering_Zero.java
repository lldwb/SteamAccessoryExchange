package top.lldwb.sae.api.filterate;

import top.lldwb.sae.service.purview.PurviewServiceInterFace;
import top.lldwb.sae.service.purview.impl.PurviewService;
import top.lldwb.sae.service.user.UserServiceInterFace;
import top.lldwb.sae.service.user.service.UserService;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * @Date(时间)2023-06-26
 * @Author 家辉
 *
 * 权限过滤器 限制0的权限
 *
 * 这个过滤器主要针对用户，用于拦截请求并且做权限验证
 */
public class PermissionFiltering_Zero implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("过滤中...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        //转换一下
        HttpServletRequest req = (HttpServletRequest) servletRequest ;
        HttpServletResponse resp = (HttpServletResponse) servletRequest ;

        //请求获取url地址
        String url = req.getRequestURI() ;

        /***
         * 如果请求的URI以"xx.html"、"xx.do"或"xx.do"结尾,
         * 则表示用户正在登录或执行在线操作，此时通过filterChain.doFilter(request, response)方法直接放行，让请求继续向目标资源进行处理。
         */
        if(url.endsWith("user/getLogin.do")){
            filterChain.doFilter(req,resp);
            return;
        }

        //调用用户业务逻辑类
        UserServiceInterFace serviceUser = new UserService() ;

        //调用权限业务逻辑类
        PurviewServiceInterFace servicePurview = new PurviewService() ;



    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        System.out.println("过滤结束!");
    }
}
