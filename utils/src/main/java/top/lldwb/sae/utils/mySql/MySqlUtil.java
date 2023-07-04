package top.lldwb.sae.utils.mySql;

import org.nf.db.util.SqlExecutor;
import org.nf.db.util.result.BeanHandler;
import org.nf.db.util.result.BeanListHandler;
import org.nf.db.util.result.ColumnHandler;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

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

    private static final String URL = "jdbc:mysql://mysql.lldwb.top:3306/sae?serverTimezone=Asia/Shanghai&useSSL=false";
    //账号
    private static final String USER_NAME = "sae";
    //密码
    private static final String PASSWORD = "PBERGLmSDfr2Mzxi";

    private static SqlExecutor getSqlExecutor() {
        try {
            return new SqlExecutor(DriverManager.getConnection(URL, USER_NAME, PASSWORD));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 从数据库中查询符合条件的记录，并将结果封装为指定类型的List<T>对象
     *
     * @param clazz 实体
     * @param sql   SQL语句
     * @param obj   SQL语句中的参数列表
     * @param <T>   Java类型
     * @return 返回符合条件的记录封装为的List<T>对象
     * @throws SQLException
     */
    public static <T> List<T> queryList(Class<T> clazz, String sql, Object... obj) {
        //调用处理
        BeanListHandler<T> beanListHandler = new BeanListHandler<>(clazz);
        //创建list集合存放数据
        List<T> list = getSqlExecutor().executeQuery(sql, beanListHandler, obj);
        return list;
    }

    /**
     * 从数据库中查询符合条件的记录，并将结果封装为指定类型的T对象
     *
     * @param clazz 实体
     * @param sql   SQL语句
     * @param obj   SQL语句中的参数列表
     * @param <T>   Java类型
     * @return 返回符合条件的记录封装为的T对象
     */
    public static <T> T queryT(Class<T> clazz, String sql, Object... obj) {
        BeanHandler<T> handler = new BeanHandler<>(clazz);
        return getSqlExecutor().executeQuery(sql, handler, obj);
    }

    /**
     * 返回单个结果
     *
     * @param columnIndex 要获取列的下标
     * @param sql         SQL语句
     * @param obj         SQL语句中的参数列表
     * @param <T>         Java类型
     * @return
     */
    public static <T> T queryColumn(int columnIndex, String sql, Object... obj) {
        ColumnHandler<T> handler = new ColumnHandler<>(columnIndex);
        return getSqlExecutor().executeQuery(sql, handler, obj);
    }

    /**
     * 操作数据库
     *
     * @param sql
     * @param obj
     * @return
     * @throws SQLException
     */
    public static int update(String sql, Object... obj) {
        return getSqlExecutor().executeUpdate(sql, obj);
    }

    public static int[] executeBath(String sql,Object[][] params){
        return getSqlExecutor().executeBath(sql, params);
    }
}
