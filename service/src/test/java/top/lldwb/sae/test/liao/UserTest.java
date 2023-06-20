package top.lldwb.sae.test.liao;

import org.junit.jupiter.api.Test;
import top.lldwb.sae.service.dao.user.UserFace;
import top.lldwb.sae.service.dao.user.impl.UserDAO;
import top.lldwb.sae.service.entity.user.User;


import java.sql.Timestamp;


/***
 * @Date(时间)2023-06-18
 * @Author 家辉
 */
public class UserTest {
    @Test
    public void delete(){
    }




    @Test
    public void  AddUser () {

        UserFace face = new UserDAO() ;

        Timestamp timestamp = new Timestamp(System.currentTimeMillis()) ;
        User user = new User() ;
                user.setUserName("998");
                user.setUserEmail("2026319183@qq.com");
                user.setUserPassword("123");
                user.setUserNickname("小六");
                user.setUserPhone("3333");
                user.setUserIdCard("3333");
                user.setUserState(1);
                user.setUserTime(timestamp);
                user.setRoleId(0);
                user.setUserRenewTime(timestamp);

        System.out.println(face.loginAdd(user));


    }
    @Test
    public void queryName () {
        UserFace face = new UserDAO() ;


    }


}
