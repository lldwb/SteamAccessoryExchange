package top.lldwb.sae.api.controller.mail;

import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.JsonView;
import top.lldwb.sae.api.vo.PageVO;
import top.lldwb.sae.service.mailEmial.MailEmail_Code;

/***
 * @Date(时间)2023-06-21
 * @Author 家辉
 *
 *
 * 邮件发送controller接口
 */
public class Email_CodeController {

    /***
     *
     * @param EMAIL 发件人邮箱地址
     * @param userEmail 邮箱地址
     *
     */
    @RequestMapping("/user/getEmailCode.do")
        public View getEmailCode(@RequestParam("EMAIL") String EMAIL,
                             @RequestParam("userEmail")String userEmail){
        //调用发送邮箱封装类，调用静态方法
        MailEmail_Code.Mail_Code(EMAIL, "自己的QQ邮箱授权码", "Steam游戏商城", userEmail) ;

        return null;
    }
}
