package top.lldwb.sae.api.controller.Commodity;

import org.nf.web.annotation.RequestMapping;
import top.lldwb.sae.service.commodity.CommodityInstanceService;
import top.lldwb.sae.service.commodity.impl.CommodityInstanceServiceImpl;

import java.io.IOException;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class CommodityInstanceController {
    /**
     * 根据官方数据进行刷新数据源
     *
     */
    @RequestMapping("/Commodity/CommodityInstance/refresh")
    public void refresh() {
        CommodityInstanceService service = new CommodityInstanceServiceImpl();
        new Thread(() ->
                service.refresh()).start();
    }
}
