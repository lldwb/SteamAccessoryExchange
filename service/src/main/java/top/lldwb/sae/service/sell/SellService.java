package top.lldwb.sae.service.sell;

import top.lldwb.sae.entity.sell.Sell;
import top.lldwb.sae.vo.PageVO;

import java.util.List;

/**
 * Author: tianyuan
 * Date: 2023/6/24
 */
public interface SellService {
    /**
     * 查询全部商品数据
     * @return
     */
    PageVO<List<Sell>> getSell(int numberOf , int limit);
}
