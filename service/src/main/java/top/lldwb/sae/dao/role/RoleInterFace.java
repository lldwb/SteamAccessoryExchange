package top.lldwb.sae.dao.role;

import top.lldwb.sae.entity.rode.Role;

import java.util.List;

/***
 * @Date(时间)2023-06-20
 * @Author 家辉
 *
 * 角色接口
 */
public interface RoleInterFace {
    /***
     * 添加数据
     * @return
     */
    int addRole(Role role) ;

    /***
     * 根据id删除
     * @return
     */
    int deleteRole(int id) ;

    /***
     * 修改
     * @param role
     * @return
     */
    int updateRole(Role role) ;
    /***
     * 查询所有数据
     * @return
     */
    List<Role> listQuery() ;

    /***
     * 根据条件查询所有数据
     * @param role_level
     * @return
     */
    List<Role> listConditionQuery(String role_level) ;


    /***
     * 分页查询
     * @param entity
     * @param number
     * @param limit
     * @return
     */
    List<Role> queryLimitRole(Role entity,int number,int limit) ;

    /***
     * 统计
     * @return
     */
    Long count();

    /***
     * 根据id查询
     * @param id
     * @return
     */
    Role queryRoleId(int id) ;
}
