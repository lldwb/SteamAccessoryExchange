package top.lldwb.sae.service.dao.role;

import top.lldwb.sae.service.entity.rode.RoleEntity;

import javax.management.relation.Role;
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
    int addRole(RoleEntity role) ;

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
    int updateRole(RoleEntity role) ;

    /***
     * 根据级别查询
     * @param role_level
     * @return
     */
    List<RoleEntity> listQuery( String role_level) ;



}
