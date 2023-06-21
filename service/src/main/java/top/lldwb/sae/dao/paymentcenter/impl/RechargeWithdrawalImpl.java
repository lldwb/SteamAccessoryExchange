package top.lldwb.sae.dao.paymentcenter.impl;

import top.lldwb.sae.dao.paymentcenter.RechargeWithdrawalDao;
import top.lldwb.sae.entity.paymentcenter.RechargeWithdrawal;
import top.lldwb.sae.utils.MySqlUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Author: tianyuan
 * Date: 2023/6/19
 */
public class RechargeWithdrawalImpl implements RechargeWithdrawalDao {
    @Override
    public  int recharge(RechargeWithdrawal rw) {
        try {
            MySqlUtil mySqlUtil = new MySqlUtil();
            String sql="INSERT INTO recharge_withdrawal(rw_way,rw_amount_of_money,rw_balance,rw_type,user_id,third_party_order_number) VALUES(?,?,?,?,?,?)";
            return mySqlUtil.update(sql,rw.getRwWay(),rw.getRwAmountOfMoney(),rw.getRwBalance(),rw.getRwType(),rw.getUserId(),rw.getThirdPartyOrderNumber());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public RechargeWithdrawal getBalance(int id) {
        try {
            MySqlUtil mySqlUtil = new MySqlUtil();
            String sql = "SELECT rw_id,rw_way,rw_time,rw_amount_of_money,rw_balance,rw_type,user_id,third_party_order_number FROM recharge_withdrawal WHERE user_id = ? ORDER BY rw_time DESC LIMIT 1";
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
