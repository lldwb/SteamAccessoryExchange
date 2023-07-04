package top.lldwb.sae.service.commodity;


import top.lldwb.sae.entity.commodity.CommodityClass;
import top.lldwb.sae.entity.commodity.CommodityInstance;
import top.lldwb.sae.utils.vo.PageVO;

import java.util.List;

/**
 * @version v1.0
 * @Date 2023/6/28 20:21
 * @Author xiao
 */
public interface CommodityClassService {

    PageVO<List<CommodityClass>> listCommodityClass(String instanceName, int page, int limit);
}
