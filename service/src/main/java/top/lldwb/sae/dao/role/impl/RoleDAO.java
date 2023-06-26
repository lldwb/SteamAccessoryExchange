package top.lldwb.sae.dao.role.impl;

import top.lldwb.sae.entity.rode.RoleEntity;
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
     * 调用工具类
     */
    MySqlUtil mySqlUtil;

    {
        mySqlUtil = new MySqlUtil();
    }

    /***
     * 添加数据
     * @return
     */
    @Override
    public int addRole(RoleEntity role) {
        //创建Object数组存放要添加的数据
        Object[] obj = {
                role.getRoleLevel(),
                role.getRoleDescribe()

        };

        //获取sql语句
        String sql = "insert into role(role_level,role_describe)values(?,?)" ;

        //返回
        return mySqlUtil.update(sql,obj);
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
        return mySqlUtil.update(sql,id);
    }

    /***
     * 修改数据
     * @param role
     * @return
     */
    @Override
    public int updateRole(RoleEntity role) {
        //创建Object数组存放要修改的数据
        Object[] obj = {
                role.getRoleLevel(),
                role.getRoleDescribe(),
                role.getRoleId()
        };

        //获取sql语句
        String sql = "update role set role_level = ?,role_describe = ? where role_id = ?" ;

        //返回
        return mySqlUtil.update(sql,obj);
    }

    /***
     * 查询所有数据
     * @param role_level
     * @return
     */
    @Override
    public List<RoleEntity> listQuery(String role_level) {

        //获取查询语句
        String sql = "select role_id,role_level,role_describe from role where role_level = ?" ;
        //返回
        return mySqlUtil.queryList(RoleEntity.class,sql,role_level);
    }
}
