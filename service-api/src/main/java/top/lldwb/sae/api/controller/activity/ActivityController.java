package top.lldwb.sae.api.controller.activity;
import org.nf.web.annotation.Model;
import org.nf.web.servlet.View;


import org.nf.web.servlet.view.JsonView;
import top.lldwb.sae.entity.activity.Activity;
import top.lldwb.sae.service.activity.ActivityService;
import top.lldwb.sae.service.activity.impl.ActivityServiceImpl;
import top.lldwb.sae.utils.vo.ResultVO;

import java.util.List;

public class ActivityController {
   private  ActivityService service = new ActivityServiceImpl();
    /**
     * 添加数据
     * */
    public View getActivity(@Model Activity activity){
        int insert = service.insert(activity);
        ResultVO vo = new ResultVO();
        vo.setCode(200);
        vo.setData(insert);
        vo.setMessage("添加成功");
        return new JsonView(vo);
    }

    public View getDeleteActivity(Activity ac_id){
         int delete = service.delete(ac_id);
        ResultVO vo = new ResultVO();
        vo.setCode(200);
        vo.setData(delete);
        vo.setMessage("删除成功");
        return new JsonView(vo);
    }

    public View getUpdateActivity(Activity activity){
        int update = service.update(activity);
        ResultVO vo = new ResultVO();
        vo.setCode(200);
        vo.setData(update);
        vo.setMessage("修改成功");
        return new JsonView(vo);
    }

    public View getSelectActivity(int ac_id){
        Activity select = service.select(ac_id);
        ResultVO vo = new ResultVO();
        vo.setCode(200);
        vo.setData(select);
        vo.setMessage("查询成功");
        return new JsonView(vo);
    }

    public View getActivityList(Activity activity){
        List<Activity> selectlist = service.selectlist(activity);
        ResultVO vo = new ResultVO();
        vo.setCode(200);
        vo.setData(selectlist);
        vo.setMessage("查询全部成功");
        return new JsonView(vo);
    }
}
