package top.lldwb.sae.service.user.service;

import top.lldwb.sae.entity.code.CodeTable;
import top.lldwb.sae.entity.user.User;
import top.lldwb.sae.service.exception.AllException;
import top.lldwb.sae.dao.code.CodeInterFace;
import top.lldwb.sae.dao.code.impl.CodeDAO;
import top.lldwb.sae.dao.user.UserFace;
import top.lldwb.sae.dao.user.impl.UserDAO;
import top.lldwb.sae.service.user.UserServiceInterFace;

import java.sql.Timestamp;

/***
 * @Date(时间)2023-06-20
 * @Author 家辉
 * 实现用户增删改查，所有的业务逻辑类
 * 业务类
 */
public class UserService implements UserServiceInterFace {

    //调用数据访问类
   private static UserFace face = new UserDAO() ;

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
    @Override
    public int loginAdd(String name,String email,String password,String nickName,String phone,String idCard,String emailCode) {

        //调用验证码访问类
        CodeInterFace code = new CodeDAO() ;
        //调用验证码实体类
        CodeTable codeEntity = code.query(emailCode) ;
        //判断输入的邮箱验证码是否存在
        if(codeEntity == null){
            throw new AllException(500,"验证码已过期，请重新发送验证码") ;
        }

        //获取当前时间
        Timestamp timestamp = new Timestamp(System.currentTimeMillis()) ;

        //调用数据访问类
        face = new UserDAO() ;

        //调用实体类
        User user = new User() ;
        user.setUserName(name);
        user.setUserEmail(email);
        user.setUserPassword(password);
        user.setUserNickname(nickName);
        user.setUserPhone(phone);
        user.setUserIdCard(idCard);
        user.setUserState(1);
        user.setUserTime(timestamp);
        user.setRoleId(1);
        user.setUserRenewTime(timestamp);
        int row = face.loginAdd(user) ;



        if(user==null){
            throw new AllException(500,"数据异常，请重新操作") ;
        }
        if(row<1){
            throw new AllException(500,"数据异常，请重新操作") ;
        }


        //返回
        return  row ;
    }

    /***
     * 注销账号
     * @param id
     * @return
     */
    @Override
    public int loginDelete(int id) {
      int row = face.loginDelete(id) ;
      if(row<1){
          throw new AllException(500,"删除失败") ;
      }

        return row;
    }

    /***
     * 修改账号基本信息
     * @return
     */
    @Override
    public int loginUpdate(String password,String nickName,String phone,String idcard,int state,int userId) {

        //获取当前时间
        Timestamp timestamp = new Timestamp(System.currentTimeMillis()) ;

        User user = new User();
        user.setUserPassword(password); // 密码
        user.setUserNickname(nickName); // 昵称
        user.setUserPhone(phone);//手机号
        user.setUserIdCard(idcard);//身份证
        user.setUserState(state);//状态
        user.setUserRenewTime(timestamp);//更新时间
        user.setUserId(userId); //根据Id修改



        int row = face.loginUpdate(user);
        //判断一下
        if(user==null){
            throw new AllException(500,"数据异常，请重新操作") ;
        }
        if(row<1){
            throw new AllException(500,"数据异常，请重新操作") ;
        }

        return row;
    }

    /***
     * 修改邮箱地址
     * @param email 邮箱地址
     * @param userid 用户id
     * @param emailCode 输入的验证码
     * @return
     */
    @Override
    public int loginUpdateEmail(String email, int userid,String emailCode) {


        int row = face.loginUpdateEmail(email,userid) ;

        //调用验证码访问类
        CodeInterFace code = new CodeDAO() ;
        //调用验证码实体类
        CodeTable codeEntity = code.query(emailCode) ;
        //判断输入的邮箱验证码是否存在
        if(codeEntity == null){
            throw new AllException(500,"验证码已过期，请重新发送验证码") ;
        }
        if(row<1){
            throw new AllException(500,"数据异常，请重新操作") ;
        }

        return row;
    }

    /***
     * 用户登录
     * @param name
     * @param password
     * @return
     */
    @Override
    public User login(String name, String password) {

        //调用数据访问类
        face = new UserDAO() ;

        //获取方法
        User user = face.login(name) ;


        //判断查询数据是否为空
        if(user==null){
            throw new AllException(500,"账号或密码不存在") ;
        }
        //判断账号或密码输入是否错误
        if( !user.getUserName().equals(name) || !user.getUserPassword().equals(password) ){
            throw new AllException(500,"账号或密码不存在") ;
        }
        return user;
    }


    /***
     * 邮箱登录
     * @param email 邮箱地址
     * @param emailCode 输入的邮箱验证码
     * @return
     */
    @Override
    public User loginEmail(String email,String emailCode) {
        //调用数据访问类
        face = new UserDAO() ;

        //获取方法
        User user = face.loginEmail(email) ;


        //判断查询数据是否为空
        if(user==null){
            throw new AllException(500,"邮箱地址输入错误") ;
        }

        //调用验证码访问类
        CodeInterFace code = new CodeDAO() ;
        //调用验证码实体类
        CodeTable codeEntity = code.query(emailCode) ;
        System.out.println(codeEntity.getUserId());

        //判断输入的邮箱验证码是否存在
        if(codeEntity == null){
            throw new AllException(500,"验证码已过期，请重新发送验证码") ;
        }
        //判断输入的邮箱验证码是否是此账号发出
        if(user.getUserId() != codeEntity.getUserId()){
            throw new AllException(500,"验证码已过期，请重新发送验证码") ;
        }
        return user;
    }
}
