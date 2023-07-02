package top.lldwb.sae.api.controller.commodity;

import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.JsonView;
import top.lldwb.sae.api.controller.BaseController;
import top.lldwb.sae.service.commodity.CommodityService;
import top.lldwb.sae.service.commodity.impl.CommodityServiceImpl;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class CommodityController extends BaseController{
    /**
     * 根据官方数据进行刷新库存
     */
    @RequestMapping("/Commodity/Commodity/refresh")
    public View refresh(@RequestParam("userId") int userId) {
        CommodityService service = new CommodityServiceImpl();
        service.refresh(userId);
        return new JsonView(success());
    }
}
