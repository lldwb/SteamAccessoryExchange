package top.lldwb.sae.api.controller.activity;

import org.nf.web.annotation.Model;
import org.nf.web.servlet.View;


import org.nf.web.servlet.view.JsonView;
import top.lldwb.sae.api.controller.BaseController;
import top.lldwb.sae.entity.activity.Activity;
import top.lldwb.sae.service.activity.ActivityService;
import top.lldwb.sae.service.activity.impl.ActivityServiceImpl;
import top.lldwb.sae.utils.vo.ResultVO;

import java.util.List;

public class ActivityController extends BaseController {
    /**
     * 添加数据
     */
    public View getActivity(@Model Activity activity) {
        ActivityService service = new ActivityServiceImpl();
        service.insert(activity);
        return new JsonView(success());
    }

    public View getDeleteActivity(Activity ac_id) {
        ActivityService service = new ActivityServiceImpl();
        service.delete(ac_id);
        return new JsonView(success());
    }

    public View getUpdateActivity(Activity activity) {
        ActivityService service = new ActivityServiceImpl();
        service.update(activity);
        return new JsonView(success());
    }

    public View getSelectActivity(int ac_id) {
        ActivityService service = new ActivityServiceImpl();
        Activity select = service.select(ac_id);
        return new JsonView(success());
    }

    public View getActivityList(Activity activity) {
        ActivityService service = new ActivityServiceImpl();
        service.selectlist(activity);
        return new JsonView(success());
    }
}
