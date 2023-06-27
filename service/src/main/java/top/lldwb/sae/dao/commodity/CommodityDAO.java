package top.lldwb.sae.dao.commodity;

import top.lldwb.sae.entity.commodity.Commodity;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public interface CommodityDAO {
    /**
     * 判断是否存在
     *
     * @param assetId 商品父类id
     * @return 不存在返回true
     */
    Boolean judgeExist(String assetId);
    void add(Commodity commodity);
}
