package top.lldwb.sae.service.commodity.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import top.lldwb.sae.dao.user.impl.UserDAO;
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

            List<Map<String,Object>> assets = (List<Map<String, Object>>) map.get("assets");
            List<Map<String,Object>> descriptions = (List<Map<String, Object>>) map.get("descriptions");
            System.out.println(assets);
            System.out.println(descriptions);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
