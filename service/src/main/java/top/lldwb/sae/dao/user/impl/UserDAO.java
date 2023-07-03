package top.lldwb.sae.dao.user.impl;

import top.lldwb.sae.entity.user.User;
import top.lldwb.sae.dao.user.UserFace;
import top.lldwb.sae.entity.user.UserTwo;
import top.lldwb.sae.utils.mySql.MySqlUtil;

import java.time.Year;
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
        // 获取sql查询语句,强制删除 - 所有对该id进行引用的数据都将删除
        String sql = "set foreign_key_checks = 0;\n" +
                "\n" +
                "delete from user where user_id = ?;\n" +
                "set foreign_key_checks = 1;" ;
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

    @Override
    public String getSteamKeyById(int userId) {
        return MySqlUtil.queryColumn(1,"select steam_key from user where user_id = ?",userId);
    }

    /***
     * 查询所有数据
     * 含模糊查询
     * @param entity 实体类
     * @param number 当前业
     * @param limit 页数
     * @return
     */
    @Override
    public List<UserTwo> listUserLimit(UserTwo entity, int number, int limit) {
        //获取SQL语句
        StringBuilder sb = new StringBuilder() ;

        sb.append("select");
        sb.append(" user_id,");
        sb.append(" user_name,");
        sb.append(" user_email,");
        sb.append(" user_password,");
        sb.append(" user_nickname,");
        sb.append(" user_phone,");
        sb.append(" user_id_card,");
        sb.append(" user_state,");
        sb.append(" user_time,");
        sb.append(" role_id,");
        sb.append(" user_renew_time,steam_Id,(select role_level from role where role_id = user.role_id) as role_level ");
        sb.append("from user ");

        //判断多条件查询
        if(entity!=null && entity.getUserName() !=null && !"".equals(entity.getUserName().trim())){
            sb.append(" where user_name like ? ") ;
            sb.append(" limit ?,?") ;
            return MySqlUtil.queryList(UserTwo.class,sb.toString(),"%"+entity.getUserName()+"%",number,limit);
        }else if(entity.getUserEmail() !=null && !"".equals(entity.getUserEmail().trim())){
            sb.append(" where user_email like ?") ;
            sb.append(" limit ?,?") ;
            return MySqlUtil.queryList(UserTwo.class,sb.toString(),"%"+entity.getUserEmail()+"%",number,limit);
        }

       return  listUserLimitRecursion(number,limit) ;
    }

    /***
     *
     * @param number 当前页
     * @param limit 页数
     * @return
     */
    public static List<UserTwo> listUserLimitRecursion(int number, int limit) {
        //获取SQL语句
        StringBuilder sb = new StringBuilder() ;

        sb.append("select");
        sb.append(" user_id,");
        sb.append(" user_name,");
        sb.append(" user_email,");
        sb.append(" user_password,");
        sb.append(" user_nickname,");
        sb.append(" user_phone,");
        sb.append(" user_id_card,");
        sb.append(" user_state,");
        sb.append(" user_time,");
        sb.append(" role_id,");
        sb.append(" user_renew_time,steam_Id,(select role_level from role where role_id = user.role_id) as role_level ");
        sb.append("from user ");
        sb.append("limit ?,?") ;
        String sql = sb.toString();

        return MySqlUtil.queryList(UserTwo.class,sql,number,limit);
    }

    /***
     * 统计
     * @return
     */
    @Override
    public Long count() {

        //获取sql语句
        String sql = "select COUNT(*) from user" ;

        return MySqlUtil.queryColumn(1,sql);
    }

    @Override
    public int selectStatus(String name) {
        return MySqlUtil.queryColumn(1, "select user_state from user where user_name = ?", name);
    }

}
