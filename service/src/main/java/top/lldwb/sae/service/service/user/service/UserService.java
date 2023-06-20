package top.lldwb.sae.service.service.user.service;

import top.lldwb.sae.service.entity.user.User;
import top.lldwb.sae.service.service.user.UserServiceInterFace;

/***
 * @Date(时间)2023-06-20
 * @Author 家辉
 * 实现用户增删改查，所有的业务逻辑类
 * 业务类
 */
public class UserService implements UserServiceInterFace {

    /***
     * 添加数据
     * @param user
     * @return
     */
    @Override
    public int loginAdd(User user) {
        return 0;
    }

    /***
     * 注销账号
     * @param id
     * @return
     */
    @Override
    public int loginDelete(int id) {
        return 0;
    }

    /***
     * 修改账号基本信息
     * @param user
     * @return
     */
    @Override
    public int loginUpdate(User user) {
        return 0;
    }

    /***
     * 用户登录
     * @param name
     * @param password
     * @return
     */
    @Override
    public User loginList(String name, String password) {
        return null;
    }
}
