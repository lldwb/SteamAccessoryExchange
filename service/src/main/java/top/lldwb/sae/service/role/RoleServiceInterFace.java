package top.lldwb.sae.service.role;

import top.lldwb.sae.entity.rode.Role;
import top.lldwb.sae.utils.vo.PageVO;

import java.util.List;

/***
 * @Date(时间)2023-06-26
 * @Author 家辉
 *
 *
 * 角色接口
 */
public interface RoleServiceInterFace {
    /***
     * 添加数据
     * @return
     */
    int addRole(String roleVel ,String roleDescribe) ;

    /***
     * 根据id删除
     * @return
     */
    int deleteRole(int id) ;

    /***
     * 修改信息
     * @param roleVel 角色级别
     * @param roleDescribe 角色描述
     * @param roleId 角色id
     * @return
     */
    int updateRole(String roleVel ,String roleDescribe,int roleId) ;
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

     PageVO<List<Role>> pagseRoleVoList(String roleLevel, int page, int limit) ;

    /***
     * 根据id查询
     * @param id
     * @return
     */
     Role queryRoleId(int id) ;
}
