package top.lldwb.sae.utils.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 邮箱发送工具类+多线程调用外网邮件发送
 *
 * @author lldwb
 * @date 2023/4/19
 */
public class Mail {

    /**
     * 邮件发送
     * 创建Session调用send发送
     *
     * @param reception 接收邮箱
     * @param subject   邮件标题
     * @param text      邮件正文
     */
    public static void sendSession(String reception, String subject, String text) {
        // 发送邮箱服务器
        String server = "mail.lldwb.top";
        // 发送邮箱
        String sendMail = "lldwb@lldwb.top";
        // 发送邮箱密码
        String sendPasswd = "LLdwb15979809462";
        // 服务器端口
        int port = 465;
        // STARTTLS 协议
        boolean starttls = true;
        Mail.sendSession(reception, subject, text, server, sendMail, sendPasswd, Protocl.SMTP, port, starttls);
    }

    /**
     * 邮件发送
     * 创建Session调用send发送
     *
     * @param reception  接收邮箱
     * @param subject    邮件标题
     * @param text       邮件正文
     * @param server     发送邮箱服务器
     * @param sendMail   发送邮箱
     * @param sendPasswd 发送邮箱密码
     * @param protocl   邮箱传输协议，默认smtp
     * @param port       服务器端口，默认465
     * @param starttls   STARTTLS 协议，默认true
     */
    public static void sendSession(String reception, String subject, String text, String server, String sendMail, String sendPasswd, Protocl protocl, int port, boolean starttls) {
        // 创建邮件会话
        Properties props = new Properties();

        // 设置邮箱服务器配置
        props.setProperty("mail.host", server);// 服务器
        props.setProperty("mail.transport.protocol", protocl.value);// 邮箱传输协议
        props.setProperty("mail.port", String.valueOf(port));// 服务器端口
        props.setProperty("mail.starttls.enable", String.valueOf(starttls));// STARTTLS协议

        // 产生一个用于邮件发送的Session对象并调用send
        new Thread(() ->
                send(Session.getInstance(props), reception, subject, text, sendMail, sendPasswd,protocl)).start();
        // 主线程继续执行其他任务
    }

    /**
     * 邮件发送
     *
     * @param session    Session对象
     * @param reception  接收邮箱
     * @param subject    邮件标题
     * @param text       邮件正文
     * @param sendMail   发送邮箱
     * @param sendPasswd 发送邮箱密码
     * @param protocl   邮箱传输协议，默认smtp
     */
    private static void send(Session session, String reception, String subject, String text, String sendMail, String sendPasswd, Protocl protocl) {
        // 创建邮件消息
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(sendMail));
            // TO 直接发送 CC抄送 BCC密送
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reception));
            message.setSubject(subject);// 邮件标题
            message.setText(text);// 邮件正文
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        // 创建用于SMTP邮件传输的Transport对象
        try {
            Transport transport  = session.getTransport(protocl.value);
            // 连接到SMTP邮件服务器
            transport.connect(sendMail, sendPasswd);
            // 发送包含在MimeMessage对象中的邮件
            transport.sendMessage(message, message.getAllRecipients());
            // 关闭连接
            transport.close();
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
