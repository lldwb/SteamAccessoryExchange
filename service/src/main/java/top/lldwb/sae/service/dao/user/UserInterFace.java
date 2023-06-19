package top.lldwb.sae.service.dao.user;

import top.lldwb.sae.service.entity.user.User;

import java.util.List;

/***
 * @Date(时间)2023-06-18
 * @Author 家辉
 *
 * 用户接口抽象类
 */
public interface UserInterFace {
    /***
     * 用户注册
     * @param user
     * @return
     */
    int loginAdd(User user) ;

    /***
     * 用户注销
     * 一般不用
     * @param id
     * @return
     */
    int loginDelete(int id) ;


    /**
     * 修改用户
     * @param user
     * @return
     */
    int loginUpdate(User user) ;


    /***
     * 用户名登录
     * @param name
     * @return
     */
    List<User> loginList(String name) ;

}
