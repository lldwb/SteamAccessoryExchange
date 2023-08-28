package top.lldwb.sae.api.controller.deal;

import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.JsonView;
import top.lldwb.sae.api.controller.BaseController;
import top.lldwb.sae.entity.deal.Sell;
import top.lldwb.sae.service.deal.SellsService;
import top.lldwb.sae.service.deal.impl.SellsServiceImpl;
import top.lldwb.sae.service.exception.AllException;
import top.lldwb.sae.service.sell.SellService;
import top.lldwb.sae.service.sell.impl.SellServiceImpl;
import top.lldwb.sae.utils.vo.ResultVO;

import java.util.List;

/**
 * 出售
 * Author: tianyuan
 * Date: 2023/6/24
 */
public class SellController extends BaseController {
    /**
     * 出售，分页查询
     * @param numberOf 从第几行开始查
     * @param limit 查多少条数据
     * @return
     */
    @RequestMapping("/deal/sell/getSell")
    public View getSell(@RequestParam("numberOf") int numberOf ,@RequestParam("limit") int limit){
        SellService service = new SellServiceImpl();
        List<Sell> list= service.getSell(numberOf, limit);
        Long total = service.getCount();
        ResultVO<List<Sell>> vo = pageResult(total, list);
        return new JsonView(vo);
    }

    @RequestMapping("/deal/sell/add")
    public View add(@RequestParam("sell") Sell sell){
        SellsService service = new SellsServiceImpl();
       service.insert(sell);
        return new JsonView(success());
    }
}
