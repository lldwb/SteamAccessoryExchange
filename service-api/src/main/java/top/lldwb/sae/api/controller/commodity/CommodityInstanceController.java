package top.lldwb.sae.api.controller.commodity;

import org.nf.web.annotation.RequestMapping;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.JsonView;
import top.lldwb.sae.api.controller.BaseController;
import top.lldwb.sae.service.commodity.CommodityInstanceService;
import top.lldwb.sae.service.commodity.impl.CommodityInstanceServiceImpl;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class CommodityInstanceController {
    /**
     * 根据官方数据进行刷新数据源
     */
    @RequestMapping("/Commodity/CommodityInstance/refresh")
    public View refresh() {
        CommodityInstanceService service = new CommodityInstanceServiceImpl();
        service.refresh();
        return new JsonView(new BaseController().success());
    }
}
