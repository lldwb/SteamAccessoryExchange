package top.lldwb.sae.dao.purview.impl;

import top.lldwb.sae.dao.purview.PurviewInterFace;
import top.lldwb.sae.entity.purview.Purview;
import top.lldwb.sae.entity.purview.PurviewTwo;
import top.lldwb.sae.entity.rode.Role;
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
                purview.getPurviewLimitation(),//权限
                purview.getPurviewDescribe(),//描述
                purview.getRoleId(), // FK用户id


        };
        //获取sql数据
        String sql = "insert into purview(purview_limitation,purview_describe,role_Id) values(?,?,?)" ;
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
        String sql = "delete from purview where role_Id = ?" ;
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
        String sql = "delete from purview where purview_id = ? and role_Id =  ?" ;
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
                purview.getPurviewLimitation(),//权限
                purview.getPurviewDescribe(),//描述
                purview.getRoleId(), // FK用户id
                purview.getPurviewId() // id
        };

        //获取Sql语句
        String sql = "update purview set purview_limitation = ?,purview_describe = ?,role_Id = ? where purview_id = ?" ;

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
        String sql = "select purview_id,purview_limitation,purview_describe,role_Id from purview" ;

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
        String sql = "select purview_id,purview_limitation,purview_describe,user_id from purview where role_Id = ?" ;

        //返回结果集
        return MySqlUtil.queryT(Purview.class,sql,id);
    }

    @Override
    public List<PurviewTwo> queryLimitPurview(PurviewTwo entity, int number, int limit) {
        //获取sql语句
        StringBuilder sql = new StringBuilder() ;
        sql.append("select purview_id,purview_limitation,purview_describe,role_Id, (select role_level from role where role_id = purview.role_id) as role_level from purview ") ;

        if(entity != null && entity.getPurviewLimitation() !=null && !"".equals(entity.getPurviewLimitation().trim())){
            sql.append("where purview_limitation like ?") ;
            sql.append(" limit ?,?") ;
            return MySqlUtil.queryList(PurviewTwo.class,sql.toString(),"%"+entity.getPurviewLimitation()+"%",number,limit) ;
        }
        if(entity != null && entity.getPurviewDescribe() !=null && !"".equals(entity.getPurviewDescribe().trim())){
            sql.append("where purview_describe like ?") ;
            sql.append(" limit ?,?") ;
            return MySqlUtil.queryList(PurviewTwo.class,sql.toString(),"%"+entity.getPurviewDescribe()+"%",number,limit) ;
        }
        return queryLimitRecursionPurview(number,limit) ;
    }

    public List<PurviewTwo> queryLimitRecursionPurview(int number, int limit) {
        //获取sql语句
        StringBuilder sql = new StringBuilder() ;
        sql.append("select purview_id,purview_limitation,purview_describe,role_Id, (select role_level from role where role_id = purview.role_id) as role_level from purview ") ;
        sql.append(" limit ?,?") ;
        return MySqlUtil.queryList(PurviewTwo.class,sql.toString(),number,limit) ;
    }

    @Override
    public Long count() {
        String sql =("select COUNT(*) from purview ") ;

        return MySqlUtil.queryColumn(1,sql) ;
    }
}
