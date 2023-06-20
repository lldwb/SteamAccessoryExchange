package top.lldwb.sae.service.service.paymentcenter;

import top.lldwb.sae.service.model.paymentcenter.RechargeWithdrawal;

import java.util.List;

/**
 * Author: tianyuan
 * Date: 2023/6/19
 */
public interface RechargeWithdrawalService {
    void recharge(int id ,double money );

    RechargeWithdrawal getBalance(int id);

    List<RechargeWithdrawal>  getRechargeWithdrawal();
}
