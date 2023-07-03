package top.lldwb.sae.dao.sell.impl;

import top.lldwb.sae.dao.sell.SellDao;
import top.lldwb.sae.entity.sell.Sell;
import top.lldwb.sae.utils.mySql.MySqlUtil;

import java.util.List;

/**
 * Author: tianyuan
 * Date: 2023/6/24
 */
public class SellImpl implements SellDao {
    @Override
    public List<Sell> getSell(int numberOf , int limit) {
        try {
            MySqlUtil mySqlUtil = new MySqlUtil();
            String sql ="select sell_id,sell_price,sell_describe,co_id,user_id from sell limit ?,?";
            return mySqlUtil.queryList(Sell.class,sql,numberOf,limit);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Long getCount() {
        try {
            String sql ="select count(*) from sell";
            return MySqlUtil.queryColumn(1,sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
