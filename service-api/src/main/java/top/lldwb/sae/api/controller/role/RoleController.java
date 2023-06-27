package top.lldwb.sae.api.controller.role;

import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.JsonView;
import top.lldwb.sae.api.vo.ResultVO;
import top.lldwb.sae.entity.rode.Role;
import top.lldwb.sae.service.role.RoleServiceInterFace;
import top.lldwb.sae.service.role.impl.RoleService;

import java.util.List;

/***
 * @Date(时间)2023-06-27
 * @Author 家辉
 *
 *
 * 角色服务器接口
 */
public class RoleController {
    /***
     * 添加数据
     * @return
     */
    @RequestMapping("/role/getAddRole.do")
    public View getAddRole(@RequestParam("roleVel") String roleVel ,
                           @RequestParam("roleDescribe") String roleDescribe) {

        //调用数据业务逻辑类
        RoleServiceInterFace service = new RoleService() ;

        //调用数据响应封装类
        ResultVO<Object> resultVO = new ResultVO<>(200,"添加成功",service.addRole(roleVel,roleDescribe)) ;

        //返回
        return new JsonView(resultVO);
    };

    /***
     * 根据id删除
     * @return
     */
    @RequestMapping("/role/getDeleteRole.do")
    public View  getDeleteRole(@RequestParam("id")int id) {
        //调用数据业务逻辑类
        RoleServiceInterFace service = new RoleService() ;

        //调用数据响应封装类
        ResultVO<Object> resultVO = new ResultVO<>(200,"删除成功",service.deleteRole(id)) ;

        //返回
        return new JsonView(resultVO);
    };

    /***
     * 修改信息
     * @param roleVel 角色级别
     * @param roleDescribe 角色描述
     * @param roleId 角色id
     * @return
     */
    @RequestMapping("/role/getUpdateRole.do")
    public View  getUpdateRole(@RequestParam("roleVel")String roleVel ,
                               @RequestParam("roleDescribe")String roleDescribe,
                               @RequestParam("roleId")int roleId) {
        //调用数据业务逻辑类
        RoleServiceInterFace service = new RoleService() ;

        //调用数据响应封装类
        ResultVO<Object> resultVO = new ResultVO<>(200,"修改成功",service.updateRole(roleVel,roleDescribe,roleId)) ;

        //返回
        return new JsonView(resultVO);
    };
    /***
     * 查询所有数据
     * @return
     */
    @RequestMapping("/role/getListQuery.do")
    public View  getListQuery() {
        //调用数据业务逻辑类
        RoleServiceInterFace service = new RoleService() ;

        //调用数据响应封装类
        ResultVO<Object> resultVO = new ResultVO<>(200,"查询成功",service.listQuery()) ;

        //返回
        return new JsonView(resultVO);
    };

    /***
     * 根据条件查询所有数据
     * @param role_level
     * @return
     */
    @RequestMapping("/role/getListConditionQuery.do")
    public View  getListConditionQuery(@RequestParam("role_level")String role_level) {
        //调用数据业务逻辑类
        RoleServiceInterFace service = new RoleService() ;

        //调用数据响应封装类
        ResultVO<Object> resultVO = new ResultVO<>(200,"查询成功",service.listConditionQuery(role_level)) ;

        //返回
        return new JsonView(resultVO);
    };





}
