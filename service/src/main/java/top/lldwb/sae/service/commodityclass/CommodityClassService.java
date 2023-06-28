package top.lldwb.sae.service.commodityclass;

import top.lldwb.sae.entity.commodityclass.CommodityClass;
import top.lldwb.sae.vo.PageVO;


import java.util.List;

/**
 * @version v1.0
 * @Date 2023/6/28 20:21
 * @Author xiao
 */
public interface CommodityClassService {

    PageVO<List<CommodityClass>> listCommodityClass(int page, int limit);
}
