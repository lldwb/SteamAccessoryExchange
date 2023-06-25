package top.lldwb.sae.service.commodity.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import top.lldwb.sae.dao.commodity.CommodityInstanceDAO;
import top.lldwb.sae.dao.commodity.impl.CommodityInstanceDAOImpl;
import top.lldwb.sae.service.commodity.CommodityInstanceService;
import top.lldwb.sae.utils.http.ConnectionMethod;
import top.lldwb.sae.utils.http.ConnectionUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommodityInstanceServiceImpl implements CommodityInstanceService {
    @Override
    public void refresh() {
        try {
            // 设置饰品分类地址
            ConnectionUtil connectionUtil = new ConnectionUtil("https://steamcommunity.com/market/appfilters/730");
            Map<String, String> data = new HashMap<>();
            data.put("l", "schinese");

//        ConnectionUtil connectionUtil = new ConnectionUtil("https://csgo-1300694263.cos.ap-guangzhou.myqcloud.com/csgo_class.json");

            // 获取结果
            BufferedReader reader = connectionUtil.getBufferedWriter(ConnectionMethod.GET, data);
            // 对结果进行解析
            Map<String, Object> map = new ObjectMapper().readValue(reader.readLine(), Map.class);

            CommodityInstanceDAO dao = new CommodityInstanceDAOImpl();
            map = (Map<String, Object>) map.get("facets");
            System.out.println(map);
            map.forEach((key, value) -> {
//            System.out.println(key + ":" + value);
                Map<String, Object> tags = (Map<String, Object>) value;
                String parent = (String) tags.get("localized_name");
                System.out.println(parent);
                Map<String, Object> finalTags = (Map<String, Object>) tags.get("tags");
                new Thread(() -> {
                    if (dao.judgeExist(parent)) {
                        dao.add(parent);
                    }
                    // 返回父类的id
                    int parent_id = dao.getIdByName(parent);
                    if (parent_id != 0) {
                        finalTags.forEach((k, v) -> {
                            Map<String, Object> vMap = (Map<String, Object>) v;
                            String instance_name = (String) vMap.get("localized_name");
                            System.out.println(instance_name);
                            if (dao.judgeExist(instance_name)) {
                                dao.add(instance_name, parent_id);
                            }
                        });
                    }
                }).start();
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
