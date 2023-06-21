package top.lldwb.sae.paymentcenter;

import org.junit.jupiter.api.Test;
import top.lldwb.sae.entity.paymentcenter.RechargeWithdrawal;
import top.lldwb.sae.service.paymentcenter.RechargeWithdrawalService;
import top.lldwb.sae.service.paymentcenter.impl.RechargeWithdrawalServiceImpl;

import java.math.BigDecimal;

/**
 * Author: tianyuan
 * Date: 2023/6/20
 */
public class RechargeWithdrawalTest {

    @Test
    public void rechargeTest(){
        RechargeWithdrawalService service = new RechargeWithdrawalServiceImpl();
        RechargeWithdrawal withdrawal = new RechargeWithdrawal();
        withdrawal.setRwWay(1);
        withdrawal.setRwAmountOfMoney(BigDecimal.valueOf(50));
        withdrawal.setRwBalance(BigDecimal.valueOf(150));
        withdrawal.setRwType(2);
        withdrawal.setUserId(1);
        withdrawal.setThirdPartyOrderNumber(4564665);
        service.recharge(withdrawal);
    }

    @Test
    public void getBalanceTest(){
        RechargeWithdrawalService service = new RechargeWithdrawalServiceImpl();
        service.getBalance(1);

    }
    @Test
    public void getfjs(){
        RechargeWithdrawalService service = new RechargeWithdrawalServiceImpl();
        service.getRechargeWithdrawal();
    }
}
