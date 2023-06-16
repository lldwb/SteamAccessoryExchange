package top.lldwb.sae.utils;

import org.nf.db.util.SqlExecutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class MySqlUtil {
    static {
        /*
         * 加载驱动程序
         */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动程序失败...");
            e.printStackTrace();
        }
    }


        private static final String URL = "jdbc:mysql://mysql.lldwb.top:33366/noitasaver?serverTimezone=Asia/Shanghai&useSSL=false";
    //账号
    private static final String USER_NAME = "root";
    //密码
    private static final String PASSWORD = "@dwb123456";
    private static SqlExecutor sqlExecutor;
    //数据库连接对象并传入数据库参数
    Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

    public MySqlUtil() throws SQLException {
    }
}
