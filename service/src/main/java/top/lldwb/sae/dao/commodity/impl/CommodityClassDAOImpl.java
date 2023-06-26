package top.lldwb.sae.dao.commodity.impl;

import top.lldwb.sae.dao.commodity.CommodityClassDAO;
import top.lldwb.sae.entity.commodity.CommodityClass;
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

    @Override
    public void add(CommodityClass commodityClass) {
        MySqlUtil.update("insert into commodity_class(class_id, class_name, class_url, class_url_large, class_descriptions, class_actions) value(?,?,?,?,?,?);", commodityClass.getClassId(), commodityClass.getClassName(), commodityClass.getClassUrl(), commodityClass.getClassUrlLarge(), commodityClass.getClassDescriptions(), commodityClass.getClassActions());

    }
}
