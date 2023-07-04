package top.lldwb.sae.entity.purview;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nf.db.util.Column;

/***
 * @Date(时间)2023-06-25
 * @Author 家辉
 *
 * 权限表实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurviewTwo {
    @Column("purview_id")
    private int purviewId	;//主键,自增1,非空	权限ID
    @Column("purview_limitation")
    private String purviewLimitation	;//	非空	限制
    @Column("purview_describe")
    private String purviewDescribe	;//	非空	描述
    @Column("role_id")
    private int roleId	;//外键	用户id

    @Column("role_level")
    private String roleLevel;//角色级别

}
