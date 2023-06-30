package top.lldwb.sae.dao.user.impl;

import org.junit.jupiter.api.Test;
import top.lldwb.sae.dao.user.UserFace;
import top.lldwb.sae.dao.user.impl.UserDAO;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class UserDAOTest {
    @Test
    public void test(){
        UserFace dao = new UserDAO();
        System.out.println(dao.getSteamIdById(10));
    }
}
