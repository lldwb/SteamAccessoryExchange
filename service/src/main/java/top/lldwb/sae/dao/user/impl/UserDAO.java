package top.lldwb.sae.dao.user.impl;

import top.lldwb.sae.entity.user.User;
import top.lldwb.sae.dao.user.UserFace;
import top.lldwb.sae.utils.mySql.MySqlUtil;


/***
 * @Date(时间)2023-06-18
 * @Author 家辉
 *
 * 用户信息数据访问类
 */
public class UserDAO implements UserFace {

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
        String sql = "insert into user(user_name,user_email,user_password,user_nickname,user_phone,user_id_card,user_state,user_time,role_id,user_renew_time)VALUES(?,?,?,?,?,?,?,?,?,?);" ;
        return MySqlUtil.update(sql,useObj);
    }

    @Override
    public int loginDelete(int id) {
        //获取sql查询语句
        String sql = "delete from user where user_id = ?" ;
        //执行
        return MySqlUtil.update(sql,id);
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

        return MySqlUtil.update(sql,useObj);
    }

    @Override
    public int loginUpdateEmail(String email, int userid) {
        //获取sql语句
        String sql = "update user set user_email = ? where user_id = ?" ;
        return MySqlUtil.update(sql,email,userid);
    }

    @Override
    public  User login(String name) {
        //获取查询语句
        String sql = "select user_id,user_name,user_email,user_password,user_nickname,user_phone,user_id_card,user_state,user_time,role_id,user_renew_time from user where user_name = ?";
        return MySqlUtil.queryT(User.class, sql, name);
    }

    @Override
    public User loginEmail(String email) {
        //获取查询语句
        String sql = "select user_id,user_name,user_email,user_password,user_nickname,user_phone,user_id_card,user_state,user_time,role_id,user_renew_time from user where user_email = ?";
        return MySqlUtil.queryT(User.class, sql, email);
    }

    @Override
    public String getSteamIdById(int userId) {
        return MySqlUtil.queryColumn(1,"select steam_id from user where user_id = ?",userId);
    }


}
