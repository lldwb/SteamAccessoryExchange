package top.lldwb.sae.service.deal.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import top.lldwb.sae.dao.deal.OrderFormDAO;
import top.lldwb.sae.dao.deal.impl.OrderFormDAOImpl;
import top.lldwb.sae.dao.user.impl.UserDAO;
import top.lldwb.sae.entity.deal.OfId_AssetId;
import top.lldwb.sae.entity.deal.OrderForm;
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
            /* 检测未发货的订单 **/
            System.out.println("检测未发货的订单");
            OrderFormDAO orderFormDAO = new OrderFormDAOImpl();
            List<OfId_AssetId> ofId_AssetId = orderFormDAO.getAssetIdByUserId(3, userId);
            String steamKey = new UserDAO().getSteamKeyById(userId);
            if (ofId_AssetId != null) {
                // 设置交易报价
                ConnectionUtil connectionUtil = new ConnectionUtil("https://api.steampowered.com/IEconService/GetTradeOffers/v1");
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
                // 接收的所有交易报价
                List<Map<String, Object>> tradeOffersReceived = (List<Map<String, Object>>) response.get("trade_offers_received");
                class ForEach {
                    public void foEach(Map<String, Object> map) {
                        // 判断是否有效交易报价
                        if (2 == (Integer) map.get("trade_offer_state") || 3 == (Integer) map.get("trade_offer_state")) {
                            // 获取饰品列表
                            List<Map<String, Object>> itemsToGive = (List<Map<String, Object>>) map.get("items_to_give");
                            // 遍历饰品列表
                            itemsToGive.forEach(itemsToGiveMap -> ofId_AssetId.forEach(ofIdAssetId -> {
                                if (ofIdAssetId.getAssetId().equals(itemsToGiveMap.get("assetid"))) {
                                    orderFormDAO.updateOfStateAndTradeofferIdByOfId(4, ofIdAssetId.getOfId(), (String) map.get("tradeofferid"));
                                }
                            }));
                        }
                    }
                }
                if (tradeOffersSent != null) {
                    System.out.println(tradeOffersSent);
                    tradeOffersSent.forEach(new ForEach()::foEach);
                }
                if (tradeOffersReceived != null) {
                    System.out.println(tradeOffersReceived);
                    tradeOffersReceived.forEach(new ForEach()::foEach);
                }
            }


            /* 检测已发货的订单 **/
            System.out.println("检测已发货的订单");
            // 获取已发货订单
            List<OrderForm> orderFormList = orderFormDAO.getOrderFormByOfStateUserId(4, userId);
            System.out.println(orderFormList);
            if (orderFormList != null) {

                orderFormList.forEach(orderForm -> {
                    try {
                        // 设置交易报价
                        ConnectionUtil connectionUtil = new ConnectionUtil("https://api.steampowered.com/IEconService/GetTradeOffer/v1");
                        // 查询条件
                        Map<String, String> where = new HashMap<>();
                        // 用户秘钥
                        where.put("key", steamKey);
                        // 语言
                        where.put("language", "schinese");
                        // 交易报价id
                        where.put("tradeofferid", orderForm.getTradeofferId());
                        // 获取结果
                        BufferedReader reader = connectionUtil.getBufferedWriter(ConnectionMethod.GET, where);
                        // 对结果进行解析
                        Map<String, Object> data = new ObjectMapper().readValue(reader.readLine(), Map.class);

                        data = (Map<String, Object>) data.get("response");
                        if (data!=null&&!data.isEmpty()){
                            data = (Map<String, Object>) data.get("offer");
                            // 判断是否有效交易报价
                            if (2 == (Integer) data.get("trade_offer_state") || 11 == (Integer) data.get("trade_offer_state")) {
                            }
                            if (3 == (Integer) data.get("trade_offer_state")) {
                                orderFormDAO.updateOfStateAndTradeofferIdByOfId(1, orderForm.getOfId(), orderForm.getTradeofferId());
                            } else {
                                orderFormDAO.updateOfStateAndTradeofferIdByOfId(0, orderForm.getOfId(), orderForm.getTradeofferId());
                            }
                        }else {
                            orderFormDAO.updateOfStateAndTradeofferIdByOfId(0, orderForm.getOfId(), orderForm.getTradeofferId());
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void purchase(int userId, int sellId) {
        OrderFormDAO dao = new OrderFormDAOImpl();
        dao.add(userId, sellId);
    }
}
