package top.lldwb.sae.dao.commodity.impl;

import top.lldwb.sae.dao.commodity.CommodityClassDAO;
import top.lldwb.sae.utils.mySql.MySqlUtil;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class CommodityClassDAOImpl implements CommodityClassDAO {
    @Override
    public Boolean judgeExist(String classId) {
        return MySqlUtil.<Long>queryColumn(1, "SELECT count(*) FROM commodity_class WHERE class_id = ?", classId) == 0;
    }
}
