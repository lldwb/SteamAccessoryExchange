package top.lldwb.sae.service.dao.paymentcenter.impl;

import org.nf.db.util.SqlExecutor;
import top.lldwb.sae.service.dao.paymentcenter.RechargeWithdrawalDao;
import top.lldwb.sae.service.model.paymentcenter.RechargeWithdrawal;
import top.lldwb.sae.utils.MySqlUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Author: tianyuan
 * Date: 2023/6/19
 */
public class RechargeWithdrawalImpl implements RechargeWithdrawalDao {
    @Override
    public  int recharge(int id, double money) {
        try {
            MySqlUtil mySqlUtil = new MySqlUtil();
            String sql="update recharge_withdrawal set rw_balance =? where rw_id =?";
            return mySqlUtil.update(sql, money, id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public RechargeWithdrawal getBalance(int id) {
        try {
            MySqlUtil mySqlUtil = new MySqlUtil();
            String sql = "SELECT rw_id,rw_way,rw_time,rw_amount_of_money,rw_balance,rw_type,user_id,third_party_order_number FROM recharge_withdrawal where rw_id =?";
            return mySqlUtil.queryT(RechargeWithdrawal.class, sql, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<RechargeWithdrawal> getRechargeWithdrawal() {
        MySqlUtil mySqlUtil = null;
        try {
            mySqlUtil = new MySqlUtil();
            String sql = "SELECT rw_id,rw_way,rw_time,rw_amount_of_money,rw_balance,rw_type,user_id,third_party_order_number FROM recharge_withdrawal";
            return mySqlUtil.queryList(RechargeWithdrawal.class, sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
