package top.lldwb.sae.api.controller.sell;

import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.JsonView;
import top.lldwb.sae.api.controller.BaseController;
import top.lldwb.sae.entity.sell.Sell;
import top.lldwb.sae.service.sell.SellService;
import top.lldwb.sae.service.sell.impl.SellServiceImpl;
import top.lldwb.sae.utils.vo.PageVO;
import top.lldwb.sae.utils.vo.ResultVO;

import java.util.List;

/**
 * 出售
 * Author: tianyuan
 * Date: 2023/6/24
 */
public class SellController extends BaseController {
    @RequestMapping("/getSell")
    public View getSell(@RequestParam("numberOf") int numberOf ,@RequestParam("limit") int limit){
        SellService service = new SellServiceImpl();
        List<Sell> list= service.getSell(numberOf, limit);
        Long total = service.getCount();
        ResultVO<List<Sell>> vo = pageResult(total, list);
        return new JsonView(vo);
    }
}
