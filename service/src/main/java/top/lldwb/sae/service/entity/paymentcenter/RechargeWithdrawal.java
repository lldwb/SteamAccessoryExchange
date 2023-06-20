package top.lldwb.sae.service.entity.paymentcenter;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nf.db.util.Column;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Author: tianyuan
 * Date: 2023/6/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RechargeWithdrawal {
    /**
     * ID
     */
    @Column("rw_id")
    private Integer rwId;

    /**
     * 支付方式·
     */
    @Column("rw_way")
    private Integer rwWay;

    /**
     * 支付/提现时间
     */
    @Column("rw_time")
    private Date rwTime;

    /**
     * 金额
     */
    @Column("rw_amount_of_money")
    private BigDecimal rwAmountOfMoney;

    /**
     * 余额
     */
    @Column("rw_balance")
    private BigDecimal rwBalance;

    /**
     * 类型（充值/提现）
     */
    @Column("rw_type")
    private Integer rwType;

    /**
     * 用户id
     */
    @Column("user_id")
    private Integer userId;

    /**
     * 第三方订单号
     */
    @Column("third_party_order")
    private Integer thirdPartyOrder;
}
