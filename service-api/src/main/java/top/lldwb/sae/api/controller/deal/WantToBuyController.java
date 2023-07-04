package top.lldwb.sae.api.controller.deal;

import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.JsonView;
import top.lldwb.sae.api.controller.BaseController;
import top.lldwb.sae.entity.buy.WantToBuy;
import top.lldwb.sae.service.buy.WantToBuyService;
import top.lldwb.sae.service.buy.impl.WantToBuyServiceImpl;
import top.lldwb.sae.utils.vo.PageVO;
import top.lldwb.sae.utils.vo.ResultVO;

import java.util.List;

/**
 * 求购
 * Author: tianyuan
 * Date: 2023/6/28
 */
public class WantToBuyController extends BaseController {
    /**
     * 求购、分页查询
     * @param numberOf 从第几行开始查
     * @param limit 查多少条数据
     * @return
     */
    @RequestMapping("/deal/wantToBuy/getBuy")
    public View getBuy(@RequestParam("numberOf") int numberOf,@RequestParam("limit") int limit){
        WantToBuyService service = new WantToBuyServiceImpl();
        List<WantToBuy> list = service.getBuy(numberOf, limit);
        Long total = service.getCount();
        ResultVO<List<WantToBuy>> vo = pageResult(total, list);
        return new JsonView(vo);
    }
}
