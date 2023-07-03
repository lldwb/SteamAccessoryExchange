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

    /**
     * 添加商品
     * @param commodity
     */
    void add(Commodity commodity);

    /**
     * 根据用户名修改用户状态
     * @param coState 状态
     * @param userId 用户id
     */
    void updateStateByUserId(int coState,int userId);

    /**
     * 根据商品唯一id修改状态
     * @param coState 状态
     * @param assetId 唯一id
     */
    void updateStateByAssetId(int coState,String assetId);
}
