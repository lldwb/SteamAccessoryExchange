package top.lldwb.sae.service.dao.user;

import top.lldwb.sae.service.entity.user.User;

import java.util.List;

/***
 * @Date(时间)2023-06-20
 * @Author 家辉
 */public interface UserFace {

    /***
     * 查询所有
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

    public List<User> loginList(String name) ;

}
