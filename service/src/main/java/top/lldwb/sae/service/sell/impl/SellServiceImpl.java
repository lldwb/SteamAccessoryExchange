package top.lldwb.sae.service.sell.impl;

import top.lldwb.sae.dao.sell.SellDao;
import top.lldwb.sae.dao.sell.impl.SellImpl;
import top.lldwb.sae.entity.sell.Sell;
import top.lldwb.sae.service.sell.SellService;
import top.lldwb.sae.utils.vo.PageUtils;
import top.lldwb.sae.utils.vo.PageVO;

import java.util.List;

/**
 * Author: tianyuan
 * Date: 2023/6/24
 */
public class SellServiceImpl implements SellService {
    @Override
    public PageVO<List<Sell>> getSell(int numberOf , int limit) {
        SellDao dao = new SellImpl();
        List<Sell> list = dao.getSell(PageUtils.toNumberOf(numberOf,limit),limit);
        Long count = dao.count();
        return PageUtils.toPageVO(list,count);
    }
}
