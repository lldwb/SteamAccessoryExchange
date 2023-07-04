package top.lldwb.sae.buy;

import org.junit.jupiter.api.Test;
import top.lldwb.sae.entity.buy.WantToBuy;
import top.lldwb.sae.service.buy.impl.WantToBuyServiceImpl;

import java.util.List;

/**
 * Author: tianyuan
 * Date: 2023/6/28
 */
public class buyTest {
    @Test
    public void buy(){
        WantToBuyServiceImpl service = new WantToBuyServiceImpl();
        List<WantToBuy> buy = service.getBuy(1, 10);
        System.out.println(buy);
    }
}
