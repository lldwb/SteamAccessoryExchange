package top.lldwb.sae.service.paymentcenter;

import top.lldwb.sae.entity.paymentcenter.RechargeWithdrawal;

import java.util.List;

/**
 * Author: tianyuan
 * Date: 2023/6/19
 */
public interface RechargeWithdrawalService {
    /**
     * 充值/提现
     * @param rw 对象
     * @return
     */
    int recharge(RechargeWithdrawal rw);

    /**
     * 根据id查询余额
     * @param id 用户id
     * @return
     */
    RechargeWithdrawal getBalance(int id);

    /**
     * 查询全部信息
     * @return
     */
    List<RechargeWithdrawal>  getRechargeWithdrawal();
}