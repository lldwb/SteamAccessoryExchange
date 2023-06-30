package top.lldwb.sae.service.buy;

import top.lldwb.sae.entity.buy.WantToBuy;
import top.lldwb.sae.utils.vo.PageVO;

import java.util.List;

/**
 * Author: tianyuan
 * Date: 2023/6/28
 */
public interface WantToBuyService {
    /**
     * 出售，分页查询
     * @param numberOf
     * @param limit
     * @return
     */
    PageVO<List<WantToBuy>> getBuy(int numberOf,int limit);
}
