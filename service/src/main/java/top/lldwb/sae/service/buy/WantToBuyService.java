package top.lldwb.sae.service.buy;

import top.lldwb.sae.entity.buy.WantToBuy;

import java.util.List;

/**
 * 求购
 * Author: tianyuan
 * Date: 2023/6/28
 */
public interface WantToBuyService {
    /**
     * 求购，分页查询
     * @param numberOf 从第几行开始查
     * @param limit 查多少条数据
     * @return
     */
    List<WantToBuy> getBuy(int numberOf,int limit);

    /**
     * 查询总条数
     * @return
     */
    Long getCount();
}
