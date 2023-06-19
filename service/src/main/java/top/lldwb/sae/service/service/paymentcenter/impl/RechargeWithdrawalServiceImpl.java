package top.lldwb.sae.service.service.paymentcenter.impl;

import top.lldwb.sae.service.dao.paymentcenter.RechargeWithdrawalDao;
import top.lldwb.sae.service.dao.paymentcenter.impl.RechargeWithdrawalImpl;
import top.lldwb.sae.service.model.paymentcenter.RechargeWithdrawal;
import top.lldwb.sae.service.service.paymentcenter.RechargeWithdrawalService;

/**
 * Author: tianyuan
 * Date: 2023/6/19
 */
public class RechargeWithdrawalServiceImpl implements RechargeWithdrawalService {
    @Override
    public void recharge(int id ,double money) {
        RechargeWithdrawalDao dao = new RechargeWithdrawalImpl();
        dao.recharge(id, money);
    }

    @Override
    public RechargeWithdrawal getgetBalance(int id) {
        RechargeWithdrawalDao dao = new RechargeWithdrawalImpl();
        return dao.getBalance(id);
    }
}
