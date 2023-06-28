package top.lldwb.sae.service.buy.impl;

import top.lldwb.sae.dao.buy.WantToBuyDao;
import top.lldwb.sae.dao.buy.impl.WantToBuyImpl;
import top.lldwb.sae.entity.buy.WantToBuy;
import top.lldwb.sae.service.buy.WantToBuyService;
import top.lldwb.sae.vo.PageUtils;
import top.lldwb.sae.vo.PageVO;

import java.util.List;

/**
 * Author: tianyuan
 * Date: 2023/6/28
 */
public class WantToBuyServiceImpl implements WantToBuyService {
    @Override
    public PageVO<List<WantToBuy>> getBuy(int numberOf, int limit) {
        WantToBuyDao dao = new WantToBuyImpl();
        List<WantToBuy> buy = dao.getWantToBuy(PageUtils.toNumberOf(numberOf, limit), limit);
        Long count = dao.count();
        return PageUtils.toPageVO(buy,count);
    }
}
