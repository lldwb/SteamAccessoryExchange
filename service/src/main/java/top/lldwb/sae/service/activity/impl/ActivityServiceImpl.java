package top.lldwb.sae.service.activity.impl;

import top.lldwb.sae.dao.activity.ActivityDao;
import top.lldwb.sae.dao.activity.Impl.ActivityDaoImpl;
import top.lldwb.sae.entity.activity.Activity;
import top.lldwb.sae.service.activity.ActivityService;

import java.util.List;

public class ActivityServiceImpl implements ActivityService {
     ActivityDao  dao = new ActivityDaoImpl();
    @Override
    public void insert(Activity activity) {
         dao.insert(activity);
    }

    @Override
    public void delete(Activity ac_id) {
       dao.delete(ac_id);
    }

    @Override
    public void update(Activity activity) {
         dao.update(activity);
    }

    @Override
    public Activity select(int ac_id) {
        return dao.select(ac_id);
    }

    @Override
    public List<Activity> selectlist(Activity activity) {
        return dao.selectlist(activity);
    }
}
