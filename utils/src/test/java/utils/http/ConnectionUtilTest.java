package utils.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import top.lldwb.sae.utils.http.ConnectionMethod;
import top.lldwb.sae.utils.http.ConnectionUtil;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class ConnectionUtilTest {
    @Test
    public void f() throws IOException {
        ConnectionUtil connectionUtil = new ConnectionUtil("https://steamcommunity.com/market/appfilters/730");
        Map<String,String> data = new HashMap<>();
        data.put("l","schinese");

        ObjectMapper mapper = new ObjectMapper();

        BufferedReader reader = connectionUtil.getBufferedWriter(ConnectionMethod.GET,data);
        Map<String,String> map = mapper.readValue(reader.readLine(),Map.class);
        System.out.println(map);
        Map<String,String> facets = mapper.readValue(map.get("facets"),Map.class);
    }
}
