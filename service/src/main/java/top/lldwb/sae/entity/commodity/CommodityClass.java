package top.lldwb.sae.entity.commodity;

import lombok.Data;
import org.nf.db.util.Column;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
@Data
public class CommodityClass {
    @Column("class_id")
    private String classId;
    @Column("class_name")
    private String className;
    @Column("class_url")
    private String classUrl;
    @Column("class_url_large")
    private String classUrlLarge;
    @Column("class_descriptions")
    private String classDescriptions;
    @Column("class_actions")
    private String classActions;
}
