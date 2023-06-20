package top.lldwb.sae.test.liao;

import org.junit.jupiter.api.Test;
import top.lldwb.sae.service.dao.role.RoleInterFace;
import top.lldwb.sae.service.dao.role.impl.RoleDAO;
import top.lldwb.sae.service.entity.rode.RoleEntity;

/***
 * @Date(时间)2023-06-20
 * @Author 家辉
 *
 * 测试已完成
 */
public class RoleTest {
    private static  RoleInterFace face = new RoleDAO() ;

    @Test
    public void addRole(){
        RoleEntity entity = new RoleEntity() ;
        entity.setRoleLevel("9999");
        entity.setRoleDescribe("333");

        System.out.println(face.addRole(entity));

    }

    @Test
    public void updateRole(){
        RoleEntity entity = new RoleEntity() ;
        entity.setRoleLevel("888");
        entity.setRoleDescribe("333");
        entity.setRoleId(1);
        System.out.println(face.updateRole(entity));
    }


    @Test
    public void deleteRole() {

        face.deleteRole(1) ;

    }


    @Test
    public void listQuery(){
        face.listQuery("888") .forEach(System.out::println);

    }
}
