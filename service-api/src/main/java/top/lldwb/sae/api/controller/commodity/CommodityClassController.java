package top.lldwb.sae.api.controller.commodity;

import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.JsonView;
import top.lldwb.sae.api.vo.ResultVO;
import top.lldwb.sae.entity.commodity.CommodityClass;
import top.lldwb.sae.entity.commodity.CommodityInstance;
import top.lldwb.sae.service.commodity.CommodityClassService;
import top.lldwb.sae.service.commodity.impl.CommodityClassServiceImpl;
import top.lldwb.sae.vo.PageVO;

import java.util.List;


public class CommodityClassController {
    @RequestMapping("/commodity/CommodityClassController/listByInstanceName")
    public View loginUserByEmail(@RequestParam("instanceName") String where,
                                 @RequestParam("page") int page,
                                 @RequestParam("limit") int limit){
        CommodityClassService service = new CommodityClassServiceImpl();
        CommodityInstance instance = new CommodityInstance();
        instance.setInstanceName(where);
        PageVO<List<CommodityClass>> pageVO = service.listCommodityClass(instance, page, limit);
        return new JsonView(pageVO);
    }


    }
