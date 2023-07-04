package top.lldwb.sae.entity.buy;

import lombok.Data;
import org.nf.db.util.Column;

import java.math.BigDecimal;

/**
 * Author: tianyuan
 * Date: 2023/6/28
 */
@Data
public class WantToBuy {
    /**
     * 求购ID
     */
    @Column("wtb_id")
    private Integer wtbId;

    /**
     * 价格
     */
    @Column("wtb_price")
    private BigDecimal wtbPrice;

    /**
     * 数量
     */
    @Column("wtb_number")
    private Integer wtbNumber;

    /**
     * 总价
     */
    @Column("wtb_total")
    private BigDecimal wtbTotal;

    /**
     * 商品ID
     */
    @Column("co_id")
    private Integer coId;

    /**
     * 用户ID
     */
    @Column("user_id")
    private Integer userId;
}
