package top.lldwb.sae.api.controller.user;

import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.JsonView;
import top.lldwb.sae.api.vo.ResultVO;
import top.lldwb.sae.service.user.UserServiceInterFace;
import top.lldwb.sae.service.user.service.UserService;

import javax.servlet.http.HttpSession;

/**
 * @author 安然的尾巴
 * @version 1.0
 *
 *
 * 用户登录
 */
public class UserController {

    /***
     * 调用响应类
     * @return
     */
    private static  ResultVO<Object> resultVO = null ;

    @RequestMapping("/user/getUser")
    public View getUser(){
        return null;
    }


    /***
     *添加数据
     * @param name 用户名
     * @param email 邮箱地址
     * @param password 密码
     * @param nickName 昵称
     * @param phone 手机号
     * @param idCard 身份证
     * @param emailCode 输入的验证码
     * @return
     */
    @RequestMapping("/user/getAddUser.do")
    public View getAddUser(@RequestParam("userName") String name,
                           @RequestParam("userEmail")String email,
                           @RequestParam("userPassword")String password,
                           @RequestParam("userNickName")String nickName,
                           @RequestParam("userPhone")String phone,
                           @RequestParam("userIdCard")String idCard,
                           @RequestParam("userEmailCode")String emailCode){

            UserServiceInterFace service = new UserService() ;
            resultVO = new ResultVO<>(200,"成功",service.loginAdd(name, email, password, nickName, phone, idCard,emailCode)) ;
            return new JsonView(resultVO);
    };




    /***
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/user/getDeleteUser.do")
    public View getDeleteUser(@RequestParam("userid")int id) {
         UserServiceInterFace service = new UserService() ;
         resultVO = new ResultVO<>(200,"成功",service.loginDelete(id));
         return new JsonView(resultVO);
    };

    /***
     * 修改基本信息
     * @param password 密码
     * @param nickName 昵称
     * @param phone 手机号
     * @param idcard 身份证
     * @param state 状态
     * @param userId 根据id修改
     * @return
     */
    @RequestMapping("/user/getUpdateUser.do")
    public View getUpdateUser(@RequestParam("userPassword")String password,
                              @RequestParam("userNickName")String nickName,
                              @RequestParam("userPhone")String phone,
                              @RequestParam("userIdcard")String idcard,
                              @RequestParam("userState")int state,
                              @RequestParam("userId")int userId){
        UserServiceInterFace service = new UserService() ;
        resultVO = new ResultVO<>(200,"成功",service.loginUpdate(password,nickName,phone,idcard,state,userId)) ;
        return new JsonView(resultVO) ;
    }

    /***
     * 修改邮箱地址
      * @param email 邮箱地址
     * @param userid 根据用户id修改
     * @param emailCode 输入的邮箱码验证
     * @return
     */
    @RequestMapping("/user/getUpdateEmail.do")
    public View getUpdateEmail(@RequestParam("email")String email,
                               @RequestParam("userid")int userid,
                               @RequestParam("emailCode") String emailCode) {
        UserServiceInterFace service = new UserService() ;
        resultVO = new ResultVO<>(200,"成功",service.loginUpdateEmail(email,userid,emailCode));
        return new JsonView(resultVO);
    }


    /***
     * 用户登录
     * @param name 账号
     * @param password 密码
     * @return
     */
    @RequestMapping("/user/getLogin.do")
    public View getLogin(@RequestParam("userName")String name,
                         @RequestParam("userPassword")String password, HttpSession session){
        UserServiceInterFace service = new UserService() ;
        resultVO = new ResultVO<>(200,"成功",service.login(name,password)) ;

        //会话跟踪
        session.setAttribute("userSuccess",resultVO);
        return new JsonView(resultVO) ;
    }

    /***
     * 邮箱登录
     * @param email 邮箱地址
     * @param emailCode 输入邮箱验证码
     * @return
     */
    @RequestMapping("/user/getLoginEmail.do")
    public View getLoginEmail(@RequestParam("userEmail")String email,
                              @RequestParam("userEmailCode")String emailCode,HttpSession session){
        UserServiceInterFace service = new UserService() ;
        resultVO = new ResultVO<>(200,"成功",service.loginEmail(email,emailCode)) ;

        //会话跟踪
        session.setAttribute("emailCodeSuccess",resultVO);
        return new JsonView(resultVO) ;
    }

}
