package top.lldwb.sae.api.filterate;

import top.lldwb.sae.service.exception.AllException;
import top.lldwb.sae.service.user.UserServiceInterFace;
import top.lldwb.sae.service.user.service.UserService;

import javax.servlet.*;
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
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//        System.out.println("过滤中...");
//    }

//    @Override
//    public void doFilter(ServletRequest servletRequest,
//                         ServletResponse servletResponse,
//                         FilterChain filterChain) throws IOException, ServletException {
//
//        System.out.println(servletRequest.getParameter(servletRequest.getParameter("userName")));
//
//        /***
//         * 如果请求的URI以"xx.html"、"xx.do"或"xx.do"结尾,
//         * 则表示用户正在登录或执行在线操作，此时通过filterChain.doFilter(request, response)方法直接放行，让请求继续向目标资源进行处理。
//         */
//        UserServiceInterFace service = new UserService();
//        if (service.selectStatus(servletRequest.getParameter("userName")) == 1) {
//            filterChain.doFilter(servletRequest, servletResponse);
//        } else {
//            throw new AllException(500, "账号被封禁不可以登录");
//        }
//
//
//    }

//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//        System.out.println("过滤结束!");
//    }
}
