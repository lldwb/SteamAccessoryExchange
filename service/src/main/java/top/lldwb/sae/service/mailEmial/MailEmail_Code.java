package top.lldwb.sae.service.mailEmial;

import top.lldwb.sae.service.dao.code.CodeInterFace;
import top.lldwb.sae.service.dao.code.impl.CodeDAO;
import top.lldwb.sae.service.entity.code.CodeTable;
import top.lldwb.sae.service.service.code.CodeTableInterFace;
import top.lldwb.sae.service.service.code.impl.CodeTableService;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

/***
 * @Date(时间)2023-06-20
 * @Author 家辉
 */
public class MailEmail_Code {

    public static MimeMessage createMimeMessage(Session session, String fromAccount, String toAccount, String name, String ZHUTI, String staff_name)
            throws Exception {
        // 1.创建邮件对象
        MimeMessage message = new MimeMessage(session);
        // 2.设置发件⼈，其中 InternetAddress 有三个参数，分别为：邮箱，显示的昵称，昵称的字符集编码
        message.setFrom(new InternetAddress(fromAccount, staff_name, "UTF-8"));

        // 3.设置收件⼈ - MimeMessage.RecipientType.TO
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(toAccount ,name, "UTF-8"));

        // 7.设置邮件主题
        message.setSubject("验证码:"+name,"UTF-8");

        // 8.设置邮件正⽂内容，指定格式为HTML格式
        message.setContent(ZHUTI, "text/html;charset=UTF-8");
        // 9.设置显示发件时间
        message.setSentDate(new Date());

        // 10.保存设置
        message.saveChanges();

        return message;
    }



    /***
     *
     * @param EMAIL 发件人邮箱地址
     * @param AUTHORIZECODE 授权码
     * @param Verify_NAME 发件标题
     * @param userEmail 邮箱地址
     *
     */
    public static void Mail_Code (String EMAIL,String AUTHORIZECODE,String Verify_NAME,String userEmail){
        //发送邮箱验证

        /**
         * 发件⼈邮箱地址
         */
        String SEND_ACCOUNT =EMAIL ;
        /**
         * 发件⼈邮箱密码 - 登录邮件开启 SMTP 服务后，邮件服务商⽣成的“授权码”
         */
        String SEND_PASSWORD = AUTHORIZECODE;//授权码
        /**
         * 发件⼈SMTP服务器地址，⼀般的格式为：smtp.xxx.com，其中xxx为邮件服务商名称
         */
        String SMTP_HOST = "smtp.qq.com";
        /**
         * 收件⼈邮箱地址
         * xxx@qq.com
         */
        String RECEIVE_ACCOUNT = EMAIL;

        //发件标题,'如：校园论坛'
        String Verify= Verify_NAME;

        //收件人姓名 ，如‘张三’
        String NAME = EMAIL+"用户";



        //生成随机数 六位
        Random random = new Random();
        int randomNumber = random.nextInt(900000) + 100000;
        //转换一下随机数
        String name = String.valueOf(randomNumber);

        //验证码数据访问类
        CodeTableInterFace face = new CodeTableService() ;
        //调用方法
        face.loginaddCode(name,userEmail) ;



        //发送的主题
        String ZHUTI = "Steam游戏饰品商城："+name;

        // 参数配置，⽤于连接邮件服务器
        Properties props = new Properties();
        // 使⽤协议
        props.setProperty("mail.transport.protocol", "smtp");
        // 发件⼈邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.host", SMTP_HOST);
        // 需要请求认证
        props.setProperty("mail.smtp.auth", "true");
        // 创建会话对象，⽤于与邮箱服务器交互
        Session sessions = Session.getInstance(props);
        // 设置为debug模式，在控制台中可以查看详细的发送⽇志
        sessions.setDebug(true);

        try {
            //创建一封邮件
            MimeMessage message = createMimeMessage(sessions, SEND_ACCOUNT, RECEIVE_ACCOUNT,NAME,ZHUTI,Verify);

            // 根据 Session 获取邮件传输对象
            Transport transport = sessions.getTransport();
            // 连接邮件服务器
            transport.connect(SEND_ACCOUNT, SEND_PASSWORD);
            // 发送邮件
            transport.sendMessage(message, message.getAllRecipients());
            // 关闭连接
            transport.close();



        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
