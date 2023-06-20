package top.lldwb.sae.service.dao.user;

import top.lldwb.sae.service.entity.user.User;

import java.util.List;

/***
 * @Date(时间)2023-06-20
 * @Author 家辉
 */public interface UserFace {


    public int loginAdd(User user);

    public int loginDelete(int id) ;

    public int loginUpdate(User user) ;

    public List<User> loginList(String name) ;

    List<User> listName(String name) ;
}
