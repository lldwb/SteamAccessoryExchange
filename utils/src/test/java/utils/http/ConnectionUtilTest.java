package utils.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import top.lldwb.sae.utils.http.ConnectionMethod;
import top.lldwb.sae.utils.http.ConnectionUtil;
import top.lldwb.sae.utils.mySql.MySqlUtil;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class ConnectionUtilTest {
    @Test
    public void f() throws IOException, SQLException {
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
//        CommodityInstance instance = new

        map = (Map<String, Object>) map.get("facets");
        map.forEach((key, value) -> {
//            System.out.println(key + ":" + value);
            Map<String, Object> tags = (Map<String, Object>) value;
            String parent = (String) tags.get("localized_name");
            System.out.println(parent);
            if (mySqlUtil.<Long>queryColumn(1, "select count(*) from commodity_instance where instance_name = ?", parent) == 0) {
                mySqlUtil.update("insert into commodity_instance(instance_name) VALUES(?);", parent);
            }
            tags = (Map<String, Object>) tags.get("tags");
            int parent_id = mySqlUtil.<Integer>queryColumn(1, "select instance_id from commodity_instance where instance_name = ?", parent);
            tags.forEach((k, v) -> {
//                System.out.println(k + ":" + v);
                Map<String, Object> vMap = (Map<String, Object>) v;
                String instance_name = (String) vMap.get("localized_name");
                System.out.println(instance_name);
                if (mySqlUtil.<Long>queryColumn(1, "select count(*) from commodity_instance where instance_name = ?", instance_name) == 0) {
                    mySqlUtil.update("insert into commodity_instance(instance_name,parent_id) VALUES(?,?);", instance_name,parent_id);
                }
            });
        });
    }
}
