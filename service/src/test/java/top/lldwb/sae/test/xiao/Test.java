package top.lldwb.sae.test.xiao;

import top.lldwb.sae.dao.commodityclass.CommodityClassDAO;
import top.lldwb.sae.dao.commodityclass.impl.CommodityClassImpl;
import top.lldwb.sae.entity.commodityclass.CommodityClass;

import java.util.List;

/**
 * @version v1.0
 * @Date 2023/6/28 20:30
 * @Author xiao
 */
public class Test {

    @org.junit.Test
 public void testcount(){
        CommodityClassDAO dao = new CommodityClassImpl();
        Long count = dao.count();
        System.out.println(count);
    }
    @org.junit.Test
    public void testlist(){
        CommodityClassDAO dao = new CommodityClassImpl();
        List<CommodityClass> list = dao.listCommodityClassDAO(0, 5);
        list.forEach(obj -> System.out.println(obj.getClassName()));
    }

}
