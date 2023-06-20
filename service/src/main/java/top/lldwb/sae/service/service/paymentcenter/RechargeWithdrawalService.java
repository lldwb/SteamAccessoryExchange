package top.lldwb.sae.service.service.paymentcenter;

import top.lldwb.sae.service.entity.paymentcenter.RechargeWithdrawal;

/**
 * Author: tianyuan
 * Date: 2023/6/19
 */
public interface RechargeWithdrawalService {
    void recharge(int id ,double money );

    RechargeWithdrawal getgetBalance(int id);
}
