package top.lldwb.sae.test.xiao;

import top.lldwb.sae.dao.commodity.CommodityClassDAO;
import top.lldwb.sae.dao.commodity.impl.CommodityClassDAOImpl;
import top.lldwb.sae.entity.commodity.CommodityClass;
import top.lldwb.sae.entity.commodity.CommodityInstance;

import java.util.List;


/**
 * @version v1.0
 * @Date 2023/6/28 20:30
 * @Author xiao
 */
public class Test {

    @org.junit.Test
 public void testcount(){
        //创建一个对象
        CommodityInstance instance = new CommodityInstance();
        String str = new String();
        //判断对象的属性值是否为空
         //当判断对象未进行赋值的String类型属性值时
        if (str.equals("")){
            System.out.println("error");
        }

        if (instance.getInstanceName() == null){
            System.out.println("yes");
        }

    }
    @org.junit.Test
    public void testlist(){
        CommodityClassDAO dao = new CommodityClassDAOImpl();
        CommodityInstance instance = new CommodityInstance();
        instance.setInstanceName("消费级");
        List<CommodityClass> list = dao.ListCommodityClass(instance,1, 5);
        list.forEach(obj -> System.out.println(obj.getClassName()));
    }
    @org.junit.Test
    public void Str(){
        StringBuilder sql = new StringBuilder("SELECT class_id,class_name,class_url,class_url_large,class_descriptions,class_actions FROM commodity_class " +
                "LIMIT ?,?;");

        int index = sql.indexOf("LIMIT");
        String sqlwhere =  sql.insert(index," WHERE\n" +
                "\tclass_id IN ( SELECT class_id FROM commdoity_class_instance" +
                "  WHERE instance_id IN ( SELECT instance_id FROM commodity_instance WHERE instance_name = ? ) ) ").toString();

        System.out.println(sqlwhere);


    }

}
