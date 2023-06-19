package top.lldwb.sae.api.controller.Paymentcenter.rechargewithdrawal;

import top.lldwb.sae.api.entity.RechargeWithdrawal;

/**
 * 支付中心接口
 * Author: tianyuan
 * Date: 2023/6/19
 */
public interface RechargeWithdrawalService {
    /**
     * 充值
     * @param id 用户id
     * @param money 充值金额
     */
    void recharge(int id,double money);

    /**
     * 提现
     * @param id 用户id
     * @param money 提现金额
     */
    void withdrawal(int id, double money);

    /**
     * 根据用户id查询余额
     * @param id 用户id
     * @return
     */
    RechargeWithdrawal getBalance(int id);
}
