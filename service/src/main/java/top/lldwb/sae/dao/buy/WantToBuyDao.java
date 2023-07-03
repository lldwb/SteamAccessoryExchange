package top.lldwb.sae.dao.buy;

import top.lldwb.sae.entity.buy.WantToBuy;

import java.util.List;

/**
 * Author: tianyuan
 * Date: 2023/6/28
 */
public interface WantToBuyDao {

    /**
     * 求购，分页查询
     * @param numberOf 从第几行开始查
     * @param limit 查多少条数据
     * @return
     */
    List<WantToBuy> getWantToBuy(int numberOf, int limit);

    /**
     * 查询总条数
     * @return
     */
    Long getCount();
}
