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
public class Purview {
    @Column("purview_id")
    private int purview_id	;//主键,自增1,非空	权限ID
    @Column("purview_limitation")
    private String purview_limitation	;//	非空	限制
    @Column("purview_describe")
    private String purview_describe	;//	非空	描述
    @Column("user_id")
    private int user_id	;//外键	用户id

}
