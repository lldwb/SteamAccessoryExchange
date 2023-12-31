package top.lldwb.sae.service.paymentcenter.impl;

import top.lldwb.sae.dao.paymentcenter.RechargeWithdrawalDao;
import top.lldwb.sae.entity.paymentcenter.RechargeWithdrawal;
import top.lldwb.sae.dao.paymentcenter.impl.RechargeWithdrawalImpl;
import top.lldwb.sae.service.paymentcenter.RechargeWithdrawalService;

import java.util.List;

/**
 * Author: tianyuan
 * Date: 2023/6/19
 */
public class RechargeWithdrawalServiceImpl implements RechargeWithdrawalService {
    @Override
    public int insertRecharge(RechargeWithdrawal rw) {
        RechargeWithdrawalDao dao = new RechargeWithdrawalImpl();
        return dao.insertRecharge(rw);
    }

    @Override
    public RechargeWithdrawal getBalance(int id) {
        RechargeWithdrawalDao dao = new RechargeWithdrawalImpl();
        RechargeWithdrawal balance = dao.getBalance(id);
        //System.out.println(balance);
        return balance;
    }

    @Override
    public List<RechargeWithdrawal> getRechargeWithdrawal() {
        RechargeWithdrawalDao dao = new RechargeWithdrawalImpl();
        List<RechargeWithdrawal> balance = dao.getRechargeWithdrawal();
        //System.out.println(balance);
        return balance;
    }
}
