package top.lldwb.sae.data.deal;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import top.lldwb.sae.utils.http.ConnectionMethod;
import top.lldwb.sae.utils.http.ConnectionUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class OrderFormDAOImplTest {
    @Test
    public void test() throws IOException {
        // 设置交易报价
        ConnectionUtil connectionUtil = new ConnectionUtil("https://api.steampowered.com/IEconService/GetTradeOffer/v1");
        // 查询条件
        Map<String, String> where = new HashMap<>();
        // 用户秘钥
//        where.put("key", "D3F0F059CB081D85E993BADB00923A64");
        where.put("key", "31FCC55F0456FEF1C5A3B677B0504AC9");
        // 语言
        where.put("language", "schinese");
        // 交易报价id
        where.put("tradeofferid", "6176038032");
        // 获取结果
        BufferedReader reader = connectionUtil.getBufferedWriter(ConnectionMethod.GET, where);
        // 对结果进行解析
        Map<String, Object> data = new ObjectMapper().readValue(reader.readLine(), Map.class);

        data = (Map<String, Object>) data.get("response");
        System.out.println(data!=null);
        System.out.println(data);
        System.out.println(!data.isEmpty());
    }
}
