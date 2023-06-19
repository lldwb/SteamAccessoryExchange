package top.lldwb.sae.service.dao.paymentcenter;
import top.lldwb.sae.service.model.paymentcenter.RechargeWithdrawal;

/**
 * 支付中心接口
 * Author: tianyuan
 * Date: 2023/6/19
 */
public interface RechargeWithdrawalDao {
    /**
     * 充值/提现
     * @param id 用户id
     * @param money 余额
     */
    void recharge(int id,double money);


    /**
     * 根据用户id查询余额
     * @param id 用户id
     * @return
     */
    RechargeWithdrawal getBalance(int id);
}
