package top.lldwb.sae.test.liao;

import org.junit.jupiter.api.Test;
import top.lldwb.sae.service.user.UserServiceInterFace;
import top.lldwb.sae.service.user.service.UserService;

/**
 * @Date(时间)2023-06-18
 * @Author 家辉
 */
public class UserTest {

    //获取用户业务类
    private static UserServiceInterFace service = new UserService() ;

    @Test
    public void  AddUser () {
        System.out.println(service.loginAdd("231", "202", "123", "小美", "1", "33333","333333"));
    }


    @Test
    public void delete(){
        System.out.println(service.loginDelete(2));

    }
    @Test
    public void update(){
        System.out.println(service.loginUpdate("222","小白","3333","333",1,5));
    }

    @Test
    public void queryName () {
        System.out.println(service.login("2026319183@qq.com", "1233"));

    }
    @Test
    public void queryUpdateEmail(){
        System.out.println(service.loginUpdateEmail("2026319133@qq.com", 1, "824725"));
    }

    @Test
    public void loginEmail(){

        System.out.println(service.loginEmail("2026319182@qq.com","333333"));

    }

    @Test
    public void pageList(){
        PageVO<List<User>> pageVO =service.pageUserVoList("","2023@qq.com",1,3) ;
        pageVO.getData().forEach(System.out::println);
    }
}
