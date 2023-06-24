package top.lldwb.sae.dao.commodity.impl;

import top.lldwb.sae.dao.commodity.CommodityInstanceDAO;
import top.lldwb.sae.utils.mySql.MySqlUtil;

public class CommodityInstanceDAOImpl implements CommodityInstanceDAO {
    @Override
    public Long queryColumn(String instance_name) {
        MySqlUtil mySqlUtil = new MySqlUtil();
        return mySqlUtil.<Long>queryColumn(1, "select count(*) from commodity_instance where instance_name = ?", instance_name);
    }
}
