package top.lldwb.sae.service.role.impl;

import top.lldwb.sae.dao.role.RoleInterFace;
import top.lldwb.sae.dao.role.impl.RoleDAO;
import top.lldwb.sae.entity.rode.Role;
import top.lldwb.sae.service.exception.AllException;
import top.lldwb.sae.service.role.RoleServiceInterFace;

import java.util.ArrayList;
import java.util.List;

/***
 * @Date(时间)2023-06-26
 * @Author 家辉
 *
 *
 * 角色业务处理类
 */
public class RoleService implements RoleServiceInterFace {

    /***
     * 添加角色
     * @param roleVel 角色级别
     * @param roleDescribe 角色描述
     * @return
     */
    @Override
    public int addRole(String roleVel ,String roleDescribe) {

        //调用数据访问类
        RoleInterFace dao = new RoleDAO() ;

        //调用实体类
        Role entity = new Role() ;
                entity.setRoleLevel(roleVel) ;
                entity.setRoleDescribe(roleDescribe) ;

        //引用dao方法
        int row = dao.addRole(entity) ;
        //判断
        if(row<1){
            throw new AllException(500,"添加失败") ;
        }


        return row;
    }

    /***
     * 删除角色信息
     * @param id
     * @return
     */
    @Override
    public int deleteRole(int id) {
        //调用数据访问类
        RoleInterFace dao = new RoleDAO() ;

        //引用方法
        int row  = dao.deleteRole(id) ;
        //判断
        if(row<1){
            throw new AllException(500,"删除失败") ;
        }
        //放回
        return row;
    }

    /***
     *
     * @param roleVel 角色级别
     * @param roleDescribe 角色描述
     * @param roleId 角色id
     * @return
     */
    @Override
    public int updateRole(String roleVel, String roleDescribe, int roleId) {
        //调用数据访问类
        RoleInterFace dao = new RoleDAO() ;

        //调用实体类
        Role entity = new Role() ;
        entity.setRoleLevel(roleVel);
        entity.setRoleDescribe(roleDescribe);
        entity.setRoleId(roleId);

        //引用dao方法
       int row = dao.updateRole(entity) ;

       //判断
        if(row<1){
            throw new AllException(500,"修改失败") ;
        }

        //返回结果集
        return row;
    }


    /***
     * 查询所有角色信息
     * @return
     */
    @Override
    public List<Role> listQuery() {
        //调用数据访问类
        RoleInterFace dao = new RoleDAO() ;

        //创建List集合，存放要查询的数据
        List<Role> list = new ArrayList<>() ;

        //引用dao方法
        list = dao.listQuery() ;

        //判断
        if(dao == null){
            throw  new AllException(500,"查询数据空") ;
        }

        //返回结果集
        return list;
    }

    /***
     * 根据条件查询角色信息
     * @param role_level
     * @return
     */
    @Override
    public List<Role> listConditionQuery(String role_level) {
        //调用数据访问类
        RoleInterFace dao = new RoleDAO() ;

        //创建List集合存放要查询的数据
        List<Role> list = new ArrayList<>() ;

        //引用dao方法
        list = dao.listConditionQuery(role_level) ;

        //判断
        if(list == null){
            throw  new AllException(500,"未有查询到信息，请重新查询") ;
        }


        //返回结果集
        return list;
    }
}
