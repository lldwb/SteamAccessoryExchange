package top.lldwb.sae.service.dao.paymentcenter.impl;

import org.nf.db.util.SqlExecutor;
import top.lldwb.sae.service.dao.paymentcenter.RechargeWithdrawalDao;
import top.lldwb.sae.service.model.paymentcenter.RechargeWithdrawal;
import top.lldwb.sae.utils.MySqlUtil;

import java.sql.SQLException;

/**
 * Author: tianyuan
 * Date: 2023/6/19
 */
public class RechargeWithdrawalImpl implements RechargeWithdrawalDao {
    @Override
    public  void recharge(int id, double money) {
        try {
            MySqlUtil mySqlUtil = new MySqlUtil();
            String sql="update recharge_withdrawal set rwBalance =? where rwId =?";
            mySqlUtil.update(sql,money,id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public RechargeWithdrawal getBalance(int id) {
        try {
            MySqlUtil mySqlUtil = new MySqlUtil();
            String sql = "SELECT rwId,rwWay,rwTime,rwAmountOfMoney,rwBalance,rwType,userId,thirdPartyOrderNumber FROM recharge_withdrawal where rwId =?";
            return mySqlUtil.queryT(new RechargeWithdrawal(), sql, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
