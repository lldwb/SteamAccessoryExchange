package top.lldwb.sae.service.user;

import top.lldwb.sae.entity.user.User;
import top.lldwb.sae.entity.user.UserTwo;
import top.lldwb.sae.utils.vo.PageVO;

import java.util.List;

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
     *  添加数据
     * @param name 用户名
     * @param email 邮箱号
     * @param password 密码
     * @param nickName 昵称
     * @param phone 手机号
     * @param idCard 身份证
     * @return
     */
    int loginAdd(String name,String email,String password,String nickName,String phone,String idCard ,String emailCode);

    /***
     * 根据id删除
     * @param id
     * @return
     */

    int loginDelete(int id) ;

    /***
     * 修改
     * @return
     */

    int loginUpdate(String password,String nickName,String phone,String idcard,int state,int userId) ;
    int loginUpdateEmail(String email,int userid,String emailCode) ;
    /***
     * 用户登录
     * @param name 用户名
     * @param password  密码
     * @return
     */

    User login(String name, String password) ;
    User loginEmail(String email,String emailCode) ;

    /***
     * 分页查询
     * 含条件查询
     * @param page 当前页
     * @param limit 分页
     * @param userName 条件用户名
     * @param userEmail 条件邮箱地址
     * @return
     */
    PageVO<List<UserTwo>> pageUserVoList(String userName, String userEmail, int page, int limit) ;

    /**
     * 查询用户状态
     * @param name 用户名
     * @return
     */
    int selectStatus(String name);

}
