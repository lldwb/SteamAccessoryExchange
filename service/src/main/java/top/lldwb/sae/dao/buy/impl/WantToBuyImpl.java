package top.lldwb.sae.dao.buy.impl;

import top.lldwb.sae.dao.buy.WantToBuyDao;
import top.lldwb.sae.entity.buy.WantToBuy;
import top.lldwb.sae.utils.mySql.MySqlUtil;

import java.util.List;

/**
 * Author: tianyuan
 * Date: 2023/6/28
 */
public class WantToBuyImpl implements WantToBuyDao {
    @Override
    public List<WantToBuy> getWantToBuy(int numberOf, int limit) {
        try {
            String sql = "select wtb_id,wtb_price,wtb_number,wtb_total,co_id,user_id from want_to_buy limit ?,?";
            return MySqlUtil.queryList(WantToBuy.class,sql,numberOf,limit);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    @Override
    public Long getCount() {
        try {
            String sql = "select count(*) from want_to_buy";
            return MySqlUtil.queryColumn(1,sql);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }
}
