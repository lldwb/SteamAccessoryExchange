package top.lldwb.sae.api.controller.user;

import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.JsonView;
import top.lldwb.sae.service.service.user.UserServiceInterFace;
import top.lldwb.sae.service.service.user.service.UserService;

/**
 * @author 安然的尾巴
 * @version 1.0
 *
 *
 * 用户登录
 */
public class UserController {

    private static UserServiceInterFace service = new UserService() ;
    @RequestMapping("/user/getUser")
    public View getUser(){
        return null;
    }


    /***
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/user/getDeleteUser.do")
    public View getDeleteUser(@RequestParam("userid")int id) {
        return new JsonView(service.loginDelete(id));
    }




}
