package top.lldwb.sae.dao.commodity.impl;

import top.lldwb.sae.dao.commodity.CommodityDAO;
import top.lldwb.sae.entity.commodity.Commodity;
import top.lldwb.sae.utils.mySql.MySqlUtil;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class CommodityDAOImpl implements CommodityDAO {
    @Override
    public Boolean judgeExist(String assetId) {
        return MySqlUtil.<Long>queryColumn(1, "SELECT count(*) FROM commodity WHERE asset_id = ?", assetId) == 0;
    }

    @Override
    public void add(Commodity commodity) {
        MySqlUtil.update("insert into commodity(asset_id,class_id,user_id) value(?,?,?);",commodity.getAssetId(),commodity.getClassId(),commodity.getUserId());
    }
}
