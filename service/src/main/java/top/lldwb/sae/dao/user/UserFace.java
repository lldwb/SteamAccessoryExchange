package top.lldwb.sae.dao.user;

import top.lldwb.sae.entity.user.User;

import java.util.List;

/***
 * @Date(时间)2023-06-20
 * @Author 家辉
 */
public interface UserFace {

    /***
     * 添加数据
     * @param user
     * @return
     */
    int loginAdd(User user);

    /***
     * 根据id删除
     * @param id
     * @return
     */

    int loginDelete(int id);

    /***
     * 修改
     * @param user
     * @return
     */

    int loginUpdate(User user);

    /***
     * 修改邮箱
     * @param email 根据id修改邮箱地址
     * @param userid id
     * @return
     */
    int loginUpdateEmail(String email, int userid);

    /***
     * 用户登录
     * @param name
     * @return
     */
    User login(String name);


    /***
     * 邮箱登录
     * @param email
     * @return
     */
    User loginEmail(String email);

    /**
     * 根据用户id获取SteamID
     * @param userId
     * @return
     */
    String getSteamIdById(int userId);


    /***
     * 分页查询
     * @param page 当前业
     * @param limit 页数
     * @return
     */
    List<User> listUserLimit(User entity,int page,int limit) ;

    /***
     * 统计用户数量
     * @return
     */
    Long count() ;
}
