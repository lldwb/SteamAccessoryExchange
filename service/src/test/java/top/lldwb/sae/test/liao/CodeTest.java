package top.lldwb.sae.test.liao;

import org.junit.jupiter.api.Test;
import top.lldwb.sae.service.dao.code.CodeInterFace;
import top.lldwb.sae.service.dao.code.impl.CodeDAO;
import top.lldwb.sae.service.entity.code.CodeTable;
import top.lldwb.sae.service.mailEmial.MailEmail_Code;

/***
 * @Date(时间)2023-06-20
 * @Author 家辉
 */
public class CodeTest {

    @Test
    public void query(){
        CodeInterFace face = new CodeDAO() ;

        System.out.println(face.query("824725"));
    }

    @Test
    public void AddCode(){
        CodeInterFace face = new CodeDAO() ;

        CodeTable entity = new CodeTable() ;
            entity.setCtCode("333333");
            entity.setCtValidOrNot(1);
            entity.setCtType(1);
            entity.setUserId(1);

        System.out.println(face.addCode(entity));


    }

    @Test
    public void Mail() {
        MailEmail_Code.Mail_Code("2026319183@qq.com","输入授权码","Steam游戏商城",1) ;

    }



}
