package top.lldwb.sae.service.deal.impl;

import top.lldwb.sae.dao.deal.SellDAO;
import top.lldwb.sae.dao.deal.impl.SellDAOImpl;
import top.lldwb.sae.entity.deal.Sell;
import top.lldwb.sae.service.deal.SellsService;

public class SellsServiceImpl implements SellsService {
    @Override
    public void insert(Sell sell) {
        SellDAO dao =new SellDAOImpl();
        dao.insert(sell);
    }
}
