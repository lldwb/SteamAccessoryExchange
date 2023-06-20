package top.lldwb.sae.service.dao.user.impl;

import org.nf.db.util.SqlExecutor;
import org.nf.db.util.result.BeanListHandler;
import top.lldwb.sae.service.dao.user.UserFace;
import top.lldwb.sae.service.entity.user.User;
import top.lldwb.sae.utils.MySqlUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/***
 * @Date(时间)2023-06-18
 * @Author 家辉
 *
 * 用户信息数据访问类
 */
public class UserDAO implements UserFace {

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
        //获取sql查询语句
        String sql = "delete from user where user_id = ?" ;
        //执行
        try {
            return mySqlUtil.update(sql,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int loginUpdate(User user) {
        //创建Object父类数组存放要添加的数据
        Object[]useObj = {
                user.getUserPassword(), // 密码
                user.getUserNickname(), // 昵称
                user.getUserPhone(),//手机号
                user.getUserIdCard(),//身份证
                user.getUserState(),//状态
                user.getUserRenewTime(),//更新时间
                user.getUserId() //根据Id修改
        };
        //获取sql语句
        String sql = "update user set user_password = ?,user_nickname = ?,user_phone = ?,user_id_card = ?,user_state = ?,user_renew_time = ? where user_id = ?" ;

        try {
            return mySqlUtil.update(sql,useObj);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int loginUpdateEmail(String email, int userid) {
        //获取sql语句
        String sql = "update user set user_email = ? where user_id = ?" ;
        try {
            return mySqlUtil.update(sql,email,userid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public  User login(String name) {
        //获取查询语句
        String sql = "select user_id,user_name,user_email,user_password,user_nickname,user_phone,user_id_card,user_state,user_time,role_id,user_renew_time from user where user_name = ?";
        return mySqlUtil.queryT(User.class, sql, name);
    }

    @Override
    public User loginEmail(String email) {
        //获取查询语句
        String sql = "select user_id,user_name,user_email,user_password,user_nickname,user_phone,user_id_card,user_state,user_time,role_id,user_renew_time from user where user_email = ?";
        return mySqlUtil.queryT(User.class, sql, email);
    }


}
