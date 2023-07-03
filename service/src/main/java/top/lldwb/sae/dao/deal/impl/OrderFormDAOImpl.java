package top.lldwb.sae.dao.deal.impl;

import top.lldwb.sae.dao.deal.OrderFormDAO;
import top.lldwb.sae.entity.deal.OfId_AssetId;
import top.lldwb.sae.utils.mySql.MySqlUtil;

import java.util.List;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class OrderFormDAOImpl implements OrderFormDAO {
    @Override
    public List<OfId_AssetId> getAssetIdByUserId(int ofState, int userId) {
        return MySqlUtil.queryList(OfId_AssetId.class, "SELECT of_id,asset_id FROM order_form inner join sell on order_form.sell_id = sell.sell_id where of_state = ? && (order_form.user_id = ? || sell.user_id = ?)", ofState, userId, userId);
    }

    @Override
    public void updateOfStateAndTradeofferIdByOfId(int ofId, String tradeofferId) {
        MySqlUtil.update("update order_form set of_state = 4,tradeoffer_id = ? where of_id = ?", tradeofferId, ofId);
    }
}
