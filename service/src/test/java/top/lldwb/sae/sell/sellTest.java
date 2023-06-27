package top.lldwb.sae.sell;

import org.junit.jupiter.api.Test;
import top.lldwb.sae.entity.sell.Sell;
import top.lldwb.sae.service.sell.impl.SellServiceImpl;
import top.lldwb.sae.vo.PageVO;

import java.util.List;

/**
 * Author: tianyuan
 * Date: 2023/6/25
 */
public class sellTest {
    @Test
    public void commodity(){
        SellServiceImpl service = new SellServiceImpl();
        PageVO<List<Sell>> pageVO = service.getSell(1, 10);
        System.out.println(pageVO.getData());
        System.out.println(pageVO.getCount());
        System.out.println(pageVO.getCode());
    }
}