package top.lldwb.sae.service.activity;

import top.lldwb.sae.entity.activity.Activity;

import java.util.List;

public interface ActivityService {


    /**
     * 添加数据
     * @param activity
     * @return
     */
    int insert(Activity activity);

    /**
     * 删除数据
     * @param ac_id
     * @return
     */
    int delete(Activity ac_id);


    /**
     * 修改数据
     * @param activity
     * @return
     */
    int update(Activity activity);

    /**
     * 查询活动
     * @param ac_id
     * @return
     */
    Activity select(int ac_id);

    /**
     * 查询所有活动
     * @param activity
     * @return
     */

    List<Activity> selectlist(Activity activity);
}
