package top.lldwb.sae.api.filterate;

import top.lldwb.sae.dao.user.UserFace;
import top.lldwb.sae.dao.user.impl.UserDAO;
import top.lldwb.sae.entity.purview.Purview;
import top.lldwb.sae.entity.user.User;
import top.lldwb.sae.service.exception.AllException;
import top.lldwb.sae.service.purview.PurviewServiceInterFace;
import top.lldwb.sae.service.purview.impl.PurviewService;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

        //创建HttpSession会话
        HttpSession session = req.getSession() ;
        String user = (String) session.getAttribute("userSuccess")  ;


        //调用用户数据访问类
        UserFace userDao = new UserDAO() ;
        //引用dao方法
        User userEntity = userDao.login(url) ;

        if("0".equals(userEntity.getUserState())){
            throw new AllException(500,"账号被封禁不可以登录") ;
        }


    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        System.out.println("过滤结束!");
    }
}
