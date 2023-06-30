package top.lldwb.sae.dao.role.impl;

import top.lldwb.sae.entity.rode.Role;
import top.lldwb.sae.dao.role.RoleInterFace;
import top.lldwb.sae.utils.mySql.MySqlUtil;

import java.util.List;

/***
 * @Date(时间)2023-06-20
 * @Author 家辉
 *
 * 角色数据访问类
 */
public class RoleDAO implements RoleInterFace {

    /***
     * 添加数据
     * @return
     */
    @Override
    public int addRole(Role role) {
        //创建Object数组存放要添加的数据
        Object[] obj = {
                role.getRoleLevel(),
                role.getRoleDescribe()

        };
        //获取sql语句
        String sql = "insert into role(role_level,role_describe)values(?,?)" ;

        //返回
        return MySqlUtil.update(sql,obj);
    }

    /***
     * 删除数据
     * @param id
     * @return
     */
    @Override
    public int deleteRole(int id) {

        //获取sql语句
        String sql = " delete from role where role_id = ?" ;
        //放回
        return MySqlUtil.update(sql,id);
    }

    /***
     * 修改数据
     * @param role
     * @return
     */
    @Override
    public int updateRole(Role role) {
        //创建Object数组存放要修改的数据
        Object[] obj = {
                role.getRoleLevel(),
                role.getRoleDescribe(),
                role.getRoleId()
        };

        //获取sql语句
        String sql = "update role set role_level = ?,role_describe = ? where role_id = ?" ;

        //返回
        return MySqlUtil.update(sql,obj);
    }

    /***
     * 查询所有数据
     * @return
     */
    @Override
    public List<Role> listQuery() {

        //获取查询语句
        String sql = "select role_id,role_level,role_describe from role" ;

        return MySqlUtil.queryList(Role.class,sql);
    }


    /***
     * 根据条件查询所有数据
     * @param role_level
     * @return
     */
    @Override
    public List<Role> listConditionQuery(String role_level) {

        //获取查询语句
        String sql = "select role_id,role_level,role_describe from role where role_level = ?" ;
        //返回
        return MySqlUtil.queryList(Role.class,sql,role_level);
    }

    @Override
    public List<Role> queryLimitRole(Role entity, int number, int limit) {
        //获取sql语句
        StringBuilder sql = new StringBuilder() ;
        sql.append("select role_id,role_level,role_describe from role ") ;

        //判断一下是否输入了条件
        if(entity!=null && entity.getRoleLevel() !=null && !"".equals(entity.getRoleLevel().trim())){
            sql.append("where role_level like ?") ;
            sql.append("limit ?,?") ;
            return MySqlUtil.queryList(Role.class,sql.toString(),"%"+entity.getRoleLevel()+"%",number,limit);
        }
        return queryLimitRecursionRole(number,limit);
    }


    public List<Role> queryLimitRecursionRole( int number, int limit) {
        //获取sql语句
        StringBuilder sql = new StringBuilder() ;
        sql.append("select role_id,role_level,role_describe from role limit ?,?") ;
        return MySqlUtil.queryList(Role.class,sql.toString(),number,limit);
    }

    @Override
    public Long count() {
        String sql = "select COUNT(*) from role" ;

        return MySqlUtil.queryColumn(1,sql) ;
    }

}
