package top.lldwb.sae.service.commodity.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import top.lldwb.sae.dao.commodity.CommodityInstanceDAO;
import top.lldwb.sae.dao.commodity.impl.CommodityInstanceDAOImpl;
import top.lldwb.sae.service.commodity.CommodityInstanceService;
import top.lldwb.sae.utils.http.ConnectionMethod;
import top.lldwb.sae.utils.http.ConnectionUtil;
import top.lldwb.sae.utils.mySql.MySqlUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommodityInstanceServiceImpl implements CommodityInstanceService {
    @Override
    public void add() throws IOException {
//        ConnectionUtil connectionUtil = new ConnectionUtil("https://steamcommunity.com/market/appfilters/730");
        ConnectionUtil connectionUtil = new ConnectionUtil("https://csgo-1300694263.cos.ap-guangzhou.myqcloud.com/csgo_class.json");
        Map<String, String> data = new HashMap<>();
//        data.put("l","schinese");

        ObjectMapper mapper = new ObjectMapper();

//        BufferedReader reader = connectionUtil.getBufferedWriter(ConnectionMethod.GET,data);
        BufferedReader reader = connectionUtil.getBufferedWriter(ConnectionMethod.GET);
        Map<String, Object> map = mapper.readValue(reader.readLine(), Map.class);
//        System.out.println(map);

//        map.forEach((k, v) -> System.out.println(k + ":" + v));
//        System.out.println(map.get("facets"));

        MySqlUtil mySqlUtil = new MySqlUtil();
        CommodityInstanceDAO instance = new CommodityInstanceDAOImpl();

        map = (Map<String, Object>) map.get("facets");
        map.forEach((key, value) -> {
//            System.out.println(key + ":" + value);
            Map<String, Object> tags = (Map<String, Object>) value;
            String parent = (String) tags.get("localized_name");
            System.out.println(parent);
            if (instance.queryColumn(parent) == 0) {
                mySqlUtil.update("insert into commodity_instance(instance_name) VALUES(?);", parent);
            }
            tags = (Map<String, Object>) tags.get("tags");
            int parent_id = mySqlUtil.<Integer>queryColumn(1, "select instance_id from commodity_instance where instance_name = ?", parent);
            tags.forEach((k, v) -> {
//                System.out.println(k + ":" + v);
                Map<String, Object> vMap = (Map<String, Object>) v;
                String instance_name = (String) vMap.get("localized_name");
                System.out.println(instance_name);
                if (instance.queryColumn(instance_name) == 0) {
                    mySqlUtil.update("insert into commodity_instance(instance_name,parent_id) VALUES(?,?);", instance_name,parent_id);
                }
            });
        });
    };
}
