package top.lldwb.sae.service.commodity.impl;

import org.junit.jupiter.api.Test;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class CommodityServiceImplTest {
    @Test
    public void test(){
        new CommodityServiceImpl().refresh(10);
    }
}
