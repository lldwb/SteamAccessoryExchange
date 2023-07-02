package top.lldwb.sae.api.controller.activity;

import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import top.lldwb.sae.dao.activity.ActivityDao;
import top.lldwb.sae.dao.activity.Impl.ActivityDaoImpl;

public class ActivityController {
    public View getActivityController(){
        ActivityDao dao = new ActivityDaoImpl();

    }
}
