package top.lldwb.sae.test.liao;

import org.junit.jupiter.api.Test;
import top.lldwb.sae.service.dao.user.impl.UserDAO;
import top.lldwb.sae.service.entity.user.dao.UserInterFace;



/***
 * @Date(时间)2023-06-18
 * @Author 家辉
 */
public class UserTest {
    @Test
    public void delete(){

        UserInterFace userInterFace = (UserInterFace) new UserDAO();
        System.out.println(userInterFace.loginDelete(1));
    }

}
