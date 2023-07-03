package top.lldwb.sae.entity.deal;

import lombok.Data;
import org.nf.db.util.Column;

/**
 * 订单id和商品id关联实体类
 *
 * @author 安然的尾巴
 * @version 1.0
 */
@Data
public class OfId_AssetId {
    /**
     * 订单id
     */
    @Column("of_id")
    Integer ofId;
    /**
     * 商品id
     */
    @Column("asset_id")
    String assetId;
}
