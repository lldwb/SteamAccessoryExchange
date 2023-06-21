package top.lldwb.sae.dao.Impl;

import top.lldwb.sae.dao.activity.ActivityDao;
import top.lldwb.sae.entity.activity.Activity;
import top.lldwb.sae.utils.MySqlUtil;

import java.util.List;

public class ActivityDaoImpl implements ActivityDao {


    @Override
    public int insert(Activity activity) {
        MySqlUtil mySqlUtil = null;
        try {
            mySqlUtil = new MySqlUtil();
            String sql ="insert into activity(ac_id,ac_theme,user_id,ac_time,ac_content) values (?,?,?,?);" ;
             int update = mySqlUtil.update(sql, activity);
            return update;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public int delete(Activity ac_id) {
        try {
            MySqlUtil mySqlUtil =new MySqlUtil();
            String sql = "delete from activity where ac_id = ? ";
            int update = mySqlUtil.update(sql, ac_id);
            return update;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int update(Activity activity) {
        try {
            MySqlUtil mySqlUtil = new MySqlUtil();
            String sql = "update activity set ac_id=?,ac_theme=?,user_id=?,ac_time=?,ac_content=?";
            int update = mySqlUtil.update(sql, activity);
            return update;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Activity select(int ac_id) {
        try {
            MySqlUtil mySqlUtil= new MySqlUtil();
            String sql = "select from activity where zc_id = ?";
            return mySqlUtil.queryT(Activity.class, sql, ac_id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Activity> selectlist(Activity activity) {
        try {
            MySqlUtil mySqlUtil = new MySqlUtil();
            String sql= "select ac_id,ac_theme,user_id,ac_time,ac_content from activity";
            return mySqlUtil.queryList(Activity.class,sql,activity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
