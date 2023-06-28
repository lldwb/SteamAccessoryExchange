package top.lldwb.sae.api.controller.buy;

import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.JsonView;
import top.lldwb.sae.entity.buy.WantToBuy;
import top.lldwb.sae.service.buy.WantToBuyService;
import top.lldwb.sae.service.buy.impl.WantToBuyServiceImpl;
import top.lldwb.sae.vo.PageVO;

import java.util.List;

/**
 * Author: tianyuan
 * Date: 2023/6/28
 */
public class WantToBuyController {

    @RequestMapping("/getBuy")
    public View getBuy(@RequestParam("numberOf") int numberOf,@RequestParam("limit") int limit){
        WantToBuyService service = new WantToBuyServiceImpl();
        PageVO<List<WantToBuy>> vo = service.getBuy(numberOf, limit);
        JsonView view = new JsonView(vo);
        return view;
    }
}
