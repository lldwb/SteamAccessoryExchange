package top.lldwb.sae.dao.commodityclass.impl;

import top.lldwb.sae.dao.commodityclass.CommodityClassDAO;
import top.lldwb.sae.entity.commodityclass.CommodityClass;
import top.lldwb.sae.utils.mySql.MySqlUtil;


import java.util.List;

/**
 * @version v1.0
 * @Date 2023/6/28 19:51
 * @Author xiao
 */
public class CommodityClassImpl implements CommodityClassDAO {

    @Override
    public List<CommodityClass> listCommodityClassDAO(int numberOf, int limit) {
        try {
            String sql ="SELECT\n" +
                    "\tclass_id,\n" +
                    "\tclass_name,\n" +
                    "\tclass_url,\n" +
                    "\tclass_url_large,\n" +
                    "\tclass_descriptions,\n" +
                    "\tclass_actions \n" +
                    "FROM\n" +
                    "\tcommodity_class " +
                    "LIMIT ?,?;" ;
            return MySqlUtil.queryList(CommodityClass.class, sql,numberOf,limit);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Long count() {
        String sql = "select count(*) from commodity_class; ";
        return MySqlUtil.queryColumn(1,sql);
    }
}
