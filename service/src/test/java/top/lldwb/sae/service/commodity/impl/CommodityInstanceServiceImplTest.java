package top.lldwb.sae.service.commodity.impl;

import org.junit.jupiter.api.Test;
import top.lldwb.sae.service.commodity.CommodityInstanceService;

import java.io.IOException;

public class CommodityInstanceServiceImplTest {
    @Test
    public void f() throws IOException {
        CommodityInstanceService service = new CommodityInstanceServiceImpl();
        service.refresh();
    }
}
