package top.lldwb.sae.utils.mail;

/**
 * 邮箱传输协议类型
 * @author 安然的尾巴
 * @version 1.0
 */
public enum Protocl {
    SMTP("smtp"),
    POP3("POP3");
    final String value;
    Protocl(String value){
        this.value = value;
    }
}
