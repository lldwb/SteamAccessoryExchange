package top.lldwb.sae.api.controller.sell;

import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.JsonView;
import top.lldwb.sae.entity.sell.Sell;
import top.lldwb.sae.service.sell.SellService;
import top.lldwb.sae.service.sell.impl.SellServiceImpl;
import top.lldwb.sae.utils.vo.PageVO;

import java.util.List;

/**
 * Author: tianyuan
 * Date: 2023/6/24
 */
public class SellController {
    @RequestMapping("/getSell")
    public View getSell(@RequestParam("numberOf") int numberOf ,@RequestParam("limit") int limit){
        SellService service = new SellServiceImpl();
        PageVO<List<Sell>> vo = service.getSell(numberOf, limit);
        JsonView view = new JsonView(vo);
        return view;
    }
}
