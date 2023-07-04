package top.lldwb.sae.api.controller.commodity;

import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.JsonView;
import top.lldwb.sae.api.controller.BaseController;
import top.lldwb.sae.entity.commodity.CommodityClass;
import top.lldwb.sae.service.commodity.CommodityClassService;
import top.lldwb.sae.service.commodity.impl.CommodityClassServiceImpl;
import top.lldwb.sae.utils.vo.PageVO;

import java.util.List;


public class CommodityClassController extends BaseController {
    /**
     *
     * @param instanceName 条件
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/commodity/CommodityClassController/listByInstanceName")
    public View loginUserByEmail(@RequestParam("instanceName") String instanceName,
                                 @RequestParam("page") int page,
                                 @RequestParam("limit") int limit){
        CommodityClassService service = new CommodityClassServiceImpl();
        PageVO<List<CommodityClass>> pageVO = service.listCommodityClass(instanceName, page, limit);
        return new JsonView(pageVO);
    }


    }
