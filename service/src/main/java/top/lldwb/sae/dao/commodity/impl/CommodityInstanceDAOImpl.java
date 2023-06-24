package top.lldwb.sae.dao.commodity.impl;

import top.lldwb.sae.dao.commodity.CommodityInstanceDAO;
import top.lldwb.sae.utils.mySql.MySqlUtil;

public class CommodityInstanceDAOImpl implements CommodityInstanceDAO {
    @Override
    public Boolean judgeExist(String name) {
        MySqlUtil mySqlUtil = new MySqlUtil();
        return mySqlUtil.<Long>queryColumn(1, "SELECT count(*) FROM commodity_instance WHERE instance_name = ?", name) == 0;
    }

    @Override
    public Integer getIdByName(String name) {
        return MySqlUtil.<Integer>queryColumn(1, "select instance_id from commodity_instance where instance_name = ?", name);
    }

    @Override
    public void add(String name) {
        MySqlUtil.update("insert into commodity_instance(instance_name) VALUES(?);", name);
    }

    @Override
    public void add(String name, Integer parent_id) {
        MySqlUtil.update("insert into commodity_instance(instance_name,parent_id) VALUES(?,?);", name, parent_id);
    }
}
