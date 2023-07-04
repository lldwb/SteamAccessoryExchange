package top.lldwb.sae.entity.code;

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

    @Column("ct_id")
    private Integer ctId ;//验证码ID
    @Column("ct_code")
    private String ctCode;//非空	验证码
    @Column("ct_time")
    private Timestamp ctTime;//默认当前时间，非空	当前时间
    @Column("ct_effective_time")
    private Timestamp ctEffectiveTime;//非空	有效时间
    @Column("ct_Valid_or_not")
    private Integer ctValidOrNot	;//非空	是否有效
    @Column("ct_type")
    private Integer ctType	;//验证类型
    @Column("user_id")
    private Integer userId	;//	非空，外键	用户id

}
