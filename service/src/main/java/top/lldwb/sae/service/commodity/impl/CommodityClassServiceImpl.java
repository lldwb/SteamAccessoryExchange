package top.lldwb.sae.service.commodity.impl;




import top.lldwb.sae.dao.commodity.CommodityClassDAO;
import top.lldwb.sae.dao.commodity.impl.CommodityClassDAOImpl;
import top.lldwb.sae.entity.commodity.CommodityClass;
import top.lldwb.sae.entity.commodity.CommodityInstance;
import top.lldwb.sae.service.commodity.CommodityClassService;
import top.lldwb.sae.vo.PageUtils;
import top.lldwb.sae.vo.PageVO;

import java.util.List;


/**
 * @version v1.0
 * @Date 2023/6/28 20:35
 * @Author xiao
 */
public class CommodityClassServiceImpl implements CommodityClassService {
    @Override
    public PageVO<List<CommodityClass>> listCommodityClass(CommodityInstance instance,int page, int limit) {
        //先根据page计算出从表的第几条开始查询
        int numberOf = PageUtils.toNumberOf(page,limit);
        //创建DAO实例
        CommodityClassDAO dao = new CommodityClassDAOImpl();
        List<CommodityClass> list = dao.ListCommodityClass(instance,numberOf, limit);
        Long count = dao.count();
        //将数据封装成PageVo对象
        return PageUtils.toPageVO(list,count);
    }
}
