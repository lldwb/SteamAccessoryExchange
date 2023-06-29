package top.lldwb.sae.dao.commodityclass;

import top.lldwb.sae.entity.commodityclass.CommodityClass;
import top.lldwb.sae.pagingUtil.PageVO;

import java.util.List;

/**
 * @version v1.0
 * @Date 2023/6/28 19:51
 * @Author xiao
 */
public interface CommodityClassDAO {

    /**
     * 分页查询所有 商品父类
     * @return
     */
    List<CommodityClass> listCommodityClassDAO(int numberOf, int limit);

    /**
     * 查询总记录数，用于计算总页数
     * @return
     */
    Long count();
}
