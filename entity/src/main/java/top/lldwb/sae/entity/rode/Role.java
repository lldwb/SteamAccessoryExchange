package top.lldwb.sae.entity.rode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nf.db.util.Column;

/***
 * @Date(时间)2023-06-20
 * @Author 家辉
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {
    @Column("role_id")
    private int roleId ;//	角色ID
    @Column("role_level")
    private String roleLevel ;//	非空	级别
    @Column("role_describe")
    private String  roleDescribe ;//非空	描述

}
