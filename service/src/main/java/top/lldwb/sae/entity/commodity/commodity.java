package top.lldwb.sae.entity.commodity;

import lombok.Data;
import org.nf.db.util.Column;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
@Data
public class commodity {
    @Column("co_id")
    private Integer coId;
    @Column("asset_id")
    private String assetId;
    @Column("class_id")
    private String classId;
    @Column("user_id")
    private Integer userId;
}
