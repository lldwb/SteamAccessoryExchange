package top.lldwb.sae.test.liao;

import org.junit.jupiter.api.Test;
import top.lldwb.sae.dao.purview.PurviewInterFace;
import top.lldwb.sae.dao.purview.impl.PurviewDAO;
import top.lldwb.sae.entity.purview.Purview;
import top.lldwb.sae.service.purview.PurviewServiceInterFace;
import top.lldwb.sae.service.purview.impl.PurviewService;
import top.lldwb.sae.utils.vo.PageVO;

import java.util.List;

/***
 * @Date(时间)2023-06-25
 * @Author 家辉
 *
 * 测试
 */
public class PurviewTest {
    private static  PurviewInterFace face = new PurviewDAO() ;

    /***
     * 添加数据测试
     * 测试通过
     */
    @Test
    public void purviewADD(){

        Purview purview = new Purview() ;
                purview.setPurviewLimitation("2");//权限
                purview.setPurviewDescribe("hello world");//描述
                purview.setRoleId(1); // FK用户id

        System.out.println(face.purviewADD(purview));
    }

    /***
     * 删除测试
     * 测试成功
     */
    @Test
    public void purviewDelete(){

        System.out.println(face.purviewDelete(2,1));

        System.out.println(face.purviewDelete(1));

    }

    /***
     * 修改语句
     *
     * 测试成功
     */
    @Test
   public void purviewUdate() {

        Purview purview = new Purview() ;
        purview.setPurviewLimitation("2");//权限
        purview.setPurviewDescribe("hello world");//描述
        purview.setRoleId(1); // FK用户id
        purview.setPurviewId(11);

        System.out.println(face.purviewUpdate(purview));
   }

    /***
     * 查询全部
     * 测试通过
     */
   @Test
   public void purviewList(){

       List<Purview> list = face.purviewList();
       list.forEach(System.out::println);

   }


    /***
     * 测试通过
     */
    @Test
   public void purviewUserIDQuery(){
       Purview entity = face.purviewUserIDQuery(1);
       System.out.println(entity);
   }

    @Test
   public void purviewUserIDQuerys(){
       PurviewServiceInterFace serviceInterFace = new PurviewService() ;
       System.out.println(serviceInterFace.purviewRoleIDQuery(1));

   }
   @Test
   public void limitQuery(){
       PurviewServiceInterFace serviceInterFace = new PurviewService() ;
       PageVO<List<Purview>> listPageVO = serviceInterFace.queryLimitPurview("","h",1,2) ;
       listPageVO.getData().forEach(System.out::println);
   }
}
