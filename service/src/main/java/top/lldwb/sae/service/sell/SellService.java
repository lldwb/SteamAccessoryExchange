package top.lldwb.sae.service.sell;

import top.lldwb.sae.entity.deal.Sell;

import java.util.List;

/**
 * 出售
 * Author: tianyuan
 * Date: 2023/6/24
 */
public interface SellService {

    /**
     * 出售 分页查询
     * @param numberOf 从第几行开始查
     * @param limit 查多少条数据
     * @return
     */
    List<Sell> getSell(int numberOf , int limit);

    /**
     * 查询数据总条数
     * @return
     */
    Long getCount();
}
