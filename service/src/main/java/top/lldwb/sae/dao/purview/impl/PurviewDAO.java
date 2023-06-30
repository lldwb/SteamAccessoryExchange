package top.lldwb.sae.dao.purview.impl;

import top.lldwb.sae.dao.purview.PurviewInterFace;
import top.lldwb.sae.entity.purview.Purview;
import top.lldwb.sae.utils.mySql.MySqlUtil;

import java.util.List;

/***
 * @Date(时间)2023-06-25
 * @Author 家辉
 *
 * 权限数据访问类
 */
public class PurviewDAO implements PurviewInterFace {
    /***
     * 添加数据
     * @param purview
     * @return
     */
    @Override
    public int purviewADD(Purview purview) {
        //创建Object数组存放要添加的数据
        Object[] object = {
                purview.getPurview_limitation(),//权限
                purview.getPurview_describe(),//描述
                purview.getUser_id() // FK用户id


        };
        //获取sql数据
        String sql = "insert into purview(purview_limitation,purview_describe,user_id) values(?,?,?)" ;
        //返回结果集
        return MySqlUtil.update(sql,object);
    }

    /***
     * 根据用户ID删除数据
     * @param id
     * @return
     */
    @Override
    public int purviewDelete(int id) {

        //获取sql语句
        String sql = "delete from purview where user_id = ?" ;
        //返回结果集
        return MySqlUtil.update(sql,id);
    }

    /***
     * 根据id和根据用户id删除
     * @param purvoewId id
     * @param userId 用户id
     * @return
     */
    @Override
    public int purviewDelete(int purvoewId,int userId) {

        //获取sql语句
        String sql = "delete from purview where purview_id = ? and user_id =  ?" ;
        //返回结果集
        return MySqlUtil.update(sql,purvoewId,userId);
    }


    /***
     * 修改数据
     * @param purview
     * @return
     */
    @Override
    public int purviewUpdate(Purview purview) {

        //创建Object数组存放要修改的数据
        Object[] object = {
                purview.getPurview_limitation(),//权限
                purview.getPurview_describe(),//描述
                purview.getUser_id(), // FK用户id
                purview.getPurview_id() // id
        };

        //获取Sql语句
        String sql = "update purview set purview_limitation = ?,purview_describe = ?,user_id = ? where purview_id = ?" ;

        //返回结果集
        return MySqlUtil.update(sql,object);
    }

    /***
     * 查询所有数据
     * @return
     */
    @Override
    public List<Purview> purviewList() {
        //获取查询语句
        String sql = "select purview_id,purview_limitation,purview_describe,user_id from purview" ;

        //返回结果集
        return MySqlUtil.queryList(Purview.class,sql);
    }

    /***
     * 根据条件查询数据
     * @param id
     * @return
     */
    @Override
    public Purview purviewUserIDQuery(int id) {
        //获取sql查询语句
        String sql = "select purview_id,purview_limitation,purview_describe,user_id from purview where user_id = ?" ;

        //返回结果集
        return MySqlUtil.queryT(Purview.class,sql,id);
    }
}
