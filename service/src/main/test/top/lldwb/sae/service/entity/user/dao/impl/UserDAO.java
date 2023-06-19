package top.lldwb.sae.service.entity.user.dao.impl;

import top.lldwb.sae.service.dao.user.UserInterFace;
import top.lldwb.sae.service.entity.user.User;
import top.lldwb.sae.utils.MySqlUtil;


import java.sql.SQLException;
import java.util.List;

/***
 * @Date(时间)2023-06-18
 * @Author 家辉
 *
 * 用户信息数据访问类
 */
public class UserDAO implements UserInterFace {

    /***
     * 调用工具类
     */
    MySqlUtil mySqlUtil;

    {
        try {
            mySqlUtil = new MySqlUtil();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public int loginAdd(User user) {
        //创建Object父类数组存放要添加的数据
        Object[]useObj = {
                user.getUserName(),
                user.getUserEmail(),
                user.getUserPassword(),
                user.getUserNickname(),
                user.getUserPhone(),
                user.getUserIdCard(),
                user.getUserState(),
                user.getUserTime(),
                user.getRoleId(),
                user.getUserRenewTime()
        };


        //获取sql语句
        String sql = "insert into user(user_name,user_email," +
                "user_password,user_nickname,user_phone,user_id_card,user_state,user_time,role_id,user_renew_time)" +
                "VALUES(?,?,?,?,?,?,?,?,?,?); " ;

        try {
            return mySqlUtil.update(sql,useObj);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int loginDelete(int id) {
        return 0;
    }

    @Override
    public int loginUpdate(User user) {
        return 0;
    }

    @Override
    public List<User> loginList(String name) {
        return null;
    }
}
