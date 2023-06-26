package top.lldwb.sae.entity.commodity;

import lombok.Data;
import org.nf.db.util.Column;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
@Data
public class CommodityInstance {
    @Column("instance_id")
    private Integer instanceId;
    @Column("parent_id")
    private String parentId;
    @Column("instance_name")
    private String instanceName;
}
