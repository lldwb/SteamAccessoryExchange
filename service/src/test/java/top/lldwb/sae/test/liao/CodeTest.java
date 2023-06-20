package top.lldwb.sae.test.liao;

import org.junit.jupiter.api.Test;
import top.lldwb.sae.service.dao.code.CodeInterFace;
import top.lldwb.sae.service.dao.code.impl.CodeDAO;

/***
 * @Date(时间)2023-06-20
 * @Author 家辉
 */
public class CodeTest {

    @Test
    public void query(){
        CodeInterFace face = new CodeDAO() ;

        System.out.println(face.query("333333"));


    }





}
