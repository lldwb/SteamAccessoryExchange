package top.lldwb.sae.utils.mysql;

import org.nf.db.util.ResultSetHandler;
import org.nf.db.util.SqlExecutor;
import org.nf.db.util.result.BeanHandler;
import org.nf.db.util.result.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class MySqlUtil {
    private static final String URL = "jdbc:mysql://mysql.lldwb.top:33366/noitasaver?serverTimezone=Asia/Shanghai&useSSL=false";
    //账号
    private static final String USER_NAME = "root";
    //密码
    private static final String PASSWORD = "@dwb123456";
    private static SqlExecutor sqlExecutor;

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

    MySqlUtil() throws SQLException {
        sqlExecutor = new SqlExecutor(DriverManager.getConnection(URL, USER_NAME, PASSWORD));
    }

    /**
     * 从数据库中查询符合条件的记录，并将结果封装为指定类型的List<T>对象
     *
     * @param t   用于封装结果的Java对象
     * @param sql SQL语句
     * @param obj SQL语句中的参数列表
     * @param <T> Java类型
     * @return 返回符合条件的记录封装为的List<T>对象
     * @throws SQLException
     */
    public <T> List<T> queryList(T t, String sql, Object... obj) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        BeanListHandler<T> handler = new BeanListHandler<T>((Class<T>) t.getClass());
        List<T> list = sqlExecutor.executeQuery(sql, handler, obj);
//        DbUtils.close(conn);
        return list;
//        return null;
    }

    /**
     * 从数据库中查询符合条件的记录，并将结果封装为指定类型的T对象
     *
     * @param t   用于封装结果的Java对象
     * @param sql SQL语句
     * @param obj SQL语句中的参数列表
     * @param <T> Java类型
     * @return 返回符合条件的记录封装为的T对象
     * @throws SQLException
     */
    public <T> T queryT(T t, String sql, Object... obj) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        BeanHandler<T> handler = new BeanHandler<T>((Class<T>) t.getClass());
        return sqlExecutor.executeQuery(sql, handler, obj);
    }

    public int update(String sql, Object... obj) throws SQLException {
        return sqlExecutor.executeUpdate(sql, obj);
    }
}
