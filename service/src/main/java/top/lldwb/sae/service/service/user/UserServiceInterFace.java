package top.lldwb.sae.service.service.user;

import top.lldwb.sae.service.entity.user.User;

/**
 * @author 安然的尾巴
 * @version 1.0
 *
 *
 *
 * 用户业务逻辑抽象类
 */
public interface UserServiceInterFace {


    /***
     * 添加数据
     * @param user
     * @return
     */
    public int loginAdd(User user);

    /***
     * 根据id删除
     * @param id
     * @return
     */

    public int loginDelete(int id) ;

    /***
     * 修改
     * @param user
     * @return
     */

    public int loginUpdate(User user) ;

    /***
     * 用户登录
     * @param name
     * @return
     */

    public User loginList(String name,String password) ;
}
