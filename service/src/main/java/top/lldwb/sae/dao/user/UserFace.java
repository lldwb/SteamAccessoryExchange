package top.lldwb.sae.dao.user;

import top.lldwb.sae.entity.user.User;

/***
 * @Date(时间)2023-06-20
 * @Author 家辉
 */public interface UserFace {

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
     * 修改邮箱
     * @param email 根据id修改邮箱地址
     * @param userid id
     * @return
     */
    public int loginUpdateEmail(String email,int userid) ;

    /***
     * 用户登录
     * @param name
     * @return
     */
    public User login(String name) ;


    /***
     * 邮箱登录
     * @param email
     * @return
     */
    public User loginEmail(String email) ;
}
