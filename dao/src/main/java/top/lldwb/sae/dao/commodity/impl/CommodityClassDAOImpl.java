package top.lldwb.sae.dao.commodity.impl;

import top.lldwb.sae.dao.commodity.CommodityClassDAO;
import top.lldwb.sae.entity.commodity.CommodityClass;
import top.lldwb.sae.entity.commodity.CommodityInstance;
import top.lldwb.sae.utils.mySql.MySqlUtil;

import java.util.List;

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

    @Override
    public void addAll(CommodityClass[] commodityClass) {
//        MySqlUtil.executeBath("insert into commodity_class(class_id, class_name, class_url, class_url_large, class_descriptions, class_actions) value(?,?,?,?,?,?);",);
    }

    @Override
    public List<CommodityClass> ListCommodityClass(String instanceName, int numberOf, int limit) {
        StringBuilder sql = new StringBuilder("SELECT class_id,class_name,class_url,class_url_large,class_descriptions,class_actions FROM commodity_class limit ?,?;");


        if ( instanceName == null ){
            return MySqlUtil.queryList(CommodityClass.class,sql.toString(),numberOf,limit);
        }

        int index = sql.indexOf("limit");
        StringBuilder sqlwhere =  sql.insert(index," WHERE\n" +
                "\tclass_id IN ( SELECT class_id FROM commdoity_class_instance" +
                "  WHERE instance_id IN ( SELECT instance_id FROM commodity_instance WHERE instance_name = ? ) ) ");
        return MySqlUtil.queryList(CommodityClass.class,sqlwhere.toString(),instanceName,numberOf,limit);

    }

    @Override
    public Long count() {
        String sql = "SELECT COUNT(*) FROM commodity_class;";
        return MySqlUtil.queryColumn(1,sql);
    }


}
