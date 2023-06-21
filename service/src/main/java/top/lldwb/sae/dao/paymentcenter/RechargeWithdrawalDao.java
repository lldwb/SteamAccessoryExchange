package top.lldwb.sae.dao.paymentcenter;
import top.lldwb.sae.entity.paymentcenter.RechargeWithdrawal;

import java.util.List;

/**
 * 支付中心接口
 * Author: tianyuan
 * Date: 2023/6/19
 */
public interface RechargeWithdrawalDao {
    /**
     * 充值/提现
     * @param rw 对象
     */
    int recharge(RechargeWithdrawal rw);


    /**
     * 根据用户id查询余额
     * @param id 用户id
     * @return
     */
    RechargeWithdrawal getBalance(int id);

    /**
     * 查询所有的数据
     * @return
     */
    List<RechargeWithdrawal> getRechargeWithdrawal();
}
