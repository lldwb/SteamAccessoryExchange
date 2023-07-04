package top.lldwb.sae.service.buy.impl;

import top.lldwb.sae.dao.buy.WantToBuyDao;
import top.lldwb.sae.dao.buy.impl.WantToBuyImpl;
import top.lldwb.sae.entity.buy.WantToBuy;
import top.lldwb.sae.service.buy.WantToBuyService;
import top.lldwb.sae.utils.vo.PageUtils;

import java.util.List;

/**
 * Author: tianyuan
 * Date: 2023/6/28
 */
public class WantToBuyServiceImpl implements WantToBuyService {
    @Override
    public List<WantToBuy> getBuy(int numberOf, int limit) {
        WantToBuyDao dao = new WantToBuyImpl();
        List<WantToBuy> list = dao.getWantToBuy(PageUtils.toNumberOf(numberOf, limit), limit);
        return list;
    }

    @Override
    public Long getCount() {
        WantToBuyDao dao = new WantToBuyImpl();
        Long count = dao.getCount();
        return count;
    }
}
