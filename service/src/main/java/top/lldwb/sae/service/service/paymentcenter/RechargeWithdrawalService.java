package top.lldwb.sae.service.service.paymentcenter;

import top.lldwb.sae.service.model.paymentcenter.RechargeWithdrawal;

import java.util.List;

/**
 * Author: tianyuan
 * Date: 2023/6/19
 */
public interface RechargeWithdrawalService {
    /**
     * 充值/提现
     * @param id 用户id
     * @param money 余额
     * @return
     */
    int recharge(int id ,double money );

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
