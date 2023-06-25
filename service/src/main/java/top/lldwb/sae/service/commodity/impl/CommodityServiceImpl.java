package top.lldwb.sae.service.commodity.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import top.lldwb.sae.dao.commodity.CommodityClassDAO;
import top.lldwb.sae.dao.commodity.impl.CommodityClassDAOImpl;
import top.lldwb.sae.dao.user.impl.UserDAO;
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
            data.put("count", "10");

            // 获取结果
            BufferedReader reader = connectionUtil.getBufferedWriter(ConnectionMethod.GET, data);
            // 对结果进行解析
            Map<String, Object> map = new ObjectMapper().readValue(reader.readLine(), Map.class);
            System.out.println(map);

            List<Map<String, Object>> descriptions = (List<Map<String, Object>>) map.get("descriptions");
            System.out.println(descriptions);
            CommodityClassDAO commodityClassDAO = new CommodityClassDAOImpl();
            descriptions.forEach(descriptionsMap -> {
                if (commodityClassDAO.judgeExist((String) descriptionsMap.get("classid"))) {
                    CommodityClass commodityClass = new CommodityClass();
                    commodityClass.setClassId((String) descriptionsMap.get("classid"));
                    commodityClass.setClassName((String) descriptionsMap.get("market_name"));
                    commodityClass.setClassUrl((String) descriptionsMap.get("icon_url"));
                    commodityClass.setClassUrlLarge((String) descriptionsMap.get("icon_url_large"));
                    commodityClass.setClassActions((String) ((List<Map<String, Object>>) descriptionsMap.get("actions")).get(0).get("link"));
                    try {
                        commodityClass.setClassDescriptions(new ObjectMapper().writeValueAsString(descriptionsMap.get("descriptions")));
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(commodityClass);
                    commodityClassDAO.add(commodityClass);
                    System.out.println(descriptionsMap.get("market_name"));
                }
            });


            List<Map<String, Object>> assets = (List<Map<String, Object>>) map.get("assets");
            System.out.println(assets);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
