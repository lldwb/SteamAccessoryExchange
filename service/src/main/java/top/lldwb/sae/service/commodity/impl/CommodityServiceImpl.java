package top.lldwb.sae.service.commodity.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import top.lldwb.sae.dao.commodity.CommdoityClassInstanceDAO;
import top.lldwb.sae.dao.commodity.CommodityClassDAO;
import top.lldwb.sae.dao.commodity.CommodityDAO;
import top.lldwb.sae.dao.commodity.CommodityInstanceDAO;
import top.lldwb.sae.dao.commodity.impl.CommdoityClassInstanceDAOImpl;
import top.lldwb.sae.dao.commodity.impl.CommodityClassDAOImpl;
import top.lldwb.sae.dao.commodity.impl.CommodityDAOImpl;
import top.lldwb.sae.dao.commodity.impl.CommodityInstanceDAOImpl;
import top.lldwb.sae.dao.user.impl.UserDAO;
import top.lldwb.sae.entity.commodity.Commodity;
import top.lldwb.sae.entity.commodity.CommodityClass;
import top.lldwb.sae.service.commodity.CommodityService;
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
public class CommodityServiceImpl implements CommodityService {
    @Override
    public void refresh(int userId) {
        try {
            String steamId = new UserDAO().getSteamIdById(userId);
            // 设置饰品分类地址
            ConnectionUtil connectionUtil = new ConnectionUtil("https://steamcommunity.com/inventory/" + steamId + "/730/2");
            Map<String, String> data = new HashMap<>();
            data.put("l", "schinese");
//            data.put("count", "10");

            // 获取结果
            BufferedReader reader = connectionUtil.getBufferedWriter(ConnectionMethod.GET, data);
            // 对结果进行解析
            Map<String, Object> map = new ObjectMapper().readValue(reader.readLine(), Map.class);
//            System.out.println(map);

            List<Map<String, Object>> descriptions = (List<Map<String, Object>>) map.get("descriptions");
//            System.out.println(descriptions);
            CommodityClassDAO commodityClassDAO = new CommodityClassDAOImpl();
            new Thread(() -> {
                descriptions.forEach(descriptionsMap -> {
                    System.out.println(descriptionsMap);
                    // 添加模板
                    if (commodityClassDAO.judgeExist((String) descriptionsMap.get("classid"))) {
                        try {
                            System.out.println("添加");
                            CommodityClass commodityClass = new CommodityClass();
                            commodityClass.setClassId((String) descriptionsMap.get("classid"));
                            commodityClass.setClassName((String) descriptionsMap.get("market_name"));
                            commodityClass.setClassUrl((String) descriptionsMap.get("icon_url"));
                            commodityClass.setClassUrlLarge((String) descriptionsMap.get("icon_url_large"));
                            commodityClass.setClassActions(new ObjectMapper().writeValueAsString(descriptionsMap.get("actions")));
                            commodityClass.setClassDescriptions(new ObjectMapper().writeValueAsString(descriptionsMap.get("descriptions")));
                            System.out.println(commodityClass);
//                        System.out.println(descriptionsMap.get("market_name"));
                            commodityClassDAO.add(commodityClass);
                        } catch (JsonProcessingException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    // 设置关联
                    new Thread(() -> {
                        ((List<Map<String, Object>>) descriptionsMap.get("tags")).forEach((tags -> {
                            CommodityInstanceDAO commodityInstanceDAO = new CommodityInstanceDAOImpl();
                            int instanceId = commodityInstanceDAO.getIdByName((String) tags.get("localized_tag_name"));
                            CommdoityClassInstanceDAO commdoityClassInstanceDAO = new CommdoityClassInstanceDAOImpl();
                            if (commdoityClassInstanceDAO.judgeExist((String) descriptionsMap.get("classid"), instanceId)) {
                                commdoityClassInstanceDAO.add((String) descriptionsMap.get("classid"), instanceId);
                            }
                        }));
                    }).start();
                });
            }).start();

            // 添加商品
            new Thread(() -> {
                List<Map<String, Object>> assets = (List<Map<String, Object>>) map.get("assets");
                CommodityDAO commodityDAO = new CommodityDAOImpl();
                assets.forEach(tags -> {
                    if (commodityDAO.judgeExist((String) tags.get("assetid"))) {
                        Commodity commodity = new Commodity();
                        commodity.setAssetId((String) tags.get("assetid"));
                        commodity.setClassId((String) tags.get("classid"));
                        commodity.setUserId(userId);
                        commodityDAO.add(commodity);
                    }
                });
//                System.out.println(assets);
            }).start();
        } catch (IOException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
}
