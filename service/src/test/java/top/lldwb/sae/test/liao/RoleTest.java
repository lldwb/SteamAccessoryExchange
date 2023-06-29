package top.lldwb.sae.test.liao;

import org.junit.jupiter.api.Test;
import top.lldwb.sae.dao.role.RoleInterFace;
import top.lldwb.sae.dao.role.impl.RoleDAO;
import top.lldwb.sae.entity.rode.Role;
import top.lldwb.sae.pagingUtil.PagingUtil;
import top.lldwb.sae.service.role.RoleServiceInterFace;
import top.lldwb.sae.service.role.impl.RoleService;
import top.lldwb.sae.vo.PageVO;

import java.util.ArrayList;
import java.util.List;

/***
 * @Date(时间)2023-06-20
 * @Author 家辉
 *
 * 测试已完成
 */
public class RoleTest {
    private static  RoleInterFace face = new RoleDAO() ;
    /***
     * 添加测试通过
     */
    @Test
    public void addRole(){
        Role entity = new Role() ;
        entity.setRoleLevel("9999");
        entity.setRoleDescribe("333");

        System.out.println(face.addRole(entity));

    }
    /***
     * 修改试通过
     */
    @Test
    public void updateRole(){
        Role entity = new Role() ;
        entity.setRoleLevel("888");
        entity.setRoleDescribe("333");
        entity.setRoleId(1);
        System.out.println(face.updateRole(entity));
    }

    /***
     * 删除测试通过
     */
    @Test
    public void deleteRole() {

        face.deleteRole(1) ;

    }

    /***
     * 查询所有测试通过
     */
    @Test
    public void listQuery(){
        List<Role> list = face.listQuery();
        list.forEach(System.out::println);
    }


    /***
     * 条件查询测试通过
     */
    @Test
    public void listConditionQuery(){
        face.listConditionQuery("888") .forEach(System.out::println);

    }

    @Test
    public void limitQuery(){

        RoleServiceInterFace serviceInterFace = new RoleService() ;
        PageVO<List<Role>> listPageVO = serviceInterFace.pagseRoleVoList(1,1,4) ;
       listPageVO.getData().forEach(System.out::println);

    }

    @Test
    public void count(){
        System.out.println(face.count());
    }
}
