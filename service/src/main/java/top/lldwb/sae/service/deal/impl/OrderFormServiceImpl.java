package top.lldwb.sae.service.deal.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import top.lldwb.sae.dao.deal.OrderFormDAO;
import top.lldwb.sae.dao.deal.impl.OrderFormDAOImpl;
import top.lldwb.sae.dao.user.impl.UserDAO;
import top.lldwb.sae.entity.deal.OfId_AssetId;
import top.lldwb.sae.service.deal.OrderFormService;
import top.lldwb.sae.utils.http.ConnectionMethod;
import top.lldwb.sae.utils.http.ConnectionUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class OrderFormServiceImpl implements OrderFormService {
    @Override
    public void refresh(int userId) {
        try {
            /** 检测未发货的订单 **/
            OrderFormDAO orderFormDAO = new OrderFormDAOImpl();
            List<OfId_AssetId> orderForm = orderFormDAO.getAssetIdByUserId(3, userId);
            if (!orderForm.isEmpty()) {
                String steamKey = new UserDAO().getSteamKeyById(userId);
                // 设置交易报价
                ConnectionUtil connectionUtil = new ConnectionUtil("http://api.steampowered.com/IEconService/GetTradeOffers/v1");
                // 查询条件
                Map<String, String> where = new HashMap<>();
                // 用户秘钥
                where.put("key", steamKey);
                // 语言
                where.put("language", "schinese");
                // 获取已发送的交易报价(1/0)
                where.put("get_sent_offers", "1");
                // 获取已接收的交易报价(1/0)
                where.put("get_received_offers", "1");
                // 指示我们仅返回仍有效的报价(1/0)
                where.put("active_only", "1");

                // 获取结果
                BufferedReader reader = connectionUtil.getBufferedWriter(ConnectionMethod.GET, where);
                // 对结果进行解析
                Map<String, Object> data = new ObjectMapper().readValue(reader.readLine(), Map.class);
                Map<String, Object> response = (Map<String, Object>) data.get("response");
                // 发送的所有交易报价
                List<Map<String, Object>> tradeOffersSent = (List<Map<String, Object>>) response.get("trade_offers_sent");
                List<Map<String, Object>> tradeOffersReceived = (List<Map<String, Object>>) response.get("trade_offers_received");
                tradeOffersSent.forEach(map -> {
//                    System.out.println(map);
//                    System.out.println(2 == (Integer) map.get("trade_offer_state") || 3 == (Integer) map.get("trade_offer_state"));
//                    System.out.println(map.get("trade_offer_state"));
                    // 判断是否有效交易报价
                    if (2 == (Integer) map.get("trade_offer_state") || 3 == (Integer) map.get("trade_offer_state")) {
                        // 获取饰品列表
                        List<Map<String, Object>> itemsToGive = (List<Map<String, Object>>) map.get("items_to_give");
                        System.out.println(itemsToGive);
                        // 遍历饰品列表
                        itemsToGive.forEach(itemsToGiveMap -> {
                            System.out.println(itemsToGiveMap);
                            orderForm.forEach(ofIdAssetId -> {
                                System.out.println(ofIdAssetId);
                                if (ofIdAssetId.getAssetId().equals(itemsToGiveMap.get("assetid"))) {
                                    orderFormDAO.updateOfStateAndTradeofferIdByOfId(ofIdAssetId.getOfId(), (String) map.get("tradeofferid"));
                                }
                            });
                        });
                    }
                });
            }


            /** 检测已发货的订单 **/
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
