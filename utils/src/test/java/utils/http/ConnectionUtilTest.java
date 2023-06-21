package utils.http;

import org.junit.jupiter.api.Test;
import top.lldwb.sae.utils.http.ConnectionMethod;
import top.lldwb.sae.utils.http.ConnectionUtil;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class ConnectionUtilTest {
    @Test
    public void f() throws IOException {
        ConnectionUtil connectionUtil = new ConnectionUtil("https://steamcommunity.com/market/appfilters/730?l=schinese");
        BufferedReader reader = connectionUtil.getBufferedWriter(ConnectionMethod.GET);
        for (writer)
    }
}
