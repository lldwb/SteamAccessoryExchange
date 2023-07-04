package top.lldwb.sae.dao.commodity;

import top.lldwb.sae.entity.commodity.CommodityClass;
import top.lldwb.sae.entity.commodity.CommodityInstance;

import java.util.List;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public interface CommodityClassDAO {
    /**
     * 判断是否存在
     *
     * @param classId 商品父类id
     * @return 不存在返回true
     */
    Boolean judgeExist(String classId);

    /**
     * 添加数据
     * @param commodityClass
     */
    void add(CommodityClass commodityClass);

    /**
     * 添加数据
     * @param commodityClass
     */
    void addAll(CommodityClass[] commodityClass);

    /**
     * 分页 + 条件 查询商品父类列表
     * @param instanceName 查询条件 为空时执行无条件分页查询
     * @param numberOf 从第几条开始查
     * @param limit 查多少条
     * @return
     */
    List<CommodityClass> ListCommodityClass(String instanceName, int numberOf, int limit);

    /**
     * 查询总记录数，用于计算总页数
     * @return
     */
    Long count();
}
