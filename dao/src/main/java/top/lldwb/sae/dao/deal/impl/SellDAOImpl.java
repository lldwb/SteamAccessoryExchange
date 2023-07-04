package top.lldwb.sae.dao.deal.impl;

import top.lldwb.sae.dao.deal.SellDAO;
import top.lldwb.sae.entity.deal.Sell;
import top.lldwb.sae.utils.mySql.MySqlUtil;

public class SellDAOImpl implements SellDAO {
    @Override
    public void insert(Sell sell) {
        MySqlUtil.update("insert into Sell(sell_id,sell_price,sell_describe,co_id,user_id) values (?,?,?,?);",sell);
    }
}
