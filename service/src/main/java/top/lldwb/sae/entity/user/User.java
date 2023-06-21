package top.lldwb.sae.entity.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nf.db.util.Column;

import java.sql.Timestamp;

/**
 * @author 安然的尾巴
 * @version 1.0
 *
 * 实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
/***
 * 家辉
 */
public class User {
    @Column("user_id")
    private int userId;//用户ID
    @Column("user_name")
    private String userName ;//用户名
    @Column("user_email")
    private String userEmail;//邮箱地址
    @Column("user_password")
    private String  userPassword;//用户密码
    @Column("user_nickname")
    private String userNickname;//用户昵称
    @Column("user_phone")
    private String userPhone;//用户手机号
    @Column("user_id_card")
    private String userIdCard;//用户身份证
    @Column("user_state")
    private int userState;//用户状态
    @Column("user_time")
    private Timestamp userTime;//用户创建时间
    @Column("role_id")
    private int roleId;//外键角色表id
    @Column("user_renew_time")
    private Timestamp userRenewTime;//用户修改时间
}
