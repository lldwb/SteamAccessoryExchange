package top.lldwb.sae;

import top.lldwb.sae.dao.ActivityDao;
import top.lldwb.sae.dao.Impl.ActivityDaoImpl;
import top.lldwb.sae.entity.Activity;

import java.util.List;

public class ActivityServiceImpl implements ActivityService{
     ActivityDao  dao = new ActivityDaoImpl();
    @Override
    public void insert(Activity activity) {
        int insert = dao.insert(activity);
        System.out.println(insert);
    }

    @Override
    public void delete(Activity ac_id) {
        int delete = dao.delete(ac_id);
        System.out.println(delete);
    }

    @Override
    public void update(Activity activity) {
        int update = dao.update(activity);
        System.out.println(update);

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
