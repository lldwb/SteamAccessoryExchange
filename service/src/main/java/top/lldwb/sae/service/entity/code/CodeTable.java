package top.lldwb.sae.service.entity.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nf.db.util.Column;

import java.sql.Timestamp;

/***
 * @Date(时间)2023-06-20
 * @Author 家辉
 *
 * 验证码实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CodeTable {

    @Column("ctId")
    private int ctId ;//验证码ID
    @Column("ctCode")
    private String ctCode;//非空	验证码
    @Column("ctTime")
    private Timestamp ctTime;//默认当前时间，非空	当前时间
    @Column("ctEffectiveTime")
    private Timestamp ctEffectiveTime;//非空	有效时间
    @Column("ctValidOrNot")
    private int ctValidOrNot	;//非空	是否有效
    @Column("ct_type")
    private int ctType	;//验证类型
    @Column("user_id")
    private int userId	;//	非空，外键	用户id

}
