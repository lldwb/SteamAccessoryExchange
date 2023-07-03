package top.lldwb.sae.dao.deal;

import top.lldwb.sae.entity.deal.OfId_AssetId;
import top.lldwb.sae.entity.deal.OrderForm;

import java.util.List;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public interface OrderFormDAO {
    /**
     * 根据用户id返回指定状态的订单的饰品id列表
     *
     * @param ofState 指定状态
     * @param userId  用户id
     * @return
     */
    List<OfId_AssetId> getAssetIdByUserId(int ofState, int userId);

    /**
     * 根据用户id返回指定状态的订单列表
     *
     * @param ofState 指定状态
     * @param userId  用户id
     * @return
     */
    List<OrderForm> getOrderFormByOfStateUserId(int ofState, int userId);

    /**
     * 根据订单id修改订单状态和交易报价id
     *
     * @param ofState      指定状态
     * @param ofId         订单id
     * @param tradeofferId 交易报价id
     */
    void updateOfStateAndTradeofferIdByOfId(int ofState, int ofId, String tradeofferId);
}
