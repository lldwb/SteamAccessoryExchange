package top.lldwb.sae.utils.http;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class ConnectionUtil {
    // URL表示一个统一的资源定位符，一个指向万维网上“资源”的指针
    private String url;

    public ConnectionUtil(String url) throws MalformedURLException {
        this.url = url;
    }

    public BufferedReader getBufferedWriter(ConnectionMethod method) throws IOException {
        return getBufferedWriter(method, null);
    }

    public BufferedReader getBufferedWriter(ConnectionMethod method, Map<String, String> map) throws IOException {
        if (map != null) {
            // 判断是否是第一个条件
            boolean verify = true;
            for (String key : map.keySet()) {
                url += verify ? "?" : "&" + key + "=" + map.get(key);
                verify = false;
            }
        }

        // 打开和url之间的连接
        // HttpURLConnection实例用于发出一个请求
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        // 请求方式
        conn.setRequestMethod(method.value);

        // 设置通用的请求属性
        conn.setRequestProperty("accept", "*/*");
        conn.setRequestProperty("connection", "Keep-Alive");
        conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
        conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");

        // DoOutput设置是否向httpUrlConnection输出，DoInput设置是否从httpUrlConnection读入，此外发送post请求必须设置这两个
        if (ConnectionMethod.POST == method) {
            conn.setDoOutput(true);
            conn.setDoInput(true);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        return reader;
    }
}
