package top.lldwb.sae.api.controller.deal;

import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.JsonView;
import top.lldwb.sae.api.controller.BaseController;
import top.lldwb.sae.service.deal.OrderFormService;
import top.lldwb.sae.service.deal.impl.OrderFormServiceImpl;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class OrderForm extends BaseController {
    /**
     * 刷新订单信息(检测订单信息)
     * @param userId 用户id
     * @return
     */
    @RequestMapping("/deal/orderForm/refresh")
    public View refresh(@RequestParam("userId") int userId) {
        OrderFormService service = new OrderFormServiceImpl();
        service.refresh(userId);
        return new JsonView(success());
    }
}
