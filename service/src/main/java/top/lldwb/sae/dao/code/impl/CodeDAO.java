package top.lldwb.sae.dao.code.impl;

import top.lldwb.sae.dao.code.CodeInterFace;
import top.lldwb.sae.entity.code.CodeTable;
import top.lldwb.sae.utils.mySql.MySqlUtil;

import java.sql.SQLException;
import java.sql.Timestamp;

/***
 * @Date(时间)2023-06-20
 * @Author 家辉
 *
 * 验证码数据访问类
 */
public class CodeDAO implements CodeInterFace {

    /***
     * 调用工具类
     */
    MySqlUtil mySqlUtil;

    {
        try {
            mySqlUtil = new MySqlUtil();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /***
     *
     * @param times
     * @return
     */
    @Override
    public int deleteCOde(Timestamp times) {


        return 0;
    }


    @Override
    public int updateCode(int id) {
        return 0;
    }

    /***
     * 添加验证码
     * @param entity
     * @return
     */
    @Override
    public int addCode(CodeTable entity) {

        //创建Obj数组存放要添加的数据
        Object obj[] = {
                entity.getCtCode(),
                entity.getCtValidOrNot(),
                entity.getCtType(),
                entity.getUserId()
        };

        //获取sql语句
        String sql = "insert into code_table(ct_code,ct_Valid_or_not,ct_type,user_id)\n" +
                "values(?,?,?,?)" ;

        //返回
        try {
            return mySqlUtil.update(sql,obj);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * 根据Id删除
     * @param id
     * @return
     */
    @Override
    public int deleteCodesID(int id) {
        //获取sql语句
        String sql = "delete from code_table where user_id = ?" ;
        try {
            return mySqlUtil.update(sql,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * 根据验证码，查询验证码
     * @param name
     * @return
     */
    @Override
    public CodeTable query(String name) {
        //获取sql语句
        String sql = "select ct_id,ct_code,ct_time,ct_effective_time,ct_Valid_or_not,ct_type,user_Id from code_table where ct_code = ?" ;
        return mySqlUtil.queryT(CodeTable.class,sql,name);
    }
}
