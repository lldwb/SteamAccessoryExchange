package top.lldwb.sae.entity.deal;

import lombok.Data;
import org.nf.db.util.Column;

import java.math.BigDecimal;

/**
 * 订单id
 *
 * @author 安然的尾巴
 * @version 1.0
 */
@Data
public class OrderForm {
    /**
     * 订单id
     */
    @Column("of_id")
    private Integer ofId;
    /**
     * 状态(0失败，1成功，2未支付，3未发货，4已发货未收货)
     */
    @Column("of_state")
    private Integer ofState;
    /**
     * 交易报价id
     */
    @Column("tradeoffer_id")
    private String tradeofferId;
    /**
     * 购买用户id
     */
    @Column("user_id")
    private Integer userId;
    /**
     * 出售id
     */
    @Column("sell_id")
    private Integer sellId;
}
