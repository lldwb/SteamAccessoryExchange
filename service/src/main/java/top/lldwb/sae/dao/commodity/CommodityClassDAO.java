package top.lldwb.sae.dao.commodity;

import top.lldwb.sae.entity.commodity.CommodityClass;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public interface CommodityClassDAO {
    /**
     * 判断是否存在
     *
     * @param classId 商品父类id
     * @return 不存在返回true
     */
    Boolean judgeExist(String classId);

    void add(CommodityClass commodityClass);
}