package top.lldwb.sae.service.sell;

import top.lldwb.sae.entity.sell.Sell;
import top.lldwb.sae.utils.vo.PageVO;

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
    List<Sell> getSell(int numberOf , int limit);

    /**
     * 查询数据总条数
     * @return
     */
    Long getCount();
}
