package top.lldwb.sae.dao.sell;

import top.lldwb.sae.entity.sell.Sell;

import java.util.List;

/**
 * Author: tianyuan
 * Date: 2023/6/24
 */
public interface SellDao {
    /**
     * 分页查询
     * @param numberOf 从第几行开始查
     * @param limit 查多少条
     * @return
     */
    List<Sell> getSell(int numberOf, int limit);

    /**
     * 查询数据总条数
     * @return
     */
    Long count();
}
