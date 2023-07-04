package top.lldwb.sae.entity.deal;

import lombok.Data;
import org.nf.db.util.Column;

import java.math.BigDecimal;

/**
 * Author: tianyuan
 * Date: 2023/6/24
 */
@Data
public class Sell {
    /**
     * 出售ID
     */
    @Column("sell_id")
    private Integer sellId;

    /**
     * 价格
     */
    @Column("sell_price")
    private BigDecimal sellPrice;

    /**
     * 描述
     */
    @Column("sell_describe")
    private String sellDescribe;

    /**
     * 商品id
     */
    @Column("co_id")
    private Integer coId;

    /**
     * 用户id
     */
    @Column("user_id")
    private Integer userId;
}
